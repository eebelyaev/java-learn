package lesson02;

import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        long stamp = getStamp(-10);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("getStamp");
        System.out.println(stamp + "\t" + dateFormat.format(stamp));

        System.out.println("changeBalance");
        System.out.println(changeBalance(Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println(changeBalance(Integer.MIN_VALUE, -1));
        System.out.println(changeBalance(Integer.MIN_VALUE, 1));
        System.out.println(changeBalance(Integer.MAX_VALUE, Integer.MAX_VALUE));

        System.out.println("increaseBalance");
        System.out.println(increaseBalance(Integer.MAX_VALUE, 0));
        System.out.println(increaseBalance(Integer.MAX_VALUE, 5));
        System.out.println(increaseBalance(Integer.MAX_VALUE, -10));
    }

    // 1. Написать метод принимающий количество дней (положительное или отрицательное) и возвращающий дату в виде
    // таймстемпа (миллисикунды с 1970 года) в виде long.
    private static long getStamp(int dayCount) {
        long res = System.currentTimeMillis();
        res += dayCount * 24L * 60 * 60 * 1000;
        return res;
    }

    // 2. Доработать метод из ДЗ предыдущего урока, увеличивающий баланс таким образом: если сложили 2 больших
    // положительных числа, но получилось отрицательное - вернуть 0
    private static int increaseBalance(int balance, int amount) {
        int res = balance + amount;
        if (balance > 0 && amount > 0 && res < 0) {
            res = 0;
        }
        return res;
    }

    /*
    3. можно и даже лучше дорабоать во 2-ом задании текущего ДЗ. Организовать проверку таким образом: если складываем
    положительные числа, но получаем отрицательное, то вывести 0, если получаем положительное, но вычитаем из него
    большее (т.е. получаем отрицательное), то возвращаем отрицательное. Так же учесть кейс, когда у нас первое число
    отрицательное и второе положительное/отрицательное. Иначе говоря:  пытаемся придумать как проверить, что
    не произошло дерьмо с int overflow.
     */
    private static int changeBalance(int balance, int amount) {
        long res = (long) balance + amount;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            res = 0;
        }
        return (int) res;
    }
}
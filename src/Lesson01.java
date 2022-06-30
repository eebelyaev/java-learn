public class Lesson01 {
    public static void main(String[] args) {
        int balance = 9;
        int amount = Integer.MAX_VALUE - 10;
        int newBalance = increaseBalance(balance, amount);
        System.out.println(balance + " + " + amount + " = " + newBalance) ;

        balance = -19;
        amount = Integer.MIN_VALUE + 10;
        newBalance = increaseBalance(balance, amount);
        System.out.println(balance + " + " + amount + " = " + newBalance) ;

        playWithChar();

        showText(24);
    }

    // 1. Написать метод увеличения счета (счет и часть для увеличения int, всегда положительные),
    // объяснить какие могут быть проблемы.
    private static int increaseBalance(int balance, int amount) {
        // Проблема: неправильный результат, вызванный переполнением
        return balance + amount;
    }

    // 2. Пиграться с char. Объявить переменную, прибавить к ней int значение (допустим 1 10 22) и отнять,
    // объяснить как это рабоатет, т.е. какой результат получаем и почему.
    private static void playWithChar() {
        char ch = 'a';
        int carry = 3;
        System.out.println(ch + "\t" + (char) (ch - carry) + "\t" + (char) (ch + carry));
        ch = 't';
        System.out.println(ch + "\t" + (char) (ch - carry) + "\t" + (char) (ch + carry));
    }

    // 3. Написать метод ничего принимающий int и выводящий в консоль: Результат равен: значение_переменной овец (штук).
    // Метод ничего не возращает, только выводит в консоль.
    private static void showText(int value) {
        System.out.println("Результат равен: " + value + " овец (штук).");
    }
}

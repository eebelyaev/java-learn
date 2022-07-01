package lesson03;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*
            1. Создать массив интов, заполнить его значениями Integer.MIN_VALUE.
            Поменять какие-то значения в массиве.
            Посчитать сколько элементов массива не равны Integer.MIN_VALUE.
            Таким образом получим сколько элементов менялось от первоначального.
        */
        manipulationWithArray();

        /*
            2. Составить массив из значимых годов Республики Татартсан (любые 20), добавить их в массив
            в рандомном порядке, написать метод, принимающий массив годов (интов) и возвращающий их
            в отсортированном порядке. Сортировку реализовать методом bubble sort (пузырьковая сортировка).
        */
        int[] years = TatarParser.getYearsFromText();
        System.out.println("До сортировки:\t" + Arrays.toString(years));
        years = bubbleSort(years);
        System.out.println("После сортировки:\t" + Arrays.toString(years));

        /*
            3. Написать метод, который на вход принимает отсортированный массив годов (из 2-го задания) и
            произвольный год, возвращает boolean значение, которое означает наличие или отсутствие даты в
            переданном массиве. Читаем и используем binary search (бинарный поиск).
        */
        Random randomYear = new Random();
        boolean exist = false;
        System.out.print("Их нет в массиве:");
        for (int i = 0, year; i < years.length && !exist; i++) {
            year = 1800 + randomYear.nextInt(200);
            exist = existValue(years, year);
            if (exist) {
                System.out.println("\nА вот " + year + " год нашелся");
            }
            else {
                System.out.print("\t" + year);
            }
        }
    }

    private static void manipulationWithArray() {
        final int count = 5;
        int[] ints = new int[count];
        Arrays.fill(ints, Integer.MIN_VALUE);

        ints[2] = 2;
        ints[4] = 4;
        System.out.println("Массив: " + Arrays.toString(ints));
        int countChanged = 0;
        for (int anInt : ints) {
            if (anInt != Integer.MIN_VALUE) {
                countChanged++;
            }
        }
        System.out.println("\tМенялось элементов от первоначального: " + countChanged);
    }

    private static int[] bubbleSort(int[] arrayInt) {
        int[] result = arrayInt.clone();
        int value;
        for (int i = result.length; i > 1 ; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    value = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = value;
                }
            }
        }
        return result;
    }

    private static boolean existValue(int[] array, int value) {
        int beginIndex = 0;
        int length = array.length;
        int endIndex = length - 1;
        if (length == 0) {
            return false;
        }
        int middleIndex;
        while (length > 0) {
            middleIndex = beginIndex + (length >> 1);
            if (array[middleIndex] < value) {
                beginIndex = middleIndex + 1;
            } else if (array[middleIndex] > value) {
                endIndex = middleIndex - 1;
            } else {
                return true;
            }
            length = endIndex - beginIndex + 1;
        }
        return false;
    }
}

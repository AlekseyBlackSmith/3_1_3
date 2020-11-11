package JavaCore.block2.task2416;

/**
 * Напишите метод evenArray который принимает целое число типа int и возвращает массив заполненный четными числами от 1 до этого числа.
 *
 * Пример ввода: 8
 * Пример вывода: [2,4,6,8]
 *
 * Требования:
 * 1. Метод должен быть публичным.
 * 2. Параметр должен иметь тип int.
 * 3. Сигнатура метода должна быть: evenArray(int number)
 */

public class Task2416 {

    public static void main(String[] args) {

    }

    public int[] evenArray(int number) {
        int[] array = new int[number / 2];
        for (int i = 2, j = 0; i <= number; i += 2, j++) {
            array[j] = i;
        }
        return array;
    }

}

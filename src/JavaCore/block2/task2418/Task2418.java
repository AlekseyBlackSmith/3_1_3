package JavaCore.block2.task2418;

/**
 * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
 * Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив. Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
 * К сожалению, автоматически это не проверить, так что это остается на вашей совести :)
 * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
 *
 * Пример ввода: {0, 2, 2} и {1, 3}
 * Пример вывода: {0, 1, 2, 2, 3}
 *
 * Требования:
 * Cигнатура метода должна быть: mergeArrays(int[] a1, int[] a2)
 */

public class Task2418 {

    public static int[] mergeArrays(int[] a1, int[] a2) {

        int[] array = new int[a1.length + a2.length];
        boolean flag = true;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        while (flag) {
            if (count1 < a1.length && count2 < a2.length) {
                if (a1[count1] <= a2[count2]) {
                    array[count3] = a1[count1];
                    count1++;
                    count3++;
                } else {
                    array[count3] = a2[count2];
                    count2++;
                    count3++;
                }
            }

            if (count1 == a1.length && count2 < a2.length) {
                array[count3] = a2[count2];
                count2++;
                count3++;
            }

            if (count1 < a1.length && count2 == a2.length) {
                array[count3] = a1[count1];
                count1++;
                count3++;
            }

            if (count1 == a1.length && count2 == a2.length) {
                flag = false;
            }

        }

        return array;
    }


}

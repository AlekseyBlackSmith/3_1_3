package JavaCore.block6.task6214;

import java.util.*;

/**
 * Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами,
 * затем удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном порядке в System.out.
 *
 * Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.
 *
 * Все import объявлены за вас.
 *
 * Пример ввода: 1 2 3 4 5 6 7 8 9 10
 * Пример вывода: 10 8 6 4 2
 *
 * Требования:
 * 1. Необходимо наличие метода public static void main(String[] args)
 * 2. Программа должна читать данные из консоли
 * 3. Программа должна выводить текст в консоль
 */

public class Task6214 {
// 1 2 3 4 5 6 7 8 9 10

    public static void main(String[] args) {

        Scanner scanToString = new Scanner(System.in);
        String str = scanToString.nextLine();
        scanToString.close();

        Scanner scanner = new Scanner(str);
        ArrayDeque<Integer> array = new ArrayDeque<>();
        int count = 0;

        while (scanner.hasNext()) {
            count++;
            if (count % 2 == 0) {
                array.offerFirst(scanner.nextInt());
            } else {
                scanner.nextInt();
            }
        }
        scanner.close();

        for (Integer i : array) {
            System.out.printf("%d ", i);
        }

    }

}

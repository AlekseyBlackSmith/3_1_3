package JavaCore.block5.task5312;



import java.io.IOException;
import java.util.Scanner;

/**
 * Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте
 * вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов,
 * отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
 *
 * На этот раз вам надо написать программу полностью, т.е. объявить  публичный класс с именем Main  и точку входа в
 * программу — метод  main. И добавить все необходимые импорты
 */

public class Task5312 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //scanner.useLocale(Locale.ENGLISH);
        double sum = 0.0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        scanner.close();
        System.out.printf("%6f", sum);

    }
}

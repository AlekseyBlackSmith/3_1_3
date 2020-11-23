package JavaCore.block5.task527;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Напишите метод int sumOfStream(InputStream inputStream), который принимает InputStream и возвращает сумму всех его элементов.
 *
 * Пример ввода: 1, 2, 4, 10
 *
 * Пример вывода: 17
 *
 * Требования:
 * 1. Метод должен быть публичным.
 * 2. Параметр должен иметь тип InputStream.
 * 3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)
 */

public class Task527 {

    public static void main(String[] args) throws IOException {
        byte[] arr = {1, 2, 4, 10, -16};
        System.out.println(new Task527().sumOfStream(new ByteArrayInputStream(arr)));
    }

    public int sumOfStream(InputStream inputStream) throws IOException {
        int b = 0;
        int summ = 0;
        while ((b = inputStream.read()) != -1) {
            summ += (byte)b;
        }
        return summ;
    }
}

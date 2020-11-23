package JavaCore.block5.task528;

import java.io.*;

/**
 * Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает InputStream и
 * OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.
 *
 * Пример ввода: 3, 10, 4, 5, 7
 *
 * Пример вывода: 10, 4
 *
 * Требования:
 * 1. Метод должен быть публичным.
 * 2. Параметры должны иметь тип InputStream inputStream и OutputStream outputStream.
 * 3. Сигнатура метода должна быть: print(InputStream inputStream, OutputStream outputStream)
 */

public class Task528 {
    public static void main(String[] args) throws IOException {
        InputStream stream = new ByteArrayInputStream(new byte[]{3, 10, 4, 5, 7});
        OutputStream outputStream = new ByteArrayOutputStream();
        print(stream, outputStream);


    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int b;
        byte c;
        while ((b = inputStream.read()) != -1) {
            c = (byte) b;
            if (c % 2 == 0) {
                outputStream.write(c);
                outputStream.flush();
            }
        }
    }
}

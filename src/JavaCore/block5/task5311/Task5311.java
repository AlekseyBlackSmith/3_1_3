package JavaCore.block5.task5311;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.
 *
 * Пример:
 * InputStream последовательно возвращает четыре байта: 48 49 50 51.
 * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".
 *
 * Требования:
 * 1. Метод должен быть публичным.
 * 2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset)
 */

public class Task5311 {

    public static void main(String[] args) throws IOException {
        byte[] arr = {48, 49, 50, 51};
        System.out.println(readAsString(new ByteArrayInputStream(arr), StandardCharsets.UTF_8));


    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        StringBuilder builder = new StringBuilder();
        int a;
        while ((a = reader.read()) != -1) {
            builder.append( (char)a );
        }
        return builder.toString();
    }




}

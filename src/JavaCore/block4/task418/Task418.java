package JavaCore.block4.task418;

/**
 * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
 * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод, вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод, вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
 * Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод, откуда сообщение было залогировано.
 * Пример
 * package org.stepic.java.example;
 *
 * public class Test {
 *     public static void main(String[] args) {
 *         System.out.println(getCallerClassAndMethodName());
 *         anotherMethod();
 *     }
 *
 *     private static void anotherMethod() {
 *         System.out.println(getCallerClassAndMethodName());
 *     }
 *
 *     public static String getCallerClassAndMethodName() {
 *         // ...
 *     }
 * }
 * При запуске эта программа должна вывести:
 *
 * null
 * org.your.project.Test#main
 * P.S. При тестировании этой программы в среде разработки вы можете получить другой результат: вместо null в первой строчке будет напечатан какой-то посторонний класс и метод. Это связано с тем, что среда разработки обычно запускает не ваш класс, а свой собственный, который затем уже вызывает ваш. Чтобы этого избежать, запускайте программу командой "java" в командной строке.
 *
 * P.P.S. Эта задача в уроке про исключения не случайно :)
 */

public class Task418 {

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    public static String getCallerClassAndMethodName(){
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        if (ste.length < 4) {
            return null;
        }
        return ste[3].getClassName() + "#" + ste[3].getMethodName();
    }

    /*
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] ste =  new Exception().getStackTrace();
        if (ste.length < 3) {
            return null;
        }
        return ste[2].getClassName() + "#" + ste[2].getMethodName();
    }
     */
    private static void anotherMethod(){
        System.out.println(getCallerClassAndMethodName());

    }

}

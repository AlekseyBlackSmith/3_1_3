package JavaCore.block4.task427;

import java.io.Closeable;

/**
 * Создайте статический класс Car, чтобы объекты этого типа можно было использовать в try-with-resources.
 * Метод close() должен выводить на экран фразу "Машина закрывается...".
 * Try должен ловить все непроверяемые исключения и игнорировать их.
 * В методе main в блоке try вызови метод drive(). Метод drive должен выводить на экран сообщение "Машина поехала."
 *
 * Требования:
 * 1. Решение должно содержать статический класс Car.
 * 2. Решение должно содержать метод main.
 * 3. В решение должен использоваться try с ресурсами.
 */

public class Task427 {

    public static void main(String[] args) {

        try (Car car = new Car()) {
            Car.drive();
        } catch (RuntimeException e) {

        }

    }

    public static class Car implements AutoCloseable {

        public static void drive() {
            System.out.println("Машина поехала.");
        }

        @Override
        public void close() {
            System.out.println("Машина закрывается...");
        }
    }
}

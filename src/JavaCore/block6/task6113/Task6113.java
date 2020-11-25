package JavaCore.block6.task6113;

import java.util.Arrays;

/**
 * Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray, который
 * хранит в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления и
 * извлечения T get(int index) из него элементов, при переполнении текущего массива, должен создаваться новый,
 * большего размера.
 *
 * Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно
 * воспользоваться методами из класса java.util.Arrays. Импорт этого класса уже объявлен в тестирующей системе.
 * Добавлять его явно не нужно
 *
 * Требования:
 * 1. должен быть класс public static class DynamicArray
 * 2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
 * 3. класс DynamicArray должен  иметь публичный конструктор по умолчанию
 * 3. работа методов должна соответствовать условию
 */
public class Task6113 {

    public static void main(String[] args) {
        DynamicArray<String> test = new DynamicArray<>();
        test.add("0");
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        test.add("6");
        test.add("7");
        test.add("8");
        test.add("9");
        System.out.println(test.get(0));
        System.out.printf("В массиве %d элементов\n", test.array.length);
        for (int i = 0; i < test.array.length; i++) {
            System.out.println("элемент с индексом "+test.array[i]);
        }

    }

    public static class DynamicArray<T> {
        private Object[] array;


        public DynamicArray() {
            array = new Object[0];
        }

        //добавление в массив
        public void add(T el) {
            Object[] newArray = Arrays.copyOf(array, array.length + 1);
            newArray[newArray.length - 1] = (Object) el;
            array = newArray;
        }

        //удаление из массива
        public void remove(int index) {
            Object[] first = Arrays.copyOfRange(array, 0, index);
            Object[] second = Arrays.copyOfRange(array, index + 1, array.length);

            Object[] newArray = new Object[array.length - 1];
            System.arraycopy(first, 0, newArray, 0, first.length);
            System.arraycopy(second, 0, newArray,first.length, second.length);
            array = newArray;
        }

        //извлечение из массива по индексу
        public T get(int index) {
            return (T) array[index];
        }
    }
}

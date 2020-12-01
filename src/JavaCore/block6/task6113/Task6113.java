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
        test.add("10");

        System.out.println(test.get(10));
        test.remove(10);
        test.add("11");
        System.out.println(test.get(0));
        test.remove(0);
        System.out.println(test.get(0));
        test.remove(6);
        test.remove(10); // за пределами массива
        System.out.println(test.get(6));
        System.out.printf("текущий индекс curentElement %d\n", test.currentElement);
        System.out.println(test.get(10));
        test.add("12");
        test.add("13");
        test.add("14");
        test.add("15");
        test.add("16");
        test.add("17");
        test.remove(1);
        test.remove(20);
        test.add("18");
        test.add("19");
        test.add("20");
        test.add("21");
        test.add("22");
        test.add("23");
        test.add("24");
        test.add("25");
        test.add("26");
        test.add("27");
        test.add("28");
        test.add("29");
        test.add("30");
        System.out.println("------------test------------");
        System.out.printf("В массиве %d ячеек\n", test.array.length);
        System.out.printf("В массиве %d элементов\n",test.currentElement+1);
        for (int i = 0; i < test.array.length; i++) {
            System.out.printf("элемент с индексом %d, со значением %s\n",i, test.array[i]);
        }

    }

    public static class DynamicArray<T> {
        private Object[] array;
        private int currentElement;


        //создание
        public DynamicArray() {
            array = new Object[10];
            currentElement = -1;
        }


        //добавление в массив
        public void add(T el) {
            currentElement++;
            if (currentElement == array.length) {
                array = Arrays.copyOf(array, array.length + 5);
                System.out.printf("произошло расширение массива до %d ячеек\n", array.length);
            }
            array[currentElement] = (Object) el;
            System.out.printf("Добавлен элемент с индексом %d и значением %s\n", currentElement, el);
        }

        //удаление из массива
        public void remove(int index) {
            if (index >= 0 && index <= currentElement) {
                System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
                array[array.length-1] = null;
                currentElement--;
                System.out.println("Удален элемент с индексом "+index);
            } else {
                System.out.println("неверно указаан индекс элемента для удаления");
            }
        }

        //извлечение из массива по индексу
        public T get(int index) {
            if (index >= 0 && index <= currentElement) {
                return (T) array[index];
            } else {
                return null;
            }
        }
    }
}

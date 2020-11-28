package JavaCore.block6.task6213;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

/**
 * Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств. Метод должен возвращать
 * результат в виде нового множества. Изменять переданные в него множества не допускается.
 *
 * Пример ввода: [1, 2, 3} и {0, 1, 2]
 * Пример вывода: [0, 3]
 *
 * Требования:
 * 1. должен быть метод public static Set symmetricDifference(Set set1, Set set2)
 * 2. метод symmetricDifference не должен изменять исходные множества
 * 3. метод symmetricDifference должен возвращать корректный результат
 */

public class Task6213 {

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);

        Set<Integer> b = new HashSet<>();
        b.add(0);
        b.add(1);
        b.add(2);

        System.out.println(symmetricDifference(a,b));

    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);

        Set<T> forDeliting = new HashSet<>(set1);
        forDeliting.retainAll(set2);

        result.removeAll(forDeliting);

        return result;
    }

}

package JavaCore.block6.task6112;

import java.util.Objects;
import java.util.Optional;

/**
 * Реализуйте generic-класс Pair, похожий на Optional, но содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.
 *
 * Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
 *
 * С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:
 */


public class Task6112 {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
    }

    public static class Pair<T, X> {
        private final T first;
        private final X second;

        private Pair(T first, X second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public X getSecond() {
            return second;
        }

        public static <T, X> Pair<T, X> of(T first, X second) {
            return new Pair<T, X>(first, second);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }


    }
}

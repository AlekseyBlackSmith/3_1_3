package JavaCore.block7.task7210;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

/**
 * Напишите метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм генерации чисел следующий:
 *
 * Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
 * Первый элемент последовательности устанавливается равным этому числу.
 * Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2), где mid — это функция, выделяющая второй,
 * третий и четвертый разряд переданного числа. Например, mid(123456)=345.
 * Алгоритм, конечно, дурацкий и не выдерживающий никакой критики, но для практики работы со стримами сойдет :)
 *
 * Пример ввода: 13
 * Пример вывода: 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)
 *
 * Требования:
 * 1. Должен быть метод public static IntStream pseudoRandomStream(int seed)
 * 2. Метод должен возвращать поток, удовлетворяющий условию
 */

public class Task7210 {

    public static void main(String[] args) {
        pseudoRandomStream(13).limit(9).mapToObj(x -> " " + x).forEach(System.out::print);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ( (n * n) / 10 % 1000 ) );
    }

}

package JavaCore.block7.task717;

import java.util.function.UnaryOperator;

/**
 * Напишите метод с названием sqrt, который возвращает реализацию функционального интерфейса UnaryOperator,
 * который принимает целое число(тип int) и возвращает его квадрат.
 *
 * Требования:
 * 1. Должен быть метод public UnaryOperator sqrt()
 * 2. Метод должен возвращать реализацию интерфейса UnaryOperator.
 * 3. Реализация должна соответствовать условию
 */
public class Task717 {
    public static void main(String[] args) {



        Task717 main = new Task717(); //ваш класс
        UnaryOperator unaryOperator = main.sqrt();
        System.out.println("2 -> "+   unaryOperator.apply(2));
        System.out.println("-4 -> "+   unaryOperator.apply(-4));
        System.out.println("6 -> "+   unaryOperator.apply(6));
        System.out.println("12 -> "+   unaryOperator.apply(12));



    }

    public UnaryOperator<Integer> sqrt(){
        return  x -> x * x;


    }

}

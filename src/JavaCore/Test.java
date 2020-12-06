package JavaCore;


import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {



    }
}



//
//        Predicate<Integer> myPredicate = x -> x > 0;
//        System.out.println(myPredicate.test(1));
//
//        BinaryOperator<Integer> binaryOperator = (x, y) -> x - y;
//        System.out.println(binaryOperator.apply(1,2));
//
//        UnaryOperator<String> unaryOperator = x -> x.toUpperCase(Locale.ROOT);
//        System.out.println(unaryOperator.apply("thisTextIsADifferent"));
//
//        Function<Integer, String> function = (x) -> "получено значение "+ x.toString();
//        System.out.println(function.apply(123));
//
//        Consumer<String> consumer = System.out::println;
//        consumer.accept("string");
//
//        Supplier<String> userFactory = ()->{
//
//            Scanner in = new Scanner(System.in);
//            System.out.println("Введите имя: ");
//            String name = in.nextLine();
//            return name;
//        };
//
//        String user1 = userFactory.get();
//        String user2 = userFactory.get();
//
//        System.out.println("Имя user1: " + user1);
//        System.out.println("Имя user2: " + user2);
//    }
//
//}
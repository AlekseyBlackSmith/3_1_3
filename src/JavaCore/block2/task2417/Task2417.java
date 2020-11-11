package JavaCore.block2.task2417;

/**
 * Напишите метод printOddNumbers, который принимает массив и выводит в консоль только нечетные числа из него, через запятую. Конец вывода должен перевести курсор на новую строку.
 *
 * Пример ввода: [3,5,20,8,7,3,100]
 *
 * Пример вывода: 3,5,7,3
 */

public class Task2417 {

    public static void printOddNumbers(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++){
            if (arr[i] % 2 != 0){
                builder.append(arr[i]);
                builder.append(",");
            }
        }
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
    }
}

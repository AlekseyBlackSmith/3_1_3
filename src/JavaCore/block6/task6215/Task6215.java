package JavaCore.block6.task6215;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Магазину нужно сохранять информацию о продажах для каждого сотрудника. Напишите метод Map getSalesMap(Reader reader)
 * который принимает Reader содержащий строки вида:
 *
 * Алексей 3000
 * Дмитрий 9000
 * Антон 3000
 * Алексей 7000
 * Антон 8000
 * Метод должен получить все строки из Readera и заполнить и вернуть карту где ключом будет имя сотрудника, а значением сумма всех его продаж.
 *
 * Пример ввода:
 *
 *
 * Алексей 3000
 * Дмитрий 9000
 * Антон 3000
 * Алексей 7000
 * Антон 8000
 * Пример вывода:
 * {Алексей=[10000], Дмитрий=[9000], Антон=[11000]}
 *
 * Требования:
 * 1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
 * 2. Работа метода getSalesMap должна удовлетворять условию
 *
 */
public class Task6215 {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream("Алексей 3000\nДмитрий 9000\nАнтон 3000\nАлексей 7000\nАнтон 8000".getBytes());
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(bais));

        Map<String, Long> students = getSalesMap(buffReader);

        for (Map.Entry<String, Long> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    public static Map<String, Long> getSalesMap(Reader reader) throws IOException {
        BufferedReader bReader = new BufferedReader(reader);
        Map<String, Long> map = new HashMap<>();
        String s;
        while ((s = bReader.readLine()) != null) {
            String[] array = s.split(" ");
            if (map.containsKey(array[0])) {
                map.put( array[0], map.get(array[0]) + Long.parseLong(array[1]) );
            } else {
                map.put(array[0], Long.parseLong(array[1]));
            }
        }
        bReader.close();
        return map;
    }
}

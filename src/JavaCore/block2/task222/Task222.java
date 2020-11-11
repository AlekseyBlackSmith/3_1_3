package JavaCore.block2.task222;

/**
 * Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
 * В качестве примера написано заведомо неправильное выражение. Исправьте его.
 *
 * Требования:
 * 1. Сигнатура метода должна быть: charExpression(int a)
 */

public class Task222 {

    public static char charExpression(int a) {
        return (char) ('\\' + a);
    }
}

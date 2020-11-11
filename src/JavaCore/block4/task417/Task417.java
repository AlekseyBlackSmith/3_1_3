package JavaCore.block4.task417;

/**
 * Создайте новое проверяемое исключение MyNewException, и создайте метод testExp(), который выбрасывает MyNewException при вызове.
 *
 * Требования:
 * 1. Метод testExp() должен быть публичным и иметь тип возвращаемого значения void.
 * 2. Класс исключения должен иметь модификатор доступа по умолчанию.
 * 3. Метод testExp() расположите вне класса исключения.
 */
public class Task417 {
    public static void main(String[] args) throws MyNewException {
        //Task417 q = new Task417();
        //q.testExp();
    }

    public void testExp() throws MyNewException {
        throw new MyNewException();
    }

    class MyNewException extends Exception{
    }


}


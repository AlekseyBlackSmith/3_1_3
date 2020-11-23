package JavaCore.block6.task6110;

/**
 * Создайте дженерик класс Box, который может хранить в себе один объект класса, которым он параметризирован в поле с названием object.
 *
 * Требования:
 * 1. Класс должен быть параметризован T.
 * 2. Поле должно быть приватным с именем object.
 * 3. Класс должен иметь модификатор доступа по умолчанию.
 */

public class Task6110 {

    class Box<T> {
        private T object;

        public T getT() {
            return object;
        }

        public void setT(T object) {
            this.object = object;
        }
    }

    public static void main(String[] args) {

    }
}

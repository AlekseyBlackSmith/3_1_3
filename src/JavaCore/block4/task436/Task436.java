package JavaCore.block4.task436;

import java.util.logging.Logger;

/**
 * Создайте в статичном публичном методе logging логгер с именем com.javamentor.logging.Test, залогируйте им два сообщения: первое "Все хорошо" с уровнем INFO и второе "Произошла ошибка" с уровнем WARNING.
 *
 * java.util.logging.* импортирован за вас
 */
public class Task436 {

    public static void main(String[] args) {
        logging();
    }

    public static void logging() {
        Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.info("Все хорошо");
        logger.warning("Произошла ошибка");

    }
}

package JavaCore.block4.task429;



/**
 * Реши предыдущую задачу с использованием try-with-resources
 */

public class Task429 {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {

        for (int i = 1; i <= 3; i++) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                i += 3;
            } catch (RobotConnectionException e) {
                if (i == 3) {
                    throw e;
                }
            }
        }




    }



    interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

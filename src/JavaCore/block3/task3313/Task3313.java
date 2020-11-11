package JavaCore.block3.task3313;

/**
 * На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y. Ось X смотрит слева направо, ось Y - снизу вверх. (Помните, как рисовали графики функций в школе?)
 * В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз, направо или налево. Ваша задача — привести робота в заданную точку игрового поля.
 * Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):
 *
 * Пример:
 * В метод передано: toX == 3, toY == 0; начальное состояние робота такое: robot.getX() == 0, robot.getY() == 0, robot.getDirection() == Direction.UP
 *
 * Чтобы привести робота в указанную точку (3, 0), метод должен вызвать у робота следующие методы:
 * robot.turnRight();
 * robot.stepForward();
 * robot.stepForward();
 * robot.stepForward();
 *
 * Требования:
 * 1. должен быть метод public static void moveRobot(Robot robot, int toX, int toY)
 * 2. метод moveRobot должен переместить робота в позицию int toX, int toY
 */

public class Task3313 {

    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.getX()+" "+robot.getY()+" "+robot.getDirection());
        moveRobot(robot, 0, 0);
        System.out.println(robot.getX()+" "+robot.getY()+" "+robot.getDirection());

    }

    public static void moveRobot(Robot robot, int toX, int toY) {

        if (robot.getX() != toX) {
            if (robot.getX() > toX) {
                while (robot.getDirection() != Direction.LEFT) {
                    robot.turnLeft();
                }
            } else {
                while (robot.getDirection() != Direction.RIGHT) {
                    robot.turnLeft();
                }
            }
            while (robot.getX() != toX){
                robot.stepForward();
            }
        }

        if (robot.getY() != toY) {
            if (robot.getY() > toY) {
                while (robot.getDirection() != Direction.DOWN) {
                    robot.turnLeft();
                }
            } else {
                while (robot.getDirection() != Direction.UP) {
                    robot.turnLeft();
                }
            }
            while (robot.getY() != toY) {
                robot.stepForward();
            }
        }
    }

}
    /* забракованный ментором метод
    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();

        if (x != toX) {
            if (x > toX) {
                switch (robot.getDirection()) {
                    case UP:
                        robot.turnLeft();
                        break;
                    case DOWN:
                        robot.turnRight();
                        break;
                    case RIGHT:
                        robot.turnLeft();
                        robot.turnLeft();
                        break;
                }
                for (int i = 0; i < x-toX; i++) {
                    robot.stepForward();
                }
            } else {
                switch (robot.getDirection()) {
                    case UP:
                        robot.turnRight();
                        break;
                    case DOWN:
                        robot.turnLeft();
                        break;
                    case LEFT:
                        robot.turnLeft();
                        robot.turnLeft();
                        break;
                }
                for (int i = 0; i < toX-x; i++) {
                    robot.stepForward();
                }
            }
        }

        if (y != toY){
            if (y > toY){
                switch (robot.getDirection()){
                    case RIGHT:
                        robot.turnRight();
                        break;
                    case LEFT:
                        robot.turnLeft();
                        break;
                    case UP:
                        robot.turnLeft();
                        robot.turnLeft();
                        break;
                }
                for (int i = 0; i < y-toY; i++) {
                    robot.stepForward();
                }
            } else {
                switch ((robot.getDirection())){
                    case LEFT:
                        robot.turnRight();
                        break;
                    case RIGHT:
                        robot.turnLeft();
                        break;
                    case DOWN:
                        robot.turnLeft();
                        robot.turnLeft();
                        break;
                }
                for (int i = 0; i < toY-y; i++) {
                    robot.stepForward();
                }
            }
        }
    }
     */

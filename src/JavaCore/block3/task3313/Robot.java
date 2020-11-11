package JavaCore.block3.task3313;

public class Robot {
    private Direction direction = Direction.UP;
    private int x = 4;
    private int y = 3;

    public Direction getDirection() {
        // текущее направление взгляда
        return direction;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        direction = Direction.LEFT;
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        direction = Direction.RIGHT;
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        switch (direction){
            case UP -> y++;
            case RIGHT -> x++;
            case DOWN -> y--;
            case LEFT -> x--;
        }
    }


}

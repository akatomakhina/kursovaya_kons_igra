package by.katomakhina.snakegame.entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import by.katomakhina.snakegame.logic.SnakeGame;
import by.katomakhina.snakegame.canvas.Canvas;


public class Poison {
    Random random = new Random();
    ArrayList<Point> poison = new ArrayList<Point>();
    Color color = SnakeGame.POISON_DEFAULT;

    boolean isPoison(int x, int y) {
        for (Point point : poison) {
            if ((point.getX() == x) && (point.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    public void add(Snake snake, Canvas canvas) {
        int x, y;
        do {
            x = random.nextInt(SnakeGame.FIELD_WIDTH - 2) + 1;
            y = random.nextInt(SnakeGame.FIELD_HIGHT - 5) + 4;
        } while (isPoison(x, y) ||
                snake.isInsideSnake(x, y) ||
                canvas.snake.isFood(new Point(x, y)));
        poison.add(new Point(x, y, color));
    }

    public void paint(Graphics g) {
        for (Point point : poison) {
            point.paint(g);
        }
    }
}

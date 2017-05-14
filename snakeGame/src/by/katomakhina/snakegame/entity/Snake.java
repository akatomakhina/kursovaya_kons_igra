package by.katomakhina.snakegame.entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import by.katomakhina.snakegame.logic.SnakeGame;
import by.katomakhina.snakegame.canvas.Canvas;


public class Snake {
    ArrayList<Point> snake = new ArrayList<Point>();
    int direction;

    public Snake(int x, int y, int lenght, int direction) {      //начальные координаты расположения змейки, ее длина и направление
        for (int i = 0; i < lenght; i++) {                         //цикл создает серию объектов поинт...
            Point point = new Point((x - i), y);
            snake.add(point);                                   //... и эти объекты через этот метод адд добавляются в список эррэй
        }
        this.direction = direction;
    }

    public ArrayList<Point> getSnake() {
        return snake;
    }

    public void setSnake(ArrayList<Point> snake) {
        this.snake = snake;
    }

    public Snake() {
    }

    boolean isFood(Point food) {
        return snake.get(0).getX() == food.getX() && snake.get(0).getY() == food.getY();
    }

    public void move(Canvas canvas, JFrame frame) {
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        if (direction == SnakeGame.LEFT) {
            x--;
        }
        if (direction == SnakeGame.RIGHT) {
            x++;
        }
        if (direction == SnakeGame.UP) {
            y--;
        }
        if (direction == SnakeGame.DOWN) {
            y++;
        }
        if (x > SnakeGame.FIELD_WIDTH - 2) {
            x = 1;
        }
        if (x < 1) {
            x = SnakeGame.FIELD_WIDTH - 2;
        }
        if (y > SnakeGame.FIELD_HIGHT - 1) {
            y = 4;
        }
        if (y < 4) {
            y = SnakeGame.FIELD_HIGHT - 1;
        }
        SnakeGame.gameOver = isInsideSnake(x, y) || (canvas.poison.isPoison(x,y));
        snake.add(0, new Point(x, y));
        if (isFood(canvas.food)) {
            canvas.food.eat();
            frame.setTitle(SnakeGame.TITLE_OF_PROGRAM + " : " + snake.size());
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    public void setDirection(int direction) {
        if ((direction >= SnakeGame.LEFT) && (direction <= SnakeGame.DOWN)) {
            if(Math.abs(this.direction - direction) != 2){
                this.direction = direction;
            }
        }
    }

    boolean isInsideSnake(int x, int y) {
        for (Point point : snake) {
            if ((point.getX() == x) && (point.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics g) {                  //цикл FOREACH
        for (Point point : snake) {           //snake - это массив, в который мы загоняем поинты, а потом через метод пэйнт рисуем поинты
            point.paint(g);
        }
    }
}

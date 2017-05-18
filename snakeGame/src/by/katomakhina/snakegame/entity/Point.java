package by.katomakhina.snakegame.entity;

import java.awt.*;

import by.katomakhina.snakegame.logic.SnakeGame;


public class Point {
    int x, y;
    Color color = SnakeGame.COLOR_DEFAULT;

    public Point(int x, int y) {
        this.setXY(x, y);
    }

    public Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void paint(Graphics g) {            //рисование точек
        g.setColor(color);
        g.fillOval(x * SnakeGame.POINT_RADIUS, y * SnakeGame.POINT_RADIUS, SnakeGame.POINT_RADIUS, SnakeGame.POINT_RADIUS);
    }

    void setXY(int x, int y) {           //добавляет координаты
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

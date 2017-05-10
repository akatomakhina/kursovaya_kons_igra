package by.katomakhina.snakegame.entity;

import java.util.*;

import by.katomakhina.snakegame.logic.SnakeGame;


public class Food extends Point {

    Random random = new Random();

    public Food(){
        super(-1, -1);
        this.color = SnakeGame.FOOD_COLOR;
    }

    public void eat(){
        this.setXY(-1, -1);
    }
    public boolean isEaten(){
        return this.getX() == -1;
    }

    public void next(Snake snake){
        int x, y;
        do{
            x = random.nextInt(SnakeGame.FIELD_WIDTH);
            y = random.nextInt(SnakeGame.FIELD_HIGHT);
        } while(snake.isInsideSnake(x, y));
        this.setXY(x, y);
    }
}

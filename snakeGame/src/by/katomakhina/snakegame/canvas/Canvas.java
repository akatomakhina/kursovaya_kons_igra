package by.katomakhina.snakegame.canvas;

import by.katomakhina.snakegame.entity.Snake;
import javax.swing.*;
import java.awt.*;

import by.katomakhina.snakegame.logic.SnakeGame;
import by.katomakhina.snakegame.entity.Food;
import by.katomakhina.snakegame.entity.Poison;


public class Canvas extends JPanel {
    private ImageIcon titleImage;

    public Snake snake = new Snake(SnakeGame.START_SNAKE_X, SnakeGame.START_SNAKE_Y, SnakeGame.START_SNAKE_SIZE, SnakeGame.START_DIRECTION);
    public Food food = new Food();
    public Poison poison = new Poison();

    @Override
    public void repaint() {
        super.repaint();
    }

    @Override
    public void paint (Graphics g){
        super.paint(g);
        snake.paint(g);
        food.paint(g);
        poison.paint(g);
        if(SnakeGame.gameOver){
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            FontMetrics fm = g.getFontMetrics();
            g.drawString(SnakeGame.GAME_OVER, (SnakeGame.FIELD_WIDTH * SnakeGame.POINT_RADIUS + SnakeGame.FIELD_DX - fm.stringWidth(SnakeGame.GAME_OVER))/2, (SnakeGame.FIELD_HIGHT * SnakeGame.POINT_RADIUS + SnakeGame.FIELD_DY)/2);
        }

        /*TITLE*/
        g.setColor(Color.white);
        g.drawRect(15, 10, 768, 55);

        titleImage = new ImageIcon("snake_title.png");
        titleImage.paintIcon(this, g, 238, 20);

        g.setColor(Color.white);
        g.drawRect(15, 80, 768, 378);
    }
}

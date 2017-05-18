package by.katomakhina.snakegame.logic;

import java.awt.*;                      //для работы с графическим интерфейсом
import java.awt.event.*;                //для обработки событий
import javax.swing.*;                   //для графического интерфейса

import by.katomakhina.snakegame.entity.Snake;
import by.katomakhina.snakegame.entity.Food;
import by.katomakhina.snakegame.entity.Poison;
import by.katomakhina.snakegame.canvas.Canvas;


public class SnakeGame {
    final public static String TITLE_OF_PROGRAM = "Snake Game";
    final public static String GAME_OVER = "GAME OVER";
    final public static int POINT_RADIUS = 20;        //пиксели на змейку
    final public static int FIELD_WIDTH = 40;         //в поинтах
    final public static int FIELD_HIGHT = 23;
    final public static int FIELD_DX = 6;
    final public static int FIELD_DY = 38;
    final public static int START_LOCATION = 200;     //стартовая позиция змейки

    /*ЗМЕЙКА*/
    final public static int START_SNAKE_SIZE = 3;
    final public static int START_SNAKE_X = 10;       //в поинтах
    final public static int START_SNAKE_Y = 10;
    final public static int SHOW_DELAY = 150;         //милисекунды

    /*НАПРАВЛЕНИЕ ДВИЖЕНИЯ*/
    final public static int LEFT = 37;                //37, 38, 39, 40 - коды клавиш
    final public static int UP = 38;
    final public static int RIGHT = 39;
    final public static int DOWN = 40;
    final public static int START_DIRECTION = RIGHT;   //первоначальное направление змейки

    /*ЦВЕТА*/
    final public static Color COLOR_DEFAULT = Color.white;
    final public static Color FOOD_COLOR = Color.green;
    final public static Color POISON_DEFAULT = Color.red;

    /*ПЕРЕМЕННЫЕ*/
    JFrame frame;
    Canvas canvasPanel;
    static public boolean gameOver = false;
    public static int showDelay = 100;         //милисекунды
    public static int speed = 0;
    public static int score = 0;
    public static int lvl = 1;
    public static int lvl_counter = 0;
    public static int counter = 0;

    public static enum STATE {
        GAME,
        MENU
    }

    public static STATE State = STATE.MENU;

    public static void main(String[] args) {
        new SnakeGame().go();
    }

    /*public static*/ void go() {
        frame = new JFrame(TITLE_OF_PROGRAM);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //закрывает окно при нажатии на exit
        frame.setSize(FIELD_WIDTH * POINT_RADIUS + FIELD_DX, FIELD_HIGHT * POINT_RADIUS + FIELD_DY);    //задает размер окна
        frame.setLocation(START_LOCATION, START_LOCATION);  //задает стартовое положение окна
        frame.setResizable(false);  //нельзя менять размеры окна

        /*КАНВА*/
        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.gray);

        /*ОБРАБОТЧИК КНОПОК КЛАВИАТУРЫ*/
        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);   //добавляет канву на панель, т.е. обновляет канву

        frame.addKeyListener(new KeyAdapter() {         //обработчик событий клавиатуры из пакета java.awt.event
            public void keyPressed(KeyEvent e) {        //keyPressed вызывается системой в случае нажатия любой клавиши на клавиатуре
                canvasPanel.snake.setDirection(e.getKeyCode());
            }
        });

        frame.addMouseListener(new MouseInput());

        frame.setVisible(true);

        while (!gameOver) {
            canvasPanel.snake.move(canvasPanel, frame);
            canvasPanel.repaint();
            if (canvasPanel.food.isEaten()) {
                canvasPanel.food.next(canvasPanel.snake);
                canvasPanel.poison.add(canvasPanel.snake, canvasPanel);
            }
            try {
                Thread.sleep(SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

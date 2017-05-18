package by.katomakhina.snakegame.menu;

import java.awt.*;

import by.katomakhina.snakegame.logic.SnakeGame;

public class Menu {

    public Rectangle playButton = new Rectangle(SnakeGame.FIELD_WIDTH / 2 + 330, 230, 100, 50);
    public Rectangle exitButton = new Rectangle(SnakeGame.FIELD_WIDTH / 2 + 330, 310, 100, 50);

    public void renger(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt = new Font("COMIC SANS MS", Font.BOLD, 40);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("BEST SNAKE GAME", SnakeGame.FIELD_WIDTH / 2 + 185, 150);

        Font fntPlay = new Font("COMIC SANS MS", Font.BOLD, 30);
        g.setFont(fntPlay);
        g.drawString("PLAY", playButton.x + 15, playButton.y + 37);

        Font fntExit = new Font("COMIC SANS MS", Font.BOLD, 30);
        g.setFont(fntExit);
        g.drawString("EXIT", exitButton.x + 15, exitButton.y + 40);

        g2d.draw(playButton);
        g2d.draw(exitButton);
    }
}

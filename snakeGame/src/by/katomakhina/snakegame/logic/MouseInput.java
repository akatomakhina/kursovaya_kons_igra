package by.katomakhina.snakegame.logic;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mx >= SnakeGame.FIELD_WIDTH / 2 + 330 && mx <= SnakeGame.FIELD_WIDTH / 2 + 430) {
            if (my >= 258 && my <= 308) {
                SnakeGame.State = SnakeGame.STATE.GAME;

            }
        }
        if (my >= 340 && my <= 390) {
            System.exit(1);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


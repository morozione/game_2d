package morozione;

import javax.swing.*;
import java.awt.*;

public class Wall {

    private int x;
    private int y;

    private Image iWallWeight1 = new ImageIcon("resources/wall1.png").getImage();
    private Image iWallWeight2 = new ImageIcon("resources/wall2.png").getImage();
    private Image iWallWeight3 = new ImageIcon("resources/wall3.png").getImage();
    private Image iWallWeight4 = new ImageIcon("resources/wall4.png").getImage();
    private Image iWallWeight5 = new ImageIcon("resources/wall5.png").getImage();
    private Image iMain = iWallWeight5;

    private LevelManager levelManager;

    public Wall() {
        levelManager = LevelManager.getInstance();

        makeStartPoint();
    }

    public void crashWall() {
        int level = levelManager.getLevelWall();

        if (level == 1) {
            iMain = iWallWeight5;
        } else if (level == 2) {
            iMain = iWallWeight4;
        } else if (level == 3) {
            iMain = iWallWeight3;
        } else if (level == 4) {
            iMain = iWallWeight2;
        } else if (level == 5) {
            iMain = iWallWeight1;
        }

        makeStartPoint();
    }

    private void makeStartPoint() {
        x = 450;
        y = Road.HEIGHT - iMain.getHeight(null) - 20;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, iMain.getWidth(null), iMain.getHeight(null));
    }

    public Image getImage() {
        return iMain;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

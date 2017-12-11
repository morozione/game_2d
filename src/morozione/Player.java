package morozione;

import javax.swing.*;
import java.awt.*;

public class Player {
    private int x, y;
    private int dx = 0;

    private Image iLevel1 = new ImageIcon("resources/image1.png").getImage();
    private Image iLevel2 = new ImageIcon("resources/image2.png").getImage();
    private Image iLevel3 = new ImageIcon("resources/image3.png").getImage();
    private Image iLevel4 = new ImageIcon("resources/image4.png").getImage();
    private Image iMain = iLevel1;

    private LevelManager levelManager;

    public Player() {
        levelManager = LevelManager.getInstance();

        makeStartPosition();
    }

    private void makeStartPosition() {
        x = 10;
        y = Road.HEIGHT - iMain.getHeight(null) - 20;
    }

    public void movePosition() {
        x += dx;
    }

    public void stopRide() {
        dx = 0;
        x = 10;
    }

    public void upperSpeed() {
        dx += 2;
    }

    public void upperLevel() {
        int level = levelManager.getLevel();

        if (level == 1) {
            iMain = iLevel1;
        } else if (level == 2) {
            iMain = iLevel2;
        } else if (level == 3) {
            iMain = iLevel3;
        } else if (level == 4) {
            iMain = iLevel4;
        }

        makeStartPosition();
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

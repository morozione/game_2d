package morozione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Road extends JPanel implements ActionListener, LevelManager.OnLevelUpdatedListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 250;

    private final Image iRoad = new ImageIcon("resources/road.png").getImage();

    private final LevelManager levelManager;

    private Timer mainThread = new Timer(50, this);

    private Player player;
    private Wall wall;

    public Road() {
        super();
        mainThread.start();

        player = new Player();
        wall = new Wall();

        levelManager = LevelManager.getInstance();
        levelManager.addLevelListener(this);

        makeListeners();
    }

    private void makeListeners() {
        addKeyListener(new MyKeyAdapter());
        addMouseListener(new MyMouseAdapter());
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g = (Graphics2D) g;

        g.drawImage(iRoad, 0, 0, null);
        g.drawImage(player.getImage(), player.getX(), player.getY(), null);
        g.drawImage(wall.getImage(), wall.getX(), wall.getY(), null);

        g.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("Level: " + levelManager.getLevel(), 10, 20);
        g.drawString(levelManager.getLevelWall() + " / 5", 230, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.movePosition();

        repaint();
        checkOnCrashWall();
    }

    private void checkOnCrashWall() {
        if (player.getRectangle().intersects(wall.getRectangle())) {
            player.stopRide();

            levelManager.crashWall();
            wall.crashWall();

            if (levelManager.getLevel() == LevelManager.MAX_LEVEL) {
                showWinnerDialog();
            }
        }
    }

    private void showWinnerDialog() {
        JOptionPane.showMessageDialog(null, "You winner!!!");
        System.exit(1);
    }

    @Override
    public void levelUpdated() {
        player.upperLevel();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            raid();
        }
    }

    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            raid();
        }
    }

    public void raid() {
        player.upperSpeed();
    }
}
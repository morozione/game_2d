package morozione;

import javax.swing.*;

public class Main {

    public static final String NAME_GAME = "Breaker";

    public static void main(String[] args) {
        JFrame frame = new JFrame(NAME_GAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Road.WIDTH, Road.HEIGHT);
        frame.add(new Road());
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
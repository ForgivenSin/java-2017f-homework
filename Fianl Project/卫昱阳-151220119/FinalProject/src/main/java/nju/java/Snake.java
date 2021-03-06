package nju.java;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Random;

/**
 * Created by Yuyang Wei on 2017/12/24.
 */
public class Snake extends Thing2D implements Runnable{
    private Field field;
    public Snake(int x, int y, Field field) {
        super(x, y);

        this.field = field;

        URL loc = this.getClass().getClassLoader().getResource("snake.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void move(int x, int y) {
        int nx = this.x() + x;
        int ny = this.y() + y;
        this.setX(nx);
        this.setY(ny);
    }

    public void run() {
        while (!Thread.interrupted()) {
            Random rand = new Random();

            this.move(rand.nextInt(10), rand.nextInt(10));
            try {

                Thread.sleep(rand.nextInt(1000) + 1000);
                this.field.repaint();

            } catch (Exception e) {

            }
        }
    }
}

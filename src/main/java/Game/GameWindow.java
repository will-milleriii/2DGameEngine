package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameWindow {
    private JFrame frame = new JFrame();
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy strategy;
    private Graphics graphics;

    public GameWindow(Container game){

        image = new BufferedImage(game.getWidth(), game.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension size = new Dimension((int)(game.getWidth() * game.getScale()), (int) (game.getHeight() * game.getScale()));
        canvas.setPreferredSize(size);
        canvas.setMaximumSize(size);
        canvas.setMinimumSize(size);

        frame = new JFrame(game.getTitle());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        strategy = canvas.getBufferStrategy();
        graphics = strategy.getDrawGraphics();

    }

    public void updateWindow(){
        graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        strategy.show();
    }

    public BufferedImage getImage() {
        return image;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    static private StateManager runningState;

    static private boolean running = true;
    static private double fpsCap = 60;
    static private int fps;

    public GamePanel() {
        addKeyListener(this);
        runningState = new StateManager();
        runningState.setState(new MenuState());
    }

    public void keyTyped(KeyEvent key) {
        runningState.keyPressed(key);
    }

    public void keyPressed(KeyEvent key) {
        runningState.keyPressed(key);
    }

    public void keyReleased(KeyEvent key) {
        runningState.keyPressed(key);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        runningState.render(g2);

        g2.setColor(Color.black);
        g2.drawString("FPS: " + fps, 10, 500 - 50);
    }

    public void run() {
        int frames = 0;

        double unprocessedSeconds = 0;
        long lastTime = System.nanoTime();
        double secondsPerTick = 1 / fpsCap;
        int tickCount = 0;

        requestFocus();

        while (running) {
            long now = System.nanoTime();
            long passedTime = now - lastTime;
            lastTime = now;
            if (passedTime < 0) {
                passedTime = 0;
            }
            if (passedTime > 100000000) {
                passedTime = 100000000;
            }

            unprocessedSeconds += passedTime / 1000000000.0;

            boolean ticked = false;
            while (unprocessedSeconds > secondsPerTick) {
                tick();
                unprocessedSeconds -= secondsPerTick;
                ticked = true;

                tickCount++;
                if (tickCount % fpsCap == 0) {
                    System.out.println(frames + " fps");
                    fps = frames;
                    lastTime += 1000;
                    frames = 0;
                }
            }

            if (ticked) {
                repaint();
                frames++;
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void tick() {
        runningState.update();
    }

    public static State getState() {
        return runningState;
    }

    public static void setState(State newState) {
        runningState.setState(newState);
    }
}

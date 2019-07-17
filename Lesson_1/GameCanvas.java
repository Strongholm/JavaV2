import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameCanvas extends JPanel {

    private final MainCircles MainCircles;
    private long lastFrameTime;
    private final int NUMBER_OF_BALLS = 10;
    private int countBalls = 0;
    private long currentTime;
    float deltaTime;
    private Ball balls[] = new Ball[NUMBER_OF_BALLS];

    GameCanvas(MainCircles _MainCircles) {
        MainCircles = _MainCircles;
        lastFrameTime = System.nanoTime();

        mouseCliks();

    }

    private void mouseCliks() {
        addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (countBalls < NUMBER_OF_BALLS) {
                        initBalls(countBalls);
                        countBalls++;
                    }
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    if (countBalls > 0) {
                        countBalls--;
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
            }
        });

    }

    int getLeft() {
        return 0;
    }
    int getRight() {
        return getWidth() - 1;
    }
    int getTop() {
        return 0;
    }
    int getBottom() {
        return getHeight() - 1;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        currentTime = System.nanoTime();
        deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;
        if (countBalls >= 0) {
            setPosition(this, deltaTime);
            drawBalls(this, g);
        }
        repaint();

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e);
        }
    }
    void initBalls(int i) {
        balls[i] = new Ball();
    }
    void setPosition(GameCanvas gameCanvas, float deltaTime) {
        for (int i = 0; i < countBalls; i++) {
            balls[i].update(gameCanvas, deltaTime);
        }
    }
    void drawBalls(GameCanvas gameCanvas, Graphics g) {
        for (int i = 0; i < countBalls; i++) {
            balls[i].render(gameCanvas, g);
        }
    }
}
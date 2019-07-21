import java.awt.Color;
import java.awt.Graphics;

public class Background extends GameCanvas {

    private int startLowBGUpdateTime = 50;
    private int lowBGUpdateTime = startLowBGUpdateTime;


    Background(MainCircles _MainCircles) {
        super(_MainCircles);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        lowBGUpdateTime--;

        if (lowBGUpdateTime == 0) {
            setBG(this);
            lowBGUpdateTime = startLowBGUpdateTime;
        }
    }

    void setBG(GameCanvas gameCanvas) {
        int gray = (int)(Math.random() * 256f);
        int green = (int)(Math.random() * 256f);
        int yellow = (int)(Math.random() * 256f);

        gameCanvas.setBackground(new Color(gray, green, yellow));

    }

}
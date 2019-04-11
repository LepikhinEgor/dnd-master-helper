package com.egorl.view;

import javax.swing.*;
import java.awt.*;

/**
 * This object show line, that indicate current value health, mana, stamina, breath and so on
 */
public class IndecatorLine extends JPanel {

    public static final int HEIGHT = 32;

    private String indicatorName;

    private int maxValue;
    private int currentValue;

    private Color lineColor;

    private Font font;

    /**
     * Create indicator line
     * @param indicatorName name of line
     * @param maxValue max indicator value
     * @param currentValue current indicator value
     */
    public IndecatorLine(String indicatorName, int maxValue, int currentValue, Color lineColor) {
        this.indicatorName = indicatorName;
        this.maxValue = maxValue;
        this.currentValue = currentValue;
        this.lineColor = lineColor;

        this.setPreferredSize(new Dimension(this.getWidth(), HEIGHT));

        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        Font font = new Font("Arial", Font.PLAIN, 12);
        g2.setFont(font);
        drawStringWithShadow(g2, indicatorName, 0,12);

        double coef = (double)currentValue/maxValue;

        Color oldColor = g2.getColor();
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 18, this.getWidth(), 10);
        g2.setColor(lineColor);
        g2.fillRect(0, 18, (int)(this.getWidth() * coef), 10);
        g2.setColor(oldColor);

    }

    private void drawStringWithShadow(Graphics2D g2, String text, int x, int y) {
        Color oldColor = g2.getColor();

        final int[][] shadowPositionArray = {{0, -1}, {1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, 0}, {0, 1}};
        final float[] shadowColorArray = {0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0, 0};

        int  offsetSize = 1;

        g2.setColor(Color.BLACK);
        for (int i = 0; i < shadowPositionArray.length; i++) {
            int dx = shadowPositionArray[i][0];
            int dy = shadowPositionArray[i][1];
            g2.setColor(new Color(0.3f, 0.3f, 0.3f, shadowColorArray[i]));

            int coordX =  x + dx * offsetSize;
            int coordY =  y + dy * offsetSize;
            g2.drawString(text, coordX, coordY);
        }

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        g2.setColor(oldColor);
    }
}

package com.egorl.view;

import com.egorl.model.GameCharacter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

/**
 * Panel that show brief information of Character:
 * name, icon, indicator lines
 */
public class CharacterPanel extends JPanel {

    private final static Logger logger = LoggerFactory.getLogger(CharacterPanel.class);

    private final int DEFAULT_HEIGHT = 260;

    private final double ICON_LEFT_MARGIN_COEF = 0.12;
    private final double ICON_RIGHT_MARGIN_COEF = 0.12;
    private final double INDICATOR_MARGIN_COEF = 0.05;

    private final int NAME_FONT_SIZE = 16;
    private final int ICON_TOP_MARGIN = 14;
    private final int ICON_BOTTOM_MARGIN = 5;

    private Image backgroundImage;

    private int iconLeftMargin;
    private int iconRightMargin;

    /**
     * Character icon, expect size 256*256
     */
    private Image characterIcon;
    private Dimension iconDimension;

    private GameCharacter character;

    IndecatorLine[] indicatorlines;

    private final int[][] shadowPositionArray = {{0, -1}, {1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, 0}, {0, 1}};
    private final float[] shadowColorArray = {0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0, 0};

    /**
     * Create a character panel
     * @param icon icon fo character
     * @param character character object
     * @param linesName array of indicator lines
     */
    public CharacterPanel(Image icon, GameCharacter character, String[] linesName) {
        super();

        this.setLayout(null);
        this.characterIcon = icon;

        setPanelSize(2);
        this.character = character;

        indicatorlines = new IndecatorLine[2];
        indicatorlines[0] = new IndecatorLine("Health",100,90, Color.RED);
        indicatorlines[1] = new IndecatorLine("Stamina",100,60, Color.GREEN);

        if (characterIcon != null) {
            logger.info("ss");
//            drawIcon();
        }
//
        for(IndecatorLine indecatorLine: indicatorlines) {
            this.add(indecatorLine);
        }

        try{
            backgroundImage = ImageIO.read(new File("src/main/resources/images/ui/characters-background.jpg"));
        } catch(IOException ex) {
            logger.error(ex.toString());
        }

        repaint();
        this.setVisible(true);
    }

    private void setPanelSize(int linesNum) {
        int width = this.getWidth();
        int height = DEFAULT_HEIGHT + linesNum * IndecatorLine.HEIGHT;

        setPreferredSize(new Dimension(width, height));
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (character != null) {
            //drawing background because java bug draw not correct
            g2.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);

            drawCharacterIcon(g2);
            drawCharacterName(g2);

            for(IndecatorLine characteristicPanel: indicatorlines) {
                int firstLineY = ICON_TOP_MARGIN + NAME_FONT_SIZE + iconDimension.height + ICON_BOTTOM_MARGIN;
                for (int i = 0; i < indicatorlines.length; i++) {
                    int lineCoordY = firstLineY + i * IndecatorLine.HEIGHT;
                    int lineMargin = (int)(this.getWidth() * INDICATOR_MARGIN_COEF);
                    indicatorlines[i].setBounds(lineMargin, lineCoordY, this.getWidth()-lineMargin*2, IndecatorLine.HEIGHT);
                }
                characteristicPanel.repaint();
            }

        }
        g2.setBackground(Color.red);


    }

    private void drawCharacterName(Graphics2D g2) {
        String name = this.character.getName();
        final int FONT_SIZE = 16;

        Font oldFont = g2.getFont();
        Font font = new Font("Arial", Font.ITALIC, FONT_SIZE);
        g2.setFont(font);

        FontMetrics metrics = g2.getFontMetrics();
        double textWidth = metrics.getStringBounds(name, g2).getWidth();

        int coordX =  (int)(this.getWidth() / 2 - textWidth / 2);
        int coordY = FONT_SIZE + 4;

        drawStringWithShadow(g2, name, coordX, coordY);

        g2.setFont(oldFont);

    }

    /**
     * Drawing character icon, using margins coefs
     * align center
     * @param g2
     */
    private void drawCharacterIcon(Graphics2D g2) {
        iconLeftMargin = (int)(this.getWidth() * ICON_LEFT_MARGIN_COEF);
        iconRightMargin = (int)(this.getWidth() * ICON_RIGHT_MARGIN_COEF);

        int iconWidth = (int)(this.getWidth() - iconLeftMargin - iconRightMargin);
        int iconHeight = iconWidth;

        iconDimension = new Dimension(iconWidth, iconHeight);

        g2.drawImage(characterIcon, iconLeftMargin, ICON_TOP_MARGIN + NAME_FONT_SIZE, iconWidth, iconHeight, null);
    }

    /**
     * Draw string with outline
     * @param g2
     * @param text
     * @param x
     * @param y
     */
    private void drawStringWithShadow(Graphics2D g2, String text, int x, int y) {
        Color oldColor = g2.getColor();

        final int[][] shadowPositionArray = {{0, -1}, {1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, 0}, {0, 1}};
        final float[] shadowColorArray = {0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0.5f, 0, 0};

        int  offsetSize = 1;

        g2.setColor(Color.BLACK);
        for (int i = 0; i < shadowPositionArray.length; i++) {
            int dx = shadowPositionArray[i][0];
            int dy = shadowPositionArray[i][1];
            g2.setColor(new Color(0.5f, 0.5f, 0.5f, shadowColorArray[i]));

            int coordX =  x + dx * offsetSize;
            int coordY =  y + dy * offsetSize;
            g2.drawString(text, coordX, coordY);
        }

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        g2.setColor(oldColor);
    }
}

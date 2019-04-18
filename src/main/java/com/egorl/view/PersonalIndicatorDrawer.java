package com.egorl.view;

import com.egorl.model.CharacterSkill;
import com.egorl.model.PersonalIndicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PersonalIndicatorDrawer extends JPanel {

    private final int ICON_SIZE = 45;

    private static final Logger logger = LoggerFactory.getLogger(SkillDrawer.class);

    private PersonalIndicator personalIndicator;

    private Image backgroundImage;

    public PersonalIndicator getPersonalIndicator() {
        return personalIndicator;
    }

    public PersonalIndicatorDrawer(PersonalIndicator personalIndicator) {
        this.personalIndicator = personalIndicator;

        logger.info(this.getWidth()+"");
        this.setVisible(true);

        try{
            backgroundImage = ImageIO.read(new File("src/main/resources/images/ui/skill-background.jpg"));
        } catch(IOException ex) {
            logger.error(ex.toString());
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
        g2.setColor(new Color(240,240,240));
        g2.fillRect(0,0,this.getWidth(),this.getHeight());

        drawSkillName(g2);

        g2.setColor(Color.GRAY);
        g2.drawLine(0, this.getHeight()-1, this.getWidth(),this.getHeight()-1);
    }

    private void drawSkillName(Graphics2D g2) {
        String name = this.personalIndicator.getName();
        final int FONT_SIZE = 16;

        Font oldFont = g2.getFont();
        Font font = new Font("Arial", Font.PLAIN, FONT_SIZE);
        g2.setFont(font);

        FontMetrics metrics = g2.getFontMetrics();
        double textWidth = metrics.getStringBounds(name, g2).getWidth();

        int coordX =  (int)(this.getWidth() / 2 - textWidth / 2);
        int coordY = this.getHeight()/2 +FONT_SIZE/2 -2;

        drawStringWithShadow(g2, name, coordX, coordY);

        g2.setFont(oldFont);

    }

    private void drawStringWithShadow(Graphics2D g2, String text, int x, int y) {
        Color oldColor = g2.getColor();

        final int[][] shadowPositionArray = {{0, -1}, {1, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, 0}, {0, 1}};
        final float[] shadowColorArray = {0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0.3f, 0, 0};

        int  offsetSize = 1;

        g2.setColor(Color.BLACK);
        for (int i = 0; i < shadowPositionArray.length; i++) {
            int dx = shadowPositionArray[i][0];
            int dy = shadowPositionArray[i][1];
//            g2.setColor(new Color(0.5f, 0.5f, 0.5f, shadowColorArray[i]));
            g2.setColor(new Color(0.5f, 0.5f, 0.5f, 0.5f));

            int coordX =  x + dx * offsetSize;
            int coordY =  y + dy * offsetSize;
            g2.drawString(text, coordX, coordY);
        }

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        g2.setColor(oldColor);
    }
}

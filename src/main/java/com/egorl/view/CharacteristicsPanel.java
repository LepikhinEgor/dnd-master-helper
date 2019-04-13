package com.egorl.view;

import com.egorl.model.CharacterMainCharacteristic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

public class CharacteristicsPanel extends JPanel {
    private final static Logger logger = LoggerFactory.getLogger(CharacteristicsPanel.class);

    private CharacterMainCharacteristic[] characteristics;

    public CharacteristicsPanel(CharacterMainCharacteristic[] characteristics) {
        super();
        this.characteristics = characteristics;
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.CYAN);
    }

    @Override
    public void paint(Graphics g) {
        logger.info("fffff");
        Graphics2D g2 = (Graphics2D)g;

        for (int i = 1; i < characteristics.length; i++) {
            g2.drawString(characteristics[i].getName(), 0, i*30);
            g2.drawString(characteristics[i].getValue() + "", this.getWidth() - 50, i*30);
        }
    }
}

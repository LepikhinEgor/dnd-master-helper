package com.egorl.view;

import com.egorl.model.CharacterMainCharacteristic;
import com.egorl.model.CharacterSkill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

public class PersonalPanel extends JPanel {
    private final static Logger logger = LoggerFactory.getLogger(AbilitiesPanel.class);

    private final int SKILL_DRAWER_HEIGHT = 50;

    @Autowired
    private PersonalIndicatorDrawer[] personalIndicatorDrawers;


    public PersonalPanel() {
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.CYAN);
        this.setLayout(null);
    }

    public void fill() {
        for (int i = 0; i < personalIndicatorDrawers.length; i++) {
            this.add(personalIndicatorDrawers[i]);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        for (int i = 0; i < personalIndicatorDrawers.length; i++) {
            personalIndicatorDrawers[i].setBounds(0, i*SKILL_DRAWER_HEIGHT, this.getWidth(), SKILL_DRAWER_HEIGHT);
            personalIndicatorDrawers[i].repaint();
        }
    }
}

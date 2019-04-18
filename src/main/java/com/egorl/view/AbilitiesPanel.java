package com.egorl.view;

import com.egorl.model.CharacterMainCharacteristic;
import com.egorl.model.CharacterSkill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

public class AbilitiesPanel extends JPanel {
    private final static Logger logger = LoggerFactory.getLogger(AbilitiesPanel.class);

    private final int SKILL_DRAWER_HEIGHT = 50;

    @Autowired
    private AbilityDrawer[] abilityDrawers;


    public AbilitiesPanel() {
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.CYAN);
        this.setLayout(null);
    }

    public void fill() {
        for (int i = 0; i < abilityDrawers.length; i++) {
            this.add(abilityDrawers[i]);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        for (int i = 0; i < abilityDrawers.length; i++) {
            abilityDrawers[i].setBounds(0, i*SKILL_DRAWER_HEIGHT, this.getWidth(), SKILL_DRAWER_HEIGHT);
            abilityDrawers[i].repaint();
        }
    }
}
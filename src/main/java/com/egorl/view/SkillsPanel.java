package com.egorl.view;

import com.egorl.model.CharacterMainCharacteristic;
import com.egorl.model.CharacterSkill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;

public class SkillsPanel extends JPanel {
    private final static Logger logger = LoggerFactory.getLogger(SkillsPanel.class);

    private final int SKILL_DRAWER_HEIGHT = 50;

    @Autowired
    private SkillDrawer[] skillDrawers;


    public SkillsPanel() {
        super();
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.CYAN);
        this.setLayout(null);
    }

    public void fill() {
        for (int i = 0; i < skillDrawers.length; i++) {
            this.add(skillDrawers[i]);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        for (int i = 0; i < skillDrawers.length; i++) {
           skillDrawers[i].setBounds(0, i*SKILL_DRAWER_HEIGHT, this.getWidth(), SKILL_DRAWER_HEIGHT);
           skillDrawers[i].repaint();
        }
    }
}


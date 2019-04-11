package com.egorl;

import com.egorl.model.GameCharacter;
import com.egorl.view.AppCreator;
import com.egorl.view.CharacterPanel;
import com.egorl.view.MainWindow;
import com.egorl.view.ScrollCharactersPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;
import java.awt.*;

@Configuration
public class ViewsConfiguration {

//    @Autowired
//    @Qualifier("charactersPanel1")
//    private JPanel charactersPanel;

    @Bean()
    GridBagConstraints charactersPanelConstraints() {
        GridBagConstraints characterConstraints = new GridBagConstraints();

        characterConstraints.anchor = GridBagConstraints.WEST;
        characterConstraints.gridx = GridBagConstraints.RELATIVE;
        characterConstraints.gridy = 0;
        characterConstraints.gridheight = GridBagConstraints.REMAINDER;
        characterConstraints.weightx = 0.15;
        characterConstraints.weighty = 1;
        characterConstraints.gridwidth = 30;
        characterConstraints.anchor = GridBagConstraints.NORTH;
        characterConstraints.fill = GridBagConstraints.BOTH;

        return characterConstraints;
    }

    @Bean()
    JPanel charactersPanel() {
        JPanel charactersPanel = new JPanel();

        charactersPanel.setBackground(Color.green);
        GridLayout layout = new GridLayout(4,1);
        charactersPanel.setLayout(new GridLayout(0,1));

        return charactersPanel;
    }

    @Bean()
    ScrollCharactersPane scrollCharactersPanel() {
        ScrollCharactersPane charactersPanel = new ScrollCharactersPane(charactersPanel());

        charactersPanel.setBackground(Color.green);

        return charactersPanel;
    }

    @Bean()
    JPanel mainPanel() {
        JPanel charactersPanel = new JPanel();

        charactersPanel.setBackground(Color.blue);
        charactersPanel.setVisible(true);

        return charactersPanel;
    }

    @Bean()
    GridBagConstraints mainPanelConstraints() {
        GridBagConstraints characterConstraints = new GridBagConstraints();

        characterConstraints.anchor = GridBagConstraints.WEST;
        characterConstraints.gridx = GridBagConstraints.RELATIVE;
        characterConstraints.gridy = 0;
        characterConstraints.gridheight = GridBagConstraints.REMAINDER;
        characterConstraints.weightx = 0.85;
        characterConstraints.weighty = 1;
        characterConstraints.gridwidth = 30;
        characterConstraints.anchor = GridBagConstraints.NORTH;
        characterConstraints.fill = GridBagConstraints.HORIZONTAL;

        return characterConstraints;
    }
//
    @Bean
    CharacterPanel jackSparrowPanel() {
        String[] indicators = {"Health","Stamina","Breath"};
        CharacterPanel jackSparrowPanel = new CharacterPanel(null, jackSparrowCharacter(), indicators);

        return jackSparrowPanel;
    }
//
    @Bean
    GameCharacter jackSparrowCharacter() {
        GameCharacter jackSparrow = new GameCharacter();
        jackSparrow.setName("Jack Sparrow");

        return jackSparrow;
    }


    @Bean
    MainWindow mainWindow() {
        return new MainWindow();
    }

    @Bean
    AppCreator appCreator() {
        return new AppCreator();
    }
}

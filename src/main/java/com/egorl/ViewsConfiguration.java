package com.egorl;

import com.egorl.model.*;
import com.egorl.view.*;
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
        JPanel mainPanel = new JPanel();

        mainPanel.setBackground(Color.blue);
        mainPanel.setVisible(true);

        return mainPanel;
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
        characterConstraints.fill = GridBagConstraints.BOTH;

        return characterConstraints;
    }

    @Bean
    CharacteristicsPanel characteristicsPanel() {
        CharacterMainCharacteristic[] characteristics = new CharacterMainCharacteristic[5];
        characteristics[0] = new CharacterMainCharacteristic("Power", 1);
        characteristics[1] = new CharacterMainCharacteristic("Power", 2);
        characteristics[2] = new CharacterMainCharacteristic("Power", 3);
        characteristics[3] = new CharacterMainCharacteristic("Power", 4);
        characteristics[4] = new CharacterMainCharacteristic("Power", 5);

        return  new CharacteristicsPanel(characteristics);
    }

    @Bean
    SkillDrawer[] skillDrawers() {
        SkillDrawer[] skillDrawers = new SkillDrawer[5];
        skillDrawers[0] = new SkillDrawer(new CharacterSkill("skill1", true));
        skillDrawers[1] = new SkillDrawer(new CharacterSkill("skill2", true));
        skillDrawers[2] = new SkillDrawer(new CharacterSkill("skill3", true));
        skillDrawers[3] = new SkillDrawer(new CharacterSkill("skill4", true));
        skillDrawers[4] = new SkillDrawer(new CharacterSkill("skill5", true));

        return skillDrawers;
    }

    @Bean
    AbilityDrawer[] abilityDrawers() {
        AbilityDrawer[] abilityDrawers = new AbilityDrawer[5];
        abilityDrawers[0] = new AbilityDrawer(new CharacterAbility("skill1", 50));
        abilityDrawers[1] = new AbilityDrawer(new CharacterAbility("skill2", 60));
        abilityDrawers[2] = new AbilityDrawer(new CharacterAbility("skill3", 70));
        abilityDrawers[3] = new AbilityDrawer(new CharacterAbility("skill4", 80));
        abilityDrawers[4] = new AbilityDrawer(new CharacterAbility("skill5", 90));

        return abilityDrawers;
    }

    @Bean
    PersonalIndicatorDrawer[] personalIndicatorDrawers() {
        PersonalIndicatorDrawer[] personalIndicatorDrawers = new PersonalIndicatorDrawer[5];
        personalIndicatorDrawers[0] = new PersonalIndicatorDrawer(new PersonalIndicator("skill1", "qwert"));
        personalIndicatorDrawers[1] = new PersonalIndicatorDrawer(new PersonalIndicator("skill2", "gergtrg"));
        personalIndicatorDrawers[2] = new PersonalIndicatorDrawer(new PersonalIndicator("skill3", "rtghtrg"));
        personalIndicatorDrawers[3] = new PersonalIndicatorDrawer(new PersonalIndicator("skill4", "rhrg"));
        personalIndicatorDrawers[4] = new PersonalIndicatorDrawer(new PersonalIndicator("skill5", "egetge"));

        return personalIndicatorDrawers;
    }
    @Bean
    PersonalPanel personalPanel() {
        return new PersonalPanel();
    }

    @Bean
    AbilitiesPanel abilitiesPanel() {
        return new AbilitiesPanel();
    }

    @Bean
    SkillsPanel skillsPanel() {
        return new SkillsPanel();
    }

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

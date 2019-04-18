package com.egorl.view;

import com.egorl.model.CharacterMainCharacteristic;
import com.egorl.model.GameCharacter;
import com.egorl.properties.UserProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AppCreator {

    private final static Logger logger = LoggerFactory.getLogger(AppCreator.class);

    private final String APP_NAME = "Master helper";

    @Autowired
    private MainWindow mainWindow;

    /**
     * Object with user properties and preferenses
     */
    private UserProperties userProperties;

    /**
     * Panel that contains charactersPanel on the left side
     */
    @Autowired
    @Qualifier("scrollCharactersPanel")
    public ScrollCharactersPane charactersPanel;

    @Autowired
    @Qualifier("charactersPanelConstraints")
    public GridBagConstraints charactersPanelConstraints;

    /**
     * Main panel that containts map and character detail information
     */
    @Autowired
    @Qualifier("mainPanel")
    private JPanel mainPanel;

    @Autowired
    @Qualifier("mainPanelConstraints")
    private GridBagConstraints mainPanelConstraints;

    @Autowired
    private CharacteristicsPanel characteristicsPanel;

    @Autowired
    private SkillsPanel skillsPanel;

    @Autowired
    private AbilitiesPanel abilitiesPanel;

    @Autowired
    private PersonalPanel personalPanel;

    public AppCreator() {
        userProperties = UserProperties.getInstance();
    }

    public void createApp() {
        mainWindow.setTitle(APP_NAME);

        mainWindow.setSize(userProperties.getUserScreenWidth(), userProperties.getUserScreenHeight());
        mainWindow.setExtendedState(Frame.MAXIMIZED_BOTH);

        GameCharacter sparrow1 = new GameCharacter();
        sparrow1.setName("Sparrow");
        GameCharacter sparrow2 = new GameCharacter();
        sparrow2.setName("Sparrow2");
        GameCharacter sparrow3 = new GameCharacter();
        sparrow3.setName("Sparrow2");
        GameCharacter sparrow4 = new GameCharacter();
        sparrow4.setName("Sparrow2");
        String[] lines = {"Health", "Mana"};

        Image steisIcon = null;
        Image bloodIcon = null;
//        Image charactersBack = null;

        try{
            bloodIcon = ImageIO.read(new File("src/main/resources/images/characters/blood.jpg"));
            steisIcon = ImageIO.read(new File("src/main/resources/images/characters/steis.jpg"));
//            charactersBack = ImageIO.read(new File("src/main/resources/images/ui/characters-background.jpg"));
        } catch(IOException ex) {
            logger.error(ex.toString());
        }

        if(bloodIcon == null)
            logger.error("123");
        else
            logger.error(((BufferedImage) bloodIcon).getWidth()+"");

        if(steisIcon == null)
            logger.error("321");

        CharacterPanel sparrowPanel = new CharacterPanel(steisIcon,sparrow1, lines);
        CharacterPanel sparrowPanel1 = new CharacterPanel(bloodIcon,sparrow2, lines);
        CharacterPanel sparrowPanel2 = new CharacterPanel(bloodIcon,sparrow3, lines);
        CharacterPanel sparrowPanel3 = new CharacterPanel(bloodIcon,sparrow4, lines);
        CharacterPanel sparrowPanel4 = new CharacterPanel(bloodIcon,sparrow4, lines);

        charactersPanel.addCharacterPanel(sparrowPanel);
        charactersPanel.addCharacterPanel(sparrowPanel1);
        charactersPanel.addCharacterPanel(sparrowPanel2);
        charactersPanel.addCharacterPanel(sparrowPanel3);
        charactersPanel.addCharacterPanel(sparrowPanel4);

        GridBagLayout mainWindowLayout = mainWindow.getGridBagLayout();
        mainWindowLayout.setConstraints(charactersPanel, charactersPanelConstraints);
        mainWindow.add(charactersPanel);
        logger.info(mainWindowLayout.getConstraints(charactersPanel).weightx + "");

//        mainPanel.add(characteristicsPanel);
        skillsPanel.fill();
        abilitiesPanel.fill();
        personalPanel.fill();
//        JSplitPane firstPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, characteristicsPanel, skillsPanel);
        JScrollPane skillsScroll = new JScrollPane(skillsPanel);
        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setPreferredSize(new Dimension(500, 500));
        JPanel facePanel = new JPanel();
        facePanel.setPreferredSize(new Dimension(500, 500));
        JSplitPane firstPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, skillsScroll, characteristicsPanel);
        JSplitPane secondPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, facePanel, personalPanel);
        JSplitPane thirdPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, abilitiesPanel, inventoryPanel);
        mainWindowLayout.setConstraints(mainPanel, mainPanelConstraints);
        mainPanel.add(firstPane);
        mainPanel.add(secondPane);
        mainPanel.add(thirdPane);
        mainWindow.add(mainPanel);
        mainWindow.repaint();
        logger.info(mainWindowLayout.getConstraints(mainPanel).weightx + "");
        mainWindow.setVisible(true);

    }
}

package com.egorl.view;

import com.egorl.model.GameCharacter;
import com.egorl.properties.UserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * Main window, that contains all programm
 * Uses gridBagLayout
 * @author egor
 */
@Component
public class MainWindow extends JFrame {

    /**
     * Panel that contains charactersPanel on the left side
     */
    public JPanel charactersPanel;

    public GridBagConstraints charactersPanelConstraints;

    /**
     * Main panel that containts map and character detail information
     */
    private JPanel mainPanel;

    private GridBagConstraints mainPanelConstraints;

    private GridBagLayout gridBagLayout;

    public MainWindow() {
        gridBagLayout = new GridBagLayout();
        this.setLayout(gridBagLayout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public GridBagLayout getGridBagLayout(){
        return this.gridBagLayout;
    }
}

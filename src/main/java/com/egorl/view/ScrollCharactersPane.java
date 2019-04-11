package com.egorl.view;

import javax.swing.*;
import java.awt.*;

public class ScrollCharactersPane extends JScrollPane {
    private JPanel charactersPanel;

    public ScrollCharactersPane(Component var1) {
        super(var1, 20, 30);

        if(var1 instanceof JPanel) {
            JPanel panel = (JPanel) var1;
            this.charactersPanel = panel;
        } else {
            throw new IllegalArgumentException("Requared JPanel object in arg");
        }
    }

    public void addCharacterPanel(CharacterPanel characterPanel) {
        charactersPanel.add(characterPanel);
    }
}

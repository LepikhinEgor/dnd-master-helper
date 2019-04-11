package com.egorl.properties;

import java.awt.*;

/**
 * Singleton class that contains user properties and preferences
 */
public class UserProperties {

    private static UserProperties instance;

    private int userScreenWidth;
    private int userScreenHeight;

    private UserProperties() {
        setUserScreenSize();
    }

    public static UserProperties getInstance() {
        if (instance == null)
            instance = new UserProperties();
        return instance;
    }

    public int getUserScreenWidth() {
        return userScreenWidth;
    }

    public int getUserScreenHeight() {
        return userScreenHeight;
    }

    /**
     * get user screen size from system
     */
    private void setUserScreenSize() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();

        userScreenWidth = graphicsDevice.getDisplayMode().getWidth();
        userScreenHeight = graphicsDevice.getDisplayMode().getHeight();
    }
}

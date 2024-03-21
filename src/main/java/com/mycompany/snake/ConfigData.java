/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;

/**
 *
 * @author gmd
 */
public class ConfigData {
    public static final Color HEAD_COLOR = Color.RED;
    public static final Color BODY_COLOR = Color.YELLOW;
    public static final Color FOOD_COLOR = Color.BLACK;
    public static final Color SPECIAL_FOOD_COLOR = Color.BLACK;
    
    public static final Color BACKGROUND1 = new Color(210, 170, 88);
    public static final Color BACKGROUND2 = new Color(198, 166, 100);
    
    private static ConfigData configData = new ConfigData();
    private int deltaTime;
    
    private ConfigData(){
        deltaTime = 250;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }
    
    public static ConfigData getInstance(){
        return configData;
    }
    
}

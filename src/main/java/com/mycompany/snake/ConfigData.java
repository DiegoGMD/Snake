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
   
    public static  Color headColor = new Color(0);
    public static  Color bodyColor = new Color(0);
    public static  Color background1 = new Color(0);
    public static  Color background2 = new Color(0);
    public static  Color foodColor = new Color(0);
    public static  Color specialFoodColor = new Color(0);
    private static ConfigData configData = new ConfigData();
    private int deltaTime;
    private int score;
    
    private ConfigData(){
        deltaTime = 250;
        headColor = new Color(79, 111, 156);
        bodyColor = new Color(79, 121, 181);
        background1 = new Color(118, 204, 86);
        background2 = new Color(94, 180, 68);
        foodColor = Color.red;
        specialFoodColor = Color.yellow;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public static ConfigData getInstance(){
        return configData;
    }

    public static Color getHeadColor() {
        return headColor;
    }

    public static void setHeadColor(Color headColor) {
        ConfigData.headColor = headColor;
    }

    public static Color getBodyColor() {
        return bodyColor;
    }

    public static void setBodyColor(Color bodyColor) {
        ConfigData.bodyColor = bodyColor;
    }

    public static Color getBackground1() {
        return background1;
    }

    public static void setBackground1(Color background1) {
        ConfigData.background1 = background1;
    }

    public static Color getBackground2() {
        return background2;
    }

    public static void setBackground2(Color background2) {
        ConfigData.background2 = background2;
    }

    public static Color getFoodColor() {
        return foodColor;
    }

    public static void setFoodColor(Color foodColor) {
        ConfigData.foodColor = foodColor;
    }

    public static Color getSpecialFoodColor() {
        return specialFoodColor;
    }

    public static void setSpecialFoodColor(Color specialFoodColor) {
        ConfigData.specialFoodColor = specialFoodColor;
    }
    
    
}

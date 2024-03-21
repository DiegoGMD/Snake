/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author gmd
 */
public class Food {

    private Node food;

    public Food() {
        
        food = new Node(Util.generateRandom(), Util.generateRandom());
    }
    
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Color color;
        color = new Color(171, 123, 89);
        Util.drawSquare(g, food.getRow(), food.getCol(), color, squareWidth, squareHeight);
    }
}

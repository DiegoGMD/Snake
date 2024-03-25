/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author gmd02
 */
public class SuperFood {
    private Node superFood;

    public SuperFood() {
        superFood = new Node(Util.generateRandom(Board.NUM_ROWS), Util.generateRandom(Board.NUM_COLS));
    }
        
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Color color;
        color = new Color(255, 0, 0);
        Util.drawSquare(g, superFood.getRow(), superFood.getCol(), color, squareWidth, squareHeight);
    }
    
    public Node getFood() {
        return superFood;
    }
}

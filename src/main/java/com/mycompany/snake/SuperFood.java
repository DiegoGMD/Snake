/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class SuperFood {
    private Node superFood;

    public SuperFood(List<Node> body) {
        boolean correct = false;
        while (!correct) {
            correct = true;
            int foodRow = Util.generateRandom(Board.NUM_ROWS - 1);
            int foodCol = Util.generateRandom(Board.NUM_COLS - 1);
            for (Node node : body) {
                if (node.getRow() == foodRow && node.getCol() == foodCol) {
                    correct = false;
                }
                if (correct) {
                    superFood = new Node(foodRow, foodCol);
                }
            }
        }
    }
        
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Color color = new Color(255, 192, 0);
        Util.drawSquare(g, superFood.getRow(), superFood.getCol(), color, squareWidth, squareHeight);
    }
    
    public Node getSuperFood() {
        return superFood;
    }
}


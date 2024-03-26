/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

/**
 *
 * @author gmd
 */
public class ScoreBoard extends JTextField {
    private int score = 0;

    public ScoreBoard() {
        score = 0;
        setFont(new Font("Oswald", Font.BOLD, 20));
        setBackground(Color.black);
        setForeground(Color.red);
    }

    public void increment() {
        score += 1;
        displayScore();
    }

    public void reset() {
        score = 0;
        displayScore();
    }

    private void displayScore() {
        setText("Score: " + score);
    }
}
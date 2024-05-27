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

    // Constructor de la clase ScoreBoard
    public ScoreBoard() {
        score = 0; // Inicializa el puntaje en 0
        setFont(new Font("Oswald", Font.BOLD, 20)); // Establece la fuente del texto
        setBackground(Color.black); // Establece el color de fondo
        setForeground(Color.red); // Establece el color del texto
    }

    // Método para incrementar el puntaje
    public void increment(int points) {
        score += points;
        displayScore(); // Muestra el puntaje actualizado
    }

    // Método para reiniciar el puntaje
    public void reset() {
        score = 0;
        displayScore();
    }

    // Método privado para mostrar el puntaje en el cuadro de texto
    private void displayScore() {
        setText("Score: " + score); // Establece el texto del cuadro de texto con el puntaje actual
    }
}

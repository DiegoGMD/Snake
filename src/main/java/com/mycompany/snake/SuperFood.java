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
        boolean correct = false; // Variable para controlar si la posición de la super comida es válida
        while (!correct) { // Repetir hasta encontrar una posición válida
            correct = true;
            int foodRow = Util.generateRandom(Board.NUM_ROWS - 1);
            int foodCol = Util.generateRandom(Board.NUM_COLS - 1);
            for (Node node : body) { // Recorrer los nodos del cuerpo de la serpiente
                if (node.getRow() == foodRow && node.getCol() == foodCol) { // Si la posición generada coincide con alguna parte del cuerpo de la serpiente
                    correct = false; // La posición no es válida
                }
                if (correct) { // Si la posición es válida
                    superFood = new Node(foodRow, foodCol); // Crear un nuevo nodo para la super comida en esa posición
                }
            }
        }
    }

    // Método para pintar la super comida en el tablero
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Color color = new Color(255, 192, 0); // Establecer el color de la super comida (naranja)
        Util.drawSquare(g, superFood.getRow(), superFood.getCol(), color, squareWidth, squareHeight); // Dibujar la super comida en el tablero
    }

    public Node getSuperFood() {
        return superFood;
    }
}

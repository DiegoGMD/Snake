/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gmd
 */
public class Food {

    private Node food;
// Constructor que recibe el cuerpo de la serpiente como lista de nodos

    public Food(List<Node> body) {
        boolean correct = false; // Variable para controlar si la posición de la comida es válida
        while (!correct) { // Repetir hasta encontrar una posición válida
            correct = true; // Asumir que la posición generada es correcta
            int foodRow = Util.generateRandom(Board.NUM_ROWS - 1); // Generar una fila aleatoria para la comida
            int foodCol = Util.generateRandom(Board.NUM_COLS - 1); // Generar una columna aleatoria para la comida
            for (Node node : body) { // Recorrer los nodos del cuerpo de la serpiente
                if (node.getRow() == foodRow && node.getCol() == foodCol) { // Si la posición generada coincide con alguna parte del cuerpo de la serpiente
                    correct = false; // La posición no es válida
                }
                if (correct) { // Si la posición es válida
                    food = new Node(foodRow, foodCol); // Crear un nuevo nodo para la comida en esa posición
                }
            }
        }
    }

    // Método para pintar la comida en el tablero
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        Color color; // Variable para el color de la comida
        color = new Color(255, 0, 0); // Establecer el color de la comida (rojo)
        Util.drawSquare(g, food.getRow(), food.getCol(), color, squareWidth, squareHeight); // Dibujar la comida en el tablero
    }

    // Método para obtener el nodo de la comida
    public Node getFood() {
        return food; // Devolver el nodo de la comida
    }
}

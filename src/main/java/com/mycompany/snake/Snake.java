/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import static com.mycompany.snake.Board.NUM_COLS;
import static com.mycompany.snake.Board.NUM_ROWS;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gmd
 */
public class Snake extends javax.swing.JPanel {

    private List<Node> body; // Lista que almacena los nodos del cuerpo de la serpiente
    private Direction direction;
    private int nodesToGrow;
    private boolean gameOver; // Estado del juego

    // Constructor de la clase Snake
    public Snake() {
        body = new ArrayList<Node>(); // Inicializa la lista del cuerpo
        // Añade los nodos iniciales al cuerpo de la serpiente
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 3));
        direction = Direction.RIGHT; // Establece la dirección inicial de la serpiente
        nodesToGrow = 0; // Inicializa el crecimiento de la serpiente en 0
        gameOver = false; // Inicializa el estado del juego como no terminado
    }

    // Método para pintar la serpiente en el tablero
    public void paint(Graphics g, int squareWidth, int squareHeight) {
        boolean firstNode = true; // Variable para identificar la cabeza de la serpiente
        Color color; // Color del nodo
        for (Node node : body) { // Recorre cada nodo del cuerpo de la serpiente
            if (firstNode) {
                color = ConfigData.getHeadColor(); // Color de la cabeza de la serpiente
                firstNode = false; // Marca que la cabeza ya ha sido dibujada
            } else {
                color = ConfigData.getBodyColor(); // Color del cuerpo de la serpiente
            }
            Util.drawSquare(g, node.getRow(), node.getCol(), color, squareWidth, squareHeight); // Dibuja el nodo
        }
    }

    public Node getHead() {
        return body.get(0);
    }

    public Node getTail() {
        return body.get(body.size() - 1);
    }

    public List<Node> getBody() {
        return body;
    }

    public int getNodesToGrow() {
        return nodesToGrow;
    }

    public void setNodesToGrow(int nodesToGrow) {
        this.nodesToGrow = nodesToGrow;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.gameOver = isGameOver;
    }

    // Método para mover la serpiente
    //Funciona dando la ilusión de movimiento añadiendo y eliminando nodos delante y detrás
    public void moveSnake() {
        Node head = getHead(); // Obtiene la cabeza de la serpiente
        int row = head.getRow(); // Obtiene la fila de la cabeza
        int col = head.getCol(); // Obtiene la columna de la cabeza
        switch (direction) { // Cambia el comportamiento según la dirección
            case UP:
                if (canMove(row - 1, col)) {
                    body.add(0, new Node(row - 1, col));// Añade un nuevo nodo que será la cabeza
                } else {
                    gameOver = true; // Marca el juego como terminado si no puede moverse
                }
                break;
            case DOWN:
                if (canMove(row + 1, col)) {
                    body.add(0, new Node(row + 1, col));
                } else {
                    gameOver = true;
                }
                break;
            case LEFT:
                if (canMove(row, col - 1)) {
                    body.add(0, new Node(row, col - 1));
                } else {
                    gameOver = true;
                }
                break;
            case RIGHT:
                if (canMove(row, col + 1)) {
                    body.add(0, new Node(row, col + 1));
                } else {
                    gameOver = true;
                }
                break;
        }
        if (nodesToGrow == 0) {
            body.remove(body.size() - 1); // Elimina el último nodo si no tiene que crecer
        } else {
            nodesToGrow -= 1; // Decrementa el número de nodos que tiene que crecer
        }
    }

    // Método para verificar si la serpiente puede moverse a una posición dada
    public boolean canMove(int row, int col) {
        if (row < 0 || row >= Board.NUM_ROWS
                || col < 0 || col >= Board.NUM_COLS) {
            return false; // Retorna falso si la posición está fuera de los límites del tablero
        }
        for (int i = 1; i < (body.size() - 1); i++) {
            if (body.get(i).getRow() == row && body.get(i).getCol() == col) {
                return false; // Retorna falso si la posición coincide con alguna parte del cuerpo de la serpiente
            }
        }
        return true; // Retorna verdadero si la posición es válida
    }

    // Método para obtener la dirección actual de la serpiente
    public Direction getDirection() {
        return direction; // Devuelve la dirección actual
    }

    // Método para establecer la dirección de la serpiente
    public void setDirection(Direction direction) {
        this.direction = direction; // Establece la nueva dirección
    }
}

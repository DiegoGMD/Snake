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

    private List<Node> body;
    private Direction direction;
    private int nodesToGrow;
    private boolean gameOver;

    public Snake() {
        body = new ArrayList<Node>();
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 1));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 2));
        body.add(new Node(Board.NUM_ROWS / 2, Board.NUM_COLS / 2 - 3));
        direction = Direction.RIGHT;
        nodesToGrow = 0;
        gameOver = false;
    }

    public void paint(Graphics g, int squareWidth, int squareHeight) {
        boolean firstNode = true;
        Color color;
        for (Node node : body) {
            if (firstNode) {
                color = new Color(156, 111, 79);
                firstNode = false;
            } else {
                color = new Color(181, 121, 79);
            }
            Util.drawSquare(g, node.getRow(), node.getCol(), color, squareWidth, squareHeight);
        }
    }
    
    public Node getHead() {
        return body.get(0);
    }
    
    public Node getTail() {
        return body.get(body.size() - 1);
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

    public void moveSnake() {
        Node head = getHead();
        int row = head.getRow();
        int col = head.getCol();
        switch(direction){
            case UP:
                if(canMove (row - 1, col)){
                    body.add(0, new Node(row - 1, col));
                } else {
                    gameOver = true;
                }
                break;
            case DOWN:
                if(canMove (row + 1, col)){
                    body.add(0, new Node(row + 1, col));
                } else {
                    gameOver = true;
                }
                break;
            case LEFT:
                if(canMove (row, col - 1)){
                    body.add(0, new Node(row, col - 1));
                } else {
                    gameOver = true;
                }
                break;
            case RIGHT:
                if(canMove (row, col + 1)){
                    body.add(0, new Node(row, col + 1));
                }
                else {
                    gameOver = true;
                }
                break;
        }
        if (nodesToGrow == 0){
            body.remove(body.size() - 1);
        } else {
            nodesToGrow -= 1;
        }
    }
    
    public boolean canMove(int row, int col) {
        if (row < 0 || row >= Board.NUM_ROWS || 
                col < 0 || col >= Board.NUM_COLS){
            return false;
        }
        for (int i = 1; i < (body.size() - 1); i++){
            if (body.get(i).getRow() == row && body.get(i).getCol() == col){
                return false;
            }
        }
        return true;
    }
    
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

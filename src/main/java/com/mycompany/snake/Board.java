/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author gmd
 */
public class Board extends javax.swing.JPanel {

    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 30;
    private int currentRow;
    private int currentCol;
    private MyKeyAdapter keyAdapter;
    private Graphics g;
    private Snake snake;
    private Food food;
    private Timer timer;
    private TimerText timerText;
    private ScoreBoard scoreBoard;
    private boolean executingMovement;
    private boolean startGame;

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (!executingMovement) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (snake.getDirection() != Direction.RIGHT) {
                            snake.setDirection(Direction.LEFT);
                            executingMovement = true;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (snake.getDirection() != Direction.LEFT) {
                            snake.setDirection(Direction.RIGHT);
                            executingMovement = true;

                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (snake.getDirection() != Direction.DOWN) {
                            snake.setDirection(Direction.UP);
                            executingMovement = true;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (snake.getDirection() != Direction.UP) {
                            snake.setDirection(Direction.DOWN);
                            executingMovement = true;
                        }
                        break;
                    default:
                        break;
                }
            }
            repaint();
        }
    }

    public Board() {
        initComponents();
        setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
        setPreferredSize(new Dimension(NUM_ROWS * 15, NUM_COLS * 15));
        keyAdapter = new MyKeyAdapter();
        addKeyListener(keyAdapter);
        setFocusable(true);

    }

    public void initGame() {
        snake = new Snake();
        food = new Food();
        int deltaTime = ConfigData.getInstance().getDeltaTime();
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(deltaTime, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.restart();
        timerText.start();
    }

    public int getSquareWidth() {
        return getWidth() / NUM_COLS;
    }

    public int getSquareHeight() {
        return getHeight() / NUM_ROWS;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBackground(g);
        if (snake != null) {
            snake.paint(g, getSquareWidth(), getSquareHeight());
        }
        if (food != null) {
            food.paint(g, getSquareWidth(), getSquareHeight());
        }
        getToolkit().getDefaultToolkit().sync();
    }

    public void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        BasicStroke bs = new BasicStroke(1);
        g2d.setStroke(bs);
        g2d.drawRect(0, 0, NUM_COLS * getSquareWidth() - 2, NUM_ROWS * getSquareHeight() - 2);
        getToolkit().getDefaultToolkit().sync();
    }

    public void paintBackground(Graphics g) {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if ((row + col) % 2 == 0) {
                    Util.drawSquare(g, row, col, ConfigData.getBackground1(), getSquareWidth(), getSquareHeight());
                } else {
                    Util.drawSquare(g, col, row, ConfigData.getBackground2(), getSquareWidth(), getSquareHeight());
                }
            }
        }
        getToolkit().getDefaultToolkit().sync();
    }

    public void tick() {
        if (snake.isGameOver()) {
            timerText.stop();
            JOptionPane.showMessageDialog(null, "You LOOSE", "GAME OVER", JOptionPane.ERROR_MESSAGE);
            timer.stop();
        } else {
            snake.moveSnake();
            executingMovement = false;
            repaint();
            checkFood();
        }
    }

    public void checkFood() {
        if (snake.getHead().getRow() == food.getFood().getRow()
                && snake.getHead().getCol() == food.getFood().getCol()) {
            food = new Food();
            snake.setNodesToGrow(1);
            scoreBoard.increment();
            while (snake.colidesWithSnake(food)) {
                food = new Food();
            }
        }
    }

    public void setTimerText(TimerText timerText) {
        this.timerText = timerText;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

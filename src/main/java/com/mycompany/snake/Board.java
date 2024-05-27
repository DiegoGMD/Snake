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
    private SuperFood superFood;
    private Timer timer;
    private TimerText timerText;
    private ScoreBoard scoreBoard;
    private boolean executingMovement;
    private boolean startGame;
    private int counterRemainingTime = 0;

    // Clase que extiende KeyAdapter para jugar con el teclado
    class MyKeyAdapter extends KeyAdapter {

        // Método que se llama cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
            if (!executingMovement) { // Si no se está ejecutando un movimiento
                switch (e.getKeyCode()) { // Verifica la tecla presionada
                    case KeyEvent.VK_LEFT:
                        if (snake.getDirection() != Direction.RIGHT) { // Si la dirección de la serpiente no es derecha
                            snake.setDirection(Direction.LEFT); // Cambia la dirección a izquierda
                            executingMovement = true; // Marca que se está ejecutando un movimiento
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
            repaint();// Redibuja el componente
        }
    }
// Constructor de la clase Board

    public Board() {
        initComponents(); // Inicializa componentes
        setLayout(new GridLayout(NUM_ROWS, NUM_COLS)); // Establece el layout del tablero
        setPreferredSize(new Dimension(NUM_ROWS * 15, NUM_COLS * 15)); // Establece el tamaño preferido del tablero
        keyAdapter = new MyKeyAdapter(); // Crea una instancia del adaptador de teclado
        addKeyListener(keyAdapter); // Añade el adaptador de teclado
        setFocusable(true); // Hace que el tablero sea foco de eventos de teclado
    }
// Inicializa el juego

    public void initGame() {
        snake = new Snake();// Crea una nueva serpiente
        food = new Food(snake.getBody());// Crea nueva comida basada en la posición de la serpiente
        int deltaTime = ConfigData.getInstance().getDeltaTime();// Obtiene el tiempo de la configuración
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(deltaTime, new ActionListener() {// Crea un nuevo temporizador
            @Override
            public void actionPerformed(ActionEvent e) {
                tick();// Llama al método tick en cada tick del temporizador
            }
        });
        timer.restart(); // Reinicia el temporizador
        timerText.start(); // Inicia el temporizador del texto
    }

    public int getSquareWidth() {
        return getWidth() / NUM_COLS;
    }

    public int getSquareHeight() {
        return getHeight() / NUM_ROWS;
    }
// Método que se llama para pintar el componente

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);// Llama al método de la superclase
        paintBackground(g);// Pinta el fondo
        if (snake != null) {
            snake.paint(g, getSquareWidth(), getSquareHeight());// Pinta la serpiente
        }
        if (food != null) {
            food.paint(g, getSquareWidth(), getSquareHeight());// Pinta la comida
        }
        if (superFood != null) {
            superFood.paint(g, getSquareWidth(), getSquareHeight());// Pinta la supercomida
        }
        getToolkit().getDefaultToolkit().sync();// Sincroniza la actualización de la pantalla
    }

    // Método para pintar el borde del tablero
    public void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK); // Establece el color del borde
        BasicStroke bs = new BasicStroke(1); // Establece el grosor del borde
        g2d.setStroke(bs);
        g2d.drawRect(0, 0, NUM_COLS * getSquareWidth() - 2, NUM_ROWS * getSquareHeight() - 2); // Dibuja el borde
        getToolkit().getDefaultToolkit().sync(); // Sincroniza la actualización de la pantalla
    }

    // Método para pintar el fondo del tablero
    public void paintBackground(Graphics g) {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                if ((row + col) % 2 == 0) {
                    /* Para pintar en posiciones alternas */
                    Util.drawSquare(g, row, col, ConfigData.getBackground1(), getSquareWidth(), getSquareHeight()); // Pinta el fondo con el color principal
                } else {
                    Util.drawSquare(g, col, row, ConfigData.getBackground2(), getSquareWidth(), getSquareHeight()); // Pinta el fondo con el color secundario
                }
            }
        }
        getToolkit().getDefaultToolkit().sync(); // Sincroniza la actualización de la pantalla
    }
// Método para pintar el borde del tablero

    public void tick() {
        if (snake.isGameOver()) {
            timerText.stop(); // Detén el texto del tiempo (el que se muestra en pantalla)
            JOptionPane.showMessageDialog(null, "You LOOSE", "GAME OVER", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de fin de juego
            timer.stop(); // Detén el temporizador
        } else {
            snake.moveSnake(); // Mueve la serpiente
            executingMovement = false; // Booleano para indicar q no se está haciendo ningún movimiento
            repaint(); // Redibuja el componente
            checkFood(); // Verifica si la serpiente ha comido
            checkSuperFood(); // Verifica si la serpiente ha comido supercomida
        }
    }

// Verifica si la serpiente ha comido comida
    public void checkFood() {
        if (snake.getHead().getRow() == food.getFood().getRow() // Si la cabeza de la serpiente está en la misma posición que la comida
                && snake.getHead().getCol() == food.getFood().getCol()) {
            food = new Food(snake.getBody()); // Crea nueva comida
            snake.setNodesToGrow(1); // Crece la serpiente en un nodo
            scoreBoard.increment(1); // Incrementa el marcador en 1 punto
        }
    }

    // Verifica si la serpiente ha comido supercomida
    public void checkSuperFood() {
        if (superFood != null) {
            if (snake.getHead().getRow() == superFood.getSuperFood().getRow() // Si la cabeza de la serpiente está en la misma posición que la supercomida
                    && snake.getHead().getCol() == superFood.getSuperFood().getCol()) {
                superFood = null; // Elimina la supercomida
                snake.setNodesToGrow(3); // Crece la serpiente en tres nodos
                scoreBoard.increment(3); // Incrementa el marcador en 3 puntos
            }
            if (counterRemainingTime == 0) {
                superFood = null; // Elimina la supercomida
            }
            counterRemainingTime--; // Decrementa el contador de tiempo restante para desaparecer
        } else {
            if (Math.random() < 0.01) { // Probabilidad de 1% de que aparezca supercomida
                superFood = new SuperFood(snake.getBody());
                counterRemainingTime = (int) (Math.random() * 13 + 3); // Establece el tiempo de duración de la supercomida entre 3 y 15
            }
        }
    }

// Establece el temporizador del texto
    public void setTimerText(TimerText timerText) {
        this.timerText = timerText;
    }

// Establece el marcador
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
        setPreferredSize(new java.awt.Dimension(450, 450));

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

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

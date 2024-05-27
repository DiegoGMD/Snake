/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author gmd
 */
public class Util {

    public static void drawSquare(Graphics g, int row, int col, Color color, int squareWidth, int squareHeight) {
        int x = col * squareWidth; // Calcular la posición x en el tablero
        int y = row * squareHeight; // Calcular la posición y en el tablero
        g.setColor(color);// Establecer el color del gráfico
        g.fillRect(x + 1, y + 1, squareWidth - 2, squareHeight - 2);// Dibujar el relleno del cuadrado
        g.setColor(color.brighter());// Establecer un color más brillante para los bordes superiores e izquierdos
        g.drawLine(x, y + squareHeight - 1, x, y);// Dibujar la línea superior del borde
        g.drawLine(x, y, x + squareWidth - 1, y);// Dibujar la línea izquierda del borde
        g.setColor(color.darker());// Establecer un color más oscuro para los bordes inferiores y derechos
        g.drawLine(x + 1, y + squareHeight - 1, x + squareWidth - 1, y + squareHeight - 1);// Dibujar la línea inferior del borde
        g.drawLine(x + squareWidth - 1, y + squareHeight - 1, x + squareWidth - 1, y + 1);// Dibujar la línea derecha del borde
    }

    public static int generateRandom(int number) {
        // Generar un número aleatorio entre 1 y el valor de number (inclusive)
        return (int) (Math.random() * number + 1);
    }
}

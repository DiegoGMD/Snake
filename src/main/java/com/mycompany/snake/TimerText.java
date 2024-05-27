/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author gmd
 */
public class TimerText extends JTextField {

    private Timer timer;
    private int seconds = 0;
    private int minutes = 0;

    public TimerText() {
        seconds = 0;
        minutes = 0;

        // Crear un nuevo temporizador que se ejecuta cada 1000 milisegundos (1 segundo)
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTime(); // Actualizar la visualización del tiempo
                if (seconds == 59) { // Si los segundos llegan a 59
                    minutes++; // Incrementar los minutos
                    seconds = 0; // Reiniciar los segundos a 0
                } else {
                    seconds++; // Incrementar los segundos
                }
            }
        });

        // Configurar la fuente del texto del temporizador
        setFont(new Font("Oswald", Font.BOLD, 20));
        // Configurar el color de fondo del temporizador
        setBackground(Color.black);
        // Configurar el color del texto del temporizador
        setForeground(Color.red);
    }

    public void start() {
        timer.start();
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    public void stop() {
        if (timer.isRunning()) {
            timer.stop();
        }
    }

    public void reset() {
        timer.stop();
        seconds = 0;
        minutes = 0;
        displayTime();
    }

    // Método para actualizar y mostrar el tiempo transcurrido
    private void displayTime() {
        // Establecer el texto del temporizador con el formato "Time: MM:SS"
        setText("Time: " + (minutes < 10 ? "0" : "") + minutes
                + ":" + (seconds < 10 ? "0" : "") + seconds);
    }

    public int getSeconds() {
        return seconds;
    }

}

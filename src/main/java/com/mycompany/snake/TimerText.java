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
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTime();
                if (seconds == 59) {
                    minutes++;
                    seconds = 0;
                } else {
                    seconds++;
                }
            }
        });
        setFont(new Font("Press Start 2P", Font.BOLD, 20));
        setBackground(Color.black);
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

    private void displayTime() {
        setText("Time:" + (minutes < 10 ? "0" : "") + minutes
                + ":" + (seconds < 10 ? "0" : "") + seconds);
    }

}

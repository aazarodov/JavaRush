package com.zarodov.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by zarodov on 16.12.2016.
 */
public class PanelPelota extends JPanel implements Runnable {
    private  static final long serialVersionUID = 1L;
    private int pelotaX = 10, pelotaY = 100, jug1X = 10, jug1Y = 100, jug2X = 230, jug2Y = 100;
    Thread hilo;
    int derecha = 5;
    int izquierda = -5;
    int arriba = 5;
    int abajo = -5;
    int ancho, alto;
    int contPlay1 = 0, contPlay2 = 0;
    boolean player1FlagArr, player1FlagAba, player2FlagArr, player2FlagAba;
    boolean juego, gameOver;

    public PanelPelota() {
        juego = true;
        hilo = new Thread(this);
        hilo.start();
    }

    public void paintComponent(Graphics gc) {
        setOpaque(false);
        super.paintComponent(gc);

        gc.setColor(Color.BLACK);
        gc.fillOval(pelotaX, pelotaY, 8, 8);
        gc.fillRect(jug1X, jug1Y, 10, 25);
        gc.fillRect(jug2X, jug2Y, 10, 25);
        gc.drawString("Player 1: " + contPlay1, 25, 10);
        gc.drawString("Player 2: " + contPlay2, 150, 10);

        if (gameOver)
            gc.drawString("Game over", 100, 125);
    }

    public void dibujarPelota(int nx, int ny) {
        pelotaX = nx;
        pelotaY = ny;
        this.ancho = this.getWidth();
        this.alto = this.getHeight();
        repaint();
    }

    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_W :
                player1FlagArr = true; break;
            case KeyEvent.VK_S :
                player1FlagAba = true; break;
            case KeyEvent.VK_UP :
                player2FlagArr = true; break;
            case KeyEvent.VK_DOWN :
                player2FlagAba = true; break;
        }
    }

    public void keyReleased(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_W:
                player1FlagArr = false; break;
            case KeyEvent.VK_S:
                player1FlagAba = false; break;
            case KeyEvent.VK_UP:
                player2FlagArr = false; break;
            case KeyEvent.VK_DOWN:
                player2FlagAba = false; break;
        }
    }

    public void moverPlayer1() {
        if (player1FlagArr && jug1Y >= 1)
            jug1Y += abajo;
        if (player1FlagAba && jug1Y <= (this.getHeight() - 25))
            jug1Y += arriba;
        dibujarPlayer1(jug1X, jug1Y);
    }

    public void moverPlayer2() {
        if (player2FlagArr && jug2Y >= 1)
            jug2Y += abajo;
        if (player2FlagAba && jug2Y <= (this.getHeight() - 25))
            jug2Y += arriba;
        dibujarPlayer2(jug2X, jug2Y);
    }

    private void dibujarPlayer1(int x, int y) {
        this.jug1X = x;
        this.jug1Y = y;
        repaint();
    }

    private void dibujarPlayer2(int x, int y) {
        this.jug2X = x;
        this.jug2Y = y;
        repaint();
    }

    public void run() {
        boolean izqDer = false;
        boolean arrAba = false;

        while (true) {
            if (juego) {
                if (izqDer) {
                    pelotaX += derecha;
                    if (pelotaX >= (ancho - 8))
                        izqDer = false;
                } else {
                    pelotaX += izquierda;
                    if (pelotaX <= 0)
                        izqDer = true;
                }

                if (arrAba) {
                    pelotaY += arriba;
                    if (pelotaY >= (alto - 8))
                        arrAba = false;
                } else {
                    pelotaY += abajo;
                    if (pelotaY <= 0)
                        arrAba = true;
                }

                dibujarPelota(pelotaX, pelotaY);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {}

                moverPlayer1();
                moverPlayer2();

                if (pelotaX >= (ancho - 8))
                    contPlay1++;
                if (pelotaX == 0)
                    contPlay2++;
                if (contPlay1 == 6 || contPlay2 == 6) {
                    juego = false;
                    gameOver = true;
                }

                if (pelotaX == jug1X + 10 && pelotaY >= jug1Y && pelotaY <= (jug1Y + 25))
                    izqDer = false;

                if (pelotaX == (jug2X - 5) && pelotaY >= jug2Y && pelotaY <= (jug2Y + 25))
                    izqDer = false;
            }
        }
    }
}

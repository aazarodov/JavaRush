package com.zarodov.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by zarodov on 16.12.2016.
 */
public class PanelBall extends JPanel implements Runnable {
    private int ballX = 10, ballY = 100, racket1X = 10, racket1Y = 100, racket2X = 230, racket2Y = 100;
    Thread thread;
    int right = 5;
    int left = -5;
    int up = 5;
    int down = -5;
    int Width, Height;
    int pointPlay1 = 0, pointPlay2 = 0;
    boolean player1FlagUp, player1FlagDown, player2FlagUp, player2FlagDown;
    boolean gamming, gameOver;

    public PanelBall() {
        gamming = true;
        thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics gc) {
        setOpaque(false);
        super.paintComponent(gc);

        gc.setColor(Color.BLACK);
        gc.fillOval(ballX, ballY, 8, 8);
        gc.fillRect(racket1X, racket1Y, 10, 25);
        gc.fillRect(racket2X, racket2Y, 10, 25);
        gc.drawString("Player 1: " + pointPlay1, 25, 10);
        gc.drawString("Player 2: " + pointPlay2, 150, 10);

        if (gameOver)
            gc.drawString("Game over", 100, 125);
    }

    public void drawBall(int nx, int ny) {
        ballX = nx;
        ballY = ny;
        this.Width = this.getWidth();
        this.Height = this.getHeight();
        repaint();
    }

    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_W :
                player1FlagUp = true; break;
            case KeyEvent.VK_S :
                player1FlagDown = true; break;
            case KeyEvent.VK_UP :
                player2FlagUp = true; break;
            case KeyEvent.VK_DOWN :
                player2FlagDown = true; break;
        }
    }

    public void keyReleased(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_W:
                player1FlagUp = false; break;
            case KeyEvent.VK_S:
                player1FlagDown = false; break;
            case KeyEvent.VK_UP:
                player2FlagUp = false; break;
            case KeyEvent.VK_DOWN:
                player2FlagDown = false; break;
        }
    }

    public void movePlayer1() {
        if (player1FlagUp && racket1Y >= 1)
            racket1Y += down;
        if (player1FlagDown && racket1Y <= (this.getHeight() - 25))
            racket1Y += up;
        drawPlayer1(racket1X, racket1Y);
    }

    public void movePlayer2() {
        if (player2FlagUp && racket2Y >= 1)
            racket2Y += down;
        if (player2FlagDown && racket2Y <= (this.getHeight() - 25))
            racket2Y += up;
        drawPlayer2(racket2X, racket2Y);
    }

    private void drawPlayer1(int x, int y) {
        this.racket1X = x;
        this.racket1Y = y;
        repaint();
    }

    private void drawPlayer2(int x, int y) {
        this.racket2X = x;
        this.racket2Y = y;
        repaint();
    }

    public void run() {
        boolean leftRight = false;
        boolean upDown = false;

        while (true) {
            if (gamming) {
                if (leftRight) {
                    ballX += right;
                    if (ballX >= (Width - 8))
                        leftRight = false;
                } else {
                    ballX += left;
                    if (ballX <= 0)
                        leftRight = true;
                }

                if (upDown) {
                    ballY += up;
                    if (ballY >= (Height - 8))
                        upDown = false;
                } else {
                    ballY += down;
                    if (ballY <= 0)
                        upDown = true;
                }

                drawBall(ballX, ballY);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {}

                movePlayer1();
                movePlayer2();

                if (ballX >= (Width - 8))
                    pointPlay1++;
                if (ballX == 0)
                    pointPlay2++;
                if (pointPlay1 == 6 || pointPlay2 == 6) {
                    gamming = false;
                    gameOver = true;
                }

                if (ballX == racket1X + 10 && ballY >= racket1Y && ballY <= (racket1Y + 25))
                    leftRight = false;

                if (ballX == (racket2X - 5) && ballY >= racket2Y && ballY <= (racket2Y + 25))
                    leftRight = false;
            }
        }
    }
}

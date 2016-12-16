package com.zarodov.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by zarodov on 16.12.2016.
 */
public class Main extends JFrame {
    private JPanel jContentPanel = null;
    private PanelBall panel = null;

    private PanelBall getPanel() {
        if (panel == null)
            panel = new PanelBall();
        return panel;
    }

    public Main() {
        super();
        initialize();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                formKeyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                formKeyReleased(e);
            }
        });
    }

    private void initialize() {
        this.setResizable(false);
        this.setBounds(new Rectangle(312, 184, 250, 250));
        this.setMinimumSize(new Dimension(250, 250));
        this.setMaximumSize(new Dimension(250, 250));
        this.setContentPane(getJContentPane());
        this.setTitle("Pong");
    }

    private void formKeyPressed(KeyEvent e) {
        panel.keyPressed(e);
    }

    private void formKeyReleased(KeyEvent e) {
        panel.keyReleased(e);
    }


    public JPanel getJContentPane() {
        if  (jContentPanel == null) {
            jContentPanel = new JPanel();
            jContentPanel.setLayout(new BorderLayout());
            jContentPanel.add(getPanel(), BorderLayout.CENTER);
        }
        return jContentPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main thisClass = new Main();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }
}

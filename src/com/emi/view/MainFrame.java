package com.emi.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JDialog dialog;
    private boolean stopDialog;

    public MainFrame() {
        int choice = JOptionPane.showOptionDialog(null,
                "Choose option", "Option dialog",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"Settings", "Close"}, null);

        if (choice != JOptionPane.YES_OPTION)
            System.exit(0);

        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void showDialog(Color color, int seconds, int delay) throws InterruptedException {
        Thread.sleep(1000*delay);
        stopDialog = false;
        dialog = new JDialog(this, false);
        dialog.setSize(new Dimension(400, 400));
        dialog.setVisible(true);

        SwingWorker sw = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                while (!stopDialog) {
                    dialog.getContentPane().setBackground(color);
                    Thread.sleep(1000 * seconds);
                    dialog.getContentPane().setBackground(Color.WHITE);
                    Thread.sleep(1000 * seconds);
                }
                return null;
            }
        };
        sw.execute();

    }

    public void isStopped() {
        stopDialog = true;
        if (dialog != null)
            dialog.dispose();
    }

}

package com.emi.view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.List;

public class PanelNo2 extends JPanel {
    private JButton chooseColorButton;
    private JLabel currentTimeLabel;
    private ColorChooser colorChooser;

    public PanelNo2() {
        chooseColorButton = new JButton("Choose color");
        chooseColorButton.setPreferredSize(new Dimension(200,40));
        chooseColorButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(chooseColorButton, "Choose color", Color.CYAN);
            currentTimeLabel.setForeground(color);
            if (colorChooser != null)
                colorChooser.setColor(color);
        });

        currentTimeLabel = new JLabel();
        currentTimeLabel.setPreferredSize(new Dimension(50,20));

        SwingWorker<String, String> sw = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                while (true) {
                    LocalTime time;
                    Thread.sleep(1000);
                    time = LocalTime.now();
                    publish(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
                }
            }

            @Override
            protected void process(List<String> chunks) {
                currentTimeLabel.setText(chunks.get(0));
            }
        };
        sw.execute();

        setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        add(chooseColorButton);
        add(currentTimeLabel);
    }

    public void chooseColor(ColorChooser colorChooser) {
        this.colorChooser = colorChooser;
    }

}

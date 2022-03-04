package com.emi.view;

import javax.swing.*;
import java.awt.*;

public class PanelNo4 extends JPanel {
    private JButton startButton;
    private JButton stopButton;
    private StartStopButtonsPressed startButtonPressed;
    private StartStopButtonsPressed stopButtonPressed;

    public PanelNo4() {
        startButton = new JButton("Start Countdown");
        startButton.setPreferredSize(new Dimension(200,40));
        startButton.addActionListener(e -> {
            if (startButtonPressed != null)
                startButtonPressed.pressStartButton();
        });

        stopButton = new JButton("Stop");
        stopButton.setPreferredSize(new Dimension(100,40));
        stopButton.addActionListener(e -> {
            startButton.setEnabled(true);
            if (stopButtonPressed != null)
                stopButtonPressed.pressStopButton();
        });


        setLayout(new FlowLayout(FlowLayout.CENTER, 10,10));
        add(startButton);
        add(stopButton);
    }

    public void pressStartButton(StartStopButtonsPressed startButtonPressed) {
        this.startButtonPressed = startButtonPressed;
    }

    public void pressStopButton(StartStopButtonsPressed stopButtonPressed) {
        this.stopButtonPressed = stopButtonPressed;
    }

    public void disableStartButton() {
        startButton.setEnabled(false);
    }

}

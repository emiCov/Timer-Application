package com.emi.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class PanelNo3 extends JPanel {
    private JLabel speedLabel;
    private JComboBox<Integer> speedChoice;
    private SecondsChooser secondsChooser;

    public PanelNo3() {
        speedLabel = new JLabel("speed");

        speedChoice = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});

        speedChoice.addItemListener(e -> {
            if (e.getStateChange() != ItemEvent.SELECTED)
                return;
            int seconds = (int) e.getItem();
            if (secondsChooser != null)
                secondsChooser.setSeconds(seconds);
        });

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(speedLabel);
        add(speedChoice);
    }

    public void setSeconds(SecondsChooser secondsChooser) {
        this.secondsChooser = secondsChooser;
    }

}

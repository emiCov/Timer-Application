package com.emi.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PanelNo1 extends JPanel {
    private JRadioButton onTimeRB;
    private JRadioButton countdownRB;
    private ButtonGroup choices;
    private JFormattedTextField onTimeField;
    private JTextField countdownField;

    public PanelNo1() {
        onTimeRB = new JRadioButton("on time:");
        onTimeRB.setBackground(Color.lightGray);
        countdownRB = new JRadioButton("countdown (sec):");
        countdownRB.setBackground(Color.lightGray);

        choices = new ButtonGroup();
        onTimeRB.setSelected(true);
        countdownRB.setSelected(true);
        choices.add(onTimeRB);
        choices.add(countdownRB);

        try {
            onTimeField = new JFormattedTextField(new MaskFormatter("##:##:##"));
        } catch (ParseException e) {
            e.getStackTrace();
        }
        onTimeField.setPreferredSize(new Dimension(150, 20));

        countdownField = new JTextField();
        countdownField.setPreferredSize(new Dimension(150, 20));

        setLayout(new GridBagLayout());
        GridBagConstraints gcPanelNo1 = new GridBagConstraints();

        gcPanelNo1.gridx = 0;
        gcPanelNo1.gridy = 0;
        gcPanelNo1.anchor = GridBagConstraints.LINE_START;
        add(onTimeRB, gcPanelNo1);

        gcPanelNo1.gridx = 0;
        gcPanelNo1.gridy = 1;
        gcPanelNo1.anchor = GridBagConstraints.LINE_START;
        add(countdownRB, gcPanelNo1);

        gcPanelNo1.gridx = 1;
        gcPanelNo1.gridy = 0;
        gcPanelNo1.anchor = GridBagConstraints.LINE_END;
        gcPanelNo1.insets = new Insets(0, 100, 0, 0);
        add(onTimeField, gcPanelNo1);

        gcPanelNo1.gridx = 1;
        gcPanelNo1.gridy = 1;
        gcPanelNo1.anchor = GridBagConstraints.LINE_END;
        add(countdownField, gcPanelNo1);

        Border outBorder = BorderFactory.createEmptyBorder();
        Border inBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        setBorder(new CompoundBorder(outBorder, inBorder));

    }

    public String getDelay() {
        String delay = null;

        long difference;

        LocalTime timeNow = LocalTime.now();

        String textTime = onTimeField.getText();
        String textCountdown = countdownField.getText();

        onTimeRB.setActionCommand("onTime");
        countdownRB.setActionCommand("countdown");

        String choice = choices.getSelection().getActionCommand();

        if (choice.equals("onTime")) {
            try {
                int hourEntered = Integer.parseInt(textTime.split(":")[0]);
                int minuteEntered = Integer.parseInt(textTime.split(":")[1]);
                int secondEntered = Integer.parseInt(textTime.split(":")[2]);

                if (hourEntered > 24 || minuteEntered > 60 || secondEntered > 60) {
                    JOptionPane.showMessageDialog(null,
                            "Wrong time format entered for the \"on time\" field",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                    return null;
                }

                LocalTime timeEntered = LocalTime.parse(textTime);
                difference = timeNow.until(timeEntered, ChronoUnit.SECONDS);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Wrong time format entered for the \"on time\" field",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            delay = String.valueOf(difference);

        } else if (choice.equals("countdown")) {
            int secondsToGo;
            try {
                secondsToGo = Integer.parseInt(textCountdown);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please enter a numerical value in the \"countdown\" field",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            delay = String.valueOf(secondsToGo);
        }

        return delay;
    }

}

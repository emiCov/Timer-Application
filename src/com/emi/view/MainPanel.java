package com.emi.view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private PanelNo1 panelNo1;
    private PanelNo2 panelNo2;
    private PanelNo3 panelNo3;
    private PanelNo4 panelNo4;

    public MainPanel() {
        setBackground(Color.ORANGE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelNo1 = new PanelNo1();
        panelNo2 = new PanelNo2();
        panelNo3 = new PanelNo3();
        panelNo4 = new PanelNo4();

        panelNo1.setBackground(Color.lightGray);
        panelNo2.setBackground(Color.lightGray);
        panelNo3.setBackground(Color.lightGray);
        panelNo4.setBackground(Color.lightGray);

        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(panelNo1, gbc);

        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;

        add(panelNo2, gbc);

        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;

        add(panelNo3, gbc);

        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 3;

        add(panelNo4, gbc);

    }

    public PanelNo2 getPanelNo2() {
        return panelNo2;
    }

    public PanelNo1 getPanelNo1() {
        return panelNo1;
    }

    public PanelNo3 getPanelNo3() {
        return panelNo3;
    }

    public PanelNo4 getPanelNo4() {
        return panelNo4;
    }

    public void disableComponents() {
        for (Component c : panelNo1.getComponents())
            c.setEnabled(false);
        for (Component c : panelNo2.getComponents())
            c.setEnabled(false);
        for (Component c : panelNo3.getComponents())
            c.setEnabled(false);
        panelNo4.disableStartButton();
    }

    public void enableComponents() {
        for (Component c : panelNo1.getComponents())
            c.setEnabled(true);
        for (Component c : panelNo2.getComponents())
            c.setEnabled(true);
        for (Component c : panelNo3.getComponents())
            c.setEnabled(true);
    }
}

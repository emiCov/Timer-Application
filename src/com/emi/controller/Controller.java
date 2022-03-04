package com.emi.controller;

import com.emi.model.Model;
import com.emi.view.*;

import java.awt.*;

public class Controller implements StartStopButtonsPressed, ColorChooser, SecondsChooser {
    private MainFrame mainFrame;
    private MainPanel mainPanel;
    private Model model;

    public Controller() {

        mainFrame = new MainFrame();
        mainPanel = new MainPanel();

        mainFrame.setContentPane(mainPanel);

        model = new Model();

        mainPanel.getPanelNo2().chooseColor(this);
        mainPanel.getPanelNo3().setSeconds(this);
        mainPanel.getPanelNo4().pressStartButton(this);
        mainPanel.getPanelNo4().pressStopButton(this);

    }

    @Override
    public void setSeconds(int seconds) {
        model.setSeconds(seconds);
    }

    @Override
    public void setColor(Color newColor) {
        model.setColor(newColor);
    }

    @Override
    public void pressStartButton() {
        String timeStart = mainPanel.getPanelNo1().getDelay();

        if (timeStart != null) {
            mainPanel.disableComponents();
            model.setDelay(Integer.parseInt(timeStart));
            try {
                mainFrame.showDialog(model.getColor(), model.getSeconds(), model.getDelay());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void pressStopButton() {
        mainFrame.isStopped();
        mainPanel.enableComponents();
    }
}

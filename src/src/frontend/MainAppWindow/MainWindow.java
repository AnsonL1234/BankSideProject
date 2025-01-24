package src.frontend.MainAppWindow;

import src.frontend.WindowSetting;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private WindowSetting windowSetting = null;

    public MainWindow() {

        this.setSize(new Dimension(windowSetting.getMAX_WIDTH(),windowSetting.getMAX_HEIGHT()));

    }
}

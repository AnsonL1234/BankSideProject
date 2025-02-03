package src.frontend.MainAppWindow;

import src.frontend.WindowSetting;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private WindowSetting windowSetting = null;
    private final String title = "Sky Bank";

    public MainWindow() {

        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setSize(new Dimension(windowSetting.getMAX_WIDTH(),windowSetting.getMAX_HEIGHT()));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

//    protected JPanel navigation_panel() {
//        NevigatorBar nevigatorBar = new NevigatorBar();
//        JPanel panel = new JPanel();
//
//
//    }


}

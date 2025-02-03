package src.frontend.MainAppWindow;

import src.frontend.CustomizeComponent.ApplicationContent;
import src.frontend.WindowSetting;

import javax.swing.*;
import java.awt.*;

public class NevigatorBar extends JPanel {


    public NevigatorBar() {
        WindowSetting windowSetting = new WindowSetting();

        this.setBackground(ApplicationContent.NAVIFATOR_COLOR);
        this.setVisible(true);

        this.setPreferredSize(new Dimension(windowSetting.getMIN_WIDTH(),windowSetting.getMAX_HEIGHT()));
    }
}

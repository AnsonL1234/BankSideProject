package src.frontend.LoginAndRegister;

import net.miginfocom.swing.MigLayout;
import src.frontend.Content.ApplicationContent;
import src.frontend.CustomizeComponent.RoundedBorder;
import src.frontend.WindowSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {

    private JPanel loginPanel;
    private JLabel lblTitle;
    private JTextArea txtEmail_UserID;
    private JPasswordField txtUser_Password;
    private JButton btnLogin, btnRegister;

    public LoginWindow() {
        WindowSetting windowSetting = new WindowSetting();

        this.setTitle("Login Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        loginPanel = loginPanel();
        loginPanel.setLayout(new BorderLayout());
        this.add(loginPanel, BorderLayout.WEST);

        this.setSize(new Dimension(windowSetting.getMEDIUM_WIDTH() - 100, windowSetting.getMEDIUM_HEIGHT()));
        this.setLocationRelativeTo(null);
    }

    protected JPanel loginPanel() {
        loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(430,0));
        loginPanel.setBackground(ApplicationContent.NAVIFATOR_COLOR);

        JLabel imageLabel = iconImage("/Image/logo.png");
        imageLabel.setBorder(new RoundedBorder(150));
        loginPanel.add(imageLabel);

        return loginPanel;
    }

//    protected JFormattedTextField textField() {
//
//    }

    protected JLabel iconImage(String resource) {
        JLabel iconLabel = new JLabel();
        try {
            ImageIcon iconImage = new ImageIcon(resource);
            Image img = iconImage.getImage();
            Image newImg = img.getScaledInstance(175,125, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);

            iconLabel = new JLabel(newIcon);
        } catch (Exception e) {
            System.out.println("Could not find the sources");
            e.printStackTrace();
        }
        return iconLabel;
    }

    public String getTxtEmail_UserID() {
        return txtEmail_UserID.getText();
    }

    public String getTxtUser_Password() {
        return String.valueOf(txtUser_Password.getPassword());
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}

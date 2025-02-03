package src.frontend.LoginAndRegister;

import net.miginfocom.swing.MigLayout;
import src.frontend.CustomizeComponent.ApplicationContent;
import src.frontend.CustomizeComponent.RoundedBorder;
import src.frontend.WindowSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class LoginWindow extends JFrame {

    private JPanel loginPanel;
    private JLabel lblTitle;
    private JFormattedTextField txtEmail_UserID;
    private JPasswordField txtUser_Password;
    private JButton btnLogin, btnRegister;

    public LoginWindow() {
        WindowSetting windowSetting = new WindowSetting();

        this.setTitle("Login Page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        loginPanel = loginPanel();
        this.add(loginPanel);

        this.setSize(new Dimension(windowSetting.getMEDIUM_WIDTH() - 100, windowSetting.getMEDIUM_HEIGHT()));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    protected JPanel loginPanel() {
        loginPanel = new JPanel(new BorderLayout());

        JPanel west_panel = West_Panel();
        west_panel.setPreferredSize(new Dimension(425,0));
        west_panel.setBackground(ApplicationContent.NAVIFATOR_COLOR);


        loginPanel.add(west_panel, BorderLayout.WEST);

        return loginPanel;
    }

    protected JPanel West_Panel() {
        JPanel west_Panel = new JPanel(new MigLayout());
        west_Panel.setBorder(BorderFactory.createEmptyBorder(90,90,70,70));

        JLabel lblTitle = new JLabel("USER LOGIN");
        lblTitle.setBorder(BorderFactory.createEmptyBorder(0,60,0,0));
        lblTitle.setFont(new Font("Agency FB", Font.BOLD, 25));
        lblTitle.setForeground(Color.WHITE);

        JLabel lblUserDetail = new JLabel("User Detail: ");
        lblUserDetail.setFont(new Font("Agency FB", Font.BOLD, 16));
        lblUserDetail.setForeground(Color.WHITE);

        txtEmail_UserID = new JFormattedTextField();
        txtEmail_UserID.setPreferredSize(new Dimension(230, 10));
        txtEmail_UserID.setFont(new Font("Agency FB", Font.BOLD, 14));
        txtEmail_UserID.setBorder(new RoundedBorder(7, ApplicationContent.BORDER_COLOR));
        txtEmail_UserID.setForeground(Color.WHITE);
        txtEmail_UserID.setText("Enter user ID/ email address");
        txtEmail_UserID.setOpaque(false);

        txtEmail_UserID.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(txtEmail_UserID.getText().equals("Enter user ID/ email address")) {
                    txtEmail_UserID.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(txtEmail_UserID.getText().isEmpty()) {
                    txtEmail_UserID.setText("Enter user ID/ email address");
                }
            }
        });

        JLabel lblErrorMessage = new JLabel();
        lblErrorMessage.setFont(new Font("Agency FB", Font.BOLD, 16));
        lblErrorMessage.setForeground(Color.RED);

        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Agency FB", Font.BOLD, 16));
        lblPassword.setForeground(Color.WHITE);

        txtUser_Password = new JPasswordField();
        txtUser_Password.setPreferredSize(new Dimension(230, 10));
        txtUser_Password.setFont(new Font("Agency FB", Font.BOLD, 14));
        txtUser_Password.setBorder(new RoundedBorder(7,ApplicationContent.BORDER_COLOR));
        txtUser_Password.setForeground(Color.WHITE);
        txtUser_Password.setText("Enter password :");
        txtUser_Password.setOpaque(false);

        txtUser_Password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtUser_Password.getPassword();
                txtUser_Password.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtUser_Password.getPassword();
                if(txtUser_Password.getText().isEmpty()) {
                    txtUser_Password.setText("Enter password :");
                }
            }
        });

        btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(new Dimension(80, 30));
        btnLogin.setBackground(ApplicationContent.DEEP_BLUE_COLOR);
//        btnLogin.setBorder(new RoundedBorder(10,ApplicationContent.DEEP_BLUE_COLOR));
        btnLogin.setFont(new Font("Agency FB", Font.BOLD, 18));
        btnLogin.setBorder(BorderFactory.createLineBorder(ApplicationContent.DEEP_BLUE_COLOR));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setOpaque(false);

        btnRegister = new JButton();

        west_Panel.add(lblTitle,"Wrap, gap bottom 20");
        west_Panel.add(lblUserDetail,"Wrap, gap bottom 1");
        west_Panel.add(txtEmail_UserID,"Wrap");
        west_Panel.add(lblErrorMessage,"Wrap, gap bottom 8");
        west_Panel.add(lblPassword,"Wrap, gap bottom 2");
        west_Panel.add(txtUser_Password,"Wrap, gap bottom 12");
        west_Panel.add(btnLogin,"Wrap");

        return west_Panel;
    }

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

package GUI;

import Exceptions.PasswordException;
import GUI.RegisterationPage.RegisterDoc;
import GUI.homePage.AdminHomePage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {
    private JButton newDoctorButton;
    private JButton newPatientButton;
    private JButton loginButton;
    private JPanel mainPanel;

    public MainPage() {
       JFrame frame=new JFrame();
        frame.setSize(500,600);
        ///frame.setContentPane(new MainPage().mainPanel);
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       mainPanel.setVisible(true);

        newDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                //frame.dispose();
                RegisterDoc registerDoc= new RegisterDoc();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                try {
                    Login login=new Login();
                } catch (PasswordException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        MainPage mainPage=new MainPage();

    }
}

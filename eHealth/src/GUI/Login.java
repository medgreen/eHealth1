package GUI;

import Exceptions.PasswordException;
import GUI.homePage.AdminHomePage;
import GUI.homePage.DoctorHomePage;
import GUI.homePage.PatientHomePage;
import Security.PasswordManager;
import user.Admin.AdminDAOImp;
import user.Doctor.DoctorDAOImp;
import user.Patient.PatientDAOImp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField emailText;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JComboBox comboBox;
    private JPanel mainPanel;

    public Login() throws PasswordException {
        //setSize(400, 600);
        //setContentPane(mainPanel);

        JFrame frame=new JFrame();
        frame.setSize(400,600);
        ///frame.setContentPane(new MainPage().mainPanel);
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        mainPanel.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String encodedPassword = PasswordManager.encode(passwordField.getText());
                System.out.println(encodedPassword);
                //login patient
                if (comboBox.getSelectedItem().toString().equals("Patient")){
                    PatientDAOImp patientDAOImp = new PatientDAOImp();
                    if(patientDAOImp.existEmail(emailText.getText())){
                        if(patientDAOImp.getPassword(emailText.getText()).equals(encodedPassword)){
                            dispose();
                            PatientHomePage patientHomePage = new PatientHomePage(patientDAOImp.getByEmail(emailText.getText()));

                        }
                        else   JOptionPane.showMessageDialog(null,"Incorrect password!");

                    }
                    else   JOptionPane.showMessageDialog(null,"Incorrect email/password");

                }
               else if (comboBox.getSelectedItem().toString().equals("Doctor")){
                    DoctorDAOImp doctorDAOImp = new DoctorDAOImp();
                    if(doctorDAOImp.existEmail(emailText.getText())){
                        if(doctorDAOImp.getPassword(emailText.getText()).equals(encodedPassword)){
                            dispose();
                            DoctorHomePage patientHomePage = new DoctorHomePage(doctorDAOImp.getByEmail(emailText.getText()));

                        }
                        else   JOptionPane.showMessageDialog(null,"Incorrect password!");

                    }
                    else   JOptionPane.showMessageDialog(null,"Incorrect email/password");

                }

               else {
                    AdminDAOImp adminDAOImp = new AdminDAOImp();
                    if(adminDAOImp.existEmail(emailText.getText())){
                        if(passwordField.getText().equals(adminDAOImp.getPassword(emailText.getText()))){
                            dispose();
                            AdminHomePage adminHomePage = new AdminHomePage();
                        }
                        else   JOptionPane.showMessageDialog(null,"Incorrect password!");

                    }
                    else   JOptionPane.showMessageDialog(null,"Incorrect email/password");
                }
            }
        });
    }
}

package GUI.RegisterationPage;

import Exceptions.EmailException;
import Exceptions.PasswordException;
import com.toedter.calendar.JDateChooser;
import user.Doctor.Doctor;
import user.Doctor.DoctorDAOImp;
import user.Doctor.Specialization;
import user.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class RegisterDoc extends JFrame{
    private JPanel mainPanel;
    private JTextField UsernameText;
    private JTextField FirstNameText;
    private JTextField LastnameText;
    private JLabel username;
    private JPasswordField passwordField1;
    private JTextField EMailText;
    private JTextField addressText;
    private JButton registerButton;
    private JComboBox<Specialization> comboBox1;
    private JPanel BirthdatePanel;
    private JTextField BirthdateText;
    private JTextField SpecializationText;

    private JDateChooser dateChooser=new JDateChooser();


    public RegisterDoc(){

        setContentPane(mainPanel);
        setSize(500,500);
        /*
        JFrame frame=new JFrame();
        frame.setSize(300,300);
        frame.setContentPane(mainPanel);
        frame.setVisible(true);
        mainPanel.setVisible(true);

         */
        comboBox1.setModel(new DefaultComboBoxModel<>(Specialization.values()));

        BirthdatePanel.add(dateChooser);
        dateChooser.setDateFormatString("dd/MM/yyyy");


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox1.setModel(new DefaultComboBoxModel<>(Specialization.values()));
                DoctorDAOImp doctorDAOImp=new DoctorDAOImp();
                Doctor doctor= new Doctor(UsernameText.getText(),EMailText.getText(),passwordField1.getText(),
                        FirstNameText.getText(),LastnameText.getText(),addressText.getText(),
                LocalDate.ofInstant(dateChooser.getDate().toInstant(), ZoneId.systemDefault())
                ,comboBox1.getItemAt(comboBox1.getSelectedIndex()));//,DateofBirthText.getText(),SpecializationText.getText());

                try {
                    doctorDAOImp.save(doctor);
                } catch (PasswordException ex) {
                    ex.printStackTrace();
                } catch (EmailException ex) {
                    ex.printStackTrace();
                }
            }
        });
   }





    public static void main(String[] args) throws PasswordException, EmailException {

       //RegisterDoc registerDoc=new RegisterDoc();
        //registerDoc.setVisible(true);
       /* DoctorDAOImp doctorDAOImp=new DoctorDAOImp();
        Doctor doctor=new Doctor("amine1",
                "am@gmail.com",
                "ThhwjTwnn-@58",
                "amine",
                "amineamine",
                "a123str",
                LocalDate.of(1998,1,5),
                Specialization.Allergist);
        doctorDAOImp.edit(doctor);*/

    }


}

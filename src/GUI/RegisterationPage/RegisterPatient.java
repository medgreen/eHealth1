package GUI.RegisterationPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPatient extends  JFrame{
    private JButton uploadFileButton;
    private JPanel mainPanel;

    public RegisterPatient() {
        setContentPane(mainPanel);
        setSize(500,500);

        uploadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*if(e.getSource()==uploadFileButton){
                    JFileChooser file_upload= new JFileChooser();

                    int res= file_upload.showOpenDialog(null);
                    if(res == JFileChooser.APPROVE_OPTION){
                        File file_path= new File(file_upload.getSelectedFile().getAbsolutePath());
                        System.out.println(file_path);

                    }
                }
                 */

            }
        });
    }

    public static void main(String[] args) {
        RegisterPatient registerPatient=new RegisterPatient();
        registerPatient.setVisible(true);
    }
}

package Email;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MailApp extends TimerTask implements Runnable {

    private boolean exit = false;

    private String senderEmailAddress;
    private String senderPassword;
    private String receiverEmailAddress;
    private String subject;
    private String message;

    Thread t;

    public MailApp(String senderEmailAddress, String senderPassword, String receiverEmailAddress, String subject, String message) {
        this.senderEmailAddress = senderEmailAddress;
        this.senderPassword = senderPassword;
        this.receiverEmailAddress = receiverEmailAddress;
        this.subject = subject;
        this.message = message;

        t = new Thread(this);
        t.start();
    }

    @SuppressWarnings("deprecation")
    public void run() {
        t.stop();
        Mailer.send(senderEmailAddress, senderPassword, receiverEmailAddress, subject, message);

        System.out.println("Mail sent");

    }

    public void stop() {
        exit = true;
    }

    public static void main(String[] args) throws ParseException {
       Timer timer=new Timer();
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String year = String.valueOf(LocalDate.now().getYear());
        String month = String.valueOf(LocalDate.now().getMonthValue());
        String day = String.valueOf(LocalDate.now().getDayOfMonth());
        String hour=String.valueOf(LocalTime.of(16,19,1));
        Date date = dateFormatter.parse(year + "-" + month + "-" + day +" "+ hour);
       /// LocalDateTime ldt= LocalDateTime.of(LocalDate.of(2022, 1, 10), LocalTime.of(20, 36, 1));
        timer.schedule(new MailApp("clinic.uas2022@gmail.com", "Java2022", "belghazi1998@gmail.com", "Appointment reminder", "test test test"),date);

    }



}
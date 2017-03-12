package bg.garage.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailServiceImpl")
public class EmailServiceImpl {

    @Autowired
    private MailSender mailSender; // MailSender interface defines a strategy
                                   // for sending simple mails

    public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {

        SimpleMailMessage crunchifyMsg = new SimpleMailMessage();
        crunchifyMsg.setFrom(fromAddress);
        crunchifyMsg.setTo(toAddress);
        crunchifyMsg.setSubject(subject);
        crunchifyMsg.setText(msgBody);
        mailSender.send(crunchifyMsg);
    }
}

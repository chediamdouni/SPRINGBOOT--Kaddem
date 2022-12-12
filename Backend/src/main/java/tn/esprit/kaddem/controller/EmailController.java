package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.kaddem.ressource.EmailMessage;
import tn.esprit.kaddem.services.IEmailSenderServices;

@RestController
@AllArgsConstructor
public class EmailController {

     IEmailSenderServices iEmailSenderServices;
    JavaMailSender javaMailSender;

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage) {
        this.iEmailSenderServices.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getBody());
        return ResponseEntity.ok("Success");
    }
    /*@PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailMessage email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());

        javaMailSender.send(message);
    }*/
}

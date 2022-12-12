package tn.esprit.kaddem.services;

public interface IEmailSenderServices {
    void sendEmail(String to, String subject, String message);
}

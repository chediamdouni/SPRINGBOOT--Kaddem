package tn.esprit.kaddem.ressource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailMessage {

    private String to;
    private String subject;
    private String body;
}

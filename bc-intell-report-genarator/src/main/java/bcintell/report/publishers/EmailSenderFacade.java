/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcintell.report.publishers;

import jodd.mail.Email;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;
import jodd.mail.SmtpSslServer;
import leona.bc.intell.config.BCIntellConfig;

/**
 *
 * @author Raghu
 */
public class EmailSenderFacade {

    private BCIntellConfig bCIntellConfig;
    private static EmailSenderFacade i;

    public static EmailSenderFacade getInstance() {
        if (i != null) {
            i = new EmailSenderFacade();
        }
        return i;
    }

    public EmailSenderFacade() {
        bCIntellConfig = BCIntellConfig.getInstance();

    }

    public boolean sendEmail(String subject, String message, String... toAddresses) {

        SmtpServer smtpServer = SmtpSslServer
                .create("smtp.gmail.com")
                .authenticateWith("leona.dev.01@gmail.com", "WelcomeWelcome");
        SendMailSession session = smtpServer.createSession();
        session.open();

        String emailHtml = message;
        /**
         * User Delivery
         */
        
        Email email = Email.create()
                .from("leona.dev.01@gmail.com")
                .to(toAddresses)
                .subject("Bytecode ReportDelivery")
                .addHtml(emailHtml);
        session.sendMail(email);

        session.close();
        return true;
    }
}

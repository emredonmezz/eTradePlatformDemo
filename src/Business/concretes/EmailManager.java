package Business.concretes;

import Business.abstracts.EmailService;

import java.util.Random;

public class EmailManager implements EmailService {
    int verificationCode;

    public EmailManager(){
        Random randomNumber = new Random();
        this.verificationCode = randomNumber.nextInt(1000)*10;
    }

    @Override
    public int mailSend() {
        return this.verificationCode;
    }
}

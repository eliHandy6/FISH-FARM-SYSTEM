package com.example.fishFarm.SMS;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSms {
    public static final String ACCOUNT_SID = "AC1db0da1eeec76702e3841e1225917b1e";
    public static final String AUTH_TOKEN = "393ca745542797c359cc0e47ceb3f6fb";
    public static final String FROM = "+13396138262";


    public void sendSMS(MessageProperties messageProperties){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);


        PhoneNumber to = new PhoneNumber(messageProperties.getPhoneNumber());
        PhoneNumber from=new PhoneNumber(FROM);
        String message2= messageProperties.getMessage();

        Message message=Message.creator(to,from,message2).create();

    }

}

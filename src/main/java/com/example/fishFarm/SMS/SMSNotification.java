package com.example.fishFarm.SMS;

import com.example.fishFarm.models.SystemUser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class SMSNotification {

    private void SendGateway(String url) throws IOException {
        OkHttpClient client= new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.toString());
    }

    public void UserNotification(SystemUser systemUser) throws IOException {
        String message ="Dear "+systemUser.getFname()+" you have been registed successfuly to the Fish Farm.Kindy Check your Email for more information";
        String url="http://messaging.advantasms.com/bulksms/sendsms.jsp?user=sunflash&password=%23Sunfla5&mobiles="+systemUser.getPhoneNo()+"&sms="+message+"&clientsmsid=10001&senderid=SUNFLASH";
        SendGateway(url);
    }



}

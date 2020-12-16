package com.example.fishFarm.config.mpesa;


import com.squareup.okhttp.*;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class CustomerPayment {

    private final String callBackURL ="http://obscure-bayou-52273.herokuapp.com/api/Mpesa/C2BValidation";
    private final MpesaConstants mpesaConstant;

    public CustomerPayment(MpesaConstants mpesaConstant) {
        this.mpesaConstant = mpesaConstant;
    }

    public String Customer(Payment payment) throws IOException, JSONException {

        JSONArray jsonArray=new JSONArray();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("BusinessShortCode", mpesaConstant.getBusinessShortCode());
        jsonObject.put("Password",mpesaConstant.getPassword());
        jsonObject.put("Timestamp",mpesaConstant.getTimestamp());
        jsonObject.put("TransactionType", mpesaConstant.getTransactionType());
        jsonObject.put("Amount",payment.getAmount());
        jsonObject.put("PhoneNumber", payment.getNumberToReceivePopUp());
        jsonObject.put("PartyA", payment.getNumberToReceivePopUp());
        jsonObject.put("PartyB",mpesaConstant.getBusinessShortCode());
        jsonObject.put("CallBackURL", callBackURL);
        jsonObject.put("AccountReference", mpesaConstant.getAccountReference());
        jsonObject.put("QueueTimeOutURL", callBackURL);
        jsonObject.put("TransactionDesc",mpesaConstant.getAccountReference());

        jsonArray.put(jsonObject);

        System.out.println(jsonObject);

        String requestJson=jsonArray.toString().replaceAll("[\\[\\]]","");
        OkHttpClient client = new OkHttpClient();
        String url="https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestJson);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer "+mpesaConstant.authenticate())
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();

        return response.body().toString();
    }

}

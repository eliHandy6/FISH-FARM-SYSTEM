package com.example.fishFarm.config.mpesa;


import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

@Service
public class MpesaConstants {

    private final String appKey="v0ZOGXlZsQThM6vRsJw8cP1RJn3WrnmV";
    private final String appSecret="S0XAkemG0wC074R4";
    private final  int businessShortCode=174379;
    private final String  passkey="bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
    private final String transactionType="CustomerPayBillOnline";
    private final String transactionDesc="Fish Sales Payment";
    private final String accountReference="PayBill No: 174379";


    public String getAppKey() {
        return appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public int getBusinessShortCode() {
        return businessShortCode;
    }

    public String getPasskey() {
        return passkey;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public String authenticate() throws IOException, JSONException {
        String appKeySecret = appKey + ":" + appSecret;
        byte[] bytes = appKeySecret.getBytes("ISO-8859-1");
        String encoded = Base64.getEncoder().encodeToString(bytes);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get()
                .addHeader("authorization", "Basic "+encoded)
                .addHeader("cache-control", "no-cache")
                .build();
        Response response = client.newCall(request).execute();
        JSONObject jsonObject=new JSONObject(response.body().string());
        System.out.println(jsonObject.getString("access_token"));
        return jsonObject.getString("access_token");

    }

    public  String getTimestamp() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
    }

    public  String getPassword() throws UnsupportedEncodingException {
        String str = businessShortCode + passkey + getTimestamp();
        byte[] bytes = str.getBytes("ISO-8859-1");
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
    }


}

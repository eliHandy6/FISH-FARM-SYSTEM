package com.example.fishFarm.Absolute;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class SmsRequest {
   // @NotBlank
    private final String phoneNumber;
  //  @NotBlank
    private final  String message;

   // @JsonProperty("phoneNumber")
  // @JsonProperty("message")

   public SmsRequest(String phoneNumber,
                       String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "SmsRequest{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

package com.example.fishFarm.config.mpesa;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;


public class Payment {
    @JsonProperty("amount")
    @NotNull
    private String amount;

    @JsonProperty("numberToReceivePopUp")
    private String numberToReceivePopUp;


    public Payment(@NotNull String amount, String numberToReceivePopUp) {
        this.amount = amount;
        this.numberToReceivePopUp = numberToReceivePopUp;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNumberToReceivePopUp() {
        return numberToReceivePopUp;
    }

    public void setNumberToReceivePopUp(String numberToReceivePopUp) {
        this.numberToReceivePopUp = numberToReceivePopUp;
    }
}

package com.senderToQueue.messageSenderToQueue.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SmsMessageDto {

    @NotNull
    private String recipientNumber;
    @NotNull
    private String text;

    public SmsMessageDto(){}

    public SmsMessageDto(String recipientNumber, String text) {
        this.recipientNumber = recipientNumber;
        this.text = text;
    }

    public String getRecipientNumber() {
        return recipientNumber;
    }

    public void setRecipientNumber(String recipientNumber) {
        this.recipientNumber = recipientNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

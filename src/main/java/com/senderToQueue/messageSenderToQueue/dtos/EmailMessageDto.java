package com.senderToQueue.messageSenderToQueue.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class EmailMessageDto implements Serializable {

    @NotBlank(message = "Owner reference is mandatory")
    private String ownerReference;
    @NotBlank(message = "Email from is mandatory")
    @Email
    private String emailFrom;
    @NotBlank(message = "Email to is mandatory")
    @Email
    private String emailTo;
    @NotBlank(message = "Subject is mandatory")
    private String subject;
    @NotBlank(message = "Text message is mandatory")
    private String text;

    public EmailMessageDto(){}

    public EmailMessageDto(String ownerReference, String emailFrom, String emailTo, String subject, String text) {
        this.ownerReference = ownerReference;
        this.emailFrom = emailFrom;
        this.emailTo = emailTo;
        this.subject = subject;
        this.text = text;
    }

    public String getOwnerReference() {
        return ownerReference;
    }

    public void setOwnerReference(String ownerReference) {
        this.ownerReference = ownerReference;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

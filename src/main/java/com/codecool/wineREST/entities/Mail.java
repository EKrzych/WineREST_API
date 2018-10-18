package com.codecool.wineREST.entities;

public class Mail {

    private String subject;
    private String content;
    private String to;
    private String from;

    public Mail() {
    }

    public Mail(String subject, String content, String to, String from) {
        this.subject = subject;
        this.content = content;
        this.to = to;
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}

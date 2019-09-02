package com.example.chatspecial;

public class Message {
    String text;
    String sender;
    String time;
    boolean isSender;

    public Message(String text, String sender, String time, boolean isSender) {
        this.text = text;
        this.sender = sender;
        this.time = time;
        this.isSender = isSender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

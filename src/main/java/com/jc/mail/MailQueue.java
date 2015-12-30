package com.jc.mail;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-12-30
 * Time: 下午7:37
 * To change this template use File | Settings | File Templates.
 */
public class MailQueue {
    private String text;        //邮件正文
    private String subject;     //邮件主题
    private String from;         //发送着
    private String to; //收件人 分号分隔
    private String cc; //抄送
    private String bcc;//密送
    private boolean supportHtml; //是否支持html格式

    public boolean isSupportHtml() {
        return supportHtml;
    }

    public void setSupportHtml(boolean supportHtml) {
        this.supportHtml = supportHtml;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }


    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }



}

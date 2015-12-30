package com.jc.mail;


import org.apache.commons.lang.StringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-12-30
 * Time: 下午7:35
 * To change this template use File | Settings | File Templates.
 */
public class MailUtil {
    private JavaMailSender mailSender;

    public void sendMail(String content,String mailFrom,String mailOrderTo,String theme){
        MailQueue mq = new MailQueue();
        try {
            mq.setFrom(mailFrom);    //发件人邮箱
            mq.setTo(mailOrderTo);   //收件人
            mq.setSubject(theme);
            mq.setSupportHtml(false);
            mq.setText(content);
            send(mq);
        } catch (Exception e) {
        }
    }

    public void send(MailQueue m) throws Exception {
        if (StringUtils.isBlank(m.getTo())) {
            return;
        }
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        MimeMessage mailMessage = senderImpl.createMimeMessage();
        //设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

        messageHelper.setTo(m.getTo().split(";"));//接受者
        messageHelper.setFrom(m.getFrom());//发送者
        messageHelper.setSubject(m.getSubject());//主题

        if (StringUtils.isNotBlank(m.getCc())) {
            messageHelper.setCc(m.getCc().split(";"));    //抄送
        }
        if (StringUtils.isNotBlank(m.getBcc())) {
            messageHelper.setBcc(m.getBcc()); //密送
        }

        //邮件内容，注意加参数true，表示启用html格式
        messageHelper.setText(m.getText(), m.isSupportHtml());
        mailSender.send(mailMessage);
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

}

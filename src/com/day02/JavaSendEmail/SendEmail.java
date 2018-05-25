package com.day02.JavaSendEmail;


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * 下面是一个发送简单E-mail的例子。假设你的localhost已经连接到网络。
 */
public class SendEmail {
    public static void main(String[] args) {
        // 收件人电子邮箱
        String to = "abcd@gmail.com";

        // 发件人电子邮箱
        String from = "web@gmail.com";

        // 指定发送邮件的主机为 localhost
        String host = "localhost";

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties);

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // 多 收件人电子邮箱
            var address = new Address[]{
                    new InternetAddress(to),
                    new InternetAddress(to),
                    new InternetAddress(to),
                    new InternetAddress(to)
            };
            //多人接收
            message.addRecipients(Message.RecipientType.TO, address);

            // Set Subject: 头部头字段
            message.setSubject("This is the Subject Line!");

            // 设置消息体
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}


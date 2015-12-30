import com.jc.mail.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: zhaojingchun
 * Date: 15-12-30
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:ApplicationContext.xml"})
public class MyTest{
    @Autowired
    private JavaMailSenderImpl mailSender;
    @Autowired
    private MailUtil mailUtil;
    @Test
    public void  ssTest(){
        String content = "love";
        String mailFrom =   "zhaojingchun521@163.com";
        String mailOrderTo =  ""; //发送邮箱
        String theme =   "love";
        mailUtil.sendMail(content,mailFrom,mailOrderTo,theme);
        System.out.println("");
    }

    public JavaMailSenderImpl getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void setMailUtil(MailUtil mailUtil) {
        this.mailUtil = mailUtil;
    }
}

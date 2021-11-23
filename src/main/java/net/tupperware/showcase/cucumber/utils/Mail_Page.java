package net.tupperware.showcase.cucumber.utils;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import javax.mail.search.SubjectTerm;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mail_Page {

    String Host ="imap.googlemail.com";
    String Port= "993";
    String subject= "You've been invited to join";
    Folder passwordCode;
    String output, messageBody = "";
    int searchCount, unreadMsgCount;


    /**
     * open gmail account and verify mail count
     * @return
     * @throws javax.mail.MessagingException
     * @throws InterruptedException
     */
    private Mail_Page openGmailAccount(String email, String password) throws MessagingException, InterruptedException, javax.mail.MessagingException {
        Session session = Session.getDefaultInstance(new Properties());
        Store store = null;
        try {
            store = session.getStore("imaps");
        } catch (javax.mail.NoSuchProviderException e) {
            e.printStackTrace();
        }
        store.connect(Host, Integer.parseInt(Port),email ,password );
        passwordCode = store.getFolder("passwordcode");
        passwordCode.open(Folder.READ_WRITE);
        System.out.println("Total Message:" + passwordCode.getMessageCount());
        return this;
    }

    /*
        Read Unseen Message
     */
    public void readUnseenMessage(String email, String password) throws InterruptedException, javax.mail.MessagingException, MessagingException {
        openGmailAccount(email,password);
        Message[] messages;
        Thread.sleep(2000);
        //Search for mail from Redeem code subject
        messages = passwordCode.search(new SubjectTerm(subject), passwordCode.getMessages());
        searchCount = messages.length;
        System.out.println("search count: " + searchCount);
        Thread.sleep(2000);
        unreadMsgCount = passwordCode.getUnreadMessageCount();
        System.out.println("Unread Message: " + unreadMsgCount);
        Message[] unreadMessages = passwordCode.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        if(unreadMsgCount>0) {
            for (int i = 0; i < unreadMsgCount; i++) {
                unreadMessages[i].setFlag(Flags.Flag.SEEN, true);
            }
        }
        System.out.println("Unread Message count after seen:" + passwordCode.getUnreadMessageCount());
    }


    /*
        Return redeem code
     */
    public  String getCode(String email, String password) throws InterruptedException, MessagingException, javax.mail.MessagingException, IOException {
        openGmailAccount(email,password);
        Message[] messages;
        Thread.sleep(2000);
        //Search for mail from Redeem code subject
        messages = passwordCode.search(new SubjectTerm(subject), passwordCode.getMessages());
        searchCount = messages.length;
        System.out.println("search count: " + searchCount);
        Thread.sleep(2000);
        unreadMsgCount = passwordCode.getUnreadMessageCount();
        System.out.println("Unread Message: " + unreadMsgCount);
        Message[] unreadMessages = passwordCode.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        if(unreadMsgCount>0) {
            for (int i = 0; i < unreadMsgCount; i++) {
                MimeMultipart mimeMultipart = (MimeMultipart) unreadMessages[i].getContent();
                messageBody = getTextFromMimeMultipart(mimeMultipart);
                System.out.println(messageBody);
                //System.out.println("Result Value is :"+ messageBody);
                //Pattern p = Pattern.compile("-?\\d+");
                Pattern p = Pattern.compile("Your Invitation Code is \\d+");
                Matcher m = p.matcher(messageBody);
                while (m.find()) {
                    output= m.group();
                }
            }
        }
        return output;
    }

    /*
        Get text from email body
     */
    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException, javax.mail.MessagingException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break;
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }
}


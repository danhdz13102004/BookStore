package util;

import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;

public class Email {
	static final String from = "testmail131004@gmail.com";
	static final String password = "ivrsnlcgwkiembcw";
	public static boolean sendEmail(String to,String tieuDe,String noiDung) {
		Properties  props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
			
		};
		
		Session session = Session.getInstance(props,auth);
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.addHeader("Content-type", "text/HTML; charset=UTF8");
			
			msg.setFrom(from);
			
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
			
			msg.setSubject(tieuDe);
			
			msg.setSentDate(new Date());
			
		//	msg.setReplyTo(InternetAddress.parse(from,false)) Quy định email nhận phản hồi
			// Nội dung
			msg.setContent(noiDung,"text/HTML; charset=UTF8");
			
			Transport.send(msg);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public static void main(String[] args) {
		String noiDung = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<style>\r\n"
				+ "    .center {\r\n"
				+ "        display: flex;\r\n"
				+ "        align-items: center;\r\n"
				+ "        justify-content: center;\r\n"
				+ "\r\n"
				+ "    }\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "    <h2> Đây là xác nhận, vui lòng nhập mã này ở trang đăng kí để hoàn thành thủ tục</h2>\r\n"
				+ "    <div class=\"center\" style=\"width: 200px; height: 50px;\">\r\n"
				+ "            123456\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		if(Email.sendEmail("ngovandanh12345679@gmail.com", "Email xac nhan", noiDung)) {
			System.out.println("Ok");
		}
		else {
			System.out.println("Ko Ok");
		}
		
 	}
}

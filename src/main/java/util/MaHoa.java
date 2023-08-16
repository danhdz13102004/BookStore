package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

import com.mysql.cj.util.Base64Decoder;

public class MaHoa {
	public static String Encode(String str) {
		String salt = "adsdkwms@3#sddd;>AsdSADaCCsdsa<he,o2.qesaaaedkfr.>.<-+-";
		str += salt;
		String result = null;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = Base64.encodeBase64String(md.digest(dataBytes));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Encode("123"));
	}
}

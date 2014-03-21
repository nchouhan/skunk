import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

public class URLGenerator1 {

	public URLGenerator1() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testurl = "/faces/ai/odi/odiHome?tab=LPE&agent=GENAGENT&type=ERROR";
		String testurl2 = "http://127.0.0.1:7101/app4/odiHome%3Ftarget%3Dtesttarget%26name%3DtestTargetNAME";
		System.out.println(URLEncoder.encode(testurl));
		System.out.println(URLDecoder.decode(testurl2));
	}

}

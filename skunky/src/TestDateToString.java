import java.sql.SQLXML;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateToString {

	public TestDateToString() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d = new Date();
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		Date javaDate = d;
		// Either get both java date and sql date to same format String and
		// compare
		String javaDateStr = DateFormat.getDateTimeInstance().format(javaDate);
		String sqlDateStr = DateFormat.getDateTimeInstance().format(sqlDate);
		System.out.println(javaDateStr);
		System.out.println(sqlDateStr);
		/*
		 * Sysout console 
		 * Apr 25, 2013 10:39:46 AM 
		 * Apr 25, 2013 10:39:46 AM
		 */
		// Do String compare
		// OR getMillis and compare
		long javaDateMillis = javaDate.getTime();
		long sqlDateMillis = sqlDate.getTime();

		System.out.println(javaDateMillis);
		System.out.println(sqlDateMillis);
		/*
		 * Sysout console 
		 * 1366866586716 
		 * 1366866586716
		 */



	}

}

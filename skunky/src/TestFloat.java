import java.text.DateFormat;
import java.util.Date;


public class TestFloat {

	public TestFloat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1.36272832E12";
		Double f1 = Double.valueOf(s);
		Double f = 1.36272832E12;
		System.out.println(f1.longValue());
		System.out.println(DateFormat.getDateTimeInstance().format(new Date(f1.longValue())));
		

	}

}

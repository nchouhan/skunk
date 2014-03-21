import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class MillisToPST {

	public MillisToPST() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long millisStart = 1389767185000l ;
		long millisEnd = 1389768993000l;
		System.out.println("Diff Millis       :"+(millisEnd-millisStart));
		System.out.println("Diff Sec        :"+(millisEnd-millisStart)/1000);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yy HH:mm:SS z");//SimpleDateFormat.getDateInstance();
		df.setTimeZone(TimeZone.getTimeZone("PST"));
		
		System.out.println(df.format(new Date(millisStart)));
		System.out.println(df.format(new Date(millisEnd))); 
		
	}

}

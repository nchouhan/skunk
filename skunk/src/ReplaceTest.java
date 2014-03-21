import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ReplaceTest {

	public ReplaceTest() {
		// TODO Auto-generated constructor stub
	}
    private static long getMillisFromDate(String iDate)
    {
        long timeMillis = 0;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lastCollectionTimestamp = 0;
        try
        {
            Date d1 = df.parse(iDate);
            lastCollectionTimestamp = d1.getTime();
        }
        catch (Exception e)
        {
            //will reach here on first collection. ignore it.
        }
        return lastCollectionTimestamp;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String toReplace = "2013-04-17 03:07:43";
		
		System.out.println(getMillisFromDate(toReplace));
		// TODO Auto-generated method stub

	}

}

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


public class Temp {

	public Temp() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder x = new StringBuilder();
		String y = "";
		boolean vcard_start = false;
		boolean vcard_end = true;
		try {
			FileInputStream fin = new FileInputStream(
					new File(
							"C:\\Users\\nichouha.ST-IDC\\Documents\\EMGC\\temp2.txt"));
			// InputStreamReader isr = new InputStreamReader(fin);
			Scanner scan = new Scanner(fin);
			VcftoCsv vcftocsv = new VcftoCsv();
			while (scan.hasNextLine()) {
				y = scan.nextLine();
				y = y.trim();
				System.out.println(y);
//				int position = y.indexOf("\">");
//				if (position != -1){
//				String x1 = y.substring(0,y.indexOf("\">"));
////				System.out.println(x1.indexOf("public static final String "));
//				String x2 = x1.replaceFirst("public static final String ", "").trim();
//				System.out.println(x1+"= \""+x2+"\";".trim());
//				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		}
	}



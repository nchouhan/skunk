import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.xml.registry.infomodel.EmailAddress;

public class VcftoCsv {
	private static String BEGIN = "BEGIN";
	private static String VERSION = "BEGIN";
	private static String EMAIL = "EMAIL:";
	private static String EMAIL_PREF_HOME = "EMAIL;PREF;HOME:";
	private static String EMAIL_PREF = "EMAIL;PREF:";
	private static String EMAIL_HOME = "EMAIL;HOME:";
	private static String END = "END";
	private static String N = "N:";
	private static String FN = "FN:";
	private static String TEL_WORK = "TEL;WORK:";
	private static String TEL_VOICE = "TEL;VOICE:";
	private static String TEL_CELL = "TEL;CELL:";

	private String name = "";

	@Override
	public String toString() {
		return "VcftoCsv [name=" + name + ", desc=" + desc + ", phone=" + phone
				+ ", phone_work=" + phone_work + ", phone_cell=" + phone_cell
				+ ", email=" + email + "]";
	}
	public String toCsv() {
		return  name + "," + desc + "" + phone
				+ "," + phone_work + "," + phone_cell
				+ "," + email;
	}

	private String desc = "";
	private String phone = "";
	private String phone_work = "";
	private String phone_cell = "";
	private String email = "";

	private static boolean isVcardStart(String iLine) {
		return iLine.contains("BEGIN:VCARD");
	}

	private static boolean isVcardEnd(String iLine) {
		return iLine.contains("END:VCARD");
	}
//	private String removeColon(String iLine)
	private void setTo(String iLine) {
//		iLine.replace(";", "");
		if (iLine.contains("BEGIN:VCARD") || iLine.contains("VERSION:")) {

		} else {
			if (iLine.contains(N) && !(iLine.contains(FN))) {
				iLine = iLine.replaceFirst(N, "");
				this.desc = iLine.replace(";", "");
			} else if (iLine.contains(FN)) {
				iLine = iLine.replaceFirst(FN, "");
				this.name = iLine.replace(";", "");
			} else if (iLine.contains(EMAIL)) {
				iLine = iLine.replaceFirst(EMAIL, "");
				this.email = iLine.replace(";", "");
			} else if (iLine.contains(EMAIL_PREF)) {
				iLine = iLine.replaceFirst(EMAIL_PREF, "");
				this.email = iLine.replace(";", "");
			} else if (iLine.contains(EMAIL_PREF_HOME)) {
				iLine = iLine.replaceFirst(EMAIL_PREF_HOME, "");
				this.email = iLine.replace(";", "");
			}else if (iLine.contains(EMAIL_HOME)) {
				iLine = iLine.replaceFirst(EMAIL_HOME, "");
				this.email = iLine.replace(";", "");
			} else if (iLine.contains(TEL_CELL)) {
				iLine = iLine.replaceFirst(TEL_CELL, "");
				this.phone_cell = iLine.replace(";", "");
			} else if (iLine.contains(TEL_VOICE)) {
				iLine = iLine.replaceFirst(TEL_VOICE, "");
				this.phone_work = iLine.replace(";", "");
			} else if (iLine.contains(TEL_WORK)) {
				iLine = iLine.replaceFirst(TEL_WORK, "");
				this.phone = iLine.replace(";", "");
			}
		}
	}

	public static void main(String[] args) {
		StringBuilder x = new StringBuilder();
		String y = "";
		boolean vcard_start = false;
		boolean vcard_end = true;
		try {
			FileInputStream fin = new FileInputStream(
					new File(
							"c:\\Users\\nichouha.ST-IDC\\Documents\\Personal\\Phone\\file2.vcf"));
			// InputStreamReader isr = new InputStreamReader(fin);
			Scanner scan = new Scanner(fin);
			VcftoCsv vcftocsv = new VcftoCsv();
			while (scan.hasNextLine()) {
				y = scan.nextLine();
				if (vcard_end) {
					if (isVcardStart(y)) {
						vcard_start = true;
						vcard_end = false;
						vcftocsv = new VcftoCsv();
					}
				}
				if (vcard_start) {
					if (isVcardEnd(y)) {
						vcard_end = true;
						System.out.println(vcftocsv.toString());
					} else {
						vcftocsv.setTo(y);
					}

				}

				// System.out.println(y);
				// x.trimToSize();
			}
			// System.out.println(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

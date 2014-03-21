import java.util.Scanner;

import sun.nio.ch.SctpStdSocketOption;


public class TestScanner {

	public TestScanner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
	    try {
	        while (scan.hasNextLine()){

	            String line = scan.nextLine().toLowerCase();
	            System.out.println(line);
	            if (line.equals("##")) {
	            	System.exit(0);
	            	scan.close();
	            }
	        }

	    } finally {
	    	if (scan != null)
	        scan.close();
	    }

	}

}

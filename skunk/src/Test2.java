
public class Test2 {

	public Test2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "11.1.1.7.0 - 08/09/2012";
		s = s.substring(0,s.indexOf('-'));
		System.out.println(s);

	}

}

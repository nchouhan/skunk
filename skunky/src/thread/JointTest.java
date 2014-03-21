package thread;

public class JointTest {

	public JointTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task t1 = new Task("First");
		Task t2 = new Task("Second");
		Task t3 = new Task("Third");
		t1.start();
		t2.start();
		t3.start();
		try{
			
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException intExce){
			intExce.printStackTrace();
		}
		
		
	}

}

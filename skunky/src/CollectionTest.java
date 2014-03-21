import java.util.ArrayList;
import java.util.List;


public class CollectionTest {

	public CollectionTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<LPESession> lpesessions = new ArrayList<LPESession>();
		LPESession lpe = new LPESession();
		lpesessions.add(lpe);
		lpe.setId("123");
		
		for (LPESession lpesess : lpesessions){
			System.out.println(lpesess.getId());
		}

	}

}

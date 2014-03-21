import java.util.HashMap;
import java.util.Map;


public class Counter {

	public Counter() {
		// TODO Auto-generated constructor stub
		Map<Integer, Object> x = new HashMap<>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int i =0;
for (int j =0; j<10; j++){
	System.out.println("Before update"+i);
	int x = ++i;
	System.out.println("After Update"+i +"Value f x "+x);
}
	}

}

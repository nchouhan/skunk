import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableTest implements Externalizable {
	private String test;
	private int number;

	public ExternalizableTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExternalizableTest newt = new ExternalizableTest();
		newt.setNumber(2);
		newt.setTest("TEST");
		try {
			FileOutputStream fos = new FileOutputStream("testfile");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(newt);
			oos.flush();
			oos.close();

			ExternalizableTest userRead;
			FileInputStream fis = new FileInputStream("testfile");
			ObjectInputStream ois = new ObjectInputStream(fis);
			userRead = (ExternalizableTest) ois.readObject();
			ois.close();

			System.out.println("username: " + userRead.getTest());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(number);
		out.writeObject(test);

	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// TODO Auto-generated method stub
		number = in.readInt();
		test = (String) in.readObject();
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}

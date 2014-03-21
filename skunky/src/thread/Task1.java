package thread;

public class Task1 extends Thread{
	private String taskName;
	public Task1(String iTaskName) {
		// TODO Auto-generated constructor stub
		this.taskName = iTaskName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i< 5; i++)
		{
			System.out.println("Thread"+taskName+"count"+i);
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

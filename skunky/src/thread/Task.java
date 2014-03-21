package thread;

public class Task extends Thread{
	private String taskName;
	public Task(String iTaskName) {
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
		
		for (int i = 0; i< 1; i++)
		{
			System.out.println("Thread"+taskName+" Started count"+i);
			try {
//				sleep(100);
				Task1 task1 = new Task1("Task1");
				task1.start();
				task1.join();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread"+taskName+" Completed count"+i);
		}
		
	}

}

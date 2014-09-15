package testCase;

public class MultilyThreadsVolatile {
	private volatile boolean b = true;
	
	public void set(boolean b){
		this.b = b;
	}
	
	public boolean get(){
		return this.b;
	}
	
	public class thread implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			b = true;
			set(true);
		}
	}
	
}

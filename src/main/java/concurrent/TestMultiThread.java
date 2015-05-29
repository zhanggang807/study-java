package concurrent;


public class TestMultiThread {
	
	private int totalNum = 100000;

	Object lock1 = new Object();
	Object lock2 = new Object();
	
	
	public static void main(String[] args) {
		TestMultiThread thread = new TestMultiThread();
		for(int i = 0; i < 5; i++){
			if (i % 2 == 0){
				new Thread(new Minus(thread)).start();
 			} else {
 				new Thread(new Plus(thread)).start();
			}
		}
		
	}

	public void minus(){
		synchronized (lock1) {
			totalNum = totalNum - 2;
			System.out.println("minus 2 : " + Thread.currentThread().getName() + " : " + totalNum);
			
		}
	}
	
	public void plus(){
		synchronized (lock2) {
			totalNum = totalNum + 1;
			System.out.println("plus  1 : " + Thread.currentThread().getName() + " : " + totalNum);
		}
	}

	/** 获得 totalNum */
	public int getTotalNum() {
		return totalNum;
	}

	/** 设置 totalNum */
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
}

class  Minus implements Runnable{
	
	private TestMultiThread minus;
	
	public Minus(TestMultiThread minus) {
		super();
		this.minus = minus;
	}

	@Override
	public void run() {
		while (minus.getTotalNum() > 0){
			minus.minus();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Plus implements Runnable{
	
	private TestMultiThread plus;
	
	public Plus(TestMultiThread plus) {
		super();
		this.plus = plus;
	}

	@Override
	public void run() {
		while (plus.getTotalNum() > 0){
			plus.plus();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
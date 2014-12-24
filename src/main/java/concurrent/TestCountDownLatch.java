package concurrent;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch{
	
	private static final int N = 10;
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch doneSignal = new CountDownLatch(N);
		CountDownLatch startSignal = new CountDownLatch(1);//开始执行信号
		
		for (int i = 0; i < N; i++) {
			new Thread(new Worker(doneSignal, startSignal, i)).start();//线程启动了
		}
		
		System.out.println("begin-------------------");
		startSignal.countDown();//开始执行啦
		System.out.println("开始计数器剩余值: " + startSignal.getCount());
		doneSignal.await();//等待所有的线程执行完毕
		System.out.print("OK");
	}

	static class Worker implements Runnable{
		
		private final CountDownLatch doneSignal;
		private final CountDownLatch startSignal;
		private int beginIndex; 
		
		
		public Worker(CountDownLatch doneSignal, CountDownLatch startSignal, int beginIndex) {
			this.doneSignal = doneSignal;
			this.startSignal = startSignal;
			this.beginIndex = beginIndex;
		}
		
		@Override
		public void run() {
			try {
				startSignal.await();//等待开始执行信号的发布
				beginIndex = beginIndex * 10 +1;
				for (int i = beginIndex; i < beginIndex + 10; i++) {
					System.out.println(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				doneSignal.countDown();
				System.out.println(Thread.currentThread().getName() + "--完成计算器剩余值: " + doneSignal.getCount());
			}
		}
		
	}
}

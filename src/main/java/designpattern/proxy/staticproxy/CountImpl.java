package designpattern.proxy.staticproxy;

public class CountImpl implements Count{

	@Override
	public void queryCount() {
		System.out.println("query count method...");
	}

	@Override
	public void updateCount() {
		System.out.println("update count method...");
	}

}

package designpattern.proxy.staticproxy;

/**
 * static proxy class
 * 
 * @author dean Mar 31, 2015
 */
public class CountProxy implements Count{
	
	private CountImpl impl;
	
	public CountProxy(CountImpl impl) {
		super();
		this.impl = impl;
	}

	@Override
	public void queryCount() {
		System.out.println("before query count...");
		impl.queryCount();
		System.out.println("after query count...");
	}

	@Override
	public void updateCount() {
		System.out.println("before update count...");
		impl.updateCount();
		System.out.println("after update count...");
	}
	
}

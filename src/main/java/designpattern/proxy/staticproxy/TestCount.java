package designpattern.proxy.staticproxy;

/**
 * test static proxy pattern
 * 
 * @author dean Mar 31, 2015
 */
public class TestCount {
	
	public static void main(String[] args) {
		CountImpl impl = new CountImpl();
		CountProxy proxy = new CountProxy(impl);
		proxy.queryCount();
		proxy.updateCount();
	}
	
}
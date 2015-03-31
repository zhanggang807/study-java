package designpattern.proxy.dynamicproxy.jdk;

/**
 * test jdk dynamic proxy pattern
 * 
 * @author dean Mar 31, 2015
 */
public class TestJdkProxy {

	public static void main(String[] args) {
		
		BookFacadeProxy proxy = new BookFacadeProxy();
		
		BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
		
		bookProxy.addBook();
		
	}

}

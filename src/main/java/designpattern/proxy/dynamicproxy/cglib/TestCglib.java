package designpattern.proxy.dynamicproxy.cglib;

/**
 * test cglib dynamic proxy
 * 
 * @author dean Mar 31, 2015
 */
public class TestCglib {

	public static void main(String[] args) {
		
		BookFacadeCglib cglib = new BookFacadeCglib();
		
		BookFacade facade = (BookFacade)cglib.getInstance(new BookFacade());
		
		facade.addBook();
		
	}

}

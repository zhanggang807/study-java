package designpattern.proxy.dynamicproxy.jdk;

public class BookFacadeImpl implements BookFacade{

	@Override
	public void addBook() {
		System.out.println("add book method...");
	}

}

package xstream;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class TestXstream {

	private static XStream xStream = null;

	static {
		xStream = new XStream();
		xStream.autodetectAnnotations(true);
	}
	
	public static void main(String[] args) {
		TestAnnotation obj = new TestAnnotation();
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			User u = new User();
			u.setPassword("password--" + i);
			u.setUserName("username--" + i);
			users.add(u);
		}
		obj.setUsers(users);
		System.out.println(xStream.toXML(obj));
	}
	/**
	 * 要想在result集合里的item上加一个父标签
	 * 必须加一个对象,里面放一个集合才行
	 */
}

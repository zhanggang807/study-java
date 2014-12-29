package jsonlib;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import xstream.TestAnnotation;
import xstream.User;

public class TestJsonLib {

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
		System.out.println(getJsonResponse(obj));
	}
	
	private static String getJsonResponse(Object result) {
		String json = "{}";
		if (result != null) {
			json = JSONSerializer.toJSON(result).toString();
			json = JSONObject.fromObject(result).toString();
		}
		return json;
	}

}

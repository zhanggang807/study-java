package xstream;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("result")
public class TestAnnotation {
	
	@XStreamImplicit(itemFieldName="item")
	public List<User> users;

	/** 获得 users */
	public List<User> getUsers() {
		return users;
	}

	/** 设置 users */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}

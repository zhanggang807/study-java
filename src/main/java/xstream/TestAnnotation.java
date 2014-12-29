package xstream;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("result")
public class TestAnnotation {
	
//	@XStreamImplicit(itemFieldName="item")
	public List<User> users;

	/** 获得 users */
	public List<User> getUsers() {
		return users;
	}

	/** 设置 users */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	/**
	 * 集合上可以不加	@XStreamImplicit(itemFieldName="item")
	 * 也就不用再为父标签而添加一个对象了
	 * 直接在集合里的元素上加一个别名注解就行了
	 * 这样即有父标签,每个子标签也有名字了
	 */
	
}

package designpattern.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookFacadeProxy implements InvocationHandler{
	
	private Object target;
	
	public Object bind(Object target){
		this.target = target;
		//取得代理对象,这里要绑定一个接口，cglib弥补了这一缺陷
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("something begin");
		result = method.invoke(target, args);
		System.out.println("something end");
		return result;
	}

}

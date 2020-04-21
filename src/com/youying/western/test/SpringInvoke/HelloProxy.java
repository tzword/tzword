/**
 * 
 */
package com.youying.western.test.SpringInvoke;


/**
 * @author jhy
 * 
 */
public class HelloProxy implements IHello {

	private Hello hello;

	public HelloProxy(Hello hello2) {
		this.hello = hello2;
	}

	public void sayHello(String name) {
		Logger.logging(Level.DEBUGE, "sayHello method start.");
        hello.sayHello(name);
        Logger.logging(Level.INFO, "sayHello method end!");

	}

	/* (non-Javadoc)
	 * @see com.youying.western.test.IHello#sayGoogBye(java.lang.String)
	 */
	public void sayGoogBye(String name) {
		// TODO Auto-generated method stub
		
	}

}

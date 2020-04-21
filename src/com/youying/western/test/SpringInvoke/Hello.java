/**
 * 
 */
package com.youying.western.test.SpringInvoke;

/**
 * @author jhy
 *
 */
public class Hello implements IHello{

	/* (non-Javadoc)
	 * @see com.youying.western.test.IHello#sayHello(java.lang.String)
	 */
	public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
	public void sayGoogBye(String name) {
		System.out.println(name+" GoodBye!");
	}

}

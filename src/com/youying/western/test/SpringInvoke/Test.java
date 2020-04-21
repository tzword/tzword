/**
 * 
 */
package com.youying.western.test.SpringInvoke;

/**
 * @author jhy
 *
 */
public class Test {
	public static void main(String[] args) {
		IHello hello = (IHello)new DynaProxyHello().bind(new Hello());
		hello.sayGoogBye("Double J");
        hello.sayHello("Double J");
	}
}

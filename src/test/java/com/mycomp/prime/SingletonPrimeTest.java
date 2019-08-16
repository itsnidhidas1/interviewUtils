package com.mycomp.prime;

import org.junit.Assert;
import org.junit.Test;


public class SingletonPrimeTest {

	@Test
	public void test() {
		System.out.println("This is test.");
	}
	
	@Test
	public void testSingletonInstanceCreated() {
		Singleton singleton = Singleton.getInsance();
		Assert.assertNotNull(singleton);
	}
	
	@Test
	public void testNthPrimeValue() {
		Singleton singleton = Singleton.getInsance();
		int nthPrimeNumber = singleton.findNthPrimeNumber(5);
		Assert.assertEquals(11,nthPrimeNumber);
	}
	
	@Test
	public void testNthPrimeFailed() {
		Singleton singleton = Singleton.getInsance();
		int nthPrimeNumber = singleton.findNthPrimeNumber(5);
		Assert.assertNotEquals(110,nthPrimeNumber);
	}
	
}

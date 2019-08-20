package com.mycomp.prime;

import java.io.Serializable;

public class Singleton implements Serializable {//implemented Serializable just in case if we persit the state.

	private static final long serialVersionUID = -5565319985683459583L;
	private static Singleton singleton;
	static {
		if (null == singleton) {
			try {
				singleton = new Singleton();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//Default constructor throws exception, just to prevent reflection instantiation
	private Singleton() throws Exception {
		if (null != singleton) {
			throw new Exception("Singleton is already initilazied.");
		}
	}

	public int findNthPrimeNumber(int nth) {
		int count=0;
		int i=1;
		while(count<nth) {
			if(findPrime(++i, i-1)==1) {
				count++;
			}
		}
		return i;
	}

	/*CalculateNthPrime result = (int nth) -> {
		System.out.println("Within findprime method, finding prime for nth>>" + nth);
		int i;
		int count=0;
		int num =1;
		while (count < nth) {
			num = num + 1;
			for (i = 2; i <= num; i++)
				if (num % i == 0)
					break;
			if (i == num)
				count = count + 1;
		}
		count=0;
		return num;
	};*/
	
	public int findPrime(int num, int divisor) {
		if (divisor == 1) {
            return 1;
       }
       try {
            if (num % divisor == 0) {
                 return 0;
            } else {
                 return findPrime(num, divisor - 1);
            }
       } catch (Exception e) {
            return 1;
       }
		
	}
	

	public static Singleton getInsance() {
		return singleton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Allowing user to clone same class and get same reference back
		return singleton;
	}

	// implemented readResolve method to prevent singleton failure in
	// serialization/deserialization process, just in case
	protected Object readResolve() {
		return singleton;
	}

}

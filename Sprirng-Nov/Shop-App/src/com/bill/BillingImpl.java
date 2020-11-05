package com.bill;

import com.pricematrix.PriceMatrixImpl;

// Dependent
public class BillingImpl {

	/*
	 * 
	 * two types of objects
	 * 	- dependency : which deosn't depends on any other object
	 *  - dependent  : which always depends on dependent
	 *  
	 *  
	 *  Design issues
	 *  ------------------
	 *  1. Too many dependency class objects are created ..
	 *  	-> Per of application goes down, and hard to manage memory management
	 *  
	 *  Why this issue happened?
	 *  ---------------------------
	 *  -> Dependent class itself creating dependency class object.
	 *  
	 *  what is the solution?
	 *  -----------------------
	 *  -> do not create dependency object from dependent class directly
	 *  -> Instead use techniques like JNDI look up and all...
	 *  -> JNDI location is tightly coupled with dependent class.
	 *  
	 *  What is the best solution?
	 *  ------------------------------
	 *  -> Do not create or search, instead ask some one/container to inject/pass (Inversion of control) - IoC
	 *  
	 *  What is Dependency Injection?
	 *  ------------------------------
	 *  -> Injecting Dependency object to the dependent object -> DI
	 *  
	 *  How many ways can be DI implemented? : 2 ways
	 *  1. setter based DI : methods
	 *  2. constructor based DI
	 *  
	 *  1. setter based DI
	 *  --------------------
	 *  -> Define reference of a dependency in the dependent class at class level
	 *  -> create setter for the defined dependency referance
	 *  
	 * 
	 */
	
	private PriceMatrixImpl price;

	public void setPrice(PriceMatrixImpl price) {
		this.price = price;
	}




	public double getCartTotal(String[] cart) {

		double total = 0.0;

		//PriceMatrixImpl price = new PriceMatrixImpl();

		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}

		return total;

	}

}
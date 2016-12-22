package com.redhat.mypackage.calculator.impl;

import org.apache.log4j.Logger;

import com.redhat.mypackage.calculator.interfaces.SummationClass;

public class SummationClassImpl implements SummationClass {

	
	public int Summation(int a, int b) {
		int c= a+b;
		System.out.println("Summation Value: "+c);
		
		return c;
	}

}

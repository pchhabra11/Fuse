package com.mycompany.TestService;
import com.redhat.mypackage.calculator.interfaces.SummationClass;

public class CalculateServiceConsumer {
	
	   private SummationClass summationInterfaceVariable;
		
		public SummationClass getSummationInterfaceVariable() {
		return summationInterfaceVariable;
	}

	public void setSummationInterfaceVariable(SummationClass summationInterfaceVariable) {
		this.summationInterfaceVariable = summationInterfaceVariable;
	}

		public int runConsumer(){
			int a = 5;
			int b = 6;
			int c = summationInterfaceVariable.Summation(a, b);
			return c;
			
		}
		
}
package com.serge.abousaleh.functional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class MylambdasTest {

	
    @InjectMocks
    private Mylambdas myLambdas;

    @BeforeEach
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	
	@Test
	void shouldTransformArray_givenArrayofShort() {
		//byte[] transformArray(short[] array, ShortToByteFunction shortToByteFunction) {
		// prepare
		short[] arrayShort = {0, 1, 2, -1};
		byte[] expectedArray = {0x0000, 0x0001, 0x0002, (byte) -1};
		// action
		byte[] resultByteArray = myLambdas.transformArray(arrayShort, s -> (byte)(s*1));
		// Assert
		Assertions.assertThat(resultByteArray).isEqualTo(expectedArray);
	}
	
	@Test
	public void shouldIntegrate_WhenMathExpressionProvided() {
		
		for(int i = 1; i < 7; i++) {
			int numSlices = (int)Math.pow(10, i);
			Integrable squareIntegrable = (x) -> x*x;
			Integrable powerIntegrable = x -> Math.pow(x,3);
			Integrable sinusIntegrable = x -> Math.sin(x);
			
			// Thanks to the Lambda expression we can call any of the different 
			// Math functions in parameter of the method integrate
			double a1 = myLambdas.integrate(squareIntegrable, 10, 100, numSlices);
			double a2 = myLambdas.integrate(powerIntegrable, 50, 500, numSlices);
			double a3 = myLambdas.integrate(sinusIntegrable, 0, Math.PI, numSlices);
		}
		// Action
	}

}

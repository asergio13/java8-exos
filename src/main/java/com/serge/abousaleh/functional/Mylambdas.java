package com.serge.abousaleh.functional;

public class Mylambdas {

	/**
	 * Uses The Functional interface ShortToByteFunction
	 * @param array
	 * @param shortToByteFunction
	 * @return
	 */
	public byte[] transformArray(short[] array, ShortToByteFunction shortToByteFunction) {
	    byte[] transformedArray = new byte[array.length];
	    for (int i = 0; i < array.length; i++) {
	        transformedArray[i] = shortToByteFunction.applyAsByte(array[i]);
	    }
	    return transformedArray;
	}
	
	/**
	 * Uses The Functional interface Integrate
	 * @param function
	 * @param x1
	 * @param x2
	 * @param numSlices
	 * @return
	 */
	public double integrate(Integrable function,
		double x1, double x2, int numSlices) {
		
		if (numSlices < 1) {
			numSlices = 1;
		}
		double delta = (x2 - x1)/numSlices;
		double start = x1 + delta/2;
		double sum = 0;
		// Iteration
		for(int i=0; i<numSlices; i++) {
			sum += delta * function.evaluate(start + delta * i);
		}
		return(sum);
	}
	
}

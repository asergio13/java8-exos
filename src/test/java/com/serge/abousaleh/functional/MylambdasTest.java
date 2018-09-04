package com.serge.abousaleh.functional;

import java.util.Optional;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.serge.abousaleh.Java8Exercices;

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
		byte[] expectedArray = {(byte) 0, (byte) 1, (byte) 2, (byte) -1};
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
	
	private static Stream<Arguments> computeStringProvider() {
	    return Stream.of(
	    		Arguments.of("", ""),
	    		Arguments.of(null, ""),
	            Arguments.of("dp", "pd"),
	            Arguments.of("d p", "p d"),
	            Arguments.of("o1	p", "p	1o"),
	            Arguments.of("12345", "54321"),
	            Arguments.of(" Hela lo ", " ol aleH ")
	    );
	}
	
	@DisplayName("should Perform Generic Computation on String")
	@ParameterizedTest(name = "{index} => str={0}, result={1}")
	@MethodSource("computeStringProvider")
	public void shouldPerformGenericComputationString(String str, String result) {
		// Assert
		Assertions.assertThat(myLambdas.genericComputationString(str)).isEqualTo(result);
	}
	
	private static Stream<Arguments> computeIntegerProvider() {
	    return Stream.of(
	            Arguments.of(Integer.valueOf(0), Integer.valueOf(1)),
	            Arguments.of(null, Integer.valueOf(1)),
	            Arguments.of(Integer.valueOf(1), Integer.valueOf(1)),
	            Arguments.of(Integer.valueOf(3), Integer.valueOf(6)),
	            Arguments.of(Integer.valueOf(5), Integer.valueOf(120))
	    );
	}
	
	@DisplayName("should Perform Generic Computation on Integer")
	@ParameterizedTest(name = "{index} => param={0}, result={1}")
	@MethodSource("computeIntegerProvider")
	public void shouldPerformGenericComputationInteger(Integer param, Integer result) {
		// Assert
		Assertions.assertThat(myLambdas.genericComputationInteger(param)).isEqualTo(result);
	}

}

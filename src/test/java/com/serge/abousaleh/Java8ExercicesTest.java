package com.serge.abousaleh;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class Java8ExercicesTest {

	@Test
	void testConsecutiveSum() {
		// Prepare
		List<Integer> list0 = null;
		List<Integer> list1 = Arrays.asList(1, 3, 14);
		List<Integer> list2 = Arrays.asList(1, 3, 0, 5, 0);
		List<Integer> list3 = Arrays.asList(0);
		List<Integer> list4 = Arrays.asList(0, -1);
		
		// Action
		List<Integer> list00 = Java8Exercices.consecutiveSum(list0);
		List<Integer> list11 = Java8Exercices.consecutiveSum(list1);
		List<Integer> list22 = Java8Exercices.consecutiveSum(list2);
		List<Integer> list33 = Java8Exercices.consecutiveSum(list3);
		List<Integer> list44 = Java8Exercices.consecutiveSum(list4);
		
		// Assert
		Assertions.assertThat(list00).isEqualTo(new ArrayList<>());
		Assertions.assertThat(list11).isEqualTo(Arrays.asList(4, 17));
		Assertions.assertThat(list22).isEqualTo(Arrays.asList(4, 3, 5, 5));
		Assertions.assertThat(list33).isEqualTo(new ArrayList<>());
		Assertions.assertThat(list44).isEqualTo(Arrays.asList(-1));
	}

	@Test
	void testGetNbDaysDiff() {
		// Prepare
		LocalDate date1 = LocalDate.of(2018, 01, 01);
		LocalDate date2 = LocalDate.of(2018, 01, 02);
		LocalDate date3 = LocalDate.of(2018, 02, 01);
		LocalDate date4 = LocalDate.of(2017, 12, 15);
		
		// Action
		long diffNbDays1 = Java8Exercices.getNbDaysDiff(date1, date2);
		long diffNbDays2 = Java8Exercices.getNbDaysDiff(date1, date3);
		long diffNbDays3 = Java8Exercices.getNbDaysDiff(date1, date4);
		
		// Assert
		Assertions.assertThat(diffNbDays1).isEqualTo(1l);
		Assertions.assertThat(diffNbDays2).isEqualTo(31l);
		Assertions.assertThat(diffNbDays3).isEqualTo(-17l);
	}
	
	@DisplayName("Should match digits given the numbers in parameter")
	@ParameterizedTest(name = "{index} => a={0}, b={1}, result={2}")
	@CsvSource({
			"10, 1, true",
			"1, 201, true",
			"1, 101, true",
			"9129, 99, true"
	})
	void shouldMatchDigits_whenMatchingDigitsNumbersProvided(int a, int b, boolean result) {
		// Assert
		Assertions.assertThat(Java8Exercices.matchingDigits(a, b)).isEqualTo(result);
	}
	
	@DisplayName("Should not match digits given the numbers in parameter")
	@ParameterizedTest(name = "{index} => a={0}, b={1}, result={2}")
	@CsvSource({
			"10, 77, false",
			"1, 209, false",
			"11, 0, false",
			"11, 244, false"
	})
	void shouldNotMatchDigits_whenNonMatchingDigitsNumbersProvided(int a, int b, boolean result) {
		// Assert
		Assertions.assertThat(Java8Exercices.matchingDigits(a, b)).isEqualTo(result);
	}
	
	private static Stream<Arguments> formatMyStringProvider() {
	    return Stream.of(
	            Arguments.of("dp", "pd"),
	            Arguments.of("d p", "pd"),
	            Arguments.of("o1	p", "p1o"),
	            Arguments.of("adxz q", "qdxaz"),
	            Arguments.of(" Hela lo a", "zelzloH")
	    );
	}
	
	@DisplayName("Should format Strings")
	@ParameterizedTest(name = "{index} => str={0}, result={1}")
	@MethodSource("formatMyStringProvider")
	void shouldFormatString_whenStringProvided(String str, String result) {
		// Assert
		Assertions.assertThat(Java8Exercices.formatMyString(str)).isEqualTo(result);
	}
	
	private static Stream<Arguments> insertNewLetterStringProvider() {
	    return Stream.of(
	            Arguments.of("dp", 'i', "dipi"),
	            Arguments.of("dp", ' ', "d p "),
	            Arguments.of("d", '0', "d0")
	    );
	}
	
	@DisplayName("Should insert new letter")
	@ParameterizedTest(name = "{index} => str={0}, letter= {1}, result={2}")
	@MethodSource("insertNewLetterStringProvider")
	void shouldInsertNewLetterBetweenEachChar_whenStringProvided(String str, Character letter, String result) {
		// Assert
		Assertions.assertThat(Java8Exercices.insertNewLetterBetweenEachChar(str, letter)).isEqualTo(result);
	}
	
	private static Stream<Arguments> substractOneProvider() {
	    return Stream.of(
	            Arguments.of("235460", "135350"),
	            Arguments.of("0", "0"),
	            Arguments.of("2", "1")
	    );
	}
	
	@DisplayName("Should substract 1 from pair digits")
	@ParameterizedTest(name = "{index} => str={0}, result={1}")
	@MethodSource("substractOneProvider")
	void shouldSubstractOnetoPair_whenListOfIntegersProvided(String str, String result) {
		// Assert
		Assertions.assertThat(Java8Exercices.substractOnetoPair(str)).isEqualTo(result);
	}

}

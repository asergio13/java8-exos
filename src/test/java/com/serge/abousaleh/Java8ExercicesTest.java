package com.serge.abousaleh;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

}

package com.serge.abousaleh;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Java8Exercices {
	
	// Private Constructor
	private Java8Exercices() {}
	
	/**
	 * Exercice 1
	 * @param listInt
	 * @return List of the sum of 2 consecutive numbers.
	 */
	public static List<Integer> consecutiveSum (List<Integer> listInt) {
		// vector is synchronized
		List<Integer> vector = new Vector<>();
		// ArrayList is not synchronized
		List<Integer> result = new ArrayList<>();
		if (null != listInt && listInt.size() >= 2 ) {
			
			for(int i = 1; i < listInt.size(); i++) {
				result.add(listInt.get(i-1) + listInt.get(i));
				vector.add(listInt.get(i-1) + listInt.get(i));
			}
		}
		return result;
	}
	
	/**
	 * Exercice 2
	 * @param date1
	 * @param date2
	 * @return Number of days between the 2 dates in parameter
	 */
	public static long getNbDaysDiff(LocalDate date1, LocalDate date2) {
		return ChronoUnit.DAYS.between(date1, date2);
	}
	
	/**
	 * Exercice 3
	 * @param a
	 * @param b
	 * @return true if numbers have matching digits, false otherwise
	 */
	public static boolean matchingDigits(int a, int b) {
		boolean result = false;
		// convert int to Strings
		String sa = String.valueOf(a);
		String sb = String.valueOf(b);
		
		// Convert String sa to a Set of Character in order to search inside
		Set<Character> charsSeta = sa.chars()
				.mapToObj(e->(char)e)
				.collect(Collectors.toSet());
		
		// Search for characters
		for (Character ch: sb.toCharArray()) {
			if (charsSeta.contains(ch)) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Exercice 4
	 * @param str
	 * @return removes all blank spaces from a string, replaces all 'a' with 'z', 'z' with 'a' 
	 *  and swaps the first letter with the last letter.
	 */
	public static String formatMyString(String str) {

		List<Character> charsList = str.chars()
				.mapToObj(e -> (char)e)
				.filter(ch -> (ch != ' ' && ch != '\t')) // filter blank spaces and tabs
				.map(e -> { 
					Character ch = e;            // Change 'a' to 'z' and 'z' to 'a'
					if(ch == 'a') ch = 'z';
					else if(ch == 'z') ch = 'a';
					return ch;
				} )
				.collect(Collectors.toList());
		
		// reverse first char and last char
		char firstChar = charsList.get(0).charValue();
		charsList.set(0, charsList.get(charsList.size() - 1));
		charsList.set(charsList.size() - 1, firstChar);
		
		// Convert back the List to a String
		return charsList.stream().map(e -> e.toString()).collect(Collectors.joining());
	}
	
	/*
	 * Exercice 5
	 * Existing String: abc, new Letter 'i'
	 * abc => aibici
	 */
	public static String insertNewLetterBetweenEachChar (String existingWord, Character newLetter) {
		return existingWord.chars()
				.mapToObj(c -> (char)c + newLetter.toString()).collect(Collectors.joining());
	}
	
	
	/*
	 * Exercice 6
	 * Take a List of Integer, Si digit est pair subtract 1 to it (excluding 0)
	 * 235460 => 135350
	 */
	public static String substractOnetoPair (String existingDigits) {
		List<Integer> listDigits = existingDigits.chars().mapToObj(c -> {
			Integer digit = Character.getNumericValue(c);  
			if (digit % 2 == 0 && digit != 0) return (digit -1);
			return digit;
		}).collect(Collectors.toList());
		
		return listDigits.stream().map(String::valueOf)
				.collect(Collectors.joining("")).toString();
	}
	
}

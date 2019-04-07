package com.serge.abousaleh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class myTest {

	static boolean exists(int[] ints, int k) {
		boolean result = false;
		//Predicate<T> 
		result = Arrays.asList(ints).contains(k);
		
		return result;
	}
	
	static boolean exists2(int[] ints, int k) {
		boolean result = false;
		IntPredicate element = x -> x == k ;
		result = Arrays.stream(ints).anyMatch(element);
		
		return result;
	}
	
	   // Returns the distance between the two closest numbers.
    static int distClosestNumbers1(int[] numbers) { 
    	List<Integer> distanceList = new ArrayList<>();
       for (int i=0; i < numbers.length -1; i++) {
           for (int j=i; j < numbers.length -1; j++) {
        	   int distance = Math.abs(numbers[i] - numbers[j+1]);
        	   distanceList.add(distance);
           }
       }
       System.out.println("distanceList=" +distanceList);
    	int min = distanceList.stream()
    			.mapToInt(v -> v)
    			.min().orElseThrow(NoSuchElementException::new);
		return min;
    }
    
    static int distClosestNumbers2(int[] numbers) { 
    	
    	// Sort the Array
    	Arrays.sort(numbers);
    	List<Integer> distanceList = new ArrayList<>();
    	for (int i=0; i < numbers.length -1; i++) {
    		distanceList.add(Math.abs(numbers[i] - numbers[i+1]));
    	}
	   System.out.println("distanceList=" +distanceList);
	   int min = distanceList.stream()
			.mapToInt(v -> v)
			.min().orElseThrow(NoSuchElementException::new);
	   return min;
    }
    
	
	public static void main(String[] args) {
		int [] ints = {1, 0, 8, -6};
		
		System.out.println("======= exists =====");
		System.out.println(exists(ints, 5));
		System.out.println(exists(ints, -1));
		System.out.println(exists(ints, -4543434));
		System.out.println(exists(ints, -100));
		System.out.println(exists(ints, -6));
		System.out.println(exists2(ints, -7));
		System.out.println("======= exists2 =====");
		System.out.println(exists2(ints, 5));
		System.out.println(exists2(ints, -1));
		System.out.println(exists2(ints, -4543434));
		System.out.println(exists2(ints, -100));
		System.out.println(exists2(ints, -6));
		System.out.println(exists2(ints, -7));
		
		System.out.println("======= closest distance =====");
        int[] testArray = {3, 9, 50, 15, 99, 7, 98, 65};
        int result1 = distClosestNumbers1(testArray);
        int result2 = distClosestNumbers2(testArray);
        System.out.println(result1); // Expected result is 1 (the 2 closest numbers are 98 and 99)
        System.out.println(result2); // Expected result is 1 (the 2 closest numbers are 98 and 99)
        
    
	}
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.Arrays;

/**
 *
 * @author rujuraj
 */
public class FindFrequencies {
    // Function to find counts of all elements present in
	// arr[0..n-1]. The array elements must be range from
	// 1 to n
	static void printfrequency(int arr[], int n) 
	{
		// Subtract 1 from every element so that the elements
		// become in range from 0 to n-1
		for (int j = 0; j < n; j++)
			arr[j] = arr[j] - 1;
                System.out.println(Arrays.toString(arr));
		// Use every element arr[i] as index and add 'n' to
		// element present at arr[i]%n to keep track of count of
		// occurrences of arr[i]
		for (int i = 0; i < n; i++)
                {
			arr[arr[i] % n] = arr[arr[i] % n] + n;
                        System.out.println(Arrays.toString(arr));
                }
                
		// To print counts, simply print the number of times n
		// was added at index corresponding to every element
		for (int i = 0; i < n; i++)
			System.out.println(i + 1 + "->" + arr[i] / n);
	}

	// Driver program to test above functions
	public static void main(String[] args) 
	{
		
		int arr[] = {2, 3, 3, 2, 5};
		int n = arr.length;
		printfrequency(arr, n);
	}
}

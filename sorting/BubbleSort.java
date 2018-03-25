/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;

/**
 *
 * @author rujuraj
 */
public class BubbleSort {
    
    public static void sort(int[] arr) {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j+1<arr.length-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));    
    }
    public static void main(String[] args) {
        sort(new int[]{5,7,3,9,10,3,1,4});
    }
}

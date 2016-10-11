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
public class SelectionSort {
    public static void sort(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            int min=i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]<arr[min])
                {
                    min=j;
                }
            }
            arr=swap(arr, min, i);
        }
        
        System.out.println("sorted array:"+Arrays.toString(arr));
    }
    public static int[] swap(int[] arr,int index1,int index2)
    {
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
        return arr;
    }
    public static void main(String[] args) {
        sort(new int[]{5,7,3,9,10,3,1,4});
    }
}

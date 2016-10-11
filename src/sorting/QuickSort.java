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
public class QuickSort {
    public static void sort(int[] arr) {
        quicksort(arr,0,arr.length-1);
    }
    public static void quicksort(int[] arr,int start,int end)
    {
        if(start>=end)
        {
            if(end==arr.length-1)
                System.out.println(Arrays.toString(arr));
            //return;
        }
        else
        {
            int pivot=findPivot(arr, start, end);
            quicksort(arr, start, pivot-1);
            quicksort(arr, pivot+1, end);
        }
    }
    public static int findPivot(int []arr,int start,int end)
    {
        int pivot=end;
        int pivotIndex=start;
        while(start<end)
        {
            if(arr[start]>arr[pivot])
            {
                start++;
            }
            else
            {
                // swap pivotIndex and current element
                int temp=arr[start];
                arr[start]=arr[pivotIndex];
                arr[pivotIndex]=temp;
                pivotIndex++;
                start++;
            }
        }
        // swap pivot and pivot index
        int temp=arr[pivot];
        arr[pivot]=arr[pivotIndex];
        arr[pivotIndex]=temp;
        //System.out.println(Arrays.toString(arr));
        return pivotIndex;
    }
    public static void main(String[] args) {
        sort(new int[]{5,7,3,9,10,3,1,4});
    }
}

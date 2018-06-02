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
            int pivot1=findPivot(arr, start, end);
            int pivot2=partition(arr, start, end);
            System.out.println("pivot1="+pivot1+",pivot2="+pivot2);
            quicksort(arr, start, pivot2-1);
            quicksort(arr, pivot2+1, end);
        }
    }
    public static int partition(int []arr,int start,int end){
        int pivot=arr[end];
        int pivotIndex=start;
        for(int j=start;j<=end-1;j++){
            if(arr[j]<=pivot){
                int temp=arr[j];
                arr[j]=arr[pivotIndex];
                arr[pivotIndex]=temp;
                pivotIndex++;
            }
        }
        int temp=arr[end];
        arr[end]=arr[pivotIndex];
        arr[pivotIndex]=temp;
        return pivotIndex;
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
        sort(new int[]{5,7,3,9,10,1,4});
    }
}

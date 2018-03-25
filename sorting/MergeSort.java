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
public class MergeSort {
    static int []resultarr;
    public static void sort(int arr[])
    {
        resultarr=new int[arr.length];
        mergesort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(resultarr));
    }
    
    public static void mergesort(int []arr,int start,int end)
    {
        if(start>=end)
        {
            return;
        }
        else
        {
            int mid=(start+end)/2;
            mergesort(arr, start, mid);
            mergesort(arr, mid+1, end);
            //start merging
            arr=mergeArray(arr,start,mid,end);
        }
    }
    
    public static int[] mergeArray(int []arr,int start,int mid,int end)//{3,5,7,6,10}
    {
        int index=0;
        int start1=start,start2=mid+1;
        while(start1<=mid && start2<=end)
        {
            if(arr[start1]<arr[start2])
                resultarr[index++]=arr[start1++];
            else
                resultarr[index++]=arr[start2++];
            
        }
        while(start1<=mid)
        {
            resultarr[index++]=arr[start1++];
        }
        while(start2<=end)
        {
            resultarr[index++]=arr[start2++];
        }
        for(int i=0;i<index;i++)
        {
            arr[start++]=resultarr[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        sort(new int[]{5,7,3,9,10,3,1,4}); // length=8
        sort(new int[]{5,7,3,9,10,3,1,4,8}); // length=9
        
       /*int []arr=new int[]{5,};
        resultarr=new int[arr.length];
        arr=mergeArray(arr,0,(arr.length-1)/2,arr.length-1);
         System.out.println(Arrays.toString(arr));*/
    }
}

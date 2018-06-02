/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 *
 * @author rujuraj
 */
public class MaxSubarray {
    
    public static int maxSubArray(int[] arr){
        int positives=0, negetives=0;
        int min=Integer.MAX_VALUE, sum=0;
        int total=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0) {
                positives++;
                sum+=arr[i];
            }
            else {
                negetives++;
                if(arr[i]<min)
                    min=arr[i];
            }
            total+=arr[i];
        }
        if(positives==arr.length)
            return sum;
        if(negetives==arr.length)
            return min;
        return maxSubArray(arr, arr.length-1, total);
    }
    // maxSubArray(i)=max{maxSubArray(i-1), sum(i-1)+a[i], a[i]}
    public static int maxSubArray(int[] arr, int i, int sum) {
        if(i==0)
            return arr[i];
        int item1=maxSubArray(arr, i-1, sum-arr[i]);
        int item2=sum;
        int item3=arr[i];
        return Math.max(item1, Math.max(item2, item3));
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5};
        System.out.println(maxSubArray(arr));
        arr=new int[]{-4, -1, -2, -3};
        System.out.println(maxSubArray(arr));
        arr=new int[]{-1,4,-2,-1,1,5};
        System.out.println(maxSubArray(arr));
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        
        arrayDeque.addFirst(1);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
        arrayDeque.push(2);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
        arrayDeque.addLast(3);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
        arrayDeque.add(4);
        System.out.println(Arrays.toString(arrayDeque.toArray()));
//        arrayDeque.poll();
//        System.out.println(Arrays.toString(arrayDeque.toArray()));
//        arrayDeque.remove();
//        System.out.println(Arrays.toString(arrayDeque.toArray()));
//        arrayDeque.pop();
//        System.out.println(Arrays.toString(arrayDeque.toArray()));
        
        
    }
}

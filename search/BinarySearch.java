/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author rujuraj
 */
public class BinarySearch {
    public static int search(int[] sortedArr,int elem,int start,int end)
    {
        if(start>=end)
            return -1;
        int mid=(start+end)/2;
        if(sortedArr[mid]==elem)
            return mid;
        else
        {
            if(elem>sortedArr[mid])
                return search(sortedArr, elem, mid+1, end);
            else
                return search(sortedArr, elem, start, mid-1);
        }
        
    }
    public static void main(String[] args) {
        int arr[]=new int[]{1,3,4,5,7,8,9};
        int indx=search(arr, 80, 0, arr.length);
        System.out.println("index="+indx);
                
    }
    
}

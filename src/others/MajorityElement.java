/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times (and hence there is at most one such element).

Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:

       I/P : 3 3 4 2 4 4 2 4 4
       O/P : 4 

       I/P : 3 3 4 2 4 4 2 4
       O/P : NONE
 */
public class MajorityElement {
    public static void getMajority1(int []arr)
    {
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i]))
            {
                int j=map.get(arr[i]);
                map.put(arr[i], j+1);
            }
            else
                map.put(arr[i], 1);
        }
        for (HashMap.Entry<Integer, Integer> item : map.entrySet())
        {
            if(item.getValue()>(arr.length/2))
            {
                System.out.println("found..."+item.getKey());
                break;
            }
        }
    }
    public static void getMajority2(int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int counter=1;
            for(int j=0;j<arr.length;j++)
            {
                if(arr[i]==arr[j] && i!=j)
                {
                    counter++;
                }
            }
            if(counter>(arr.length/2))
            {
                System.out.println("found...."+arr[i]);
                break;
            }
        }
    }
    // optimal - o(n)
    public static void getMajority3(int []arr)
    {
        int candidate=findCandidate(arr);
        int count=1;
        for(int i=0;i<arr.length;i++)
        {
            if(candidate==arr[i])
                count++;
            if(count>(arr.length/2))
            {
                System.out.println("Found majority..."+arr[i]);
                break;
            }
        }
        
    }
    public static int findCandidate(int []arr)
    {
        int majIndex=0, count=1;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==arr[majIndex])
                count++;
            else
                count--;
            if(count==0)
            {
                majIndex=i;
                count=1;
            }
        }
        return arr[majIndex];
    }
    public static void main(String[] args) {
        getMajority1(new int[]{3,3,4,2,4,4,2,4});
        getMajority2(new int[]{3,3,4,2,4,4,2,4,4});
        getMajority3(new int[]{3,3,4,2,4,4,2,4,4});
    }
}

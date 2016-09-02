/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rujuraj
 */
public class FindPairs {
  static int[] binarySearch(int arr[],int startIndex,int target,int firstElem)
  {
    int startitem=-1,endItem=-1;
    int start=startIndex,end=arr.length-1;
    while(start<=end)
    {
      int mid=(start+end)/2;
      if(arr[mid]+firstElem==target)
      {
          startitem=mid;
          end=mid-1;
      }
      else if(arr[mid]+firstElem>target)
      {
            end=mid-1;
      }
      else
      {
          start=mid+1;
      }
    }
    start=startitem+1;
    end=arr.length-1;
    while(start<=end)
    {
      int mid=(start+end)/2;
      if(arr[mid]+firstElem==target)
      {
          endItem=mid;
          start=mid+1;
      }
      else if(arr[mid]+firstElem>target)
      {
            end=mid-1;
      }
      else
      {
          start=mid+1;
      }
    }
    return new int[]{startitem,endItem};
  }
  
  static void findPairs3(int []arr,int target)
  {   
    if(arr.length==0)
    {
      System.out.println("no element");
      return;
    }
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++)
    {
      int[] elem=binarySearch(arr,i+1,target,arr[i]);
      if(elem[0]!=-1)
      {
        System.out.println("Pair is found:"+arr[i]+","+arr[elem[0]]);
        if(elem[1]!=-1)
        {
            for(int j=elem[0]+1;j<=elem[1];j++)
            {
                System.out.println("Pair is found:"+arr[i]+","+arr[j]);
            }
        }
      }
    }
  }
  static void findPairs4(int []arr,int target)
  {
      
  }
  static void findPairs2(int[] arr,int target)
  {
    if(arr.length==0)
    {
      System.out.println("no element");
      return;
    }
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++)
    {
      for(int j=i;j<arr.length;j++)
      {
        if(i!=j)
        {
          while(arr[i]+arr[j]<target)
            j++;
          if(arr[i]+arr[j]==target)
            System.out.println("Pair is found:"+arr[i]+","+arr[j]);
          else if(arr[i]+arr[j]>target)
            break;
        }
      }
    }
  }
  static void findPairs(int[] arr,int target)
  {
    for(int i=0;i<arr.length;i++)
    {
      for(int j=i;j<arr.length;j++)
      {
        if(arr[i]+arr[j]==target && i!=j)
        {
          System.out.println("Pair is found:"+arr[i]+","+arr[j]);
        }
      }
    }
  }
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    
    int arr[]=new int[]{15, 94, 33, 31, 58, 3, 85, 54,3};
    int target=61;
    findPairs3(arr,target);
  }
}

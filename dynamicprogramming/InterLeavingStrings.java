/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

import java.util.Arrays;

/**
 *
 * str1=ab, str2=cd, then (main)=acbd=interleaving string i.e. a permutation of str1,str2 in which order of characters does not change
 */
public class InterLeavingStrings {
    static boolean arr[][];// -1-false,1-true,0-default
    static boolean isInterLeaving(String str1,String str2,String main)
    {
        arr=new boolean[str1.length()][str2.length()];
        for(int i=0;i<arr.length;i++)
            Arrays.fill(arr[i], false);
        //arr[0][0]=0;
        return isInterLeavingHelper(str1,str2,main);
        
    }
    // dynamic programming base case without memorization
    static boolean isInterLeavingHelper1(String str1,int m,String str2,int n,String main,int i)
    {
        if(str1.isEmpty() && str2.isEmpty() && main.isEmpty())
            return true;
        else if(main.isEmpty())
            return false;
        if(i==main.length())
            return true;
        
        if(m<str1.length() && str1.charAt(m)==main.charAt(i))
        {
            return isInterLeavingHelper1(str1,m+1,str2,n,main,i+1);
        }
        else if(n<str2.length() && str2.charAt(n)==main.charAt(i))
        {
            return isInterLeavingHelper1(str1,m,str2,n+1,main,i+1);
        }
        return false;
    }
    // -1-false,1-true,0-default
    static boolean isInterLeavingHelper(String str1,String str2,String main)
    {
        if(main.length()<str1.length()+str2.length())
            return false;
        int i=0,j=0,k=0;
        arr[0][0]=true;
        for(i=0;i<str1.length();i++)
        {
            for(j=0;j<str2.length();j++)
            {
                if(i==0 && j==0)
                    arr[i][j]=true;
                else
                {
                    if(i==0 && str2.charAt(j-1)==main.charAt(k))
                        arr[i][j]=arr[i][j-1];
                    else if(j==0 && str1.charAt(i-1)==main.charAt(k))
                        arr[i][j]=arr[i-1][j];
                    else
                    {
                        if(k>main.length())
                        {
                            arr[i][j]=true;
                            break;
                        }
                        if(!arr[i][j])
                        {  
                            if(str1.charAt(i)==main.charAt(k))
                            {
                                arr[i][j]=arr[i-1][j];
                            }
                            else if(str2.charAt(j)==main.charAt(k))
                            {
                                arr[i][j]=arr[i][j-1];
                            }
                            else
                                arr[i][j]=false;
                            
                        }
                    }
                    k++;
                }
                
            }
        }
        return arr[i-1][j-1];
    }
    public static void main(String[] args) {
        String str1="AB";
        String str2="CD";
        String main="ABCD";
        System.out.println(isInterLeaving(str1, str2, main));
    }
}

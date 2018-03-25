/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

import java.util.*;
import StringManipulation.AllSubSequence;

/**
 *Problem : given two sequences X[1..m] and Y[1..n], find a longest subsequence
common to both.
* Example : X = A B C B D A B
Y = B D C A B A
LCS : <B C B A>, <B D A B> and etc
Optimal value is the size of LCS, i.e. 4
 * @author rujuraj
 */
public class LongestCommonSubsequence {
    
   
    // brute force
    // takes O(m*n*(2^m)), n=length(Y),m=length(X)
    static String LCS1(String X,String Y)
    {
        // find all sub-sequence of X and check if its sub sequence of Y
        ArrayList<String> list=AllSubSequence.getSubSequences(X);
        int len=list.size();
        int max=0;
        String maxSubString="";
        for(int i=0;i<len;i++)
        {
            String temp=list.get(i);
            System.out.println("subseq:"+temp);
            if(AllSubSequence.checkIsSubsequeceOf(Y, temp))
            {
                if(max<temp.length())
                {
                    max=temp.length();
                    maxSubString=temp;
                }
            }
        }
        return maxSubString;
    }
    static int [][]C;
    
    static void LCS(String X,String Y,int i,int j)
    {
        C=new int[i+1][j+1];
        for(int k=0;k<i+1;k++)
        {
            Arrays.fill(C[k], -999);
        }
        int maxLen= LCSHelper(X, Y, i, j);
        printLCS(X, Y, i, j);
        System.out.println("LCS found:"+finalString.reverse().toString());
        
    }
    // optimal with dynamic programming, O(mn), Returns length of LCS for X[0...i] and Y[0...j]
    static int LCSHelper(String X,String Y,int i,int j)
    {
        if(i<0 || j<0)
        {
            //C[i][j]=0;
            return 0;
        }
        int ans=C[i][j];
        if(ans==-999)
        {
            if(X.charAt(i)==Y.charAt(j))
            {
                C[i][j]=1+LCSHelper(X,Y,i-1,j-1);
            }
            else
            {
                C[i][j]=Integer.max(LCSHelper(X, Y, i-1, j), LCSHelper(X, Y, i, j-1));
            }
            ans=C[i][j];
        }
        return ans;
    }
    static StringBuilder finalString=new StringBuilder();
    static void printLCS(String X,String Y,int i,int j)
    {
        if(i<0 || j<0)
        {
            return;
        }
        else
        {
            if(i==0 || j==0)
            {
                if(X.charAt(i)==Y.charAt(j))
                    finalString.append(X.charAt(i));
            }
            else
            {
                if(C[i][j]==C[i-1][j-1]+1 && X.charAt(i)==Y.charAt(j))
                {
                    finalString.append(X.charAt(i));
                    printLCS(X, Y, i-1, j-1);
                }
                else
                {
                    if(C[i-1][j]>C[i][j-1])
                        printLCS(X, Y, i-1, j);
                    else
                        printLCS(X, Y, i, j-1);
                }
            }
            
        }
    }
    public static void main(String[] args) {
        String X="ABCBDAB",Y="BDCABA";
        int m=X.length(),n=Y.length();
        //System.out.println(LCS1(X,Y));
        LCS(X,Y,m-1,n-1);
        //System.out.println(ans);
    }
}

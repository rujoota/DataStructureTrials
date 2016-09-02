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
    static void LCS(String X,String Y)
    {
        int m=X.length(),n=Y.length();
        
        
    }
    public static void main(String[] args) {
        String X="ABCBDAB",Y="BDCABA";
        System.out.println(LCS1(X,Y));
    }
}

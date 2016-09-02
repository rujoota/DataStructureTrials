/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

import java.util.ArrayList;

/**
 * X = A B C B D A B
 * subsequence=AB,AAB,ACDA etc...
 * @author rujuraj
 */
public class AllSubSequence {
    static ArrayList<String> subseq=new ArrayList<String>();
    public static ArrayList<String> getSubSequences(String str)
    {
        getAllSubSequence(str);
        return subseq;
    }
    // takes O(2^n)
    static void getAllSubSequence(String str)
    {
        if(str.isEmpty())
        {
            subseq.add("");
        }
        else
        {
            getAllSubSequence(str.substring(1));
            if(!str.isEmpty())
            {
                int originalSize=subseq.size();
                for(int i=0;i<originalSize;i++)
                {
                    String temp=subseq.get(i);
                    subseq.add(str.charAt(0)+temp);
                   
                }
            }
        }
    }
    
    // checks if subsequenceString is subsequence of main string
    // O(nm), n=length(main), m=length(subsequencestring)
    public static boolean checkIsSubsequeceOf(String main,String subsequenceString)
    {
        for(int j=0;j<subsequenceString.length();j++)
        {
            char firstchar=subsequenceString.charAt(j);
            int firstindex=main.indexOf(firstchar);
            if(firstindex>-1) // means character exist
            {
                if(firstindex!=main.length()-1)
                    main=main.substring(firstindex+1);
            }
            else
                return false;
        }
        
        return true;
    }
    public static void main(String[] args) {
        String str="ABCDE";
        
        getAllSubSequence(str);
        System.out.println("No. of subsequece="+subseq.size());
        for(int i=0;i<subseq.size();i++)
        {
            System.out.println("Subseq:"+subseq.get(i));
        }
        System.out.println(checkIsSubsequeceOf("BDCABA","BDCA"));
    }
}

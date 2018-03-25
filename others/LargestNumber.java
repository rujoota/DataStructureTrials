/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.HashSet;

/**
 *
 * Find largest number after removing one digit
 * eg 22115 can have 2115,2215 but largest is 2215
 */
public class LargestNumber {
    static int solution(int X)
    {
        String str=Integer.toString(X);
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i+1<str.length();i++)
        {
            if(str.charAt(i)==str.charAt(i+1))
            {
                String temp=str.replaceFirst(str.charAt(i)+"", "");
                set.add(Integer.parseInt(temp));
            }
        }
        int max=Integer.MIN_VALUE;
        for(int item:set)
        {
            if(item>max)
                max=item;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(solution(11));
    }
}

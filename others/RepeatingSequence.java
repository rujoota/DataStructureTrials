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
 * @author rujuraj
 */
public class RepeatingSequence {
    public static int findRepeatingSequence(int numerator,int denominator)
    {
        int division=numerator/denominator;
        int reminder=numerator%denominator;
        boolean found=false;
        int limit=15;
        HashMap<Integer,Integer> remList=new HashMap<Integer,Integer>();
        String str="";
        if(reminder==0)
            return -1;
        else
        {
           for(int i=0;i<limit;i++)
           {
                reminder=numerator%denominator;
                if(remList.containsKey(reminder))
                {
                    found=true;
                    break;
                }
                remList.put(reminder, i);
                reminder=reminder*10;
                numerator=reminder;
                division=numerator/denominator;
                str+=division;
           }
        }
        if(found)
        {
            System.out.println("found...."+Integer.parseInt(str.substring(remList.get(reminder))));
            //System.out.println(remList.get(reminder));
            return Integer.parseInt(str.substring(remList.get(reminder)));
        }
        else
            System.out.println("not found....");
        return -1;
    }
    public static void main(String[] args) {
        findRepeatingSequence(8,7);
    }
}

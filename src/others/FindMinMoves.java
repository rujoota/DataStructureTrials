/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.ArrayList;

/**
 * Visa coding challange question, 0s and 1s...get min number of swaps to put all 1s at one side of the array
 * @author rujuraj
 */
public class FindMinMoves {
    static class Frequencies
    {
        int studentAvg;
        int freq;

        public Frequencies(int avg,int freq) {
            this.studentAvg=avg;
            this.freq=freq;
        }
        
    }
    static int minMoves(int[] avg) {
        ArrayList<Frequencies> list=new ArrayList<>();
        int count1=0,count0=0;
        
        for(int i=0;i<avg.length;i++)
        {
            while(i<avg.length && avg[i]==1)
            {
                count1++;
                i++;
            }
            if(count1!=0)
            {
                list.add(new Frequencies(1, count1));
                count1=0;
            }
            while(i<avg.length && avg[i]==0)
            {
                count0++;
                i++;
            }
            if(count0!=0)
            {
                list.add(new Frequencies(0, count0));
                count0=0;
                i--;
            }
        }
        if(list.size()<=2)
            return 0;
        int totalMoves=0;
        ArrayList<Frequencies> cloneList=(ArrayList<Frequencies>) list.clone();
        for(int i=0;i<list.size();i++)
        {
            Frequencies item=list.get(i);
            if(item.studentAvg==1 && i!=0)
            {
                totalMoves += list.get(i-1).freq;
                if(i!=list.size()-1) // after swap update freq
                    list.get(i+1).freq+=1;
            }
                
        }
        int totalMoves1=0;
        
        for(int i=cloneList.size()-1;i>=0;i--)
        {
            Frequencies item=cloneList.get(i);
            if(item.studentAvg==1 && i!=cloneList.size()-1)
            {
                totalMoves1 += cloneList.get(i+1).freq;
                if(i!=0) // after swap update freq
                    cloneList.get(i-1).freq+=1;
            }
                
        }
        return Math.min(totalMoves, totalMoves1);
    }
    public static void main(String[] args) {
        int []arr={1,0,1,0,0,0,0,1};
        System.out.println(minMoves(arr));
       
    }
}

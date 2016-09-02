/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitmanipulation;

import java.util.ArrayList;

/**
 *
 * @author rujuraj
 */
public class Basics {
    // get nth bit from num
    public int getBit(int num,int n)
    {
        int ans = (1<<n & num);
        if(ans>0)
            return 1;
        else
            return 0;
    }
    // set num'n nth bit to booleanBit(if booleanBit=false, set it to 0, otherwise 1)
    public int setBit(int num,int n,boolean booleanBit)
    {
        if(booleanBit)
            return num | (1<<n);
        else
        {
            return num & (~(1<<n));
        }
            
    }
    public void convertDoubleToBinary(double num)
    {
        String arr="";
        double temp=num;
        for(int i=0;i<32;i++)
        {
            double dbl=temp*2;
            if(dbl==1)
            {
                arr+="1";
                break;
            }
            else if(dbl>1)
            {
                arr+="1";
                temp=dbl-1;
            }
            else if(dbl<1)
            {
                temp=dbl;
                arr+="0";
            }
        }
        System.out.println("arr="+arr);
    }
    public static void main(String[] args) {
       Basics basics=new Basics();
       basics.convertDoubleToBinary(0.825);
       ArrayList<Integer> list=new ArrayList<Integer>();
       int n=5;
       for(int i=0;i<n;i++)
       {
           list.add(0,i);
       }
        System.out.println("arraylist:"+list);
    }
}

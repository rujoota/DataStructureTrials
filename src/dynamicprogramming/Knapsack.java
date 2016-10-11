/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author rujuraj
 */
public class Knapsack {
    int M;
    KnapsackObject objects[];
    int [][]arr;
    void initKnapsack(int num)
    {
        arr=new int[num][M+1];
        for(int i=0;i<num;i++)
            Arrays.fill(arr[i], -1);
        objects=new KnapsackObject[num];
        objects[0]=new KnapsackObject(0, 2, 1);
        objects[1]=new KnapsackObject(1, 3, 2);
        objects[2]=new KnapsackObject(2, 4, 5);
        objects[3]=new KnapsackObject(3, 5, 2);
    }
    // for (i+1) objects and weight Y
    int fillKnapsack(int i,int Y)
    {
        if(i<0)
        {
            //arr[i][Y]=0;
            return 0;
        }
        else if(Y<=0)
        {
            //arr[i][Y-1]=Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }
        else
        {
            if(arr[i][Y]==-1) // if not filled b4
            {
                int num1=fillKnapsack(i-1, Y);//exclude object
                int num2=fillKnapsack(i-1, Y-objects[i].weight)+objects[i].profit;// include object
                arr[i][Y] = Integer.max(num1,num2);
                if(arr[i][Y]==num2)
                {
                    System.out.println("Object included:"+i);
                }
                    
            }
        }
        return arr[i][Y];
    }
    public static void main(String[] args) {
        Knapsack knapsack=new Knapsack();
        knapsack.M=9;
        knapsack.initKnapsack(4);
        int maxprofit=knapsack.fillKnapsack(3, knapsack.M);
        System.out.println("max ="+maxprofit);
    }
}
class KnapsackObject
{
    int objNo,weight,profit;

    public KnapsackObject(int objNo,int weight,int profit) {
        this.objNo=objNo;
        this.weight=weight;
        this.profit=profit;
                
    }
    
}

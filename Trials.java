
import java.util.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rujuraj
 */
/*class Parent
{
    int x=1;
    Parent()
    {
        System.out.println("in parent");
    }
}
class Child extends Parent
{
    int x=4;
    Child()
    {
        System.out.println("in child...");
    }
}*/
public class Trials {
    public static void getModes(int[][] arr)
    {
        HashMap<Integer,Integer> numbers=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++)
            {
                
                if(numbers.containsKey(arr[i][j]))
                {
                    int freq=numbers.get(arr[i][j]);
                    numbers.replace(arr[i][j], freq+1);
                }
                else
                {
                    numbers.put(arr[i][j], 1);
                }
            }
        }
        int max=0;
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (HashMap.Entry<Integer, Integer> item : numbers.entrySet())
        {
            if(item.getValue()>max)
            {
                max=item.getValue();
            }
        }
        for (HashMap.Entry<Integer, Integer> item : numbers.entrySet())
        {
            if(item.getValue()==max)
            {
                list.add(item.getKey());
            }
        }
        System.out.println("modes are:"+Arrays.toString(list.toArray()));
    }
    public static void main(String[] args) {
        int arr[][]={{3,3,3},{1,2,3},{1,2,3}};
        //getModes(arr);
        double a=1/10;
        double b=2/10;
        double c= 3/10;
        System.out.println(0.1+0.2);
        System.out.println(0.3);
        if(a+b==c)
            System.out.println("true");
        else
            System.out.println("false");
        
    }
}

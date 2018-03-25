/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;
import java.util.*;
/**
 *
 * @author rujuraj
 */
public class MergeKLists {
    static void merge(List<List<Integer>> lists)
    {
        
        int minIndex=-1;
        List<Integer> result=new ArrayList<Integer>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<lists.size();i++)
        {
            List<Integer> list1=lists.get(i);
            for(int k=0;k<4;k++) // k<max sizes
            {
                for(int j=0;j<lists.size();j++)
                {
                    
                    if(i!=j)
                    {
                    List<Integer> list2=lists.get(j);

                    if(!list1.isEmpty() && !list2.isEmpty())
                    {
                        int a=list1.get(0);
                        int b=list2.get(0);
                        if(a>b && b<min)
                        {
                            min=b;
                            minIndex=j;
                        }
                        else if(a<b && a<min)
                        {
                            min=a;
                            minIndex=i;
                        }
                    }
                    }

                }
                if(min!=Integer.MAX_VALUE && minIndex!=-1)
                {
                    result.add(min);
                    min=Integer.MAX_VALUE;

                    lists.get(minIndex).remove(0);
                    minIndex=-1;
                }
            }
            
        }
        for(int i=0;i<lists.size();i++)
        {
            List<Integer> list1=lists.get(i);
            if(!list1.isEmpty())
            {
                for(int j=0;j<list1.size();j++)
                {
                    result.add(list1.get(j));
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
    public static void main(String[] args) {
        
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> l1=new ArrayList<Integer>();
        l1.add(5);
        l1.add(6);
        l1.add(9);
        l1.add(10);
        lists.add(l1);
        l1=new ArrayList<Integer>();
        l1.add(7);
        l1.add(8);
        l1.add(11);
        l1.add(12);
        lists.add(l1);
        l1=new ArrayList<Integer>();
        l1.add(13);
        l1.add(14);
        l1.add(15);
        l1.add(16);
        lists.add(l1);
        merge(lists);
    }
}

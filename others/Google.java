/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;


public class Google {
static public int equalibriumSum(int[] A) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int sum=0;
        for(int i=0;i<A.length;i++)
        {
            sum+=A[i];
            map.put(A[i], sum);
            
        }
        int index=-1;
        int sum1=0;
        for(int i=0;i+1<A.length;i++)
        {
            int current=map.get(A[A.length-i-1]);
            if(sum-map.get(A[i+1])==map.get(A[i]))
            {
                index=i+1;
                break;
            }
        }
        return index;
        
    }
    int solution1(int X)
    {
        if(X==0)
            return 0;
        String str=Integer.toString(X);
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i=0;i+1<str.length();i++)
        {
            
            double num1=Integer.parseInt(str.charAt(i)+"");
            double num2=Integer.parseInt(str.charAt(i+1)+"");
            int avg=(int) Math.ceil((num1+num2)/2);
            String temp=str.replaceFirst(str.charAt(i)+"", "");
            temp=temp.replaceFirst(str.charAt(i+1)+"", Integer.toString(avg));
            set.add(Integer.parseInt(temp));
            
        }
        int max=Integer.MIN_VALUE;
        for(int item:set)
        {
            if(item>max)
                max=item;
        }
        return max;
    }
    public int solution(String S) {
        if(S==null || S.isEmpty())
            return 0;
        String[] arr=S.split("\n");
        int pathLen=1;
        int pathLen2=1;
        HashSet<Integer> set=new HashSet<>();
        int spaces=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i].contains(".gif") || arr[i].contains(".jpeg") || arr[i].contains(".png"))
            {
                spaces=arr[i].lastIndexOf(' ')+1;
                /*if(pathLen>pathLen2)
                    set.add(pathLen);
                else*/
                    set.add(pathLen2);
                pathLen=pathLen2;
                pathLen2=1;
            }
            int currentSpaces=arr[i].lastIndexOf(' ')+1;
            
            if(spaces>currentSpaces)
            {
                if(pathLen2!=1)
                    pathLen2++;
                pathLen2+=arr[i].trim().length();
                
                spaces--;
            }
            
        }
        set.add(pathLen2);
        int max=0;
        for(int item:set)
        {
            if(item>max)
                max=item;
        }
        return max;
    }
    public static void main(String[] args) {
        int []arr={-1,3,-4,5,1,-6,2,1};
        Google google=new Google();
        //System.out.println(google.solution(654));
        //String struct=" dir1\n  dir11\n  dir12\n   pic.jpeg\n   dir121\n   file.txt\n dir2\n  file2.gif";
        
        String struct=" a\n  b\n   c\n    d\n     x.jpeg\n a\n  b\n   c\n    dd\n     y.jpeg";
        System.out.println(google.solution(struct));
        
    }
    
}

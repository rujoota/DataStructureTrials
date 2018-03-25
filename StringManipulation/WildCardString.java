/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author rujuraj
 */
public class WildCardString {
    public static void generateAll(String str)
    {
        generateAllHelper(str.toCharArray(),0);
    }
    ArrayList<String> arrayList=new ArrayList<>();
    public static void generateAllHelper(char[] arr,int i)
    {
        if(i==arr.length)
        {
            System.out.println("arr="+Arrays.toString(arr));
        }
        else if(arr[i]=='?')
        {
            //char[] temp=arr;
            arr[i]='0';
            generateAllHelper(arr,i+1);
            arr[i]='1';
            generateAllHelper(arr,i+1);
            arr[i]='?';
        }
        else
            generateAllHelper(arr,i+1);
    }
    public static void main(String[] args) {
        //generateAll("1?00?101");
        generateAll("1?0?");
    }
}

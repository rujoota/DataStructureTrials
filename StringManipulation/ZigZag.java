/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author rujuraj
 */
public class ZigZag {
    public static String convert1(String s, int numRows) {
        int len=s.length();
        LinkedHashMap<Integer, ArrayList<Character>> map=new LinkedHashMap<>();
        for(int i=0;i<len;i++) {
            ArrayList<Character> list=null;
            int num = (i-numRows/2)%(numRows/2+1);
            if(num==0) {
                if(map.containsKey(numRows/2)) {
                    list = map.get(numRows/2);
                }
                else {
                    list=new ArrayList<>();
                }
                list.add(s.charAt(i));
                map.put(numRows/2, list);
//                list=new ArrayList<>();
//                for(int j=i;j<len;j+=numRows/2+1) {
//                    list.add(s.charAt(j));
//                }
                map.put(numRows/2,list);
            } else {
                int indx=0;
                if(map.containsKey(i%numRows)) {
                    list = map.get(i%numRows);
                    indx=i%numRows;
                }
                else {
                    list=new ArrayList<>();
                }
                list.add(s.charAt(i));
                map.put(i%numRows, list);
            }
        }
        for (Map.Entry<Integer, ArrayList<Character>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Character> value = entry.getValue();
            System.out.println("key="+key+","+Arrays.toString(value.toArray()));
        }
        return "";
    }
    public static String convert(String s, int numRows) {
        int len=s.length();
        if(len==0 || len<=numRows || numRows==1)
            return s;
        String output="";
        int mid=0;
        if(numRows%2==0) {
            mid=numRows;
        } else {
            mid=numRows/2;
        }
        HashSet<Integer> skipList=new HashSet<>();
//        for (int i = 0; i < numRows; i++) {
//            if(i != mid && !skipList.contains(i)) {
//                for(int j=i;j<len;j+=numRows+1) {
//                    output+=s.charAt(j);
//                }
//            } else if(i==mid) {
//                for(int j=i;j<len;j+=numRows/2+1) {
//                    output+=s.charAt(j);
//                    skipList.add(j);
//                }
//            }
//        }
        for(int j=mid;j<len;j+=numRows/2+1) {
//            output+=s.charAt(j);
            skipList.add(j);
        }
        for (int i = 0; i < numRows; i++) {
            if(i<numRows/2 && !skipList.contains(i)) {
                for(int j=i;j<len;j+=numRows+1) {
                    output+=s.charAt(j);
                }
            }
            if(i==0) {
                for(int item: skipList) {
                    output+=s.charAt(item);
                }
            }
            
            if(i>=numRows/2 && !skipList.contains(i)) {
                for(int j=i;j<len;j+=numRows+1) {
                    output+=s.charAt(j);
                }
            }
        }
        
        System.out.println(output);
        return output;
    }
    public static void main(String[] args) {
//        convert("abc", 2);
//        convert("abcdefgh", 3);
        convert("abcd", 2);
    }
}

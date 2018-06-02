/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StringManipulation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author rujuraj
 */
public class StringCompression {
    public static String compress(String s) {
        LinkedHashMap<Character, Integer> map=new LinkedHashMap<>();
        for(int i=0;i<s.length();i++) {
            char curr=s.charAt(i);
            if(map.containsKey(curr)){
                int val=map.get(curr);
                val++;
                map.put(curr, val);
            } else {
                map.put(curr, 1);
            }
        }
        String result="";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            result+=key;
            result+=value;
        }
        
        return result.length()>s.length()?s:result;
    }
    public static void main(String[] args) {
        System.out.println(compress("aabbaa"));
    }
}

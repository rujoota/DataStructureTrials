/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All possible T9 words from the given number
 * @author rujuraj
 */
public class T9Word {
    static HashMap<Integer, String> map=new HashMap<>();
    
    public static List<String> findAllWords(String num, HashMap<Integer, String> map) {
        if(num.length()==1) {
            List<String> result=new ArrayList<>();
            String letters=map.get(Integer.parseInt(num));
            if(letters.equals("")) {
                result.add("");
            } else {
                for (int j=0;j<letters.length();j++) {
                    result.add(letters.charAt(j)+"");
                }
            }
//            System.out.println(Arrays.toString(result.toArray()));
            return result;
        }
        List<String> result=null;
        List<String> newResult = new ArrayList<>();
//        for(int i=0;i<num.length();i++){
            String curr=num.charAt(0)+"";
            num = num.substring(1);
            System.out.println("num="+num);
            result = findAllWords(num, map);
            String letters=map.get(Integer.parseInt(curr));
//            System.out.println("letters="+letters);
//            System.out.println(Arrays.toString(result.toArray()));
            if(letters.equals("")) {
                newResult=result;
            } else {
                for(int j=0;j<letters.length();j++){
                    for (String string : result) {
                        String word = letters.charAt(j)+string;
                        newResult.add(word);
                    }
                }
            }
//        }
        return newResult;
    }
    
    public static void main(String[] args) {
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");
        map.put(1, "");
        map.put(0, "");
        List<String> result=findAllWords("234", map);
        System.out.println(Arrays.toString(result.toArray()));
    }
}

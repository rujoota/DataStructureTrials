/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author rujuraj
 * degree = freq of element occuring max times in array
 * lenght = lenght of the subarray containing that degree
 * e.g {1,2,1,3,3,3,3}
 * degree = 4(as 3 appears 4 times)
 * length of subarray for that degree = 4
 * 
 * 
 * {1,2,2,3,1}
 * degree = 2(as 1 and 2 both appears max times i.e. 2 times)
 * length of subarray => 2 options, for element 1, its 5(from index 0 to 4), for element 2 its 2
 * hence return min(5,2)=2
 */
public class PocketGem {
    static int degreeOfArray(int[] arr) {
        if(arr.length==0)
            return 0;
        
        HashMap<Integer, Integer> occuranceMap=new HashMap<>();
        HashMap<Integer, Integer> lengthMap=new HashMap<>();
        HashMap<Integer, Integer> freqMap=new HashMap<>();
        int minLen=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(occuranceMap.containsKey(arr[i])){
                lengthMap.put(arr[i], i-occuranceMap.get(arr[i])+1);
            } else {
                occuranceMap.put(arr[i], i);
                lengthMap.put(arr[i], 1);
            }
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
        }
        if(freqMap.size()==1)
            return freqMap.get(arr[0]);
        int maxFreq=Integer.MIN_VALUE;
        ArrayList<Integer> maxFreqElems=new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value>maxFreq){
                maxFreq=value;
            }
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value==maxFreq){
                maxFreqElems.add(key);
            }
        }
        for (Map.Entry<Integer, Integer> entry : occuranceMap.entrySet()) {
            Integer key = entry.getKey();
            if(minLen>lengthMap.get(key) && lengthMap.get(key)!=1 && maxFreqElems.contains(key)){
                minLen=lengthMap.get(key);
            }
        }
        if(minLen==Integer.MAX_VALUE)
            return 1;
        return minLen;
        
    }
    public static void main(String[] args) {
//        System.out.println(degreeOfArray(new int[]{1,2,2,3,1}));
//        System.out.println(degreeOfArray(new int[]{1,1,1,1}));
//        System.out.println(degreeOfArray(new int[]{1,1,3,3,3,3,1,2,2}));
        System.out.println(degreeOfArray(new int[]{1,2,1,3,3,3,3}));
//        System.out.println(degreeOfArray(new int[]{1,1,2,1,2,2}));
//        System.out.println(degreeOfArray(new int[]{1,1,3,3,3,3,1}));
    }
}

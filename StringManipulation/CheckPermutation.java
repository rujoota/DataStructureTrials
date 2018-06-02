import java.util.*;

// if a string has all unique characters
public class CheckPermutation {
    public static boolean isPermutationBruteForce(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1=createFreqMap(s1);
        HashMap<Character, Integer> map2=createFreqMap(s2);
        for(Map.Entry<Character, Integer> item1:map1.entrySet()) {
            for(Map.Entry<Character, Integer> item2:map2.entrySet()) {
                if(item1.getKey() == item2.getKey()) {
                    if(item1.getValue()!=item2.getValue()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static HashMap<Character, Integer> createFreqMap(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char cur = s.charAt(i);
            if(map.containsKey(cur)) {
                int val=map.get(cur);
                map.put(cur, val+1);
            } else {
                map.put(cur, 1);
            }
        }
        return map;
    }
    public static boolean isPermutationSort(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        char arr1[]=s1.toCharArray();
        char arr2[]=s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String s11=new String(arr1);
        String s22=new String(arr2);
        return s11.equals(s22);
    }

    public static boolean isPermutationCharCount(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        int []charset = new int[256];
        for(int i=0;i<s1.length();i++) {
            charset[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length();i++) {
            int c=s2.charAt(i)-'a';
            if(charset[c]>0) {
                charset[c]--;
            } else if(charset[c]<=0)
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        String s1="abcdef";
        String s2="cdabef";

        System.out.println(isPermutationCharCount(s1, s2));

        s1="aafff";
        s2="faaff";
        System.out.println(isPermutationCharCount(s1, s2));
    }
}
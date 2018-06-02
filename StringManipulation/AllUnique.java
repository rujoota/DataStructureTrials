import java.util.*;

// if a string has all unique characters
public class AllUnique {
    public static boolean isUniqueBruteForce(String s) {
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<s.length();j++) {
                if(i!=j && s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUniqueHashMap(String s) {
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++) {
            if(set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public static boolean isUniqueCharArr(String s) {
        boolean arr[] = new boolean[256];
        Arrays.fill(arr, false);
        for(int i=0;i<s.length();i++) {
            if(arr[s.charAt(i)-'a']) {
                return false;
            }
            arr[s.charAt(i)-'a'] = true;
        }
        return true;
    }

    public static boolean isUniqueBitVector(String s) {
        int bitVector = 0;
        
        for(int i=0;i<s.length();i++) {
            int bitnum = s.charAt(i)-'a';
            int matcher = 1<<bitnum;
            if((bitVector & matcher) != 0) {
                return false;
            }
            bitVector = bitVector|matcher;
        }
        return true;
    }
    public static void main(String[] args) {
        String s1="pqlajdsiuj";
        String s2="yahdw";
        // System.out.println(isUniqueBruteForce(s1));
        // System.out.println(isUniqueBruteForce(s2));

        System.out.println(isUniqueBitVector(s1));
        System.out.println(isUniqueBitVector(s2));
    }
}
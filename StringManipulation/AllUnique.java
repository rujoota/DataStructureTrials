package StringManipulation;

import java.util.ArrayList;

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
    public static void main(String[] args) {
        String s1="abcdaed";
        String s2="abcde";
        System.out.println(isUniqueBruteForce(s1));
        System.out.println(isUniqueBruteForce(s2));
    }
}
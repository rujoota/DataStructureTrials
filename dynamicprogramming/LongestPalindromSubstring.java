/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

/**
 *
 * @author rujuraj
 */
public class LongestPalindromSubstring {
    public static String longestPalindromeBruteForce(String s) {
        // o(n^3)
        int n=s.length();
        String max="";
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String temp=s.substring(i, j);
//                System.out.println("temp="+temp+","+i+","+j);
                if(isPalindrom(temp)){
                    if(max.length()<temp.length())
                        max=temp;
                }
            }
        }
        return max;
    }
    public static boolean isPalindrom(String s){
        int n=s.length();
        int len=n/2-1;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1))
                return false;
        }
        return true;
    }
    
    public static String longestPalindrome(String s) {
        int n=s.length();
        String max="";
        int i=0, j=n-1;
        longestPalindromeHelper(s, i, j);
        return max;
    }
    static String max="";
    public static String longestPalindromeHelper(String s, int i, int j) {
        if(i>=j)
            return max;
        if(s.charAt(i) == s.charAt(j)) {
            String temp = s.substring(i, j+1);
            if(isPalindrom(temp)) {
                max = temp;
                return max;
            } else {
//                if(isPalindrom(s))
            }
        } else {
            String max1 = s.charAt(i)+longestPalindromeHelper(s, i+1, j-1)+s.charAt(j);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabcdcbg"));
        System.out.println(longestPalindrome("abcba"));
        System.out.println(longestPalindrome("abcc"));
        System.out.println(longestPalindrome("aaagcdcbga"));
    }
}

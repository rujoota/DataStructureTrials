/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

/**
 *generate all palindromes till number k
 * @author rujuraj
 */
public class Palindrom {
    static char min='0',max='9';
    
    static void generatePalin(int k)
    {
        StringBuffer s=new StringBuffer("0");
        for(int i=0;i<k-1;i++)
        {
            nextPalin(s);
            System.out.println(s.toString());
        }
        
    }
    static void nextPalin(StringBuffer s)
    {
        int len=s.length();
        for(int i=(len+1)/2;i>0;i--)
        {
            if(s.charAt(i-1)<max)
            {
                s.setCharAt(len-i, (char) (s.charAt(i-1)+1));
                s.setCharAt(i-1, (char) (s.charAt(i-1)+1));
                return;
            }
            else
            {
                s.setCharAt(len-i, min);
                s.setCharAt(i-1, min);
            }
        }
        s.setCharAt(0, (char) (s.charAt(0)+1));
        s.append(s.charAt(0));
    }
    public static void main(String[] args) {
        generatePalin(10);
    }
}

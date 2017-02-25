/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import java.util.*;

/**
 * given directory hierarchy with some image(extension .gif,.jpeg,.png) and other files, parse directory structure and 
 * list totals of lengths of distinct absolute paths to image
 * 
 */
public class DirectoryListing {
    static String removeTill(String str,char ch)
    {
        int index=str.lastIndexOf(ch);
        return str.substring(0, index);
    }
    
    static int solution1(String S)
    {
        String[] arr=S.split("\n");
        HashSet<String> set=new HashSet<String>();
        String path="/";
        int lastIndex=0;
        int spaces=0;
        int currentSpaces=0;
        for(int i=0;i<S.length();i++)
        {
            
            if(S.charAt(i)=='.') // got a file
            {
                String extension=S.substring(i+1,i+4);// get first 3 letters
                if(extension.equals("png") || extension.equals("gif"))
                {
                    path=removeTill(path, '/');
                    if(path.isEmpty())
                        path="/";
                    set.add(path);
                    i+=3;
                    
                }
                else if(extension.equals("jpe") && S.charAt(i+4)=='g')
                {
                    path=removeTill(path, '/');
                    if(path.isEmpty())
                        path="/";
                    set.add(path);
                    i+=4;
                }
                    
            }
            else if(S.charAt(i)=='\n')
            {
                path+="/";
                lastIndex=i;
            }
            else if(S.charAt(i)==' ')
            {
                while(S.charAt(i)==' ')
                {
                    i++;
                    spaces++;
                }
                if(spaces<=currentSpaces)
                {
                    if(!path.isEmpty())
                    {
                        if(path.charAt(path.length()-1)=='/')
                            path=path.substring(0,path.length()-1);
                        for(int j=0;j<=currentSpaces-spaces;j++)
                        {
                            if(path.contains("/"))
                                path=removeTill(path, '/');
                        }
                        path+="/";
                    }
                }
                
                currentSpaces=spaces;
                spaces=0;
                i--;
            }
            else
            {
                path+=S.charAt(i);
            }
        }
        int total=0;
        for(String item:set)
        {
            total+=item.length();
            System.out.println(item);
        }
        return total;
    }
    
    public static int printSum(String s){
       String[] arr=s.split("\n");
       int sum=0, spaces=0;
       for(int i=arr.length-1;i>=0;i--){
           String line=arr[i];
           if(line.contains(".gif") | line.contains(".jpeg") ){
               spaces=line.length()-line.trim().length();
           }
           if(spaces> line.length()-line.trim().length() ){
               sum+=line.trim().length()+1;
               spaces--;
           }
       }
       return sum;
    }
    
    public static void main(String[] args) {
        String struct=" dir1\n  dir11\n  dir12\n   pic.jpeg\n   dir121\n   file.txt\n dir2\n  file2.gif";
        String struct1=" dir1\n  dir11\n  dir12\n   pic.jpeg\n";
        String struct3=" dir1\n  dir11\n   pic.jpeg\n dir2\n   pic.jpeg\n";
        System.out.println(solution1(struct));
        System.out.println(printSum(struct));
    }
}

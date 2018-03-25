/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

/**
 *
 * @author rujuraj
 */
public class MatrixSpiral {
    
    static void printSpiral(int n,int[][] a)
    {
        int midRow=n/2;
        int midCol=midRow;
        int nextRow=midRow,nextCol=midCol;
        int k=3;
        int dx=0,dy=1;
        while(k<=n)
        {
            int max=midRow+(k/2);
            int min=midRow-(k/2);
            if(nextRow<=max && nextRow>=min && nextCol<=max && nextCol>=min)
            {
                System.out.println(a[nextRow][nextCol]);
            }
            if((nextRow==min && nextCol==max) || (nextRow==min && nextCol==min) || (nextRow==max && nextCol==min)
                    || (nextRow>=midRow && nextCol-nextRow==1))
            {
                int temp=dx;
                dx=-dy;
                dy=temp;
                
            }
            
            if(nextRow==max && nextCol==max)
                k+=2;
            nextRow+=dx;
            nextCol+=dy;
        }
    }
    
    public static void main(String[] args) {
        int [][]a={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        printSpiral(5,a);
    }
}

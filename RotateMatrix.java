
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rujuraj
 */
public class RotateMatrix {
    public static void rotateMatrix(int[][] mat) {
        int n=mat.length;
        int numLayers=n/2;
        for (int k = 0; k < numLayers; k++) {
            for (int i = k; i < n-k; i++) {
//                int temp=mat[k][i];
//                mat[k][i]=mat[n-k-1][k];
//                mat[n-k-1][k]=mat[n-k-1][n-k-1];
//                mat[n-k-1][n-k-1]=mat[k][n-k-1];
//                mat[k][n-k-1]=temp;
//               
//int temp=mat[k][k];
//                mat[k][k]=mat[n-k-1][k];
//                int temp1=mat[k][n-k-1];
//                mat[k][n-k-1]=temp;
//                int temp2=mat[n-k-1][n-k-1];
//                mat[n-k-1][n-k-1]=temp1;
//                mat[n-k-1][k]=temp2;
                int temp=mat[k][i];
                mat[k][i]=mat[n-k-1][k-i];
                mat[n-k-1][k]=mat[n-k-1][n-k-1];
                mat[n-k-1][n-k-1]=mat[k][n-k-1];
                mat[k][n-k-1]=temp;
            }
            
        }
        printMatrix(mat);
    }
    public static void printMatrix(int [][]mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]+",");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int[][] mat={{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13, 14, 15,16}};
        rotateMatrix(mat);
    }
}

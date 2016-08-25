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
public class Permutations {

    int[] arr;

    void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    void printarr() {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.print("}");
    }

    void generatePermutation(int start, int end) {
        if (start == end) {
            printarr();
            return;
        } else {
            for (int i = start; i <= end; i++) {
                swap(start, i);
                generatePermutation(start + 1, end);
                swap(start, i);
            }
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();

        obj.arr = new int[]{1, 2, 3};
        obj.generatePermutation(0, obj.arr.length-1);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree.linkedlist;

/**
 *
 * @author rujuraj
 */
public class TestClass {
    public static void main(String[] args) {
        LinkedListClass ll=new LinkedListClass();
        ll.insertAtEnd(10);
        ll.insertAtEnd(14);
        ll.insertAtEnd(6);
        ll.insertAtEnd(5);
        ll.insertAtEnd(19);
        ll.display(ll.head);
    }
}

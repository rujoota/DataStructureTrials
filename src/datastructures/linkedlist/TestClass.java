/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.linkedlist;

/**
 *
 * @author rujuraj
 */
public class TestClass {
    
    public static void main(String[] args) {
        LinkedListClass ll=new LinkedListClass();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        //ll.insertAtEnd(5);
        //ll.display(ll.head);
        Node hh=ll.fx(ll.head);
        ll.display(hh);
    }
}

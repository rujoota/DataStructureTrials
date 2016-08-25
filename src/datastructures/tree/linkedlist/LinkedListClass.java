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
public class LinkedListClass {
    public Node head;
    void insertAtEnd(int newData)
    {
        if(head==null)
        {
            head=new Node();
            head.data=newData;
            head.next=null;
           
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=new Node();
            temp.next.data=newData;
        }
    }
    void display(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data+"->");
            head=head.next;
        }
    }
}

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
public class LinkedListClass {
    public Node head;
    Node fx(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node h=new Node();
        h.data=0;
        h.next=head;
        Node p=h;
        while(p.next!=null && p.next.next!=null)
        {
            Node t1=p;
            p=p.next;
            t1.next=p.next;
            Node t2=p.next.next;
            p.next.next=p;
            p.next=t2;
        }
        return h.next;
    }
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

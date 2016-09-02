/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.ArrayList;

/**
 *
 * @author rujuraj
 */
public class Node {
    int data;
    ArrayList<Node> childNodes=new ArrayList<Node>();
    boolean visited=false;
    boolean inProgress=false;
    Node(int data,ArrayList childNodes)
    {
        this.data=data;
        this.childNodes=childNodes;
    }
    Node(int data)
    {
        this.data=data;
    }
}

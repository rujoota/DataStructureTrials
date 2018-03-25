/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

/**
 *
 * @author rujuraj
 */
public class TestClass {
    public static void main(String[] args) {
        DirectedGraph graph=new DirectedGraph();
        Node root=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        graph.insert(root, null);
        graph.insert(node2, root);
        graph.insert(node4, root);
        graph.insert(node3, node2);
        graph.insert(node5, node2);
        
        graph.insert(node5, node3);
        graph.insert(root, node3);
        graph.display();
        //System.out.println("DFS:");
        //graph.DFS(root);
        System.out.println("BFS:");
        graph.BFS(root);
        //System.out.println("cycle:"+graph.detectCycle(root));
    }
}

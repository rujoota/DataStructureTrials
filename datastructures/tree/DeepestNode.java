/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.tree;
import java.util.*;
/**
 *
 * @author rujuraj
 */
public class DeepestNode {
    static class CustomNode
    {
        Node node;
        int depth;

        public CustomNode(Node node,int depth) {
            this.node=node;
            this.depth=depth;
        }

        @Override
        public String toString() {
            return "data="+node.data+",depth="+depth;
        }
        
        
    }
    static ArrayList<CustomNode> nodes=new ArrayList<CustomNode>();
    static void addDepth(Node root,int depth)
    {
        if(root==null)
        {
            return;
        }
        
        CustomNode rootnode=new CustomNode(root, depth);
        Queue<CustomNode> queue=new LinkedList<CustomNode>();
        queue.offer(rootnode); // adds to end of queue
        while(!queue.isEmpty())
        {
            CustomNode node=queue.remove();
            nodes.add(node);
            
            if(node.node.left!=null)
                queue.offer(new CustomNode(node.node.left, node.depth+1));
            if(node.node.right!=null)
                queue.offer(new CustomNode(node.node.right, node.depth+1));
            
        }
        int max=nodes.get(0).depth;
        Node maxNode=nodes.get(0).node;
        for(CustomNode node:nodes)
        {
            //System.out.println(node);
            if(node.depth>=max)
            {
                max=node.depth;
                maxNode=node.node;
            }
        }
        System.out.println(maxNode.data+","+max);
    }
    static int deepestlevel=0;
    static int value;
    public static void find(Node root, int level) {
		if (root != null) {
                        level=level+1;
			find(root.left,level);
			if (level >= deepestlevel) {
				value = root.data;
				deepestlevel = level;
			}
			find(root.right, level);
		}
                else
                {
                    return;
                }
	}
    public static void main(String[] args) {
        Node root=new Node(1);
        root.right=new Node(3);
        /*root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);*/
        //root.left.left.left=new Node(7);
        //addDepth(root,1);
        find(root, 0);
        System.out.println(value+","+deepestlevel);
        //System.out.println(getDeepest(root));
    }
}

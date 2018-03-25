/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.*;

/**
 *
 * @author rujuraj
 */
public class DirectedGraph {
    ArrayList<Node> nodes=new ArrayList<Node>();
    HashMap<Node,ArrayList<Node>> map=new HashMap<Node,ArrayList<Node>>();
    public void prepareAdjcencyList()
    {
        for(Node node:nodes)
        {
            ArrayList list=new ArrayList();
            for(Node child:node.childNodes)
            {
                list.add(child);
            }
            map.put(node, list);
        }
    }
    public void insertInAdjecency(Node childNode,Node root)
    {
        if(map.containsKey(root))
        {
            ArrayList list=map.get(root);
            list.add(childNode);
            map.put(root, list);
        }
        else
        {
            ArrayList list=new ArrayList();
            list.add(childNode);
            map.put(root, list);
        }
    }
    public void insert(Node childNode,Node root)
    {
        if(root==null)
        {
            nodes.add(childNode);
        }
        else
        {
            root.childNodes.add(childNode);
            nodes.add(childNode);
        }
    }
    public void DFS(Node root)
    {
        if(root==null)
            return;
        visit(root);
        if(root.childNodes!=null)
        {
            for(Node node:root.childNodes)
            {
                if(!node.visited)
                {
                    DFS(node);
                }
            }
        }
    }
    public void visit(Node node)
    {
        node.visited=true;
        System.out.println("visiting..."+node.data);
    }
    public void display()
    {
        prepareAdjcencyList();
        Iterator it=map.entrySet().iterator();
        
        for(HashMap.Entry<Node,ArrayList<Node>> item:map.entrySet())
        {
            System.out.println("Main node:"+item.getKey().data);
            for(Node node:item.getValue())
            {
                System.out.println("    Child nodes:"+node.data);
            }
        }
    }
    public void BFS(Node startNode)
    {
        Queue<Node> queue=new LinkedList<Node>();
        visit(startNode);
        queue.offer(startNode);
        while(!queue.isEmpty())
        {
            Node node=queue.remove();
            for(Node child:node.childNodes)
            {
                if(!child.visited)
                {
                    visit(child);
                    queue.offer(child);
                }
            }
        }
    }
    
    public boolean detectCycle(Node root)
    {
        visit(root);
        root.inProgress=true;
        for(Node child:root.childNodes)
        {
            if(child.inProgress)
            {
                System.out.println("cycle detected");
                return true;
            }
            else
            {
                if(!child.visited)
                    if(detectCycle(child))
                        return true;
            }
        }
        root.inProgress=false;
        return false;
    }
}

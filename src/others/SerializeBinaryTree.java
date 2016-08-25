/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import datastructures.tree.BinaryTree;
import datastructures.tree.Node;
import java.io.BufferedWriter;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author rujuraj
 */
public class SerializeBinaryTree {
    
    static Writer writer=null;
    static BufferedReader reader=null;
    public static void writeToFile(String filePath,int data)
    {
        try
        {
            if(writer==null)
            {
                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"));
                writer.write(String.valueOf(data)+"\n");
            }
            else
                writer.append(String.valueOf(data)+"\n");
        } 
        catch (IOException ex) 
        {
          // report
        }
    }
    public static ArrayList readFromFile(String filepath)
    {
        ArrayList list=new ArrayList();
        try 
        {
            if(reader==null)
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
            String strLine;
            while ((strLine = reader.readLine()) != null)   
            {
                //System.out.println (strLine);
                list.add(strLine);
            }
        } 
        catch (Exception e) 
        {
        }
        return list;
    }
    // serialization for normal tree would require modified travarsal with null marked as -1
    public static void serialze(Node node,String filePath)
    {
        if(node==null)
        {
            writeToFile(filePath, -1);
            return;
        }
        writeToFile(filePath, node.data);
        serialze(node.left, filePath);
        serialze(node.right, filePath);
    }
    public static BinaryTree deserialize(String filepath)
    {
        ArrayList list=readFromFile(filepath);
        BinaryTree bt=new BinaryTree();
        bt.root=constructBinaryTree(bt.root, list);
        return bt;
    }
    public static Node constructBinaryTree(Node node,ArrayList list)
    {
        if(list.get(0).equals("-1"))
        {
            list.remove(list.get(0));
            return null;
        }
        else
        {
            node=new Node();
            node.data=Integer.parseInt(String.valueOf(list.get(0)));
            list.remove(list.get(0));
            node.left=constructBinaryTree(node.left, list);
            node.right=constructBinaryTree(node.right, list);   
        }
        return node;
    }
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        bt.insert(10);
        bt.insert(11);
        bt.insert(5);
        bt.insert(4);
        bt.insert(18);
        
        bt.insertAt(14, 4, Boolean.TRUE);
        bt.display(bt.root);
        String filepath="serialized.txt";
        serialze(bt.root, filepath);
        // close file
        try
        {
            writer.close();
        }
        catch(Exception ex)
        {
            System.out.println("cannot close writer");
        }
        BinaryTree bt2=deserialize(filepath);
        System.out.println("after deserialization....");
        bt2.display(bt2.root);
    }
 
}

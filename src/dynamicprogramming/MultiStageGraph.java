/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming;

import java.util.*;

/**
 *
 * @author rujuraj
 */
public class MultiStageGraph {
	static Graph graph=new Graph();
	public static void initGraph()
	{
		ArrayList<Vertice> V=new ArrayList<>();
		for(int i=0;i<=11;i++)
		{
			V.add(new Vertice(i));
		}
		V.get(0).setStage(1);
		for(int i=1;i<=4;i++)
			V.get(i).setStage(2);
		for(int i=5;i<=7;i++)
			V.get(i).setStage(3);
		for(int i=8;i<=10;i++)
			V.get(i).setStage(4);
		V.get(11).setStage(5);
		ArrayList<Edge> E=new ArrayList<>();
        
		E.add(new Edge(V.get(0),V.get(1),9));
		E.add(new Edge(V.get(0),V.get(2),7));
		E.add(new Edge(V.get(0),V.get(3),3));
		E.add(new Edge(V.get(0),V.get(4),2));

		E.add(new Edge(V.get(1),V.get(5),4));
		E.add(new Edge(V.get(1),V.get(6),2));
		E.add(new Edge(V.get(1),V.get(7),1));

		E.add(new Edge(V.get(2),V.get(5),2));
		E.add(new Edge(V.get(2),V.get(6),7));

		E.add(new Edge(V.get(3),V.get(7),11));
		
		E.add(new Edge(V.get(4),V.get(6),11));
		E.add(new Edge(V.get(4),V.get(7),8));
		
		E.add(new Edge(V.get(5),V.get(8),6));
		E.add(new Edge(V.get(5),V.get(9),5));
		
		E.add(new Edge(V.get(6),V.get(8),4));
		E.add(new Edge(V.get(6),V.get(9),3));
		
		E.add(new Edge(V.get(7),V.get(9),5));
		E.add(new Edge(V.get(7),V.get(10),6));
		
		E.add(new Edge(V.get(8),V.get(11),4));
		E.add(new Edge(V.get(9),V.get(11),2));
		E.add(new Edge(V.get(10),V.get(11),5));
                graph.V=V;
                graph.E=E;

	}
	public static void findMinCost(Vertice source,Vertice desti)
	{
		HashMap<Vertice,Integer> cost=new HashMap<Vertice,Integer>();
		cost.put(desti,0);
		for(int i=graph.V.size()-1;i>=0;i--)
		{
			Vertice current=graph.V.get(i);
			ArrayList<Edge> edges=graph.getEdgeFrom(current);
			int min=Integer.MAX_VALUE;
			for(int j=0;j<edges.size();j++)
			{
				Edge edge=edges.get(j);
				int total=cost.get(edge.end)+edge.getCost();
				if(total<min)
				{
					min=total;
				}
			}
			if(min==Integer.MAX_VALUE)
				min=0;
			cost.put(current,min);
		}
		System.out.println("min cost is="+cost.get(source));

	}
    public static void main(String []args)
    {
    	initGraph();
        findMinCost(graph.V.get(0), graph.V.get(11));
    }
}
class Graph
{
    ArrayList<Vertice> V=new ArrayList<>();
    ArrayList<Edge> E=new ArrayList<>();
    public ArrayList<Edge> getEdgeFrom(Vertice vertice)
    {
    	ArrayList<Edge> edges=new ArrayList<Edge>();
    	for(int i=0;i<E.size();i++)
    	{
            Edge edge=E.get(i);
    		if(edge.start.num==vertice.num && edge.end.num!=-1)
    			edges.add(edge);
    	}
    	return edges;
    }
}
class Vertice
{
    int stage;
    int num;
    public Vertice()
    {
        
    }
    public Vertice(int num)
    {
    	this.num=num;
    }
    public void setStage(int stage)
    {
    	this.stage=stage;
    }

}
class Edge
{
    Vertice start=new Vertice(-1);//start
    Vertice end=new Vertice(-1);//end
    int cost;
    public Edge(Vertice u,Vertice v,int cost)
    {
    	this.end=v;
    	this.start=u;
    	this.cost=cost;
    }
    public int getCost()
    {
    	return cost;
    }

}
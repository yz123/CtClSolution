package Chapter4;

import java.util.LinkedList;
import java.util.Queue;

import Chapter4.State.state;

public class RouteBetweenNodes {

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}

    public static boolean search(Graph g, Node start,Node end) {
    	Node listNode[] = g.getNodes();
    	int check = 0;
    	for (Node n: listNode) {
    		//Unvisited, Visited, Visiting;
    		n.marked = state.Unvisited;
    		if (n.getVertex().equals(start.getVertex())) check ++;
    		if (n.getVertex().equals(end.getVertex())) check ++;    		
    	}
    	if (check != 2){
    		System.out.println("the nodes do not present at the graph...");
    		return false;
    	}
    	// Breadth-First-Search
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(start);
    	start.marked = state.Visited;
    	
    	while(!queue.isEmpty()) {
    		Node r = queue.poll();
    		if(r.getVertex().equals(end.getVertex()))
    			return true;
    		for (Node n : r.getAdjacent()) {
    			if (n.marked == state.Unvisited){
    				n.marked = state.Visited;
    				queue.add(n);
    			}
    		}
    	}
		return false;  
	}
}

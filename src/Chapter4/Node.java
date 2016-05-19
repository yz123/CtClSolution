package Chapter4;

public class Node {
	private String vertex;
	private Node[] adjacent;
	public int adjacentCount;
	public State.state marked;

	public Node(String name, int neighbourLength){
		this.vertex = name;
		this.adjacent = new Node[neighbourLength];
		this.adjacentCount = 0;
	}
	
	public void addAdjacent(Node x) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public Node[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }

}

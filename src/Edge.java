
public class Edge {
	
	private Vertex destination;
	private int weight;
	private String edgeType;
	
	public Edge( Vertex destination, int weight,String edgeType) {
		
		this.destination = destination;
		this.weight = weight;
		this.edgeType = edgeType;
	}

	

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getEdgeType() {
		return edgeType;
	}

	public void setEdgeType(String edgeType) {
		this.edgeType = edgeType;
	}	
	
}

import java.util.ArrayList;
import java.util.LinkedList;

public class Vertex implements Comparable<Vertex> {
	private String name;
	private String id;
	private LinkedList<Vertex> path;
	private ArrayList<Edge> edges;
	private String vehicle;
	private double minDist;
	private Vertex precessor;
	
	 public Vertex(String id , String name,String vehicle) {
		 	this.id = id;
	        this.name = name;
	        this.vehicle = vehicle;
	        edges = new ArrayList();
	        minDist = Integer.MAX_VALUE;
	        path = new LinkedList<Vertex>();
	    }
	 
	 
	 public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void addEdge(Edge e)
	 {
		 edges.add(e);  
	 }
	 
	 public ArrayList<Edge> getEdges()
	 {
		 return this.edges;
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Vertex [name=" + name + ", id=" + id + ", edges=" + edges + "   vehicle="
				+ vehicle + "]";
	}


	public double getMinDist() {
		return minDist;
	}


	public void setMinDist(double newDistance) {
		this.minDist = newDistance;
	}


	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}


	public Vertex getPrecessor() {
		return precessor;
	}


	public void setPrecessor(Vertex precessor) {
		this.precessor = precessor;
	}
	
	@Override
    public int compareTo(Vertex otherVertex) 
    {
        return Double.compare(this.minDist, otherVertex.getMinDist());
    }


	public LinkedList<Vertex> getPath() {
		return path;
	}


	public void setPath(LinkedList<Vertex> path) {
		this.path = path;
	}

}

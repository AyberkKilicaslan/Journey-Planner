import java.util.HashMap;

public class Graph {
	private HashMap<String,Vertex> vertices;
	private HashMap<String,Edge> edges;
	static int counter=0;
	Graph() {
		this.vertices = new HashMap<>();
		this.edges = new HashMap<>();
	}

	//public void addEgde(Vertex source, Vertex destination, int weight,String edgeType) {
		
		///if kapanýrsa edge artýyor ama distance azalýyor ??????????????????????
		
//		if(edges.get(source.getId() + "-" + destination.getId()+ "-"+ edgeType ) == null && edges.get(destination.getId() + "-" + source.getId()+ "-"+ edgeType) == null )
//		{
//			if(vertices.get(source.getId()) == null) 
//				{
//					vertices.put(source.getId(), source);
//				}
//
//			if(vertices.get(destination.getId()) == null) 
//				{
//					vertices.put(destination.getId(), destination);
//				}
//			
//			
//			Edge edge = new Edge(source, destination, weight,edgeType);
//			source.addEdge(edge);
//			//destinationu kaparsak daha çok sonuç buluyor ama öyle de yanlýþ duruyor sanki !!!
//			destination.addEdge(edge);
//			edges.put(source.getId() + "-" + destination.getId()+ "-" +edgeType, edge);
//		}
//		else
//		{
//			counter++;
//		}
		public void addEgde(Vertex source, Vertex destination, int distance, String type) 
		{
			
			if(vertices.get(source.getId()) == null) 
				{
					vertices.put(source.getId(), source);
				}

			if(vertices.get(destination.getId()) == null) 
				{
					vertices.put(destination.getId(), destination);
				}
            Edge edge = new Edge(destination, distance,type);
            source.addEdge(edge);
            edges.put(source.getId() + "-" + destination.getId(), edge);
		}
	//}
	
	
	
//	public void print(){
//		int count = 0;
//		System.out.println("Source\tDestination\tWeight");
//		for (Edge e : edges.values()) {
//			System.out.println("" + e.getSource().getId() + "\t" + e.getDestination().getId() + "\t\t" + e.getWeight()+ " ");
//			//System.out.println("" + e.getSource().getName() + "\t" + e.getDestination().getName() + "\t\t" + e.getWeight()+ " ");
//			count++;
//		}
//		System.out.println("Edge counter : " + count);
//	}
	public  Iterable<Vertex> vertices()
	{
		return vertices.values();
	}

	public  Iterable<Edge> edges()
	{
		return edges.values();
	}

	public int size()
	{
		return vertices.size();
	}

	public HashMap<String, Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(HashMap<String, Vertex> vertices) {
		this.vertices = vertices;
	}

	public HashMap<String, Edge> getEdges() {
		return edges;
	}

	public void setEdges(HashMap<String, Edge> edges) {
		this.edges = edges;
	}
	
}

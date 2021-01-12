import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class Dijkstra {
	//////////////////Reference : https://github.com/vaishnav/Dijkstra/blob/master/Dijkstra.java
	public static int countEdge;
	public static ArrayList<Vertex> WalkOrRoad = new ArrayList<Vertex>();
	static int walkThree=0;
		//Function for minimum distance (care about edge's type)
    	public void calculate(Vertex source)
    	{
    		int walkCount=0;
    		/////assigning distance for source
    		source.setMinDist(0);
    		
    		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
    		queue.add(source);
    		while(!queue.isEmpty()){
    			
    			Vertex u = queue.poll();
    		
    			for(Edge neighbour:u.getEdges())
    			{
    				countEdge++;
    				
    				/////walk control
    				if(walkCount<1 && walkThree < 3) 
    				{
    					Double newDist = u.getMinDist()+ neighbour.getWeight();
        				if(neighbour.getEdgeType().equals("Walk"))
        				{
        					
        					walkCount++;
        					walkThree++;
        				}
        				
        				if(neighbour.getDestination().getMinDist()>newDist)
        				{
        					// Remove the node from the queue to update the distance value.
        					queue.remove(neighbour.getDestination());
        					neighbour.getDestination().setMinDist(newDist);
        					
        					//System.out.println("zaa : " + neighbour.getDestination());
        					neighbour.getDestination().setPath(new LinkedList<Vertex>(u.getPath()));
        					neighbour.getDestination().getPath().add(u);
        					
        					//Reenter the node with new distance.
        					queue.add(neighbour.getDestination());		
        				}
    				}
    				else
    				{
    					
    					if(neighbour.getEdgeType().equals("Road"))
    					{
    						
    						walkCount=0;
    						Double newDist = u.getMinDist()+ neighbour.getWeight();
            				
            				if(neighbour.getDestination().getMinDist()>newDist){
            					//removes node and update new distance
            					queue.remove(neighbour.getDestination());
            					neighbour.getDestination().setMinDist(newDist);
            					///adding vertices which we travelsed
            					neighbour.getDestination().setPath(new LinkedList<Vertex>(u.getPath()));
            					neighbour.getDestination().getPath().add(u);
            					
            					
            					//enter a new node
            					queue.add(neighbour.getDestination());					
            				}
    					}
    					
    				}
    				
    				
    			}
    		}

    	}
    	
    	///function to calculate minimum stop (ignores walk or road type)
    	public void calculateByOne(Vertex source)
    	{
    		source.setMinDist(0);
    		
    		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
    		queue.add(source);
    		while(!queue.isEmpty())
    		{	
    			Vertex u = queue.poll();
    			for(Edge neighbour:u.getEdges())
    			{
    				countEdge++;
    				Double newDist = u.getMinDist()+ neighbour.getWeight();
        			
        			if(neighbour.getDestination().getMinDist()>newDist)
        			{
        				// Remove the node from the queue to update the distance value.
        				queue.remove(neighbour.getDestination());
        				neighbour.getDestination().setMinDist(newDist);
        				neighbour.getDestination().setPath(new LinkedList<Vertex>(u.getPath()));
    					neighbour.getDestination().getPath().add(u);
        				
        				//Reenter the node with new distance.
        				queue.add(neighbour.getDestination());					
        			}
    				
    			}
    		}
    	}
}

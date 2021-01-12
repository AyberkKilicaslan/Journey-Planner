import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Application {
	public static HashMap<String,Line> lines = new HashMap<>();
	//static String inputCriteria;
	public Application() throws FileNotFoundException{
		String inputCriteria;
		int walkza=0;
		//boolean variables to break array list foreach's
		boolean one=false;
		boolean two =false;
		//necessary variables for reading
		Scanner sc5;
		String text = null;
		String [] array;
		ArrayList<Vertex> vertexes = new ArrayList<>();
		//ArrayList<Line> otobüsler = new ArrayList<>();
		Graph graphDist = new Graph();
		//Graph graphOne = new Graph();
		
		///deciding traversal calculating type
		Scanner input = new Scanner(System.in);
		System.out.println("Enter criteria !!! ");
		inputCriteria = input.nextLine();
		
		///For input taking
		if(inputCriteria.equals("2"))
			System.out.println("Calculated by using edge's weights !!");
		else
			System.out.println("Calculated by using edge's weights as 1 !!");
		
		
		///Reading stop.txt part
		try 
		{
			///creating vertices
			sc5 = new Scanner(new FileInputStream("Stop.txt"));
			sc5.nextLine();
			while(sc5.hasNextLine())
			{
				text = sc5.nextLine();
				array = text.split(";");
				Vertex stop = new Vertex(array[0],array[1],array[4]);
				vertexes.add(stop);
			}
		}
		catch(Exception e)
		{
			System.out.println("Text file can not be readable!");
		}
		
		try {
			//creating neighbor stops
			sc5 = new Scanner(new FileInputStream("Stop.txt"));
			sc5.nextLine();
			//counter for finding index in the arraylist easily
			int count=0;
			String [] neighbour;
			String[] distance;
			while(sc5.hasNextLine())
			{
				text = sc5.nextLine();
				array = text.split(";");
				String nei = array[5];
				
				neighbour = nei.split("\\.");
				
				for (int i = 0; i < neighbour.length; i++) 
				{
					distance = neighbour[i].split(":");
					for(Vertex v : vertexes)
					{
						if(v.getId().equalsIgnoreCase(distance[0]))
						{
							
							//creating walk roads
							if(inputCriteria.equals("2"))
								graphDist.addEgde(vertexes.get(count), v, Integer.parseInt(distance[1]),"Walk");
							else
								graphDist.addEgde(vertexes.get(count), v, 1,"Walk");
								
						}
						
					}
					
				}
				count++;
			}
		}
		catch(Exception a)
		{
			System.out.println("Text file can not be readable !!");
		}
		
		//Reading distance.txt part
		try {
			///creating distance edges
			sc5 = new Scanner(new FileInputStream("Distance.txt"));
			sc5.nextLine();
			//temp vertexes for adding and creating vertex
			Vertex vertex = null;
			Vertex vertex2 = null ;
			
			while(sc5.hasNextLine())
			{
				text = sc5.nextLine();
				array = text.split(";");
				///creating not exist vertices 
				if(graphDist.getVertices().get(array[0]) == null)
				{
					vertex = new Vertex(array[0],null,null);
					vertexes.add(vertex);
				}
				if(graphDist.getVertices().get(array[1]) == null)
				{
					vertex2 = new Vertex(array[1],null,null);
					vertexes.add(vertex2);
				}
				
					for(Vertex v : vertexes)
					{
						if(v.getId().equalsIgnoreCase(array[0]))
						{
							vertex=v;
							one = true;
							break;
						}
					}
					for(Vertex w : vertexes)
						{
							if(w.getId().equalsIgnoreCase(array[1]))
							{
								vertex2=w;
								two = true;
								break;
							}
								
						}
					///creating edges by using distance.txt
					if(one == true && two==true)
					{
						if(inputCriteria.equals("2"))
							graphDist.addEgde(vertex, vertex2, Integer.parseInt(array[2]),"Road");
						else
							graphDist.addEgde(vertex, vertex2, 1,"Road");
						
						one=false;
						two=false;
					}
					
			}
			
			
			///Reading Line.txt and Trip.txt part
			
//			sc5 = new Scanner(new FileInputStream("Line.txt"));
//			sc5.nextLine();
//			
//			while(sc5.hasNextLine())
//			{
//				
//				text = sc5.nextLine();
//				array = text.split(";");
//				Line line = new Line(array[0],array[2],array[3]);
//				lines.put(array[0],line);
//				otobüsler.add(line);
//			}
//			
//			
//			sc5 = new Scanner(new FileInputStream("Trip.txt"));
//			while(sc5.hasNextLine())
//			{
//				text = sc5.nextLine();
//				array = text.split(";");
//				if(array[1].equals("0"))
//				{
//					lines.get(array[0]).getVerticesVisited0().add(array[3]);
//				}
//				else if(array[1].equals("1"))
//				{
//					lines.get(array[0]).getVerticesVisited1().add(array[3]);
//				}
//			}
		}
		catch(Exception z)
		{
			System.out.println("Text file can not be readable !!");
		}
		
		//Printing graph's values
		System.out.println("graphDist's creation is completed !!");
		System.out.println("Total edges : " + graphDist.getEdges().size());
		System.out.println("Total vertices : " + graphDist.getVertices().size());
		System.out.println();
		
				/////TEXT READING PART
		Vertex start;
		int yok = 0;
		Dijkstra obj = new Dijkstra();
		Dijkstra obj2 = new Dijkstra();
		sc5 = new Scanner(new FileInputStream("test_stops.txt"));
		sc5.nextLine();
		Vertex dest;
		text=null;
		double timeCollector=0;
		int criteria1=0;
		int criteria2=0;
		while(sc5.hasNextLine())
		{
			text = sc5.nextLine();
			array = text.split(";");
			
			///from here
//			if(array[4].equals("1"))
//			{
//				criteria1++;
//				start = graphDist.getVertices().get(array[0]);
//				dest = graphDist.getVertices().get(array[1]);
//			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//				obj.calculateByOne(start);
//				System.out.println("Source : " + array[2] + " / Destination : "+array[3]);
//				
//					if(dest.getMinDist()<Integer.MAX_VALUE)
//					{
//						
//							System.out.println("Minimum distance is : "+ dest.getMinDist() + " stops.");
//						dest.getPath().add(dest);
//						System.out.print("Path -> ");
//						for(Vertex pathvert:dest.getPath()) 
//						{
//							System.out.print(pathvert.getId()+" ");
//							Dijkstra.WalkOrRoad.add(pathvert);
//						}
//						System.out.println();
//						for (int i = 0; i < Dijkstra.WalkOrRoad.size()-1; i++) 
//						{
//							Vertex temp = Dijkstra.WalkOrRoad.get(i);
//							Vertex temp2 = Dijkstra.WalkOrRoad.get(i+1);
//							System.out.print(graphDist.getEdges().get(temp.getId()+"-"+temp2.getId()).getEdgeType() + " ");
//							
//						}
//						//resetting arraylist
//						Dijkstra.WalkOrRoad = new ArrayList<Vertex>();
//						Dijkstra.walkThree = 0;
//						System.out.println();
//						System.out.println();
//					}
//					else
//					{
//						yok++;
//						System.out.println("You can not go there without walking in a row !");
//					}
//			 Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
//			 timeCollector +=timestamp2.getTime()-timestamp.getTime();
//					for(Vertex all : vertexes)
//					{
//						all.setMinDist(Integer.MAX_VALUE);
//						all.setPath(new LinkedList<Vertex>());
//					}
//				
//				
//			}
			//to here
			
			//from here
			if(array[4].equals("2"))
				{
				criteria2++;
				start = graphDist.getVertices().get(array[0]);
				dest = graphDist.getVertices().get(array[1]);
				
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				 
				obj2.calculate(start);
				System.out.println("Source : " + array[2] + " / Destination : "+array[3]);
					if(dest.getMinDist()<Integer.MAX_VALUE)
					{
							System.out.println("Minimum distance is : "+ dest.getMinDist() + " meters.");
							dest.getPath().add(dest);
						System.out.print("Path -> ");
						for(Vertex pathvert:dest.getPath()) 
							{
								System.out.print(pathvert.getId()+" ");
								Dijkstra.WalkOrRoad.add(pathvert);
							}
							System.out.println();
							for (int i = 0; i < Dijkstra.WalkOrRoad.size()-1; i++) 
							{
								Vertex temp = Dijkstra.WalkOrRoad.get(i);
								Vertex temp2 = Dijkstra.WalkOrRoad.get(i+1);
								if(graphDist.getEdges().get(temp.getId()+"-"+temp2.getId()).getEdgeType().equals("Walk"))
								{
									walkza++;
								}
										
								System.out.print(graphDist.getEdges().get(temp.getId()+"-"+temp2.getId()).getEdgeType() + " ");
								
							}
							
							//resetting arraylist
							Dijkstra.WalkOrRoad = new ArrayList<Vertex>();
							System.out.println();
							System.out.println("Walked " + walkza +" times.");
							walkza=0;
							Dijkstra.walkThree = 0;
							System.out.println();
					}
					else
					{
						yok++;
						System.out.println("You can not go there without walking in a row !");
					}
					 Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
					 timeCollector +=timestamp2.getTime()-timestamp.getTime();
			///clearing path list for each vertex
					for(Vertex all : vertexes)
					{
						all.setMinDist(Integer.MAX_VALUE);
						all.setPath(new LinkedList<Vertex>());
					}
				
			//}
			
			System.out.println("yok" + yok);
			
			System.out.println();
				}
				//to here
			
		}//while loop
		System.out.println("criteria 1 " + criteria1);
		System.out.println("criteria 2 " + (criteria2));
		System.out.println("average time is " + ((timeCollector/criteria2)/1000) + " ms");
		
		/////For input taking////
		
//		String startV;
//		String destV;
//		Vertex v;
//		
//		while(true) 
//		{
//			try
//			{
//				Scanner startVertex = new Scanner(System.in);
//				System.out.println("Enter origin stop id : ");
//				startV = startVertex.nextLine();
//				start = graphDist.getVertices().get(startV);
//				
//				//deciding dijkstra function for ignoring walk rule
//				if(inputCriteria.equals("1"))
//					obj.calculateByOne(start);
//				else
//					obj.calculate(start);
//				
//				System.out.println("Enter destination stop id : ");
//				destV = startVertex.nextLine();
//				v = graphDist.getVertices().get(destV);
//				
//				System.out.println();
//					v.getPath().add(v);
//					System.out.println("Origin stop is : " + start.getId());
//					System.out.println("Destination stop is : "+v.getId());
//					
//					//printing path by using rule 1
//					if(inputCriteria.equals("1"))
//					{
//							System.out.println("Minimum distance is : "+ v.getMinDist() + " stops.");
//							System.out.print("Path -> ");
//							for(Vertex pathvert:v.getPath()) {
//								System.out.print(pathvert.getId()+" ");
//								Dijkstra.WalkOrRoad.add(pathvert);
//							}
//							System.out.println();
//							//printing edge type
//							for (int i = 0; i < Dijkstra.WalkOrRoad.size()-1; i++) 
//							{
//								Vertex temp = Dijkstra.WalkOrRoad.get(i);
//								Vertex temp2 = Dijkstra.WalkOrRoad.get(i+1);
//								System.out.print(graphDist.getEdges().get(temp.getId()+"-"+temp2.getId()).getEdgeType() + " ");
//								
//							}
//							//resetting arraylist
//							Dijkstra.WalkOrRoad = new ArrayList<Vertex>();
//							System.out.println();
//							
//							Dijkstra.walkThree=0;
//							
//							for(Vertex all : vertexes)
//							{
//								all.setMinDist(Double.MAX_VALUE);
//								all.setPath(new LinkedList<Vertex>());
//							}
//							System.out.println();
//					}
//					
//					//printing rule by rule 2
//					else
//					{
//						if(v.getMinDist()< Integer.MAX_VALUE)
//						{
//						System.out.println("Minimum distance is : "+ v.getMinDist() + " meters.");
//						System.out.print("Path -> ");
//						for(Vertex pathvert:v.getPath()) {
//							System.out.print(pathvert.getId()+" ");
//							Dijkstra.WalkOrRoad.add(pathvert);
//						}
//						System.out.println();
//						//Printing edge's type
//						for (int i = 0; i < Dijkstra.WalkOrRoad.size()-1; i++) 
//						{
//							Vertex temp = Dijkstra.WalkOrRoad.get(i);
//							Vertex temp2 = Dijkstra.WalkOrRoad.get(i+1);
//							System.out.print(graphDist.getEdges().get(temp.getId()+"-"+temp2.getId()).getEdgeType() + " ");
//							
//						}
//						//clearing arraylist for another search
//						Dijkstra.WalkOrRoad = new ArrayList<Vertex>();
//						
//						System.out.println();
//						Dijkstra.walkThree=0;
//						
//						for(Vertex all : vertexes)
//						{
//							all.setMinDist(Double.MAX_VALUE);
//							all.setPath(new LinkedList<Vertex>());
//						}
//						System.out.println();
//						}
//						
//						//if we cant go without walking in a row alert !
//						else
//						{
//							yok++;
//							System.out.println("You cant go there without walking in a row ! ");
//						}
//					}
//			}
////			//input checking
//			catch(Exception e)
//			{
//				System.out.println("****************************");
//				System.out.println("Please enter correct input !");
//				System.out.println("****************************");
//				System.out.println();
//			}
//		
//		}
		
	}
}

import java.util.ArrayList;

public class Line {
	private String lineID;
	private String lineName;
	private String vehicleType;
	private ArrayList<String> verticesVisited0;
	private ArrayList<String> verticesVisited1;
	public Line(String lineID, String lineName, String vehicleType) {
		this.lineID = lineID;
		this.lineName = lineName;
		this.vehicleType = vehicleType;
		verticesVisited0=new ArrayList();
		verticesVisited1=new ArrayList();
	}
	public String getLineID() {
		return lineID;
	}
	public void setLineID(String lineID) {
		this.lineID = lineID;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public ArrayList<String> getVerticesVisited0() {
		return verticesVisited0;
	}
	public void setVerticesVisited0(ArrayList<String> verticesVisited0) {
		this.verticesVisited0 = verticesVisited0;
	}
	public ArrayList<String> getVerticesVisited1() {
		return verticesVisited1;
	}
	public void setVerticesVisited1(ArrayList<String> verticesVisited1) {
		this.verticesVisited1 = verticesVisited1;
	}
	
	
	
}

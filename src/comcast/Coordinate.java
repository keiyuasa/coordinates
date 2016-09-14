package comcast;


public class Coordinate {
	public String id;
	public int x;
	public int y;
	private double dist;
	
	public Coordinate (String id, int x, int y) {
		this.id = id;
		this.x  = x;
		this.y  = y;
	}
	
	public void calcDist (int ox, int oy) {
		int dx=this.x-ox;
		int dy=this.y-oy;
		this.dist=Math.sqrt(dx*dx+dy*dy);
	}
	
	public double getDist() {
		return this.dist;
	}
}

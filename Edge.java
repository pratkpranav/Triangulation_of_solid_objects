
public class Edge implements EdgeInterface, Comparable<Edge>{

	
	Point x = new Point();
	Point y = new Point();
	
	int id;
	LinkedList<Edge> connectededges = new LinkedList<Edge>();
	LinkedList<Triangle> connectedtriangle = new LinkedList<Triangle>();
	RBTree<Edge,Edge> treeconnectededges = new RBTree<Edge,Edge>();
	
	Point outputa;
	Point outputb;
 	public Edge(Point a, Point b)
	{
 		outputa = a;
 		outputb = b;
		if(a.compareTo(b) >0)
		{
			x = a;
			y = b;
		}
		else
		{
			x=b;
			y=a;
		}
		//check for both ordering of vertices
	//	System.out.println(x.x + " " + x.y + " " + x.z +" " + y.x + " " + y.y + " " + y.z );
	}
	
	PointInterface[] pointsconstitutingedges = new PointInterface[2];
	
	public void assignedgeendpoints()
	{
		pointsconstitutingedges[0] = x;
		pointsconstitutingedges[1] = y;
		
	}
	
	
	@Override
	public PointInterface[] edgeEndPoints() {
		assignedgeendpoints();
		return pointsconstitutingedges;
	}


	@Override
	public int compareTo(Edge arg0) {
//		System.out.println(arg0.x.x + " " + arg0.x.y + " " + arg0.x.z + " " + arg0.y.x + " " + arg0.y.y+ " " + arg0.y.z);

		//System.out.println(this.x.x + " " + this.x.y + " " + this.x.z + " " + this.y.x + " " + this.y.y+ " " + this.y.z);
		if(this.x.compareTo(arg0.x) < 0)
		{
		//	System.out.println(1);
			return 1;
		}
		else if(this.x.compareTo(arg0.x) > 0)
		{
		//	System.out.println(-1);
			return -1;
		}
		if(this.y.compareTo(arg0.y) < 0)
		{
		//	System.out.println(1);
			return 1;
		}
		else if(this.y.compareTo(arg0.y) > 0)
		{
		//	System.out.println(1);
			return -1;
		}
		
	//	System.out.println(0);
		return 0;
	}
	
	public float mindiatance()
	{
		return x.mindistance(y);	
	}
	
	public String toString()
	{
		return  "[" + outputa.toString() + " " + outputb.toString() + "]"  ;
		//return "[(" + this.x.x + "," + this.x.y + "," + this.x.z + ")]"+ "[(" + this.y.x + "," + this.y.y + "," + this.y.z + ")]" ;
	}
}

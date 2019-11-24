
public class Point implements PointInterface, Comparable<Point>{

	
	
	float x,y,z;
	int id;
	float[] getXYZ = new float[3];
	RBTree<Point,Point> treeconnectedpoints = new RBTree<Point,Point>();
	RBTree<Edge,Edge> treeconnectededges = new RBTree<Edge,Edge>();
 	
	LinkedList<Point> connectedpoints = new LinkedList<Point>();
	LinkedList<Edge> connectededges = new LinkedList<Edge>();
	LinkedList<Triangle> connectedtriangle = new LinkedList<Triangle>();
	
	
	public void assignPoint(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void assign()
	{
		getXYZ[0] = x;
		getXYZ[1] = y;
		getXYZ[2] = z;
		
	}
	
	
	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public float getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public float[] getXYZcoordinate() {
		// TODO Auto-generated method stub
		this.assign();
		return getXYZ;
	}
	public float mindistance(Point p)
	{
		//System.out.println(this.toString() + " " + p.toString() + " " + result);
		float result= (this.x - p.x)*(this.x-p.x) + (this.y - p.y)*(this.y - p.y) + (this.z-p.z)*(this.z - p.z);

	//	System.out.println((this.x - p.x)*(this.x-p.x) + " " + (this.y - p.y)*(this.y - p.y)  +
			//	" " +  (this.z-p.z)*(this.z - p.z) + " " + result + " " + this.toString() + " " + p.toString());
		return result;
	}

	@Override
	public int compareTo(Point arg0) {
		if(this.x > arg0.x)
		{
			return 1;
		}
		else if(this.x < arg0.x)
		{
			return -1;
		}
		else if(this.y > arg0.y)
		{
			return 1;
		}
		else if(this.y < arg0.y)
		{
			return -1;
		}
		else if(this.z > arg0.z)
		{
			return 1;
		}
		else if(this.z < arg0.z)
		{
			return -1;
		}
			return 0;
		
	}

	public String toString()
	{
		return "(" + this.x + "," + this.y + "," + this.z + ")";
		//return "[(" + this.x + "," + this.y + "," + this.z + ")]";
	}

}

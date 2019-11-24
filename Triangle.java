
public class Triangle implements TriangleInterface,Comparable<Triangle>{

	

	
	Point P1,P2,P3,Output1,Output2,Output3;
	Edge E1,E2,E3;
	int id ;
	public Triangle(Point a, Point b, Point c)
	{
		Output1 = a;
		Output2 = b;
		Output3 = c;
		if(a.compareTo(b) > 0)
		{
			if(a.compareTo(c) > 0)
			{
				P1 = a;
				if(b.compareTo(c) > 0)
				{
					P2 = b;
					P3 = c;
				}
				else
				{
					P2 = c;
					P3 = b;
				}
			}
			else
			{
				P1 = c;
				if(a.compareTo(b) > 0)
				{
					P2 = a;
					P3 = b;
				}
				else
				{
					P2 = b;
					P3 = a;
				}
			}
		}
		else
		{
			if(b.compareTo(c) > 0)
			{
				P1  = b;
				if(a.compareTo(c) > 0)
				{
					P2 = a;
					P3 = c;
				}
				else
				{
					P2 = c;
					P3 = a;
				}
			}
			else
			{
				P1 = c;
				if(b.compareTo(a) > 0)
				{
					P2 = b;
					P3 = a;
				}
				else
				{
					P2 = a;
					P3 = b;
				}
			}
		}
	}
	public void addEdge(Edge E1, Edge E2, Edge E3)
	{
		this.E1 = E1;
		this.E2 = E2;
		this.E3 = E3;
	}
	
	PointInterface [] maketriangle = new PointInterface[3];
	
	
	public void set()
	{
		maketriangle[0] = P1;
		maketriangle[1] = P2;
		maketriangle[2] = P3;
	}
	@Override
	public PointInterface [] triangle_coord()
	{
		set();
		return maketriangle;
	}
	@Override
	public int compareTo(Triangle arg0) {
		if(this.P1.compareTo(arg0.P1) > 0)
		{
			return 1;
		}
		else if(this.P1.compareTo(arg0.P1) < 0)
		{
			return -1;
		}
		if(this.P2.compareTo(arg0.P2) > 0)
		{
			return 1;
		}
		else if(this.P2.compareTo(arg0.P2) < 0)
		{
			return -1;
		}
		if(this.P3.compareTo(arg0.P3) > 0)
		{
			return 1;
		}
		else if(this.P3.compareTo(arg0.P3) < 0)
		{
			return -1;
		}
		
		return 0;
	}
	
	public String toString()
	{
		return  "["  + P3.toString() + "," +  P2.toString() + "," + P1.toString() + "]";
		
	}
}

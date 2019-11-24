
public class Shape implements ShapeInterface
{
	int countuniquetriangle  = -1;
	int countuniquepoint = 0;
	int countuniqueedge = 0;
	
	LinkedList<Point> pointcollector = new LinkedList<Point>();
	LinkedList<Edge> edgecollector = new LinkedList<Edge>();
	LinkedList<Triangle> trianglecollector = new LinkedList<Triangle>();

	RBTree<Point, Point> rbpointcollector = new RBTree<Point,Point>();
	RBTree<Edge,Edge> rbedgecollector = new RBTree<Edge,Edge>();
	RBTree<Triangle,Triangle> rbtrianglecollector = new RBTree<Triangle,Triangle>();
	

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public  boolean ADD_TRIANGLE(float [] triangle_coord){
		
		float xac = (triangle_coord[0] - triangle_coord[6]);
		float yac = (triangle_coord[1] - triangle_coord[7]);
		float zac = (triangle_coord[2] - triangle_coord[8]);
		
		

		float xab = (triangle_coord[0] - triangle_coord[3]);
		float yab = (triangle_coord[1] - triangle_coord[4]);
		float zab = (triangle_coord[2] - triangle_coord[5]);
		
		
		
		float i = (yab*zac - yac*zab);
		float j = (xab*zac - xac*zab);
		float k = (xab*yac - xac*yab);
		
		if(i == 0 && j ==0 && k==0)
		{
		//	System.out.println(false);
			return false;
		}
		else
		{
			countuniquetriangle++;
			//System.out.println(true);
			Point P1 = new Point();
			Point P2 = new Point();
			Point P3 = new Point();
			P1.assignPoint(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
			P2.assignPoint(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
			P3.assignPoint(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
			if(rbpointcollector.search(P1)!=null)
			{
				//System.out.println(P1.toString());
				P1 = rbpointcollector.search(P1).value;
				
			}
			if(rbpointcollector.search(P2)!=null)
			{
				//System.out.println(P2.toString());
				P2 = rbpointcollector.search(P2).value;
				
			}
			if(rbpointcollector.search(P3)!=null)
			{
				//System.out.println(P2.toString());
				P3 = rbpointcollector.search(P3).value;
				
			}
			
			Edge E1 = new Edge(P1,P2);
			Edge E2 = new Edge(P2,P3);
			Edge E3 = new Edge(P3,P1);
			
			if(rbedgecollector.search(E1)!=null)
			{
				E1 = rbedgecollector.search(E1).value;
			}
			if(rbedgecollector.search(E2)!=null)
			{
				E2 = rbedgecollector.search(E2).value;
			}
			if(rbedgecollector.search(E3)!=null)
			{
				E3 = rbedgecollector.search(E3).value;
			}
			
			Triangle triangle = new Triangle(P1,P2,P3);
			triangle.addEdge(E1, E2, E3);
			triangle.id = countuniquetriangle;
			//System.out.println(triangle.toString());
			if(rbpointcollector.search(P1)==null)
			{
				rbpointcollector.insert(P1, P1);
				countuniquepoint++;
				P1.id = countuniquepoint;
				P1.treeconnectedpoints.insert(P2, P2);
				P1.treeconnectedpoints.insert(P3, P3);
				P1.treeconnectededges.insert(E1, E1);
				P1.treeconnectededges.insert(E3, E3);
				P1.connectededges.add(E1);
				P1.connectededges.add(E3);
				P1.connectedpoints.add(P2);
				P1.connectedpoints.add(P3);
				P1.connectedtriangle.add(triangle);
				
				
				
				
			}
			else
			{
				RedBlackNode<Point,Point> p = rbpointcollector.search(P1);
				Point originalP1  = P1;
				
					if(originalP1.treeconnectededges.search(E3)==null)
					{
						originalP1.treeconnectededges.insert(E3, E3);
						originalP1.connectededges.add(E3);
					}
					if(originalP1.treeconnectededges.search(E1)==null)
					{
						originalP1.treeconnectededges.insert(E1, E1);
						originalP1.connectededges.add(E1);
					}
					if(originalP1.treeconnectedpoints.search(P3)==null)
					{
						originalP1.treeconnectedpoints.insert(P3, P3);
						originalP1.connectedpoints.add(P3);
					}
					if(originalP1.treeconnectedpoints.search(P2)==null)
					{
						originalP1.treeconnectedpoints.insert(P2, P2);
						originalP1.connectedpoints.add(P2);
					}
					P1.connectedtriangle.add(triangle);
			}
			if(rbpointcollector.search(P2)==null)
			{
				countuniquepoint++;
				rbpointcollector.insert(P2, P2);	
				P2.id = countuniquepoint;
				P2.treeconnectedpoints.insert(P1, P1);
				P2.treeconnectedpoints.insert(P3, P3);
				P2.treeconnectededges.insert(E1, E1);
				P2.treeconnectededges.insert(E2, E2);
				P2.connectededges.add(E1);
				P2.connectededges.add(E2);
				P2.connectedpoints.add(P1);
				P2.connectedpoints.add(P3);
				P2.connectedtriangle.add(triangle);
			}
			else
			{
				RedBlackNode<Point,Point> p = rbpointcollector.search(P2);
				Point originalP2 = P2;
				
					if(originalP2.treeconnectededges.search(E1)==null)
					{
						originalP2.treeconnectededges.insert(E1, E1);
						originalP2.connectededges.add(E1);
					}
					if(originalP2.treeconnectededges.search(E2)==null)
					{
						originalP2.treeconnectededges.insert(E2, E2);
						originalP2.connectededges.add(E2);
					}
					if(originalP2.treeconnectedpoints.search(P1)==null)
					{
						originalP2.treeconnectedpoints.insert(P1, P1);
						originalP2.connectedpoints.add(P1);
					}
					if(originalP2.treeconnectedpoints.search(P3)==null)
					{
						originalP2.treeconnectedpoints.insert(P3, P3);
						originalP2.connectedpoints.add(P3);
					}
					P2.connectedtriangle.add(triangle);
			}
			if(rbpointcollector.search(P3)==null)
			{
				countuniquepoint++;
				rbpointcollector.insert(P3, P3);
				P3.id = countuniquepoint;
				P3.treeconnectedpoints.insert(P1, P1);
				P3.treeconnectedpoints.insert(P2, P2);
				P3.treeconnectededges.insert(E3, E3);
				P3.treeconnectededges.insert(E2, E2);
				P3.connectededges.add(E3);
				P3.connectededges.add(E2);
				P3.connectedpoints.add(P1);
				P3.connectedpoints.add(P2);
				P3.connectedtriangle.add(triangle);	
			}
			else
			{

				RedBlackNode<Point,Point> p = rbpointcollector.search(P3);
				Point originalP3 = P3;
				
					if(originalP3.treeconnectededges.search(E3)==null)
					{
						originalP3.treeconnectededges.insert(E3, E3);
						originalP3.connectededges.add(E3);
					}
					if(originalP3.treeconnectededges.search(E2)==null)
					{
						originalP3.treeconnectededges.insert(E2, E2);
						originalP3.connectededges.add(E2);
					}
					if(originalP3.treeconnectedpoints.search(P1)==null)
					{
						originalP3.treeconnectedpoints.insert(P1, P1);
						originalP3.connectedpoints.add(P1);
					}
					if(originalP3.treeconnectedpoints.search(P2)==null)
					{
						originalP3.treeconnectedpoints.insert(P2, P2);
						originalP3.connectedpoints.add(P2);
					}
					P3.connectedtriangle.add(triangle);
			}
			//System.out.println(P1.toString() + " " + P1.connectedtriangle.count()
			//+ " " + P2.toString() + " " + P2.connectedtriangle.count() + " " +P3.toString() 
			//+ " " + P3.connectedtriangle.count());
			//System.out.println(rbedgecollector.search(E1) + " " + E1 + " " + E1);
			if(rbedgecollector.search(E1)==null)
			{
				countuniqueedge++;
				E1.id = countuniqueedge;
				rbedgecollector.insert(E1, E1);
				E1.connectedtriangle.add(triangle);
				E1.treeconnectededges.insert(E2, E2);
				E1.treeconnectededges.insert(E3, E3);
				E1.connectededges.add(E2);
				E1.connectededges.add(E3);
				edgecollector.add(E1);
//				System.out.println(E1.x.x);
//				System.out.println(E1.x.y);
//				System.out.println(E1.x.z);
//				System.out.println(E1.y.x);
//				System.out.println(E1.y.y);
//				System.out.println(E1.y.z);
			}
			else
			{
				Edge OriginalE1 = rbedgecollector.search(E1).value; 
//				System.out.println(E1.x.x);
//				System.out.println(E1.x.y);
//				System.out.println(E1.x.z);
//				System.out.println(E1.y.x);
//				System.out.println(E1.y.y);
//				System.out.println(E1.y.z);
				if(OriginalE1.treeconnectededges.search(E2)==null)
				{
					OriginalE1.treeconnectededges.insert(E2, E2);
					OriginalE1.connectededges.add(E2);
					
				}
				if(OriginalE1.treeconnectededges.search(E3)==null)
				{
					OriginalE1.treeconnectededges.insert(E3, E3);
					OriginalE1.connectededges.add(E3);
					
				}
				OriginalE1.connectedtriangle.add(triangle);
//				LinkedListIterator<Triangle> itrm = OriginalE1.connectedtriangle.positions();
//				while(itrm.hasNext())
//				{
//					Triangle t = itrm.next().value();
//					System.out.println(t.id + " E1");
//				}
			}
		//	System.out.println(rbedgecollector.search(E2) + " " + E2 + " " + E2.x.x) ;
			if(rbedgecollector.search(E2)==null)
			{
				countuniqueedge++;
				E2.id = countuniqueedge;
				rbedgecollector.insert(E2, E2);
				E2.connectedtriangle.add(triangle);
				E2.treeconnectededges.insert(E1, E1);
				E2.treeconnectededges.insert(E3, E3);
				E2.connectededges.add(E1);
				E2.connectededges.add(E3);
				edgecollector.add(E2);
//				System.out.println(E2.x.x);
//				System.out.println(E2.x.y);
//				System.out.println(E2.x.z);
//				System.out.println(E2.y.x);
//				System.out.println(E2.y.y);
//				System.out.println(E2.y.z);
			}
			else
			{
				Edge OriginalE2 = rbedgecollector.search(E2).value;
//				System.out.println(E2.x.x);
//				System.out.println(E2.x.y);
//				System.out.println(E2.x.z);
//				System.out.println(E2.y.x);
//				System.out.println(E2.y.y);
//				System.out.println(E2.y.z);
				if(OriginalE2.treeconnectededges.search(E3)==null)
				{
					OriginalE2.treeconnectededges.insert(E3, E3);
					OriginalE2.connectededges.add(E3);
					
				}
				if(OriginalE2.treeconnectededges.search(E1)==null)
				{
					OriginalE2.treeconnectededges.insert(E1, E1);
					OriginalE2.connectededges.add(E1);
					
				}
				OriginalE2.connectedtriangle.add(triangle);
//				LinkedListIterator<Triangle> itrm1 = OriginalE2.connectedtriangle.positions();
//				while(itrm1.hasNext())
//				{
//					Triangle t = itrm1.next().value();
//					System.out.println(t.id + " E2");
//					
//				}

			}
			//System.out.println(rbedgecollector.search(E3) + " " + E3 + " " + E3.x.x);
			if(rbedgecollector.search(E3)==null)
			{
				countuniqueedge++;
				E3.id = countuniqueedge;
				rbedgecollector.insert(E3, E3);
				E3.connectedtriangle.add(triangle);
				E3.treeconnectededges.insert(E2, E2);
				E3.treeconnectededges.insert(E1, E1);
				E3.connectededges.add(E2);
				E3.connectededges.add(E1);
				edgecollector.add(E3);
//				System.out.println(E3.x.x);
//				System.out.println(E3.x.y);
//				System.out.println(E3.x.z);
//				System.out.println(E3.y.x);
//				System.out.println(E3.y.y);
//				System.out.println(E3.y.z);
			}
			else
			{
				Edge OriginalE3 = rbedgecollector.search(E3).value;
//				System.out.println(E3.x.x);
//				System.out.println(E3.x.y);
//				System.out.println(E3.x.z);
//				System.out.println(E3.y.x);
//				System.out.println(E3.y.y);
//				System.out.println(E3.y.z);
				if(OriginalE3.treeconnectededges.search(E2)==null)
				{
					OriginalE3.treeconnectededges.insert(E2, E2);
					OriginalE3.connectededges.add(E2);
					
				}
				if(E3.treeconnectededges.search(E1)==null)
				{
					OriginalE3.treeconnectededges.insert(E1, E1);
					OriginalE3.connectededges.add(E1);
					
				}
				OriginalE3.connectedtriangle.add(triangle);
			//	LinkedListIterator<Triangle> itrm2 = OriginalE3.connectedtriangle.positions();
				//while(itrm2.hasNext())
				//{
				//	Triangle t = itrm2.next().value();
				//	System.out.println(t.id + "  E3"  );
				//}
			}
			rbtrianglecollector.insert(triangle, triangle);
		
			trianglecollector.add(triangle);

			//System.out.println(true);
			return true;
		}
		
		}

	public void dfs(RBTree<Triangle,Triangle> rbcomponent,
			LinkedList<Triangle> linkedcomponent,
			Triangle t, Boolean [] used)
	{
		//System.out.println(t.id);
		used[t.id] = true; 
		
		//System.out.println(t.id);
		rbcomponent.insert(t, t);
		//System.out.println(t.toString());
		linkedcomponent.add(t);
		//System.out.println(t.id + " 1");
		LinkedListIterator<Triangle> itr1 = t.E1.connectedtriangle.positions();
		LinkedListIterator<Triangle> itr2 = t.E2.connectedtriangle.positions();
		LinkedListIterator<Triangle> itr3 = t.E3.connectedtriangle.positions();
		//
		//System.out.println(1234);
		
		while(itr1.hasNext())
		{
			Triangle t1 = itr1.next().value();
			//System.out.println(t.id + " " + t1.id);
			if(!used[t1.id])
			{
				dfs(rbcomponent,linkedcomponent,t1,used);
			}
		}
		while(itr2.hasNext())
		{
			Triangle t2 = itr2.next().value();
			//System.out.println(t.id + " " + t2.id);
			if(!used[t2.id])
			{
				dfs(rbcomponent,linkedcomponent,t2,used);
			}
		}
		while(itr3.hasNext())
		{
			Triangle t3 = itr3.next().value();
		//	System.out.println(t.id + " " + t3.id);
			if(!used[t3.id])
			{
				dfs(rbcomponent,linkedcomponent,t3,used);
			}
		}
		
		
	}
	//
	public int TYPE_MESH(){
		
		LinkedListIterator<Edge> itr = edgecollector.positions();
		Boolean b1 = false,b2 = false;
		while(itr.hasNext())
		{
			Edge e = itr.next().value();
			if(e.connectedtriangle.count()==1)
			{
				b1 = true;
			}
			if(e.connectedtriangle.count() > 2)
			{
				b2 = true;
			}
			
		}
		if(b2)
		{
			//System.out.println("Mess Type: " + 3);
			return 3;
		}
		else if(b1)
		{
			//System.out.println("Mess Type: " + 2);
			return 2;
		}
		else
		{
			//System.out.println("Mess Type: " + 1);
			return 1;
		}
		}

	 void merge(Edge arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        Edge L[] = new Edge [n1]; 
        Edge R[] = new Edge [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i].mindiatance() <= R[j].mindiatance()) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
	
	 void sort(Edge arr[], int l, int r) 
	    { 
	        if (l < r) 
	        {  
	            int m = (l+r)/2; 
	  
	            sort(arr, l, m); 
	            sort(arr , m+1, r); 
	  
	            merge(arr, l, m, r); 
	        } 
	    }
		
	
	public EdgeInterface [] BOUNDARY_EDGES(){
		
		LinkedListIterator<Edge> itr = edgecollector.positions();
		
		int count = 0;
		while(itr.hasNext())
		{
			Edge e = itr.next().value();
			
			if(e.connectedtriangle.count()==1)
			{
				count++;
			}
		}
	//	System.out.println(edgecollector.count());
		LinkedListIterator<Edge> itr1 = edgecollector.positions();
		//System.out.println(count);
		Edge[] answer_boundary_edges = new Edge[count];
		while(itr1.hasNext())
		{
			Edge e = itr1.next().value();
		//	System.out.println(e.toString() + " " + e.connectedtriangle.count());
			if(e.connectedtriangle.count()==1)
			{
				count--;
				answer_boundary_edges[count] = e;
			}
		}
	//	System.out.println("Return:");
		//System.out.println(answer_boundary_edges.length);
		//System.out.println(count);
		//if(count== 0)
		//{
		//}
		//else
		//{
			sort(answer_boundary_edges,0,answer_boundary_edges.length - 1);
			
			EdgeInterface[] answer = new EdgeInterface[answer_boundary_edges.length];
			
			for(int i=0; i< answer_boundary_edges.length ; i++)
			{
				answer[i] = answer_boundary_edges[i] ;
			}
			
//			for(int i=0; i<answer.length ; i++)
//			{
//				//System.out.println(1);
////				if(i==answer.length - 1)
////				{
////					System.out.println(answer_boundary_edges[i].toString());
////					
////				}
////			else
////			{
////				System.out.print(answer_boundary_edges[i].toString()  + " " );
////			}
//			
//			}
			if(answer.length == 0)
			{
				return null;
			}
			return answer;
	//	}
		
	}
	
	//
	public int COUNT_CONNECTED_COMPONENTS(){
		
Boolean [] used = new Boolean[countuniquetriangle+1];
		
		for(int i=0; i<countuniquetriangle+1 ; i++)
		{
			used[i] = false;
		}
		LinkedListIterator<Triangle> itr = trianglecollector.positions();
		LinkedList<RBTree<Triangle,Triangle>> rbtreecomponentcollector = new 
				LinkedList<RBTree<Triangle,Triangle>>();
		LinkedList<LinkedList<Triangle>> linkedcomponentcollector = new
				LinkedList<LinkedList<Triangle>>();
		while(itr.hasNext())
		{
			Triangle t = itr.next().value;
			if(!used[t.id])
			{
				RBTree<Triangle,Triangle> rbcomponent = new RBTree<Triangle,Triangle>();
				LinkedList<Triangle> linkedcomponent = new LinkedList<Triangle>();
			//	System.out.println(111);
				dfs(rbcomponent,linkedcomponent,t, used);
				//System.out.println(111);
				rbtreecomponentcollector.add(rbcomponent);
				linkedcomponentcollector.add(linkedcomponent);
			}
			
			
		}
		LinkedListIterator<LinkedList<Triangle>> itra = linkedcomponentcollector.positions();
		int countconnectedcomponent = 0;
		while(itra.hasNext())
		{
			LinkedList<Triangle> temp = itra.next().value();
			
				countconnectedcomponent++;
			
		}
		
//		
////System.out.println("Return:");
////System.out.println("No of Connected Component:" + countconnectedcomponent);
//System.out.println(countconnectedcomponent);
		
		
		return countconnectedcomponent;}


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public TriangleInterface [] NEIGHBORS_OF_TRIANGLE(float [] triangle_coord){
		//[[(-1,0 ,0), (0 ,-1, 0), (0, 1, 0)], [(-1, 0 ,0),( 0 ,0, 3), (0, 1, 0)] ,
		 //[[(1,0 ,0) ,(0 ,-1, 0), (0 ,0 ,3)]]
		Point P1 = new Point();
		Point P2 = new Point();
		Point P3 = new Point();
		
		P1.assignPoint(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		P2.assignPoint(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
		P3.assignPoint(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		Triangle triangle = new Triangle(P1,P2,P3);
		RedBlackNode<Triangle,Triangle> rbnode = rbtrianglecollector.search(triangle);
		if(rbnode==null)
		{
		//	System.out.println("NO SUCH TRIANGLE EXISTS");
			return null;
		}
		else
		{// found repetition in outputs for single output
			Triangle OriginalTriangle = rbnode.value;
			TriangleInterface[] answer_neighbour_of_triangle = new TriangleInterface[OriginalTriangle.E1.connectedtriangle.count() +
			        OriginalTriangle.E2.connectedtriangle.count() 	+ OriginalTriangle.E3.connectedtriangle.count() - 1];
			int a = OriginalTriangle.E1.connectedtriangle.count() , b = OriginalTriangle.E2.connectedtriangle.count() ,
				c =	OriginalTriangle.E3.connectedtriangle.count();
			LinkedListIterator<Triangle> itra = OriginalTriangle.E1.connectedtriangle.positions();
			LinkedListIterator<Triangle> itrb = OriginalTriangle.E2.connectedtriangle.positions();
			LinkedListIterator<Triangle> itrc = OriginalTriangle.E3.connectedtriangle.positions();
 			
			Triangle s1 = itra.next().value();
			Triangle s2 = itrb.next().value();
			Triangle s3 = itrc.next().value();
			
			LinkedList<Triangle> midone = new LinkedList<Triangle>();
			while(a > 0 && b > 0)
			{
				if(s1.id > s2.id)
				{
					//System.out.print(s1.toString() + " ");
					
					if(s1.compareTo(OriginalTriangle)!=0)
					{	
						midone.add(s1);
					}
					if(itra.hasNext())
					{
						s1 = itra.next().value();
					}
					a--;
				}
				else if(s1.id < s2.id)
				{
				//	System.out.print(s2.toString() + " ");
					if(s2.compareTo(OriginalTriangle)!=0)
					{	
						midone.add(s2);
					}
					if(itrb.hasNext())
					{
						s2 = itrb.next().value();
					}
					b--;
				}
				else
				{
					if(itrb.hasNext())
					{
					s2 = itrb.next().value();
					}
					b--;
				}

			}
			while(a > 0)
			{
				if(s1.compareTo(OriginalTriangle)!=0)
				{
					midone.add(s1);
				}
				if(itra.hasNext())
				{
					s1 =itra.next().value();
				}
				a--;
			}
			while(b > 0)
			{
				if(s2.compareTo(OriginalTriangle)!=0)
				{
					midone.add(s2);
				}
				if(itrb.hasNext())
				{
					s2 = itrb.next().value();
				}
				b--;
			}
			int d = midone.count();
			LinkedList<Triangle> midtwo = new LinkedList<Triangle>();
			LinkedListIterator<Triangle> opposite = midone.positions();
			while(opposite.hasNext())
			{
				midtwo.add(opposite.next().value());
			}
			LinkedListIterator<Triangle> itrd = midtwo.positions();
			LinkedList<Triangle> find_reverse_answer = new LinkedList<Triangle>();
			Triangle s4 = itrd.next().value();
			while(d > 0 && c > 0)
			{
				if(s4.id > s3.id)
				{
					//System.out.print(s4.toString() + " ");
					if(s4.compareTo(OriginalTriangle)!=0)
					{	
						find_reverse_answer.add(s4);
					}
					if(itrd.hasNext())
					{
						s4 = itrd.next().value();
					}
					d--;
				}
				else if(s4.id < s3.id)
				{
					//System.out.print(s3.toString() + " ");
					if(s3.compareTo(OriginalTriangle)!=0)
					{
						find_reverse_answer.add(s3);
					}
					if(itrc.hasNext())
					{
						s3 = itrc.next().value();
					}
					c--;
				}
				else
				{
					if(itrc.hasNext())
					{
						s3 = itrc.next().value();
					}
					c--;
				}
			}
			while(c > 0)
			{
				if(s3.compareTo(OriginalTriangle)!=0)
				{
					find_reverse_answer.add(s3);
				}
				if(itrc.hasNext())
				{
					s3 = itrc.next().value();
				}
				c--;
			}
			while(d > 0)
			{
				if(s4.compareTo(OriginalTriangle)!=0)
				{
					find_reverse_answer.add(s4);
				}
				if(itrd.hasNext())
				{
					s4 = itrd.next().value();
				}
				d--;
			}
			TriangleInterface [] find_answer = new TriangleInterface[find_reverse_answer.count()];
			//Triangle_Interface [] 
			LinkedListIterator<Triangle> itrfinal = find_reverse_answer.positions();
			int size = 0;
			while(itrfinal.hasNext())
			{
				
				Triangle checkoriginal = itrfinal.next().value();
				if(checkoriginal.compareTo(OriginalTriangle)!=0)
				{	
					find_answer[size] = checkoriginal;
				}
				size++;
			}

			TriangleInterface [] find_answer_original = new TriangleInterface[size];
			for(int i=0; i<size ; i++)
			{
				find_answer_original[i] = find_answer[i];
			}
			
			
			//System.out.println("Return:");
			//System.out.println(find_answer.length);
//			for(int i=0; i<find_answer_original.length ; i++)
//			{
//				if(i == find_answer_original.length - 1)
//				{
//					//System.out.print(find_answer[i].toString() + " " + triangle.toString());
//					System.out.print(find_answer_original[i].toString() );
//				}
//				else
//				{
//					System.out.print(find_answer_original[i].toString() + " ");
//					
//				}
//			}
//			System.out.println();
		
			return find_answer_original;
		}
		
		}


	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public EdgeInterface [] EDGE_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		
		Point P1 = new Point();
		Point P2 = new Point();
		Point P3 = new Point();
		
		P1.assignPoint(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		P2.assignPoint(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
		P3.assignPoint(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		Triangle triangle = new Triangle(P1,P2,P3);
		RedBlackNode<Triangle,Triangle> rbnode = rbtrianglecollector.search(triangle);
		if(rbnode==null)
		{
			//System.out.println("NO SUCH TRIANGLE EXISTS");
			return null;
		}
		else
		{
			Triangle t = rbnode.value;

			EdgeInterface[ ] answer_edge_query = new EdgeInterface[3];
			answer_edge_query[0] = t.E1;
			answer_edge_query[1] = t.E2;
			answer_edge_query[2] = t.E3;
			
		//	System.out.println("Return:");
			

		//	System.out.print(answer_edge_query[1].toString() + " ");
		//	System.out.print(answer_edge_query[0].toString() + " ");
		//	System.out.print(answer_edge_query[2].toString());
//			for(int i=0; i<3; i++)
//			{
//				if(i==1)
//				{
//				System.out.print(answer_edge_query[i].toString() + " ");
//				}
//				else if(i==2)
//				{
//					System.out.print(answer_edge_query[i].toString() );
//					
//				}
//				else if(i==0)
//				{
//					System.out.print(answer_edge_query[i].toString() + " ");
//				}
//			}
			//System.out.println();
			return answer_edge_query;
			//[[(-1, 0, 0),( 0, -1, 0)],[(-1, 0, 0),( 0, 0, 3),[(0, 0, 3),( 0, -1, 0)]]
		}
		
		
	}

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	// [(-1 0 0), (0 -1 0), (0, 0, 3)]


	public PointInterface [] VERTEX_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		
		Point P1 = new Point();
		Point P2 = new Point();
		Point P3 = new Point();
		
		P1.assignPoint(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		P2.assignPoint(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
		P3.assignPoint(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		Triangle triangle = new Triangle(P1,P2,P3);
		RedBlackNode<Triangle,Triangle> rbnode = rbtrianglecollector.search(triangle);
		if(rbnode==null)
		{
			//System.out.println("NO SUCH TRIANGLE EXISTS");
			return null;
		}
		else
		{
			Triangle t = rbnode.value;

			PointInterface[ ] answer_point_query = new PointInterface[3];
			answer_point_query[0] = t.P1;
			answer_point_query[1] = t.P2;
			answer_point_query[2] = t.P3;
			
		//	System.out.println("Return:");
//			for(int i=0; i<answer_point_query.length ; i++)
//			{
//				if(i==answer_point_query.length - 1)
//				{
//					System.out.println(answer_point_query[i].toString());
//				}
//				else
//				{	
//					System.out.print(answer_point_query[i].toString() + " ");
//				}
//			}
			
			
			return answer_point_query;
			
		}
		
		
		}
	//[(-1 0 0), (0 -1 0), (0, 0, 3)]

	//INPUT [x1,y1,z1,x2,y2,z2,x3,y3,z3]
	public TriangleInterface [] EXTENDED_NEIGHBOR_TRIANGLE(float [] triangle_coord){
		
		Point P1 = new Point();
		Point P2 = new Point();
		Point P3 = new Point();
		P1.assignPoint(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
		P2.assignPoint(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
		P3.assignPoint(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
		
		
		Triangle t = new Triangle(P1,P2,P3);
		
		RedBlackNode<Triangle,Triangle> triangle = rbtrianglecollector.search(t);
		if(triangle==null)
		{
			return null;
			
		}
		else
		{
		
		
		Triangle OriginalTriangle = triangle.value;
		
		TriangleInterface[] answer_neighbour_of_triangle = new TriangleInterface[OriginalTriangle.P1.connectedtriangle.count() +
		        OriginalTriangle.P2.connectedtriangle.count() 	+ OriginalTriangle.P3.connectedtriangle.count() - 1];
		int a = OriginalTriangle.P1.connectedtriangle.count() , b = OriginalTriangle.P2.connectedtriangle.count() ,
			c =	OriginalTriangle.P3.connectedtriangle.count();
		LinkedListIterator<Triangle> itra = OriginalTriangle.P1.connectedtriangle.positions();
		LinkedListIterator<Triangle> itrb = OriginalTriangle.P2.connectedtriangle.positions();
		LinkedListIterator<Triangle> itrc = OriginalTriangle.P3.connectedtriangle.positions();
			
		Triangle s1 = itra.next().value();
		Triangle s2 = itrb.next().value();
		Triangle s3 = itrc.next().value();
		
		LinkedList<Triangle> midone = new LinkedList<Triangle>();
		while(a > 0 && b > 0)
		{
			//System.out.println(1);
			if(s1.id > s2.id)
			{
				//System.out.print(s1.toString() + " ");
				
				if(s1.compareTo(OriginalTriangle)!=0)
				{	
					midone.add(s1);
				}
				if(itra.hasNext())
				{
					s1 = itra.next().value();
				}
				a--;
			}
			else if(s1.id < s2.id)
			{
			//	System.out.print(s2.toString() + " ");
				if(s2.compareTo(OriginalTriangle)!=0)
				{	
					midone.add(s2);
				}
				if(itrb.hasNext())
				{
					s2 = itrb.next().value();
				}
				b--;
			}
			else
			{
				if(itrb.hasNext())
				{
				s2 = itrb.next().value();
				}
				b--;
			}

		}
		while(a > 0)
		{
			//System.out.print(s1.toString() + " ");
			if(s1.compareTo(OriginalTriangle)!=0)
			{	
				midone.add(s1);
			}
			if(itra.hasNext())
			{
				s1 =itra.next().value();
			}
			a--;
		}
		while(b > 0)
		{
			//System.out.print(s2.toString() + " ");
			if(s2.compareTo(OriginalTriangle)!=0)
			{
				midone.add(s2);
			}
			if(itrb.hasNext())
			{
				s2 = itrb.next().value();
			}
			b--;
		}
		int d = midone.count();
		LinkedList<Triangle> midtwo = new LinkedList<Triangle>();
		LinkedListIterator<Triangle> opposite = midone.positions();
		while(opposite.hasNext())
		{
			midtwo.add(opposite.next().value());
		}
		LinkedListIterator<Triangle> itrd = midtwo.positions();
		LinkedList<Triangle> find_reverse_answer = new LinkedList<Triangle>();
		Triangle s4 = itrd.next().value();
		while(d > 0 && c > 0)
		{
			if(s4.id > s3.id)
			{
				//System.out.print(s4.toString() + " ");
				if(s4.compareTo(OriginalTriangle)!=0)
				{	
					find_reverse_answer.add(s4);
				}
				if(itrd.hasNext())
				{
					s4 = itrd.next().value();
				}
				d--;
			}
			else if(s4.id < s3.id)
			{
				//System.out.print(s3.toString() + " ");
				if(s3.compareTo(OriginalTriangle)!=0)
				{
					find_reverse_answer.add(s3);
				}
				if(itrc.hasNext())
				{
					s3 = itrc.next().value();
				}
				c--;
			}
			else
			{
				if(itrc.hasNext())
				{
					s3 = itrc.next().value();
				}
				c--;
			}
		}
		while(c > 0)
		{//[ [(-1, 0, 0), (0 ,-1, 0), (0, 1, 0)],
		   //[(-1, 0, 0), (0, 0, 3), (0, 1 ,0)],[(1, 0, 0),( 0, -1, 0),( 0, 1, 0)]
			//	,[(1, 0, 0).( 0 -1 0),( 0, 0, 3)],[(1, 0, 0),( 0 1 0),( 0 ,0 ,3)]
			//System.out.print(s3.toString() + " ");
			if(s3.compareTo(OriginalTriangle)!=0)
			{
				find_reverse_answer.add(s3);
			}
			if(itrc.hasNext())
			{
				s3 = itrc.next().value();
			}
			c--;
		}
		while(d > 0)
		{
			//System.out.print(s4.toString() + " ");
			if(s4.compareTo(OriginalTriangle)!=0)
			{	
				find_reverse_answer.add(s4);
			}
			if(itrd.hasNext())
			{
				s4 = itrd.next().value();
			}
			d--;
		}
		TriangleInterface [] find_answer = new TriangleInterface[find_reverse_answer.count()];
		LinkedListIterator<Triangle> itrfinal = find_reverse_answer.positions();
		int size = 0;
		while(itrfinal.hasNext())
		{
			find_answer[size] = itrfinal.next().value();
			size++;
		}
		
		//System.out.print( "      Return:    ");
//		for(int i=0; i<find_answer.length ; i++)
//		{
//			if(i==find_answer.length - 1)
//			{
//				System.out.println(find_answer[i] );
//			}
//			else
//			{
//				System.out.print(find_answer[i].toString() + " ");
//			}
//		}
		
		if(find_answer.length == 0)
		{
			return null;
		}
		return find_answer;
		
		}
		
		}
	//[ [(-1, 0, 0), (0 ,-1, 0), (0, 1, 0)],[(-1, 0, 0), (0, 0, 3), (0, 1 ,0)],[(1, 0, 0),( 0, -1, 0),( 0, 1, 0)],
	  //[(1, 0, 0).( 0 -1 0),( 0, 0, 3)],[(1, 0, 0),( 0 1 0),( 0 ,0 ,3)]
	
	//INPUT [x,y,z]
	public TriangleInterface [] INCIDENT_TRIANGLES(float [] point_coordinates){
		//[[(1 ,0, 0), (0 ,-1 ,0),( 0 ,1, 0)],[(1, 0 ,0),( 0 ,-1, 0),( 0 ,0 ,3)],
		// [(1 0 0),( 0 1 0),( 0, 0, 3)]]
		Point findincidenttriangle = new Point();
		findincidenttriangle.assignPoint(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		RedBlackNode<Point,Point> findpoint = rbpointcollector.search(findincidenttriangle);
		if(findpoint==null)
		{
			System.out.println("NO SUCH POINT EXISTS");
			return null;
		}
		else
		{
			Point answerpoint = findpoint.value;
			TriangleInterface [] answer_incident_triangle  = new TriangleInterface[answerpoint.connectedtriangle.count()];
			LinkedListIterator<Triangle> itr = answerpoint.connectedtriangle.positions();
			
			int i = answerpoint.connectedtriangle.count()-1;//check for indexing could lead to NULL POINTER EXCEPTION
			//System.out.println(answerpoint.connectedtriangle.count());
			while(itr.hasNext())
			{
			
				answer_incident_triangle[i] = itr.next().value; 
				i--;
			}
			
			
			//System.out.println("Return:");
//			for(int p=0; p<answer_incident_triangle.length ; p++)
//			{
//				if(p==answer_incident_triangle.length - 1)
//				{
//					System.out.println(answer_incident_triangle[p].toString());
//				}
//				else
//				{
//					System.out.print(answer_incident_triangle[p].toString() + " ");
//					
//				}
//			}
			return answer_incident_triangle;
			
		}
		}


	// INPUT [x,y,z]
	public PointInterface [] NEIGHBORS_OF_POINT(float [] point_coordinates){
	//System.out.println(1234);
		Point findincidenttriangle = new Point();
		findincidenttriangle.assignPoint(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		RedBlackNode<Point,Point> findpoint = rbpointcollector.search(findincidenttriangle);
		if(findpoint==null)
		{
			//System.out.println(1234);
			//System.out.println("NO SUCH POINT EXISTS");
			return null;
		}
		else
		{
			Point answerpoint = findpoint.value;
			//System.out.println(1234);
			PointInterface [] answer_neighbour_of_point  = new PointInterface[answerpoint.connectedpoints.count()];
			LinkedListIterator<Point> itr = answerpoint.connectedpoints.positions();
			
			//System.out.println(answerpoint.connectedpoints.count());
			int i = answerpoint.connectedpoints.count()-1;//check for indexing could lead to NULL POINTER EXCEPTION
			//System.out.println(i);
			while(itr.hasNext())
			{
				//System.out.println(i);
				answer_neighbour_of_point[i] = itr.next().value; 
				//System.out.println(answer_neighbour_of_point[i]);
				i--;
			}
			
			//System.out.println("Return:");
//			for(int p=0; p<answer_neighbour_of_point.length ; p++)
//			{
//				if(p==answer_neighbour_of_point.length -1)
//				{
//				System.out.println(answer_neighbour_of_point[p].toString());
//				}
//				else
//				{
//					System.out.print(answer_neighbour_of_point[p].toString() + " ");
//					
//				}
//				
//			}
			return answer_neighbour_of_point;
			
		}
		
		
		}


	// INPUT[x,y,z]
	public EdgeInterface [] EDGE_NEIGHBORS_OF_POINT(float [] point_coordinates){
		
		Point findpoint = new Point();
		findpoint.assignPoint(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		RedBlackNode<Point,Point> findedge = rbpointcollector.search(findpoint);
		if(findedge==null)
		{
			//System.out.println("NO SUCH POINT EXISTS");
			return null;
		}
		else
		{
			Point answeredge = findedge.value;
			EdgeInterface [] answer_neighbour_of_point = new EdgeInterface[answeredge.connectededges.count()];
			LinkedListIterator<Edge> itr = answeredge.connectededges.positions();
			
			int i = answeredge.connectededges.count() -1;
			//System.out.println(i);
			while(itr.hasNext())
			{
				answer_neighbour_of_point[i] = itr.next().value();
				i--;
			}
			
			
		//	System.out.println("Return:");
//			for(int p=0; p<answer_neighbour_of_point.length ; p++)
//			{
//				if(p== answer_neighbour_of_point.length -1)
//				{
//					System.out.println(answer_neighbour_of_point[p].toString());
//				}
//				else
//				{
//					System.out.print(answer_neighbour_of_point[p].toString() + " ");
//					
//				}
//			}
			return answer_neighbour_of_point;
			
			
		}
		}


	// INPUT[x,y,z]
	public TriangleInterface [] FACE_NEIGHBORS_OF_POINT(float [] point_coordinates){
		
		Point P = new Point();
		P.assignPoint(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		RedBlackNode<Point,Point> result = rbpointcollector.search(P);
		if(result==null)
		{
			//System.out.println("NO SUCH POINT EXISTS");
			return null;
		}
		else
		{
		Point OriginalP = result.value;
		TriangleInterface[] answer_triangle = new TriangleInterface[OriginalP.connectedtriangle.count()];
		LinkedListIterator<Triangle> itr = OriginalP.connectedtriangle.positions();
		int size = OriginalP.connectedtriangle.count() - 1;
		while(itr.hasNext())
		{
			answer_triangle[size] = itr.next().value();
			size--;
		}
		
		//System.out.println("Return:");
//		for(int i=0; i<answer_triangle.length ; i++)
//		{
//			if(i== answer_triangle.length - 1)
//			{
//				System.out.println(answer_triangle[i].toString());
//			}
//			else
//			{
//				System.out.print(answer_triangle[i].toString() + " ");
//				
//			}
//		}
		return answer_triangle;
		}
		}



	// INPUT // [xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 , xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3]   where xa1,ya1,za1,xa2,ya2,za2,xa3,ya3,za3 are 3 coordinates of first triangle and xb1,yb1,zb1,xb2,yb2,zb2,xb3,yb3,zb3 are coordinates of second triangle as given in specificaition.

	public boolean IS_CONNECTED(float [] triangle_coord_1, float [] triangle_coord_2){
		//System.out.println(12);
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		p1.assignPoint(triangle_coord_1[0], triangle_coord_1[1], triangle_coord_1[2]);
		p2.assignPoint(triangle_coord_1[3], triangle_coord_1[4], triangle_coord_1[5]);
		p3.assignPoint(triangle_coord_1[6], triangle_coord_1[7], triangle_coord_1[8]);
		Triangle t1 = new Triangle(p1,p2,p3);
		
		Point q1 = new Point();
		Point q2 = new Point();
		Point q3 = new Point();
		q1.assignPoint(triangle_coord_2[0], triangle_coord_2[1], triangle_coord_2[2]);
		q2.assignPoint(triangle_coord_2[3], triangle_coord_2[4], triangle_coord_2[5]);
		q3.assignPoint(triangle_coord_2[6], triangle_coord_2[7], triangle_coord_2[8]);
		Triangle t2 = new Triangle(q1,q2,q3);
		//System.out.println(t2.toString());
		RedBlackNode<Triangle,Triangle> rbnode1 = rbtrianglecollector.search(t1);
		RedBlackNode<Triangle,Triangle> rbnode2 = rbtrianglecollector.search(t2);
		
		if(rbnode1==null)
		{
			//System.out.println("NO SUCH POINT EXIST");
			
			return false;
		}
		else
		{
			Triangle firstone = rbnode1.value;

Boolean [] used = new Boolean[countuniquetriangle+1];
		
		for(int i=0; i<countuniquetriangle+1 ; i++)
		{
			used[i] = false;
		}
		used[t1.id] = true; 
		//System.out.println(123);
				RBTree<Triangle,Triangle> rbcomponent = new RBTree<Triangle,Triangle>();
				LinkedList<Triangle> linkedcomponent = new LinkedList<Triangle>();
			//System.out.println(111);
				dfs(rbcomponent,linkedcomponent,firstone, used);
			//	System.out.println(111);
		LinkedListIterator<Triangle> iter = linkedcomponent.positions();
		
		while(iter.hasNext())
		{
			Triangle temp = iter.next().value();
			//System.out.println(123);
			//System.out.println(temp.toString() + " " + t2.toString());
			if(temp.compareTo(t2)==0)
			{
			//System.out.println(12);
			//	System.out.println("Return:");
				//System.out.println(true);
				return true;
			}
		}
			
			
			
		
			
		}

		//System.out.println("Return:");
		//System.out.println(false);
	return false;
	
	}


	// INPUT [x1,y1,z1,x2,y2,z2] // where (x1,y1,z1) refers to first end point of edge and  (x2,y2,z2) refers to the second.
	public TriangleInterface [] TRIANGLE_NEIGHBOR_OF_EDGE(float [] edge_coordinates){
		Point P1 = new Point();
		Point P2 = new Point();
		
		P1.assignPoint(edge_coordinates[0], edge_coordinates[1], edge_coordinates[2]);
		P2.assignPoint(edge_coordinates[3], edge_coordinates[4], edge_coordinates[5]);
		
		Edge E = new Edge(P1, P2);
		RedBlackNode<Edge,Edge> rbnode = rbedgecollector.search(E);
		if(rbnode == null)
		{
		//	System.out.println("NO SUCH EDGE EXISTS");
			return null;
		}
		else
		{
		Edge OriginalEdge = rbnode.value;
		TriangleInterface[] answer_triangle = new TriangleInterface[OriginalEdge.connectedtriangle.count()];
		LinkedListIterator<Triangle> itr = OriginalEdge.connectedtriangle.positions();
		int size = OriginalEdge.connectedtriangle.count()-1;
		
		while(itr.hasNext())
		{
			answer_triangle[size] = itr.next().value();
			size--;
		}
		
		//System.out.println("Return: ");
//		for(int i=0; i<answer_triangle.length ; i++)
//		{
//			if(i== answer_triangle.length - 1)
//			{
//				System.out.println(answer_triangle[i]);
//			}
//			else
//			{	
//				System.out.print(answer_triangle[i].toString() + " ");
//			}
//		}
		return answer_triangle;
		
		//[[(-1, 0, 0),( 0, -1, 0),( 0, 0, 3)],[ (-1, 0, 0),( 0, -1, 0),( 0, 1, 0)]]
		}
		
		
		
		
}

	
	
	
	public static void bfs(Triangle t, Boolean [] used,Integer [] d)
	{
		Node<Triangle> node = new Node<Triangle>(t);
		queue<Triangle> trianglequeue = new queue<Triangle>(used.length);
		trianglequeue.enqueue(node);
		used[t.id] = true;
		while(!trianglequeue.isEmpty())
		{
			Triangle temp = trianglequeue.dequeue().getValue();
			LinkedList<Triangle> L1 = temp.E1.connectedtriangle;
			LinkedList<Triangle> L2 = temp.E2.connectedtriangle;
			LinkedList<Triangle> L3 = temp.E3.connectedtriangle;
			
			LinkedListIterator<Triangle> itr1 = L1.positions();
			LinkedListIterator<Triangle> itr2 = L2.positions();
			LinkedListIterator<Triangle> itr3 = L3.positions();
			
			while(itr1.hasNext())
			{
				Triangle take1 = itr1.next().value();
				if(!used[take1.id])
				{
					used[take1.id] = true;
					Node<Triangle> node1 = new Node<Triangle>(take1);
					trianglequeue.enqueue(node1);
					
					d[take1.id] = d[temp.id] + 1;
					
				}
			}
			
			while(itr2.hasNext())
			{
				Triangle take2 = itr2.next().value();
				if(!used[take2.id])
				{
					used[take2.id] = true;
					Node<Triangle> node2 = new Node<Triangle>(take2);
					trianglequeue.enqueue(node2);
					
					d[take2.id] = d[temp.id] + 1;
					
				}
			}
			
			while(itr3.hasNext())
			{
				Triangle take3 = itr3.next().value();
				if(!used[take3.id])
				{
					used[take3.id] = true;
					Node<Triangle> node3 = new Node<Triangle>(take3);
					trianglequeue.enqueue(node3);
					
					d[take3.id] = d[temp.id] + 1;
					
				}
			}
		}
		 
	}
	

	public int MAXIMUM_DIAMETER(){
		
		
		
		
Boolean [] used = new Boolean[countuniquetriangle+1];
	
	for(int i=0; i<countuniquetriangle+1 ; i++)
	{
		used[i] = false;
	}
	LinkedListIterator<Triangle> itr = trianglecollector.positions();
	LinkedList<RBTree<Triangle,Triangle>> rbtreecomponentcollector = new 
			LinkedList<RBTree<Triangle,Triangle>>();
	LinkedList<LinkedList<Triangle>> linkedcomponentcollector = new
			LinkedList<LinkedList<Triangle>>();
	while(itr.hasNext())
	{
		Triangle t = itr.next().value;
		if(!used[t.id])
		{
			RBTree<Triangle,Triangle> rbcomponent = new RBTree<Triangle,Triangle>();
			LinkedList<Triangle> linkedcomponent = new LinkedList<Triangle>();
			//System.out.println(111);
			dfs(rbcomponent,linkedcomponent,t, used);
			//System.out.println(111);
			rbtreecomponentcollector.add(rbcomponent);
			linkedcomponentcollector.add(linkedcomponent);
		}
		
		
	}
	LinkedList<Triangle> maxtillnow  = new LinkedList<Triangle>();
	int max = 0;
	LinkedListIterator<LinkedList<Triangle>> pt= linkedcomponentcollector.positions();
	while(pt.hasNext())
	{
		LinkedList<Triangle> current = pt.next().value();
		if(current.count() >= max)
		{
			max = current.count();
			maxtillnow = current;
		}
	}
	
	if(maxtillnow.count()== 1)
	{
		//System.out.println(0);
		return 0;
	}
	else
	{
		int n = max;
		LinkedListIterator<Triangle> itra = maxtillnow.positions();
		int diameter = 0;
		while(itra.hasNext())
		{
			Triangle t = itra.next().value();
			Boolean [] used1 = new Boolean[countuniquetriangle + 1];
			Integer [] d = new Integer[countuniquetriangle + 1];
			for(int i=0; i<countuniquetriangle+1 ; i++)
			{
				used1[i] = false;
				d[i] = 0;
			}
			bfs(t,used1,d);
			for(int i=0 ; i<countuniquetriangle + 1; i++)
			{
				if(diameter < d[i])
				{
					diameter = d[i];
				}
			}
			
		}

		//System.out.println("Return:");
		//System.out.println("Diameter: " + diameter);
		return diameter;
		
	}
		
		}



	public PointInterface [] CENTROID (){
		
		
		
		
Boolean [] used = new Boolean[countuniquetriangle+1];
	
	for(int i=0; i<countuniquetriangle+1 ; i++)
	{
		used[i] = false;
	}
	LinkedListIterator<Triangle> itr = trianglecollector.positions();
	LinkedList<RBTree<Triangle,Triangle>> rbtreecomponentcollector = new 
			LinkedList<RBTree<Triangle,Triangle>>();
	LinkedList<LinkedList<Triangle>> linkedcomponentcollector = new
			LinkedList<LinkedList<Triangle>>();
	while(itr.hasNext())
	{
		Triangle t = itr.next().value;
		if(!used[t.id])
		{
			RBTree<Triangle,Triangle> rbcomponent = new RBTree<Triangle,Triangle>();
			LinkedList<Triangle> linkedcomponent = new LinkedList<Triangle>();
		//	System.out.println(111);
			dfs(rbcomponent,linkedcomponent,t, used);
		//	System.out.println(111);
			rbtreecomponentcollector.add(rbcomponent);
			linkedcomponentcollector.add(linkedcomponent);
		}
		
		
	}
	PointInterface[] answer_query = new PointInterface[linkedcomponentcollector.count()];
	LinkedListIterator<LinkedList<Triangle>> itra = linkedcomponentcollector.positions();

	MaxHeap<Point> sortedpointorder = new MaxHeap<Point>(); 
	Boolean [] marked = new Boolean[countuniquepoint + 1];
	
	while(itra.hasNext())
	{
		for(int i=0; i<countuniquepoint + 1 ; i++)
		{
			marked[i] = false;
		}
		int countnooftriangle = 0;
		float centroid_x=0,centroid_y = 0, centroid_z = 0;
		LinkedList<Triangle> temp = itra.next().value();
		LinkedListIterator<Triangle> tempa = temp.positions();
		while(tempa.hasNext())
		{
			Triangle t = tempa.next().value();
			//System.out.println(t.toString());
			if(!marked[t.P1.id])
			{
				centroid_x = centroid_x + t.P1.x;
				centroid_y = centroid_y + t.P1.y;
				centroid_z = centroid_z + t.P1.z;
				marked[t.P1.id] = true;
				countnooftriangle = countnooftriangle + 1;
			}
			if(!marked[t.P2.id])
			{
				centroid_x = centroid_x + t.P2.x;
				centroid_y = centroid_y + t.P2.y;
				centroid_z = centroid_z + t.P2.z;
				marked[t.P2.id] = true;
				countnooftriangle = countnooftriangle + 1;
			}
			if(!marked[t.P3.id])
			{
				centroid_x = centroid_x + t.P3.x;
				centroid_y = centroid_y + t.P3.y;
				centroid_z = centroid_z + t.P3.z;
				marked[t.P3.id] = true;
				countnooftriangle = countnooftriangle + 1;
			}
		}
		centroid_x = centroid_x/countnooftriangle;
		centroid_y = centroid_y/countnooftriangle;
		centroid_z = centroid_z/countnooftriangle;
		Point answer = new Point();
		answer.assignPoint(centroid_x, centroid_y, centroid_z);
		sortedpointorder.insert(answer);
	}
	for(int i=0; i<linkedcomponentcollector.count() ; i++)
	{
		answer_query[linkedcomponentcollector.count() - i - 1] = sortedpointorder.extractMax();
	}
	

	//System.out.println("Return:");
//	for(int i=0; i<answer_query.length ; i++)
//	{
//		if(i == answer_query.length - 1)
//		{
//			System.out.println(answer_query[i].toString());
//		}
//		else
//		{
//			System.out.print(answer_query[i].toString() + " ");
//		}
//	}
	return answer_query;
	}

	// INPUT [x,y,z]
	public PointInterface CENTROID_OF_COMPONENT (float [] point_coordinates){

			Point p = new Point();
			p.assignPoint(point_coordinates[0], point_coordinates[1], point_coordinates[2]);
		
Boolean [] used = new Boolean[countuniquetriangle+1];
		
		for(int i=0; i<countuniquetriangle+1 ; i++)
		{
			used[i] = false;
		}
		LinkedListIterator<Triangle> itr = trianglecollector.positions();
		LinkedList<RBTree<Triangle,Triangle>> rbtreecomponentcollector = new 
				LinkedList<RBTree<Triangle,Triangle>>();
		LinkedList<LinkedList<Triangle>> linkedcomponentcollector = new
				LinkedList<LinkedList<Triangle>>();
		while(itr.hasNext())
		{
			Triangle t = itr.next().value;
			if(!used[t.id])
			{
				RBTree<Triangle,Triangle> rbcomponent = new RBTree<Triangle,Triangle>();
				LinkedList<Triangle> linkedcomponent = new LinkedList<Triangle>();
			//	System.out.println(111);
				dfs(rbcomponent,linkedcomponent,t, used);
			//	System.out.println(111);
				rbtreecomponentcollector.add(rbcomponent);
				linkedcomponentcollector.add(linkedcomponent);
			}
			
			
		}
		LinkedListIterator<LinkedList<Triangle>> itra = linkedcomponentcollector.positions();
		int countconnectedcomponent = 0;
		Boolean b = true;
		Boolean [] marked = new Boolean[countuniquepoint + 1];
		
		while(itra.hasNext() && b)
		{
			int countnooftriangle = 0;
			float centroid_x=0,centroid_y = 0, centroid_z = 0;
			LinkedList<Triangle> temp = itra.next().value();
			LinkedListIterator<Triangle> tempa = temp.positions();
			for(int i=0; i<countuniquepoint + 1 ; i++)
			{
				marked[i] = false;
			}
			while(tempa.hasNext())
			{
				Triangle t = tempa.next().value();
				if(!marked[t.P1.id])
				{
					centroid_x = centroid_x + t.P1.x;
					centroid_y = centroid_y + t.P1.y;
					centroid_z = centroid_z + t.P1.z;
					marked[t.P1.id] = true;
					countnooftriangle = countnooftriangle + 1;
				}
				if(!marked[t.P2.id])
				{
					centroid_x = centroid_x + t.P2.x;
					centroid_y = centroid_y + t.P2.y;
					centroid_z = centroid_z + t.P2.z;
					marked[t.P2.id] = true;
					countnooftriangle = countnooftriangle + 1;
				}
				if(!marked[t.P3.id])
				{
					centroid_x = centroid_x + t.P3.x;
					centroid_y = centroid_y + t.P3.y;
					centroid_z = centroid_z + t.P3.z;
					marked[t.P3.id] = true;
					countnooftriangle = countnooftriangle + 1;
				}
				if(t.P1.compareTo(p)==0 || t.P2.compareTo(p)==0 || t.P3.compareTo(p)==0)
				{
					b = false;
				}

				
			}
			centroid_x = centroid_x/countnooftriangle;
			centroid_y = centroid_y/countnooftriangle;
			centroid_z = centroid_z/countnooftriangle;
			Point answer = new Point();
			answer.assignPoint(centroid_x, centroid_y, centroid_z);
			if(b==false)
			{
			//	System.out.println("Return: ");
			//	System.out.println( answer);
				return answer;
			}
		}
		
		
		
		
		
		
 		
	return null;
	}


	public 	PointInterface [] CLOSEST_COMPONENTS(){
		
		
Boolean [] used = new Boolean[countuniquetriangle+1];
	
	for(int i=0; i<countuniquetriangle+1 ; i++)
	{
		used[i] = false;
	}

	float min = Float.MAX_VALUE;
	LinkedListIterator<Triangle> itr = trianglecollector.positions();
	LinkedList<RBTree<Triangle,Triangle>> rbtreecomponentcollector = new 
			LinkedList<RBTree<Triangle,Triangle>>();
	LinkedList<Pair<LinkedList<Triangle>,Integer>> linkedcomponentcollector = new
			LinkedList<Pair<LinkedList<Triangle>,Integer>>();
	int m =0;
	while(itr.hasNext())
	{
		Triangle t = itr.next().value;
		if(!used[t.id])
		{
			RBTree<Triangle,Triangle> rbcomponent = new RBTree<Triangle,Triangle>();
			LinkedList<Triangle> linkedcomponent = new LinkedList<Triangle>();
		//	System.out.println(111);
			dfs(rbcomponent,linkedcomponent,t, used);
		//	System.out.println(111);
			rbtreecomponentcollector.add(rbcomponent);
			Pair<LinkedList<Triangle>,Integer> linked = new Pair<LinkedList<Triangle>,Integer>(linkedcomponent,m); 
			linkedcomponentcollector.add(linked);
			//System.out.println(m);
			m++;
		}
		
		
	}
	LinkedListIterator<Pair<LinkedList<Triangle>,Integer>> itra = linkedcomponentcollector.positions();
	LinkedListIterator<Pair<LinkedList<Triangle>,Integer>> itrb = linkedcomponentcollector.positions();
	PointInterface[] po = new PointInterface[2];
	while(itra.hasNext())
	{
		Pair<LinkedList<Triangle>,Integer> upperloop = itra.next().value();
		while(itrb.hasNext())
		{
			Pair<LinkedList<Triangle>,Integer> lowerloop = itrb.next().value();
			//System.out.println(upperloop.second() + " " + lowerloop.second());
			if(upperloop.second()!=lowerloop.second())
			{
				//System.out.println(upperloop.second() + " " + lowerloop.second());
				LinkedList<Triangle> upperlooptriangle = (LinkedList<Triangle>) upperloop.first();
				LinkedList<Triangle> lowerlooptriangle = (LinkedList<Triangle>) lowerloop.first();
				
				LinkedListIterator<Triangle> itrc = upperlooptriangle.positions();
				LinkedListIterator<Triangle> itrd = lowerlooptriangle.positions();

				while(itrd.hasNext())
				{
					Triangle t1 = itrd.next().value();
					while(itrc.hasNext())
					{
						Triangle t2 =itrc.next().value();
						Point [] a = new Point[3];
						Point [] b = new Point[3];
						a[0] = t1.P1;
						a[1] = t1.P2;
						a[2] = t1.P3;
						b[0] = t2.P1;
						b[1] = t2.P2;
						b[2] = t2.P3;
						
						for(int i=0; i<3; i++)
						{
							for(int j=0; j<3; j++)
							{
						//		if(a[i].compareTo(b[j])==0)
							//	{
								//	System.out.println(a[i].toString()  + " 1111111111111111111111111111111111111111");
								//}
								float diff = a[i].mindistance(b[j]);
							//	System.out.println(a[i].toString()  + " " + b[i].toString() + " " + a[i].mindistance(b[j]) );
								//System.out.println(diff + " " + min);
								if(diff < min)
								{
								//	System.out.println(diff + " " + min);
									min = diff;
									po[1] = a[i];
									po[0] = b[j];
									

									//System.out.println(diff + " " + min);
								}
							}
						}
						
					}
				}
			}
			
		}
	}

//	//System.out.println("Return:");
//	if(po[0]!=null)
//	{	
//		System.out.println(po[0].toString() + " " + po[1].toString());
//	}
		return po;
	}





}

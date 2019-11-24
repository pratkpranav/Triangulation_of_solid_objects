
public class checkqueuebfs {

	static int countuniquetriangle  = -1;
	static int countuniquepoint = 0;
	static int countuniqueedge = 0;
	
	static LinkedList<Point> pointcollector = new LinkedList<Point>();
	static LinkedList<Edge> edgecollector = new LinkedList<Edge>();
	static LinkedList<Triangle> trianglecollector = new LinkedList<Triangle>();

	static RBTree<Point, Point> rbpointcollector = new RBTree<Point,Point>();
	static RBTree<Edge,Edge> rbedgecollector = new RBTree<Edge,Edge>();
	static RBTree<Triangle,Triangle> rbtrianglecollector = new RBTree<Triangle,Triangle>();
	
	
	
	public static boolean ADD_TRIANGLE(float [] triangle_coord){
		
		float area = triangle_coord[0]*(triangle_coord[4]*triangle_coord[8] - triangle_coord[7]*triangle_coord[5]) 
				- triangle_coord[3]*(triangle_coord[7]*triangle_coord[2] - triangle_coord[1]*triangle_coord[7]) 
				+ triangle_coord[6]*(triangle_coord[1]*triangle_coord[5] - triangle_coord[4]*triangle_coord[2]); 
		if(area == 0)
		{
			return false;
		}
		else
		{
			countuniquetriangle++;
			
			Point P1 = new Point();
			Point P2 = new Point();
			Point P3 = new Point();
			P1.assignPoint(triangle_coord[0], triangle_coord[1], triangle_coord[2]);
			P2.assignPoint(triangle_coord[3], triangle_coord[4], triangle_coord[5]);
			P3.assignPoint(triangle_coord[6], triangle_coord[7], triangle_coord[8]);
			if(rbpointcollector.search(P1)!=null)
			{
				P1 = rbpointcollector.search(P1).value;
				
			}
			if(rbpointcollector.search(P2)!=null)
			{
				P2 = rbpointcollector.search(P2).value;
				
			}
			if(rbpointcollector.search(P3)!=null)
			{
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
				Point originalP1 = new Point();
				
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
					P3.connectedtriangle.add(triangle);
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
				Point originalP2 = new Point();
				
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
				Point originalP3 = new Point();
				
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
			
			return true;
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
	
	public static void main(String [] args)
	{
		

			float [] triangle_coord = new float[9];
				
			triangle_coord[0] = 3;
			triangle_coord[1] = 0;
			triangle_coord[2] = 3;
				triangle_coord[3] = 0;
				triangle_coord[4] = 1;
				triangle_coord[5] = -1;
				triangle_coord[6] = 3;
				triangle_coord[7] = 0;
				triangle_coord[8] = -2;
				ADD_TRIANGLE(triangle_coord);
				

				triangle_coord[0] = 3;
				triangle_coord[1] = 0;
				triangle_coord[2] = 3;
					triangle_coord[3] = 0;
					triangle_coord[4] = 1;
					triangle_coord[5] = -1;
					triangle_coord[6] = 0;
					triangle_coord[7] = 0;
					triangle_coord[8] = 0;
					ADD_TRIANGLE(triangle_coord);
					
					

					triangle_coord[0] = 0;
					triangle_coord[1] = 0;
					triangle_coord[2] = 225;
						triangle_coord[3] = 0;
						triangle_coord[4] = 1;
						triangle_coord[5] = -1;
						triangle_coord[6] = 3;
						triangle_coord[7] = 0;
						triangle_coord[8] = -2;
						ADD_TRIANGLE(triangle_coord);
						
		
						triangle_coord[0] = 3;
						triangle_coord[1] = 0;
						triangle_coord[2] = 3;
							triangle_coord[3] = 0;
							triangle_coord[4] = 1;
							triangle_coord[5] = -1;
							triangle_coord[6] = 0;
							triangle_coord[7] = 0;
							triangle_coord[8] = 22;
							ADD_TRIANGLE(triangle_coord);
				
			
		int n = countuniquetriangle;
		LinkedListIterator<Triangle> itr = trianglecollector.positions();
		while(itr.hasNext())
		{
			Triangle t = itr.next().value();
			Boolean [] used = new Boolean[countuniquetriangle + 1];
			Integer [] d = new Integer[countuniquetriangle + 1];
			for(int i=0; i<countuniquetriangle+1 ; i++)
			{
				used[i] = false;
				d[i] = 0;
			}
			bfs(t,used,d);
			for(int i=0 ; i<countuniquetriangle + 1; i++)
			{
				System.out.println(d[i]);
			}
			
		}
		
		
		
	}
	
	
	
}

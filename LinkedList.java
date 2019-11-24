


class LinkedList<T> 
{
	T last;
	int c  = 1;
	public Position<T> head,cad;
	Boolean b = false;
	public void assignLinkedList(T previous, int count, Position<T> hea)
	{
		last = previous;
		c=count;
		Position<T> ppp = new Position<T>(previous,hea);
		//c =1;
		head = ppp; 
	}
	public void add(T e)
	{		
		if(b==false)
		{
			assignLinkedList(e,1,null);
			b = true;
			
		}
		
		else
		{
			
			Position<T> present = new Position<T>(e,head);
			last = e;
			head = present;
			c++;
		}
			
		
	}
	public LinkedListIterator<T> positions()
	{	

		LinkedListIterator<T> it = new LinkedListIterator(head);
		return it;
	}
	
	public int count()
	{
		//System.out.println(c);
		return c;
	}
}
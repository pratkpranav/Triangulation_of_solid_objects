

class LinkedListIterator<T>
{
		
	public Position<T> current;
	public LinkedListIterator(Position<T> head)
	{
		current = head;
 	}
	public boolean hasNext()
	{
		return current != null ;
	}
	public Position<T> next()
	{		
		Position<T> poss = current;
		current = current.after();
		return poss;
	}
	
} 

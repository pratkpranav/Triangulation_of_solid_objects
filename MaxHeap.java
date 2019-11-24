


public class MaxHeap<T extends Comparable>  {


public Integer filltillnow = -1;
	Pair<T,Integer>[] storage = new Pair[1000000]; 
	
    public void insert(T element) {
    	//System.out.println(element);
    	filltillnow = filltillnow + 1;
    	//System.out.println(element);
    	Pair<T,Integer>  ell = new Pair(element,filltillnow); 
    	storage[filltillnow] = ell;
    	//System.out.println(filltillnow + " " + ((Student)element).getName());
    	shifttotop(filltillnow);
    	/*for(int i=0 ;i<10 ;i ++)
    	{
    		if(storage[i]!=null)
    		{
    			System.out.print(((Student)storage[i]).getName() + " " );
    		}
    	}
    	System.out.println();*/
    	//System.out.println(filltillnow + " " + ((Student)storage[filltillnow]).getName());
    }

    public T extractMax() {
    	
    	if(filltillnow>-1)
    	{
    	Pair returne = storage[0];

    	//System.out.println(((Student)storage[0]).getName() + " checkfortransfer");
    	storage[0] = storage[filltillnow];
    	//System.out.println(((Student)storage[filltillnow]).getName() + " checkfortransfer");
    	storage[filltillnow] = null;
    	maxheapify(0);
    	filltillnow = filltillnow -1 ;
    	T ret = (T) returne.first;
    
        return ret;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    
    
    public void shifttotop(int fill)
    {	
    	if(fill>0)
    	{
    		
    	while(((Comparable) storage[fill]).compareTo(storage[(fill-1)/2])>0)
    		{

        	//System.out.println(((Student)storage[fill].first).getName()  + " " +((Student)storage[(fill-1)/2].first).getName() );
    			//System.out.println(((Comparable) storage[fill]).compareTo(storage[(fill-1)/2]));
    				Pair check = storage[(fill-1)/2];
    				storage[(fill-1)/2] = storage[fill];
    				storage[fill] = check;
    				fill = (fill-1)/2;
        		//System.out.println( ((Comparable) storage[fill]).compareTo(storage[(fill-1)/2]));
    		}
    	}
    }
    public void maxheapify(int index)
    {	
    	
    	
    if(storage[2*index+2] == null  && storage[2*index + 1] == null)
    {
    	return;
    }
    int largest , left = 2*index + 1 , right = 2*index+2;
    
    if(storage[2*index + 1] != null)
    {
    	//System.out.println(((Student)storage[0]).getName()  + " " +((Student)storage[2*index + 1]).getName() + " " + ((Student)storage[index]).getName() + " " + ((Comparable) storage[2*index + 1]).compareTo(storage[index]));
    	if(((Comparable) storage[2*index + 1]).compareTo(storage[index])> 0)
    	{
    		//Pair temp = storage[2*index +1];
    		//storage[2*index + 1] = storage[index ];
    		//storage[index] = temp;
    		//maxheapify(2*index+1);
    		largest = left;
    	}
    	else
    	{
    		largest = index;
    	}
    	
    }
    else
	{
		largest = index;
	}
    
    if(storage[2*index + 2] != null)
    {
    	if(((Comparable) storage[2*index +2]).compareTo(storage[largest]) > 0)
    	{
    		//Pair temp = storage[2*index +2];
    		//storage[2*index+2] = storage[index];
    		//storage[index] = temp;
    		//maxheapify(2*index + 2);
    		largest = right;
    	}
    	
    }
    if(largest != index)
    {

		Pair temp = storage[largest];
		storage[largest] = storage[index];
		storage[index] = temp;
		maxheapify(largest);
    }

    	
    }
    

}
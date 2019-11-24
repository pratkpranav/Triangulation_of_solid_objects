

public class RedBlackNode<T extends Comparable, E>  {

	
	int redblackcheck;
	T key;
	E value;
	
	RedBlackNode<T,E> leftchild  ,rightchild ,parent ;
	
	public RedBlackNode(int redblack)
	{
		RedBlackNode<T,E> p, q;
		
		
		if(redblack == 0)
		{
			redblackcheck = 0;
		}
		else
		{
			redblackcheck = 1;
		}
		// 0 for true/red an 1 for false/black
	}

    public E getValue() {
    	return value;
    	
    }

    
    
   public int compareTo(T key)
   {
	   if(this.key.toString().compareTo(key.toString()) > 0)
	   {
		   return 1;
	   }
	   else if(this.key.toString().compareTo(key.toString()) < 0)
	   {
		   return -1;
	   }
	   else
	   {
		   return 0;
	   }
	   
   }
    
    
    
}




public class RBTree<T extends Comparable, E> implements RBTreeInterface<T, E>  {

	RedBlackNode<T,E> root = new RedBlackNode<>(1);
	
	int k=0;
    @Override
    public void insert(T key, E value) {
    	root.redblackcheck = 1;
    	RedBlackNode<T,E> temp =root;
    	RedBlackNode<T,E> res = inserthelp(key,temp);
    	
    	if(k==0)
    	{
    		root.value = value;
    		root.key = key;
    		
    		k++;
    	}
    	else
    	{
    	if((res.key).compareTo(key) == 0)
    	{
    		res.value = value;

    	}
    	else
    	{
    		//System.out.println("234 " + key.toString() + " " + res.key.toString() + " " + key.compareTo(res.key));
    		if(res.key.compareTo(key) < 0)
    		{
    			RedBlackNode<T,E> newss = new RedBlackNode<T,E>(0);
    			
    			
    			res.rightchild = newss;	
    			newss.key = key;
    			newss.parent = res;
    			newss.value = value;
    			fixup(newss);	
    	    	//inorder(root);
    	    	//System.out.println();
    		}
    		else
    		{
    			RedBlackNode<T,E> newss = new RedBlackNode<T,E>(0);
    			
    			res.leftchild = newss;
    			newss.parent = res;
    			newss.key = key;
    			newss.value = value;
    		//	System.out.println(res.key + " left " + newss.parent.key + " " + newss.parent.leftchild.key + " " + newss.parent.rightchild + " " +  newss.key + " " +  newss.leftchild + " " +res.parent.key  + " " + res.redblackcheck + " " +newss.redblackcheck + " " + res.parent.redblackcheck  );
    			
       	    	//inorder(root);
    	    	//System.out.println();
    			fixup(newss);
    			//System.out.println(res.key + " left " + newss.parent.key + " " + newss.parent.leftchild + " " + newss.parent.rightchild.key + " " +newss.key + " "  + newss.leftchild.key  + " " + res.parent.key + " " + res.redblackcheck+ " " +newss.parent.redblackcheck+ " " + newss.redblackcheck);
    	    	//sinorder(root);
    	    	//System.out.println();
    		}
    	}
    	}

    }
    
    public RedBlackNode<T,E> inserthelp(T key,RedBlackNode<T,E> node)
    {
    	if(node!=null && node.key!=null)
    	{
    		if(key.compareTo(node.key)>0)
    		{
    			if(node.rightchild == null)
    			{
    				return node;
    			}
    			else
    			{
    				node = node.rightchild;
    				return inserthelp(key,node);
    			}
    		}
    		else if(key.compareTo(node.key)<0)
    		{
    			if(node.leftchild==null)
    			{
    				return node;
    			}
    			else
    			{
    				node= node.leftchild;
    				return inserthelp(key,node);
    			}
    			
    		}
    		else
    		{
    			return node;
    		}
    	}
    	else
    	{
    		return root;
    	}
    }
    public void fixup(RedBlackNode<T,E> temp)
    {
    	if(temp.parent.redblackcheck == 0 )
    	{
    		if(temp.parent.parent.rightchild== null)
    		{
    			if(temp == temp.parent.rightchild)
    			{

        			temp.parent.redblackcheck = 1;
        			temp.parent.parent.redblackcheck = 0;
    			}
    			else
    			{
    				temp.redblackcheck=1;
    				temp.parent.parent.redblackcheck =0;
    			}
    			//System.out.println(1);
    			rightrotate(temp.parent.parent);
    		}
    		else if(temp.parent.parent.leftchild== null)
    		{
    		//	System.out.println(1);
    			if(temp== temp.parent.rightchild)
    			{

        			temp.redblackcheck = 1;
        			temp.parent.parent.redblackcheck = 0;
    			}
    			else
    			{

        			temp.parent.redblackcheck = 1;
        			temp.parent.parent.redblackcheck = 0;
    			}
    			//System.out.println(2);
    			leftrotate(temp.parent.parent);
    		}
    		else if(temp.parent.parent.leftchild.redblackcheck==0 && temp.parent.parent.rightchild.redblackcheck==1)
    		{    		
			if(temp== temp.parent.rightchild)
			{

    			temp.redblackcheck = 1;
    			temp.parent.parent.redblackcheck = 0;
			}
			else
			{

    			temp.parent.redblackcheck = 1;
    			temp.parent.parent.redblackcheck = 0;
			}
			//System.out.println(2);
			leftrotate(temp.parent.parent);
    		}
    		else if(temp.parent.parent.rightchild.redblackcheck==0 && temp.parent.parent.leftchild.redblackcheck==1)
    		{    
    			
    		if(temp == temp.parent.rightchild)
			{

    			temp.redblackcheck = 1;
    			temp.parent.parent.redblackcheck = 0;
			}
			else
			{
				temp.parent.redblackcheck=1;
				temp.parent.parent.redblackcheck =0;
			}
			//System.out.println(1);
			rightrotate(temp.parent.parent);
    		}
    		else
    		{
    			while(temp.parent.redblackcheck == 0)
    			{
    				if(temp.parent.parent!=null)
    				{
    				temp.parent.parent.redblackcheck =0 ;
    				}
    				if(temp.parent.parent.leftchild !=null)
    				{
    				temp.parent.parent.leftchild.redblackcheck = 1;
    				}
    				if(temp.parent.parent.rightchild!=null)
    				{
    				temp.parent.parent.rightchild.redblackcheck = 1;
    				}
    				temp =temp.parent.parent;
    				if(temp.parent==null)
    				{
    					temp.redblackcheck = 1;
    					break;
    				}
    			}
    		}
    	}
    	
    }
    public void leftrotate(RedBlackNode<T,E> x)
    {
    	RedBlackNode<T,E> y = x.rightchild;
    	x.rightchild = y.leftchild;
    	if(y.leftchild!=null)
    	{
    	y.leftchild.parent = x;
    	}
    	y.parent = x.parent;
    	if(x.parent == null)
    	{
    		root = y;
    	}
    	else 
        	//System.out.println(x.rightchild.key.toString());
        	//System.out.println(x.rightchild.key.toString());
    	{
    		if(x == x.parent.leftchild)
    		{
    		x.parent.leftchild = y;
    		}
    		else
    		{
    			x.parent.rightchild = y;
    		}
    	}
    	y.leftchild = x;
    	x.parent = y;
    	
    	
    	
    }
    public void rightrotate(RedBlackNode<T,E> x)
    {

    	RedBlackNode<T,E> y = x.leftchild;
    	x.leftchild = y.rightchild;
    	if(y.rightchild!=null)
    	{
    	y.rightchild.parent = x;
    	}
    	y.parent = x.parent;
    	if(x.parent == null)
    	{
    		root = y;
    		
    	}
    	else
    	{
    		if(x == x.parent.leftchild)
    		{
    			x.parent.leftchild = y;
    		}
    		else
    		{
    			x.parent.rightchild = y;
    		}
    	}
    	y.rightchild = x;
    	x.parent = y;
    	
    	
    }

public void inorder(RedBlackNode<T,E> root)
{
	if(root == null)
	{
		return;
		
	}
	
	inorder(root.leftchild);
	if(root.key!=null)
	{
	System.out.print(root.value.toString() + " ");
	}
	inorder(root.rightchild);
	
}
    
    @Override
    public RedBlackNode<T, E> search(T key) {
        
    	
    	RedBlackNode<T,E> temp =root;
    	
    	RedBlackNode<T,E> res = searching(key,temp);
    	if(res == null)
    	{
    		return null;
    	}
    	if(res.key == null)
    	{
    		return null;
    	}
    	if((res.key).compareTo(key) == 0)
    	{
    		
    		return res;
    	}
    	else
    	{
    		return null;
    	}
    }
    
    public RedBlackNode<T, E> searching(T key,RedBlackNode<T,E> temp)
    {
    	if(temp== null )
    	{
    		return null;
    	}
    	else if(temp.key == null)
    	{
    		return null;
    	}
    	//System.out.println(temp.key.toString()  + " " + key.toString());
    	if(temp.key != null)
    	{
        	//System.out.println(temp.key  + " " + key + " " + (temp.key).compareTo(key));
    		
    	if((temp.key).compareTo(key)>0)
    	{
    		//System.out.println(key.toString() + " " + temp.key.toString() + " " + temp.leftchild.key.toString() + " Going Left"  );
    		//if(temp.leftchild == null)
    		//{
            	//System.out.println(key.toString() + " " + temp.key.toString());
    			//System.out.println("Going Left");
    			//return temp;
    		//}
    		//else
    		//{
    		
    		temp  = temp.leftchild;
    		return searching(key,temp);
    		//}
    	}
    	else if((temp.key).compareTo(key)<0)
    	{
    		//System.out.println(key.toString() + " " + temp.key.toString() + " Going Right"  );
    		//if(temp.rightchild == null)
    		//{
            //	System.out.println(key.toString() + " " + temp.key.toString());
    			//System.out.println("Going Right");
    		//	return temp;
    	//	}
    		//else
    //		{
    			temp = temp.rightchild;
    			return searching(key,temp);
    		//}
    	}
    	else
    	{
    		return temp;
    	}
    	
    }
    
    else
    {
    	return root;
    }
    }
}
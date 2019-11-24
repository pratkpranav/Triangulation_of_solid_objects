
public class checker {

	public static void main(String [] s)
	{
		LinkedList<Integer> ll = new LinkedList<Integer>();
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
 		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll1.add(4);
		ll1.add(5);
		ll1.add(6);
		ll.add(7);
		ll2.add(8);
		ll2.add(9);
		ll2.add(10);
		ll1.add(11);
		ll2.add(12);
        
		LinkedListIterator<Integer> itr = ll.positions();
		LinkedListIterator<Integer> itr1 = ll1.positions();
		LinkedListIterator<Integer> itr2 = ll2.positions();
		
		Integer[] finalans = new Integer[ll.count() + ll1.count() + ll2.count()];
		int i = ll.count() + ll1.count() + ll2.count() -1;
		int a = ll.count(), b = ll1.count(), c = ll2.count();

		Integer s1 = itr.next().value();
		Integer s2 = itr1.next().value();
		Integer s3 = itr2.next().value();
		
		LinkedList<Integer> midone = new LinkedList<Integer>();
		Boolean bp = true;
		while(a > 0 && b > 0)
		{
			if(s1 > s2)
			{
				midone.add(s1);
				if(itr.hasNext())
				{
					s1 = itr.next().value();
				}
				a--;
				
			}
			else
			{
				midone.add(s2);
				if(itr1.hasNext())
				{
					s2 = itr1.next().value();
				}
				b--;
			}
			
			
		}
		
		while(a > 0)
		{
			midone.add(s1);
			if(itr.hasNext())
			{
				s1 = itr.next().value();
			}
			a--;
		}
		while(b > 0)
		{
			midone.add(s2);
			if(itr1.hasNext())
			{
				s2 = itr1.next().value();
			}
			b--;
		}
		int d = midone.count();
		LinkedList<Integer> midtwo = new LinkedList<Integer>();
		LinkedListIterator<Integer> itr5 =  midone.positions();
		while(itr5.hasNext())
		{
			midtwo.add(itr5.next().value());
		}
		LinkedListIterator<Integer> itr3 = midtwo.positions();
		
		LinkedList<Integer> finalanswer = new LinkedList<Integer>();
		Integer s4 = itr3.next().value;
		while(d > 0 && c > 0)
		{
			if(s4 > s3)
			{
				finalanswer.add(s4);
				if(itr3.hasNext())
				{
					s4 = itr3.next().value();
				}
				d--;
				
			}
			else
			{
				finalanswer.add(s3);
				if(itr2.hasNext())
				{
					s3 = itr2.next().value();
				}
				c--;
			}
		}
		while(c > 0)
		{
			finalanswer.add(s3);
			if(itr2.hasNext())
			{
				s3 = itr2.next().value();
			}
			c--;
		}
		while(d > 0)
		{
			finalanswer.add(s4);
			if(itr3.hasNext())
			{
				s4 = itr3.next().value();
			}
			d--;
		}
		
		LinkedListIterator<Integer> ppo = finalanswer.positions();
		while(ppo.hasNext())
		{
			System.out.println(ppo.next().value());
		}
		
	}
	
}



public class Pair<T, K> implements Comparable<Pair> {

	Object first;
	Integer second;
	public Pair(T a,Integer b)
	{
		this.first = a;
		this.second = b;
		
	}
	public Object first()
	{
		return first;
	}
	public Integer second()
	{
		return second;
	}

    @Override
	public int compareTo(Pair pair)
	{
		if(((Comparable)first).compareTo(pair.first) > 0)
		{
			return 1;
		}
		else if(((Comparable)first).compareTo(pair.first) < 0)
		{
			return -1;
		}
		else
		{
			//System.out.println(second.toString() + " " + ((Job)first) + " " +((Job)pair.first) + " " + pair.second.toString());
			if( second.compareTo(pair.second) < 0)
			{
				return 1;
			}
			else if( second.compareTo(pair.second) > 0) {
				return -1;
			}
			else 
			{
				return 0;
			}
		}
	}
}





class Position<T> 
{
	public T value;
	public Position<T> locate;

	public Position(T val,Position<T> l)
	{
		value = val;
		locate = l ;
	}
	public T value()
	{
		return value;
	}

	public Position<T> after()
	{
		return locate;
	}
} 
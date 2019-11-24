// This class implements the Queue
public class queue<V>  {

    //TODO Complete the Queue implementation
    private Node<V>[] queue;
    private int capacity, currentSize, front, rear;
	
    public queue(int capacity) {    
    	this.capacity= capacity;
    	queue = new Node[capacity];
    	currentSize=0;
    	front =0;
    	rear= -1;
    }

    public int size() {
    	return currentSize;
    }

    public boolean isEmpty() {
    	if(currentSize==0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
	
    public boolean isFull() {

    	if(currentSize==capacity)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    
    }

    public void enqueue(Node<V> node) {

    	rear = (rear + 1)%capacity;
    	queue[rear]=  node;
    	currentSize++;
    	
    }

    public Node<V> dequeue() {
    	
    	Node<V> deq = queue[front];
    
    	//System.out.println(currentSize);
    	front = (front +1)%capacity;
    	if(currentSize==0)
    	{
    		currentSize=0;
    		return null;
    	}
    	else
    	{
    		currentSize--;
    	}
    	return deq;
    	
    }

}

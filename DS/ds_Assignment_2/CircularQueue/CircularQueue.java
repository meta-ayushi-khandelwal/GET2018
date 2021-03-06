package ds_Assignment_2.Q3_CircularQueue;

/**
 * @author Ayushi Khandelwal
 *
 */
public class CircularQueue {
	int max;
	int[] array;
	int front, rear;
	int size;
	
	/**
	 * @param max
	 */
	public CircularQueue(int max) {
		this.max = max;
		 array = new int[max];
		 front = 0;
		 rear = -1;
		 size = 0;
	}

	/**
	 * @param value
	 * @return true if insertion in queue is successful
	 */
	public boolean enqueue(int value) {
		if(isFull()){
			return false;
		}
		
		rear = (rear + 1) % max;
		array[rear] = value;
		size++;
		return true;
	}

	/**
	 * @return a deleted item from queue
	 */
	public int dequeue() {
		if(isEmpty()){
			throw new AssertionError();
		}
		
		int item = array[front];
		front = (front + 1) % max;
		size--;
		return item;
	}

	/**
	 * @return true if queue is empty, else false
	 */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}

	/**
	 * @return top element of queue
	 */
	public int peek() {
		if (isEmpty()) {
            throw new AssertionError();
        } else {
            return array[front];
        }
    }
	
	/**
	 * @return true if queue is full, else return false
	 */
	public boolean isFull() {
		if(size == max)
			return true;
		return false;
	}
}

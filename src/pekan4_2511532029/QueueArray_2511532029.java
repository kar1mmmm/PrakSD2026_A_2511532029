package pekan4_2511532029;

public class QueueArray_2511532029 {
	int front_2029 , rear_2029 , size_2029;
	int capasity_2029;
	int array_2029[];
	
	public QueueArray_2511532029(int capasity_2029) {
		this.capasity_2029 = capasity_2029;
		front_2029 = this.size_2029=  0;
		rear_2029 = capasity_2029 - 1;
		array_2029 = new int [this.capasity_2029];
	}
	
	boolean isFull_2029 (QueueArray_2511532029 queue) {
		return (queue.size_2029 == queue.capasity_2029);
	}
	
	boolean isEmpty_2029 (QueueArray_2511532029 queue) {
		return (queue.size_2029 == 0);
	}
	
	 void enqueue_2029 (int item_2029) {
		 if (isFull_2029(this)) return;
		 
		 this.rear_2029 = (this.rear_2029 + 1) % this.capasity_2029;
		 this.array_2029 [this.rear_2029] = item_2029;
		 this.size_2029 = this.size_2029 + 1;
		 System.out.println(item_2029 + "enqueue to queue");
	 }
	 
	 int dequeue_2029() {
		 if (isEmpty_2029(this))
			 return Integer.MIN_VALUE;
		 	int item_2029 = this.array_2029[this.front_2029];
		 	this.front_2029 = (this.front_2029 + 1) % this.capasity_2029;
		 	this.size_2029 =  size_2029 - 1;
		 	return item_2029;
	 }
	 
	 int front_2029 () {
		 if (isEmpty_2029(this))
			 return Integer.MIN_VALUE;
		 	return this.array_2029[this.front_2029];
	 }
	 
	 int rear_2029() {
		 if (isEmpty_2029(this))
			 return Integer.MIN_VALUE;
			 return this.array_2029[this.rear_2029];
	 }
	 
	 void display_2029() {
		 int i_2029;
		 if (front_2029 == rear_2029) {
			 System.out.println("\n Antrian Kosong\n");
			 return;
		 }
		 
		 for (i_2029 =  front_2029; i_2029 < rear_2029; i_2029++) {
			 System.out.printf("%d <--", array_2029[i_2029]);
			
		 }
		 return;
	 } 
}

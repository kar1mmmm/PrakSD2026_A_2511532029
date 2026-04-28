package pekan4_2511532029;

public class QueueArrayDriver_2511532029 {

	public static void main(String[] args) {
		QueueArray_2511532029 queue_2029 = new QueueArray_2511532029(1000);
		queue_2029.enqueue_2029(10);
		queue_2029.enqueue_2029(20);
		queue_2029.enqueue_2029(30);
		queue_2029.enqueue_2029(40);
		System.out.println("item didepan " + queue_2029.front_2029());
		System.out.println("item paling belakang " + queue_2029.rear_2029());
		System.out.println("Tampilan queue");
		queue_2029.display_2029();
		System.out.println();
		System.out.println(queue_2029.dequeue_2029() + "Dihapus dari queue");
		System.out.println("item didepan" + queue_2029.front_2029);
		System.out.println("item dibelakang" + queue_2029.rear_2029);
		System.out.println("Tampilan queue setelah satu data dihapus");
		queue_2029.display_2029();
	}

}

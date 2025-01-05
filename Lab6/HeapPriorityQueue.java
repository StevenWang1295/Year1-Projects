//Steven Wang

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeapPriorityQueue {
	private int[] heap;
	private int size;
	private int capacity;

	public HeapPriorityQueue(int capacity) {
		this.heap = new int[capacity + 1]; // Adding 1 to capacity to skip index 0
		this.size = 0;
		this.capacity = capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public void insert(int value) {
		if (isFull()) {
			System.out.println("Priority queue is full. Cannot insert.");
			return;
		}

		size ++;
		heap[size] = value;
		swim(size);
	}

	public int remove() {
		if (isEmpty()) {
			System.out.println("Priority queue is empty. Cannot delete.");
			return -1;
		}

		int min = heap[1];
		heap[1] = heap[size];
		heap[size] = 0;
		size--;
		sink(1);
		return min;
	}

	private void swim(int index) {
		while (index > 1 && heap[index] < heap[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}
	}

	private void sink(int index) {
		int minIndex = index;
		int leftChild = leftChild(index);
		int rightChild = rightChild(index);

		if (leftChild <= size && heap[minIndex] > heap[leftChild]) {
			minIndex = leftChild;}

		if (rightChild <= size && heap[minIndex] > heap[rightChild]) {
			minIndex = rightChild; }

		if (index != minIndex) {
			swap(index,minIndex);
			sink(minIndex);
		}
	}

	private int parent(int index) {
		return index/2;
	}

	private int leftChild(int index) {
		return 2*index;
	}

	private int rightChild(int index) {
		return 2*index +1;
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	public void printQueue() {
		for (int i = 1; i <= size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}

	public static List<Integer> sortWithPQ(List<Integer> list) {
		HeapPriorityQueue emptyQueue = new HeapPriorityQueue(list.size());
		for (int i = 0; i < list.size(); i++) {
			emptyQueue.insert(list.get(i));			
		}
		
		List<Integer> newList = new ArrayList<>();
		
		for (int i = 0; i < list.size(); i++) {
			newList.add(emptyQueue.remove());
		}
		
		return newList;
	}
	
	public static List<Integer> makeRandomList(int n) {
		List<Integer> randList= new ArrayList<>();
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
			randList.add(rand.nextInt(10000));
		}
		
		return randList;
	}

	public static void main(String[] args) {
		HeapPriorityQueue priorityQueue = new HeapPriorityQueue(5);
		priorityQueue.insert(3);
		priorityQueue.insert(8);
		priorityQueue.insert(1);
		priorityQueue.insert(5);
		priorityQueue.insert(2);

		priorityQueue.printQueue();

		System.out.println("Deleting max element: " + priorityQueue.remove());
		System.out.println("Deleting max element: " + priorityQueue.remove());

		priorityQueue.printQueue();
	}
}

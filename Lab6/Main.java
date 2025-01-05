//Steven Wang 

import java.util.List;

public class Main {
	public static void main(String[] args) {

		List<Integer> list10 = HeapPriorityQueue.makeRandomList(10);
		List<Integer> list100 = HeapPriorityQueue.makeRandomList(100);
		List<Integer> list500 = HeapPriorityQueue.makeRandomList(500);
		List<Integer> list1000 = HeapPriorityQueue.makeRandomList(1000);
		List<Integer> list5000 = HeapPriorityQueue.makeRandomList(5000);
		List<Integer> list10000 = HeapPriorityQueue.makeRandomList(10000);
		List<Integer> list50000 = HeapPriorityQueue.makeRandomList(50000);
		List<Integer> list100000 = HeapPriorityQueue.makeRandomList(100000);

		System.out.println("Priority Sorting Queue");
		System.out.println("Average execution time on input size " + list10.size() + ": " + computeAvg(list10, 0) + " nanoseconds");
		System.out.println("Average execution time on input size " + list100.size() + ": " + computeAvg(list100, 0) + " nanoseconds");
		System.out.println("Average execution time on input size " + list500.size() + ": " + computeAvg(list500, 0) + " nanoseconds");
		System.out.println("Average execution time on input size " + list1000.size() + ": " + computeAvg(list1000, 0) + " nanoseconds");
		System.out.println("Average execution time on input size " + list5000.size() + ": " + computeAvg(list5000, 0) + " nanoseconds");
		System.out.println("Average execution time on input size " + list10000.size() + ": " + computeAvg(list10000, 0) + " nanoseconds");
		System.out.println("Average execution time on input size " + list50000.size() + ": " + computeAvg(list50000, 0) + " nanoseconds");
		System.out.println("Average execution time on input size " + list100000.size() + ": " + computeAvg(list100000, 0) + " nanoseconds");
		 
		System.out.println("--------------------------------");
		
		System.out.println("Quick Sort");
		System.out.println("Average execution time on input size " + list10.size() + ": " + computeAvg(list10, 1) + " nanoseconds");
		System.out.println("Average execution time on input size " + list100.size() + ": " + computeAvg(list100, 1) + " nanoseconds");
		System.out.println("Average execution time on input size " + list500.size() + ": " + computeAvg(list500, 1) + " nanoseconds");
		System.out.println("Average execution time on input size " + list1000.size() + ": " + computeAvg(list1000, 1) + " nanoseconds");
		System.out.println("Average execution time on input size " + list5000.size() + ": " + computeAvg(list5000, 1) + " nanoseconds");
		System.out.println("Average execution time on input size " + list10000.size() + ": " + computeAvg(list10000, 1) + " nanoseconds");
		System.out.println("Average execution time on input size " + list50000.size() + ": " + computeAvg(list50000, 1) + " nanoseconds");
		System.out.println("Average execution time on input size " + list100000.size() + ": " + computeAvg(list100000, 1) + " nanoseconds");
		
	}

	public static long computeTime(List<Integer> list, int type) {
		long startTime = System.nanoTime();
		if (type == 0) {
			HeapPriorityQueue.sortWithPQ(list);
		} else {
			QuickSort.quickSort(list);
		}
		long endTime = System.nanoTime();

		return endTime - startTime;
	}

	public static long computeAvg(List<Integer> list, int type) {
		long total = 0;
		for (int i = 0; i < 20; i++) {
			total += computeTime(list, type);
		}
		return total/20;
	}

}

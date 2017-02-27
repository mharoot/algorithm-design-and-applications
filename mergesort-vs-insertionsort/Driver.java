import java.util.Random;

public class Driver {
	
	public static int [] generateArray(int n) {
		Random rand = new Random();
		int [] a = new int [n];
		
		for (int i = 0; i < n; i++) {
			a[i] = 1+rand.nextInt(1000000);//[1,1000000] 0 inclusive specified value is exclusive
		}
		
		return a;
	}
	
	public static long[] sortTest(int n, String type) {
		
		long runtime = 0, comparisons = 0, start = 0, stop = 0;
		Sorts sorts = new Sorts();
		int [] a = generateArray(n);
		System.out.println(sorts.isSorted(a));

		if (type == "insertion") {
			start = System.nanoTime();
			comparisons = sorts.insertionsort(a);
			stop = System.nanoTime();
			runtime = stop - start;
		} else {
			start = System.nanoTime();
			comparisons = sorts.mergesort(a);
			stop = System.nanoTime();
			runtime = stop - start;
		}
		System.out.println("Number of comparisons for "+type+" sort: "+comparisons);
		System.out.println(sorts.isSorted(a));
		System.out.println("runtime: "+runtime+"ns");
		System.out.println("\n\n");
		long [] result = {runtime, comparisons};
		
		return result;
	}
	
	public static long[] runSortTest(int iterations, int size, String type) {
		long total_runtime = 0; // total runtime
		long total_comparisons = 0;
		long [] result = new long[2];
		for (int i = 0; i < iterations; i++) {
			result = sortTest(size, type);
			total_runtime += result[0];
			total_comparisons += result[1];
		}
		
		long [] mean_result = {total_runtime/5, total_comparisons/5};
		/*System.out.println("The mean for "+size+" entries is\nruntime: "
		+mean_result[0]+"\ncomparisons: "+mean_result[1]+"\n\n");*/
		
		return mean_result;
		
	}
	
	public static void main(String[] args) {

		// runInsertionSortTest();
		long[] is10 = runSortTest(5, 10, "insertion");
		long[] is100 = runSortTest(5, 100, "insertion");
		long[] is1000= runSortTest(5, 1000, "insertion");
		long[] is10000 = runSortTest(5, 10000, "insertion");
		long[] is100000 = runSortTest(5, 100000, "insertion");
		long[] ms10 = runSortTest(5, 10, "mergesort");
		long[] ms100 = runSortTest(5, 100, "mergesort");
		long[] ms1000= runSortTest(5, 1000, "mergesort");
		long[] ms10000 = runSortTest(5, 10000, "mergesort");
		long[] ms100000 = runSortTest(5, 100000, "mergesort");
		long[] ms1000000 = runSortTest(5, 1000000, "mergesort");
		long[] ms5000000 = runSortTest(5, 5000000, "mergesort");

		System.out.println("INSERTION SORT TABLE\n-----------------------------------");
		System.out.println("The mean for "+10+" entries is\nruntime: "
				+is10[0]+"\ncomparisons: "+is10[1]+"\n\n");
		System.out.println("The mean for "+100+" entries is\nruntime: "
				+is100[0]+"\ncomparisons: "+is100[1]+"\n\n");
		System.out.println("The mean for "+1000+" entries is\nruntime: "
				+is1000[0]+"\ncomparisons: "+is1000[1]+"\n\n");
		System.out.println("The mean for "+10000+" entries is\nruntime: "
				+is10000[0]+"\ncomparisons: "+is10000[1]+"\n\n");
		System.out.println("The mean for "+100000+" entries is\nruntime: "
				+is100000[0]+"\ncomparisons: "+is100000[1]);
		System.out.println("-----------------------------------\n\n");
		
		
		System.out.println("MERGE SORT TABLE\n-----------------------------------");
		System.out.println("The mean for "+10+" entries is\nruntime: "
				+ms10[0]+"\ncomparisons: "+ms10[1]+"\n\n");
		System.out.println("The mean for "+100+" entries is\nruntime: "
				+ms100[0]+"\ncomparisons: "+ms100[1]+"\n\n");
		System.out.println("The mean for "+1000+" entries is\nruntime: "
				+ms1000[0]+"\ncomparisons: "+ms1000[1]+"\n\n");
		System.out.println("The mean for "+10000+" entries is\nruntime: "
				+ms10000[0]+"\ncomparisons: "+ms10000[1]+"\n\n");
		System.out.println("The mean for "+100000+" entries is\nruntime: "
				+ms100000[0]+"\ncomparisons: "+ms100000[1]+"\n\n");
		System.out.println("The mean for "+1000000+" entries is\nruntime: "
				+ms1000000[0]+"\ncomparisons: "+ms1000000[1]+"\n\n");
		System.out.println("The mean for "+5000000+" entries is\nruntime: "
				+ms5000000[0]+"\ncomparisons: "+ms5000000[1]+"\n\n");
		System.out.println("-----------------------------------");

		
		
	}

}

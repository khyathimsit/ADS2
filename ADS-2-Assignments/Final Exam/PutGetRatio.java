import java.util.*;

public class PutGetRatio {
	public static int[] generateRandomArray(int n){
    	//ArrayList<Integer> list = new ArrayList<Integer>(n);
    	int[] randomValues = new int[n];
    	Random random = new Random();
    	for (int i = 0; i < n; i++)
    	{
        	randomValues[i] = random.nextInt(n);
    	}
    	frequencyCounter(randomValues);
    	return randomValues;
    }

     private static double[] frequencyCounter(int[] values) {
        double totalTimePut = 0;
        double totalTimeGet = 0;
        Stopwatch timer;
        BST<Integer, Integer> binarySearchTree = new BST<>();
        for(int value : values) {
            timer = new Stopwatch();
            boolean containsValue = binarySearchTree.contains(value);
            totalTimeGet += timer.elapsedTime();
            if (!containsValue) {
                timer = new Stopwatch();
                binarySearchTree.put(value, 1);
                totalTimePut += timer.elapsedTime();
            } else {
                timer = new Stopwatch();
                int currentFrequency = binarySearchTree.get(value);
                totalTimeGet += timer.elapsedTime();

                timer = new Stopwatch();
                binarySearchTree.put(value, currentFrequency + 1);
                totalTimePut += timer.elapsedTime();
            }
        }

        int max = 0;
        timer = new Stopwatch();
        binarySearchTree.put(max, 0);
        totalTimePut += timer.elapsedTime();
        for(int value : binarySearchTree.keys()) {
            timer = new Stopwatch();
            if (binarySearchTree.get(value) > binarySearchTree.get(max)) {
                totalTimeGet += timer.elapsedTime();
                max = value;
            }
        }

        double ratio = totalTimePut / totalTimeGet;
        System.out.println("Put:" +totalTimePut);
        System.out.println("Get:" +totalTimeGet);
        System.out.println("Ratio:" +ratio);
        return null;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size: ");
        int n = sc.nextInt();
        generateRandomArray(n);
	}
}
package datastructure;

import java.util.Random;

/**
 * 数组打乱算法 
 * 
 * @author dean
 */
public class ArrayShuffle {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		arrShuffle(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}

	public static void arrShuffle(int[] arr) {
		int size = arr.length;
		Random rnd = new Random(System.nanoTime());
		for (int i = size; i > 1; i--){
			int j = rnd.nextInt(i);
			int tmp = arr[i - 1];
	        arr[i - 1] = arr[j];
	        arr[j] = tmp;
		}
	}

	/**
	 * 从最后开始遍历,当前值与它前面的随机一个交换值
	 * 这样保证每个位置随机概率为 1/n;
	 */
}

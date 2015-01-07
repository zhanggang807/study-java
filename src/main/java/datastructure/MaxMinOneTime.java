package datastructure;

/**
 * 一次找出最大值和最小值
 * 
 * @author dean
 */
public class MaxMinOneTime {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		//先打乱下数组
		ArrayShuffle.arrShuffle(arr);
		System.out.print("打乱后:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();
		maxMinOneTime(arr);
	}

	public static void maxMinOneTime(int[] arr) {
		int len = arr.length;
		int max = arr[0];
		int min = arr[0];
		int maxIndex = 1;
		int minIndex = 1;
		for (int i = 1; i < len; i++) {
			int current = arr[i];
			if (current > max){
				max = current;
				maxIndex = i;
			} else if(current < min) {
				min = current;
				minIndex = i;
			}
		}
		System.out.println("最大值是:" + max + "; 索引位置是:" + maxIndex);
		System.out.println("最小值是:" + min + "; 索引位置是:" + minIndex);
	}
	
	/**
	 * 先假设第一个值既是最大值也是最小值,然后依次判断就行 
	 */ 
	
}

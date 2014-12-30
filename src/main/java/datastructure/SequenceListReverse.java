package datastructure;

/**
 * 线性表倒置
 * 
 * @author dean
 */
public class SequenceListReverse {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		int len = arr.length;
		int n = len / 2;
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			arr[i] = arr[len - i -1];
			arr[len - i -1] = temp;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}

	/**
	 *表的大小的一半为循环次数,将第一个与最后一个交换
	 *将第二个与最后第二个交换即可,时间复杂度为O(n)
	 */
}
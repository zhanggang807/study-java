package arithmetic.sort;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;
import org.junit.Test;
import java.util.Arrays;

/**
 * 各种排序方法
 * Creted by Dean on 2019-04-22.
 */
public class Sort {

    /**
     * 选择排序
     */
    @Test
    public void testSelectionSort(){
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] >= arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     */
    @Test
    public void testBubbleSort(){
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7};

        for (int i = 0; i < arr.length - 1; i++) {//排序趟数  排n-1趟
            for (int j = 0; j < arr.length - 1 - i; j++) {//冒泡过程
                if (arr[j] >= arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入法排序
     */
    @Test
    public void testInsertionSort(){
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7};

        for (int i = 0; i < arr.length - 1; i++) {
            int iForInner = i;
            if (arr[i + 1] > arr[i]){//已经排好序的不用动
                continue;
            } else {
                for (int j = iForInner; j >= 0; j--, iForInner--) {
                    //逐一和前面的值对比。符合条件则交换值,注意这里必须要有两个指针才可以
                    if (arr[iForInner + 1] < arr[j]){
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     */
    @Test
    public void testQuickSort() {
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr
     * @param start
     * @param end
     */
    private void quickSort(int[] arr, int start, int end){
        if (start < end){
            int middle = (end - start) / 2;
            int base = arr[start];



        }
    }

}

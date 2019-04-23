package arithmetic.sort;

import com.sun.tools.corba.se.idl.constExpr.ShiftLeft;
import org.junit.Test;
import sun.misc.PostVMInitHook;

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

        quickSort(arr, 0, arr.length - 1, "all");

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序内部实现-网上找的代码
     *
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] a, int low, int high, String flag) {
        System.out.println("参数为：数组：" + Arrays.toString(a) + ", low=" + low + ", high=" + high + ", flag=" + flag);
        int start = low;
        int end = high;
        int key = a[low];

        while (end > start) {
            //从后往前比较
            //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while (end > start && a[end] >= key)
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
            while (end > start && a[start] <= key)
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。
            //左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) quickSort(a, low, start - 1, "左");//左边序列。第一个索引位置到关键值索引-1
        if (end < high) quickSort(a, end + 1, high, "右");//右边序列。从关键值索引+1到最后一个

        /**
         * 这个方法 与 我自己理解的写出来的有点不一样
         * 1、我自己理解的并没有交换值，而是替换，最后才把基准值放回去，而这个方法使用了交换值的方法
         * 2、这个方法提前一步判断了是否需要继续递归调用（高效一点点），而我的方法是直接在方法里判断是否还需要执行
         *
         * */

    }

    /**
     * 我自己写的快速排序
     */
    @Test
    public void testMyQuickSort() {
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7};

        myQuickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 我自己的理解写出来的快速排序算法
     *
     * @param arr 待排序的数组
     * @param start 开始位置
     * @param end 结束位置
     */
    public void myQuickSort(int arr[], int start, int end){
        if (start < end){//中间有元素才排序，没元素就不排了，否则无限递归，此为递归结束条件

            int low = start;//左指针
            int high = end;//右指针

            int base = arr[start];//基准值，一般为第一个值

            while (low < high) {//一次快速排序过程的结束条件，左指针向右走 和 右指针向左走，左右指针重合后结束
                //从右边开始向左遍历
                while (low < high && arr[high] >= base) {//右边的值 比基准值要大的话 不需要替换
                    high --; //指针需要左移
                }
                //从右边开始找到了比基准值 小 的值，需要把比基准值小的值移动到左边区域
                arr[low] = arr[high];

                //从左边开始向右遍历
                while (low < high && arr[low] <= base) {//左边的值 比基准值要小的话 不需要替换
                    low ++; //指针需要右移
                }
                //从左边开始找到了比基准值 大 的值，需要把比基准大的值移动到右边区域
                arr[high] = arr[low];
            }

            //一次快速排序过程完成之后，需要把基准值放在 中间位置，把基准值还原回去，否则数据就少了一个基准值了
            arr[low] = base;
            //arr[high] = base; //使用low high都可以，反正左右指针已经相遇，值是相等的

            //递归处理左边 start, left1, left2, low - 1 low, right1, right2, right3, end
            myQuickSort(arr, start, low - 1);
            //递归处理右边 start, left1, left2, left3 low, low + 1, right2, right3, end
            myQuickSort(arr, low + 1, end);
        }
    }

}

package arithmetic.search;

import arithmetic.sort.Sort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 排序算法相关
 * Creted by Dean on 2019-04-23.
 */
public class Search {

    /**
     * 线性排序
     */
    @Test
    public void testLinerSearch(){
        int key = 7;
        //int key = 10;

        boolean find = false;
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key){
                find = true;
            }
        }
        Assert.assertTrue("查找失败", find);
        System.out.println("查找成功");
    }

    /**
     * 二分查找法
     * 需要先排序
     */
    @Test
    public void testBinarySearch() {
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7};
        Sort sort = new Sort();
        sort.myQuickSort(arr, 0, arr.length - 1);
        System.out.println("二分查找前需先排序，结果为：" + Arrays.toString(arr));

        int lookup = 7;
        boolean find = binarySearch(lookup, arr, 0, arr.length - 1);

        Assert.assertTrue("查找失败", find);
        System.out.println("查找成功");
    }

    /**
     * 二分查找
     *
     * @param lookup 查找值
     * @param arr 待查找数组
     * @param start 开始
     * @param end 结束
     */
    public boolean binarySearch(int lookup, int[] arr, int start , int end){
        if (lookup < arr[start] || lookup > arr[end]){
            return false;
        }

        int middleIndex = (end + start) / 2;//要考虑多次递归后 start 和 end 的中间索引值计算问题
        int middleValue = arr[middleIndex];

        if (lookup == middleValue){          //正好等于中间值时直接返回
            return true;
        } else if (lookup < middleValue){    //比查找值小的往左找
            return binarySearch(lookup, arr, start, middleIndex - 1);
        } else {                             //比查找值大的的往右找
            return binarySearch(lookup, arr, middleIndex + 1, end);
        }
    }

}

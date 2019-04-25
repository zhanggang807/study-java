package arithmetic;

import org.junit.Assert;
import org.junit.Test;

/**
 * 小练一下
 * Creted by Dean on 2019-04-24.
 */
public class FindMaxNum {

    @Test
    public void findMaxNum() {
        int[] arr = {1, 6, 8, 2, 4, 3, 9, 5, 0, 7, 20};
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = arr[i] < max ? max : arr[i];//两两相比，依次把最大值给max,遍历结束，最大值自然就是max了
        }
        Assert.assertTrue("max = " + max, max == 20);
        System.out.println("max num is " + max);
    }

}

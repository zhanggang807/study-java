package arithmetic;

import org.junit.Assert;
import org.junit.Test;
import sun.applet.Main;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 滑动窗口相关的算法题
 * <p>
 * https://mp.weixin.qq.com/s/vM6ha7Wwp_EkfRMfLg1dZQ
 * <p>
 * 这一圈题理解下来感觉 滑动窗口比较适合处理一段连续子项的这类题目 <p>
 * 滑动窗口也可以有很多形式，数组，set，list都是可以的，具体要看滑动窗口的元素内的性质和具体用途了
 *
 * Creted by Dean on 2019-04-24.
 */
public class SlidingWindowRelatedProblem {

    /**
     * LeetCode 上第 239 号问题：滑动窗口最大值
     */
    @Test
    //public int[] maxSlidingWindow(int[] nums, int k) {
    public void maxSlidingWindow() {
        //测试写法，就不传参了，先写死吧
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;//滑动窗口大小
        //有点坑，题目里都说了数组不为空，且 k > 0。但是看了一下，测试用例里面还是有nums = [], k = 0，所以只好加上这个判断
        if (nums == null || nums.length < k || k == 0) {
            System.out.println("参数有误");
            return;
        }
        int[] result = new int[nums.length - k + 1];//result数组的大小，这里也有一个计算问题
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //在尾部添加元素，并保证左边元素都比尾部大
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);//为什么保存下标而不是保存值呢？空间利用率问题？
            //在头部移除元素
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            //输出结果
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }

        String x = Arrays.toString(result);
        Assert.assertTrue(x.equals("[3, 3, 5, 5, 6, 7]"));
        System.out.println("结果=" + x);
    }

    /**
     * 题目来源于 LeetCode 上第 3 号问题：无重复字符的最长子串
     * 最长的 不重复字符的子串的长度
     */
    @Test
    public void lengthOfLongestSubstring() {
        String str = "abcabcbb";
        int[] freq = new int[256];//动态初始化，都初化为0
        int l = 0, r = -1; //滑动窗口为s[l...r]
        int res = 0;
        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到l == s.size(); r == s.size()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while(l < str.length()){
            if(r + 1 < str.length() && freq[str.charAt(r+1)] == 0){
                r++;
                freq[str.charAt(r)]++;
            }else {   //r已经到头 || freq[s[r+1]] == 1
                freq[str.charAt(l)]--;
                l++;
            }
            //res = max(res, r-l+1);
            res = res > r - l + 1 ? res : r - l + 1;
        }
        Assert.assertTrue("最长是" + res, res == 3);
        System.out.println("计算正确，最长是" + res);
    }

    /**
     * 题目来源于 LeetCode 上第 219 号问题：存在重复元素 II
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     *
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     *
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     *
     * https://www.cnblogs.com/xiaoba1203/p/6734983.html
     * 博客中还有HashMap的解法 很直接
     */
    @Test
    public void containsNearbyDuplicate() {
        int[] nums = {1,0,1,1};
        int k = 1;
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i <= k && i < nums.length; i++){
            if (set.contains(nums[i])){
                System.out.println("存在");
                return;
            }
            set.add(nums[i]);
        }
        System.out.println("这行下面的代码执行了吗");
        for (int i = k + 1, j = 0; i < nums.length; i++, j++){
            set.remove(nums[j]);//我的理解，这里是为了维持一个大小K+1的滑动窗口？？？因为上面那个循环已经初始化好滑动窗口了
            if (set.contains(nums[i])){
                System.out.println("存在");
                return;
            }
            set.add(nums[i]);
        }
        System.out.println("不存在");
    }


    /**
     * 题目来源于 LeetCode 上第 209 号问题：长度最小的子数组的找度
     * 成功找到了则输出子数组的长度 ，没法找到则输出0
     *
     * 拓展一下，其实可以输出子数组的首尾索引
     */
    @Test
    public void minSubArrayLen() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;

        int l = 0, r = -1;    // nums[l...r]为我们的滑动窗口
        int sum = 0;
        int result = nums.length + 1;

        while (l < nums.length) { //窗口的左边界在数组范围内,则循环继续

            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else { // r 已经到头 或者 sum >= s
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                result = (r - l + 1) < result ? (r - l + 1) : result;
            }
        }

        if (result == nums.length + 1) {
            System.out.println("结果未找到");
            return;
        }

        System.out.println("成功找到结果：" + result);
    }
}

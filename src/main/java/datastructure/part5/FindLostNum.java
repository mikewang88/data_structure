package datastructure.part5;

/**
 * @Author: MikeWang
 * @Date: 2019/12/31 2:30 PM
 * @Description: 一个无序数组里有若干个正整数，范围是1-100 其中98个整数出现了偶数次，只有2个整数出现了奇数次，找到这两个出现奇数次的整数
 * 时间复杂度O(n) 空间复杂度O(1)
 */
public class FindLostNum {

    public static int[] findLostNum(int[] arry) {
        //用于存储2个出现奇数次的整数
        int result[] = new int[2];
        //第一次进行整体异或运算
        int xorResult = 0;
        for (int i = 0; i < arry.length; i++) {
            xorResult ^= arry[i];
        }
        //如果进行异或运算的结果为0，则说明输入的数组不符合题目要求
        if (xorResult == 0) {
            return null;
        }
        //确定2个整数的不同位，以此来做分组
        int separator = 1;
        while (0 == (xorResult & separator)) {
            separator <<= 1;
        }

        //第2次分组进行异或运算
        for (int i = 0; i < arry.length; i++) {
            if (0 == (arry[i] & separator)) {
                result[0] ^= arry[i];
            } else {
                result[1] ^= arry[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arry = {4,1,2,2,8,1,4,9};
        int[] result = findLostNum(arry);
        System.out.println(result[0]+","+result[1]);
    }
}

package part5;

import java.util.Arrays;

/**
 * @Author: MikeWang
 * @Date: 2019/12/25 10:19 AM
 * @Description: 获取全排列的下一个数
 * 12345---》12354
 * 12354---》12435
 * 字典算法
 * 时间复杂度O(1)
 */
public class NearestNumber {

    public static int[] findNearestNumber(int[] numbers) {
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就数字置换的边界
        int index = findTransferPoint(numbers);
        //如果数字置换边界是0，说明整个数组已经逆序了，无法得到更大的相同数字组成的整数，返回null
        if (index == 0) {
            return null;
        }
        //2.把逆序区的前一位和逆序区中刚刚大于它的数字交换位置
        //复制并入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy,index);
        return numbersCopy;

    }

    private static int[] reverse(int[] num, int index) {
        for (int i = index, j = num.length - 1; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return num;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index - 1];
        for (int i = numbers.length - 1; i > 0; i--) {
            if (head < numbers[i]) {
                numbers[index - 1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }


    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }


    // 输出数组
    private static void outputNumbers(int[] numbers) {
        for (int i : numbers) {
            System.out.println(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers ={1,2,3,4,5};
        for (int i=0;i<10;i++) {
            numbers = findNearestNumber(numbers);
            System.out.println(Arrays.toString(numbers));
        }
    }
}

package part5;

/**
 * @Author: MikeWang
 * @Date: 2019/12/23 10:05 AM
 * @Description:
 * 判断一个正整数是不是2 的N 次方
 */
public class PowerOf2 {

    public static boolean isPowerOf2(int num){
        return (num&num-1) == 0;
    }
}

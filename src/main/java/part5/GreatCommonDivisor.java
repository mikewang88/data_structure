package part5;

/**
 * 求最大公约数
 * <p>
 * 在我们的实际生活中应用非常广泛。下面举一个例子说明： 
 * “一张长方形的纸板，长75厘米、宽60厘米。现在要把它切割成若干块小正方形。
 * 有几中切法
 *
 * @Author: MikeWang
 * @Date: 2019/12/17 10:27 AM
 * @Description: 暴力枚举法 O(min(a,b))
 * 辗转相除法 O(log(max(a,b)))
 * 更相减损术 O(max(a,b))
 * 更相减损术 和移位相结合 ，算法稳定 O(log(max(a,b)))
 */
public class GreatCommonDivisor {

    public static int gcd(int a, int b) {
        if (a == b) {
            return a;
        }
        // a、b 均为偶数
        if ((a & 1) == 0 && (b & 1) == 0) {
            return gcd(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return gcd(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return gcd(a, b >> 1);
        } else {
            int big = a > b ? a : b;
            int small = a < b ? a : b;
            return gcd(big - small, small);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(25,5));
        System.out.println(gcd(100,80));
        System.out.println(gcd(27,14));
        System.out.println(gcd(24,14));
    }
}

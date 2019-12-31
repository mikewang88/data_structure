package datastructure.part5;

/**
 * @Author: MikeWang
 * @Date: 2019/12/31 10:36 AM
 * @Description:
 */
public class BestGoldMining {

    /**
     * 获得金矿最优收益
     *
     * @param w 工人数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     * @return
     */
    public static int getBestGoldMining(int w, int[] p, int[] g) {
        //创建当前结果
        int[] result = new int[w + 1];
        //填充一维数组
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j > p[i - 1]) {
                    result[j] = Math.max(result[j],result[j-p[i-1]]+g[i-1]);
                }
            }
        }
        // 返回最后一个格子的值
        return result[w];
    }
}

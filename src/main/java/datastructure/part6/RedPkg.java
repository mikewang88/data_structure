package datastructure.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author: MikeWang
 * @Date: 2020/1/9 10:41 AM
 * @Description:
 */
public class RedPkg {

    public static void main(String[] args) {
        Integer totalAmount = 1000;//红包金额  分
        Integer totalPeopleNum = 10;//红包个数
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();

        while (list.size() < totalPeopleNum-1) {
            int i = random.nextInt(totalAmount) + 1;//最低1分钱
            if (list.indexOf(i) < 0) {//非重复切割添加到集合
                list.add(i);
            }
        }
        Collections.sort(list);
        int flag = 0;
        int fl = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i) - flag;
            flag = list.get(i);
            fl += temp;
            System.out.println("红包切割金额" + AmountUtil.div(temp, 100));
        }
        //最后一个红包
        list.add(totalAmount - fl);
        System.out.println("红包切割金额" + AmountUtil.div(AmountUtil.sub(totalAmount, fl), 100));

        System.out.println(fl + AmountUtil.sub(totalAmount, fl));
    }
}

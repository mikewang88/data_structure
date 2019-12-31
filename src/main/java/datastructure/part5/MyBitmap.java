package datastructure.part5;

/**
 * @Author: MikeWang
 * @Date: 2019/12/31 3:38 PM
 * @Description:
 */
public class MyBitmap {
    //每个word 是一个long 类型的元素，对应一个64位二进制数据
    private Long[] words;
    //Bitmap 的位数大小
    private Integer size;

    public MyBitmap(int size) {
        this.size = size;
        this.words = new Long[1];
    }


}

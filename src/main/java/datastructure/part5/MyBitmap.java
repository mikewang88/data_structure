package datastructure.part5;

/**
 * @Author: MikeWang
 * @Date: 2019/12/31 3:38 PM
 * @Description:
 */
public class MyBitmap {
    //每个word 是一个long 类型的元素，对应一个64位二进制数据
    private long[] words;
    //Bitmap 的位数大小
    private int size;

    public MyBitmap(int size) {
        this.size = size;
        this.words = new long[getWordIndex(size - 1) + 1];
    }

    /**
     * 判断Bitmap 某一位的状态
     *
     * @param bitIndex 位图的第bitIndex 位
     * @return
     */
    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过Bitmap 有效范围");
        }
        int worIndex = getWordIndex(bitIndex);
        return (words[worIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把Bitmap 某一位设置为true
     *
     * @param bitIndex 位图的第bitIndex 位
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过Bitmap 有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }


    /**
     * 定位Bitmap 某一位对应的word
     * @param bitIndex
     * @return
     */
    private int getWordIndex(int bitIndex) {
        //右移6位，相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        MyBitmap bitmap = new MyBitmap(128);
        bitmap.setBit(1);
        bitmap.setBit(2);
        bitmap.setBit(3);
        bitmap.setBit(4);
        System.out.println(bitmap.getBit(2));
        System.out.println(bitmap.getBit(5));
    }
}

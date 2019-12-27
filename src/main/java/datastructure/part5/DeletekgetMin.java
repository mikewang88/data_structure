package datastructure.part5;

/**
 * @Author: MikeWang
 * @Date: 2019/12/26 10:14 AM
 * @Description: 删除k 个数字，要求剩下的数字形成的新整数尽可能小
 * 时间复杂度O(n)
 */
public class DeletekgetMin {
    /**
     * @return
     */
//    public static List<Integer> removeKDigits(List<Integer> oldlist, int k) {
//        List<Integer> newlist = new ArrayList<Integer>();
//        for (int i = 0; i < oldlist.size()-1; i++) {
//            Collections.copy(newlist, oldlist);
//            if (k < 1) {
//                break;
//            }
//            if (i+1<oldlist.size()&&newlist.get(i)>newlist.get(i+1)){
//                k--;
//                newlist.remove(i);
//                oldlist = newlist;
//            }
//        }
//        return oldlist;
//    }
    public static String removeDigits(String num, int k) {
        int newlength = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //遍历到当前数字入栈
            stack[top++] = c;

        }
        //找到栈中第一个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset<newlength && stack[offset] == '0'){
            offset++;
        }
        return offset == newlength?"0":new String(stack,offset,newlength-offset);
    }

    public static void main(String[] args) {
//        Integer[] datas = {1,2,3,4,6,5};
//        List<Integer> list = Arrays.asList(datas);
//        list = removeKDigits(list,1);
//        System.out.println(list);
        System.out.println(removeDigits("70123456",1));

    }
}

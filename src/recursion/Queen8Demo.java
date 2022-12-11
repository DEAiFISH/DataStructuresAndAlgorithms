package recursion;

public class Queen8Demo {
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.getCount());
    }
}

class Queen8 {
    /**
     * 定义一个max表示共有多少个皇后
     **/
    private int max = 8;
    /**
     * 定义一个数组，保存皇后放置的结构，比如 array = {0,4,7,5,2,6,1,3,}
     */
    private int[] array = new int[max];
    /**
     * 记录共有多少种答案
     */
    private int count = 0;

    public int getCount() {
        return count;
    }

    /**
     * 写一个方法，将换后摆放的位置输出
     */
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print((array[i] + 1) + " ");
        }
        count++;
        System.out.println();
    }

    /**
     * 查看我们放置的第n个皇后，就去检测皇后是否与前面的是否冲突
     *
     * @param n 表示第n个皇后
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //判断是否与前面的同列，同斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 编写一个方法，放置第n个皇后
     *
     * @param n
     */
    public void check(int n) {
        if (n == max) {
            print();
            return;
        }

        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //把先前这个皇后n，放置到该行第一列
            array[n] = i;
            //判断当防止第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //接着放n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，继续执行 array[n] = i;即 将第n个皇后，放置到本行的后面一个位置

        }
    }

}

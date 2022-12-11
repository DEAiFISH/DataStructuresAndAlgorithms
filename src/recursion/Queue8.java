package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue8 {
    final int MAX = 8;//八个皇后
    int[] path = new int[MAX];//储存一轮的答案
    List<int[]> res = new ArrayList<>();//储存所有答案

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.show();
    }

    /**
     * 放置皇后
     *
     * @param n 第几个皇后
     */
    private void check(int n) {
        if (n == MAX) {
            res.add(path.clone());
            return;
        }

        for (int i = 0; i < 8; i++) {
            //放置
            path[n] = i;
            if (!isConflict(n)) {
                // 若不冲突 则放置n+1个
                check(n + 1);
            }
        }
    }

    /**
     * 判断是否冲突
     *
     * @param n 第几个皇后(0-7)
     * @return true:冲突;false:不冲突
     */
    private boolean isConflict(int n) {
        for (int i = 0; i < n; i++) {
            // path.get(i) == path.get(n - 1) : 判断是否列冲突
            // Math.abs(n - i) == Math.abs(path.get(i) - path.get(n - 1)) : 判断是否对角冲突
            if (path[i] == path[n] || Math.abs(n - i) == Math.abs(path[i] - path[n])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 显示答案
     */
    public void show() {
        //计算答案
        check(0);

        //输出
        int i = 1;
        for (int[] arr : res) {
            System.out.println("第" + i++ + "个答案： " + Arrays.toString(arr));
        }
    }
}

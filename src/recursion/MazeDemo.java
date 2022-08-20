package recursion;

/**
 * @author qingyuan
 */
public class MazeDemo {
    public static void main(String[] args) {

        char[][] map = createMap(9, 9);
        showMap(map);

        setWay(map, 1, 1);
        showMap(map);


    }

    /*
    使用递归回溯来给小球找路
    说明
    1· map 表示地图
    2· i，j表示从地图哪个位置开始触发（1，1）
    3· 如果能得到map[6][5] 位置，则说明通路找到
    4· 约定：当map[i][j]为
            0 表示该点没有走过
            1 表示墙
            2 表示通路可以走
            3 表示该点已经走过，但走不通
    5· 在走迷宫时，需要确定一个策略(方法) 下->右->上->左,如果走不通，再回溯
     */

    /**
     * @param map 表示地图
     * @param i   从哪开始找
     * @param j
     * @return 如果找到通路返回true，反之
     */
    public static boolean setWay(char[][] map, int i, int j) {
        if (map[i][j] == '&') {
            //通路已经找到
            return true;
        } else {
            //如果这个点没有走过
            if (map[i][j] == ' ') {
                //按照策略走 下->右->上->左
                //假设能走通
                map[i][j] = '0';
                if (setWay(map, i + 1, j)) {
                    //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    //向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    //向左走
                    return true;
                } else {
                    //说明该点走不通，是死路
                    map[i][j] = '#';
                    return false;
                }
            } else {
                //如果 map[i][j] != ' ' , 可能为 '#','~','|','0'
                return false;
            }
        }
    }


    public static char[][] createMap(int row, int col) {
        //先创建一个二维数组模拟迷宫地图
        char[][] map = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = ' ';
            }
        }
        //使用'~'表示墙
        for (int i = 0; i < col; i++) {
            map[0][i] = '~';
            map[row - 1][i] = '~';
        }
        for (int i = 0; i < row; i++) {
            map[i][0] = '|';
            map[i][col - 1] = '|';
        }

        //设置终点
        map[row - 2][col - 2] = '&';

        //随机设置路障
        for (int i = 0; i < ((row - 1) * (col - 1) / 5); i++) {
            int v = (int) (Math.random() * (row - 2) + 1);
            int m = (int) (Math.random() * (col - 2) + 1);

            if (v == 1 && m == 1 || v == row - 2 && m == col - 2) {
                i -= 1;
                continue;
            }

            map[v][m] = '~';
        }

        return map;

    }

    /**
     * 展示地图
     *
     * @param map
     */
    public static void showMap(char[][] map) {
        System.out.println("地图的情况");
        for (char[] i : map) {
            for (char value : i) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

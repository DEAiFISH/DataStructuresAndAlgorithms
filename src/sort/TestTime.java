package sort;

public interface TestTime {
    final int MAX = 80000;

    public static void test(Sort sort) {
        int[] arr = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            arr[i] = (int) (Math.random() * MAX);
        }
        long star = System.currentTimeMillis();
        sort.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间：" + (end - star) + "毫秒");
    }
}

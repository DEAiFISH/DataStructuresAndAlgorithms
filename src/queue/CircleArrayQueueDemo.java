package queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }

    /**
     * 使用环形数组模拟队列，编写一个ArrayQueue类
     */
    class ArrayQueue {
        private int maxSize; //表示在数组的最大容量
        //front 变量的含义： front 就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
        //front 的初始值为0
        private int front; //队列头
        private int rear; //队列尾
        private int[] array; //该数组用于存放数据，模拟队列

        //创建队列的构造器
        public ArrayQueue(int arrMaxsize) {
            maxSize = arrMaxsize;
            array = new int[maxSize];
        }

        //判断队列是否为满
        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return rear == front;
        }

        //添加数据到队列
        public void addQueue(int n) {
            //判断队列是否已满
            if (isFull()) {
                System.out.println("队列已满，不能继续添加。。。");
                return;
            }
            //直接将数据加入
            array[rear] = n;
            //将rear后移，这里必须考虑取模
            rear = (rear + 1) % maxSize;
        }

        //获取队列数据，出队列
        public int getQueue() {
            //判断对列是否为空
            if (isEmpty()) {
                throw new RuntimeException("队列还为空，无法取出数据。。。");
            }

            //这里需要分析出 front是指向队列的第一个元素
            //1·先把front对应的值保留到一个临时变量
            //2·将front后移，考虑取模
            //3·将临时保存的变量返回
            int value = array[front];
            front = (front + 1) % maxSize;
            return value;
        }

        //显示队列所有数据
        public void showQueue() {
            //遍历
            if (isEmpty()) {
                System.out.println("队列为空，没有数据。。。");
                return;
            }

            //思路：从front遍历，遍历多少个元素

            for (int i = front; i < front + getSize(); i++) {
                System.out.printf("array[%d] = %d\n", i % maxSize, array[i % maxSize]);
            }
        }

        //求出当前队列有效数据的个数
        public int getSize() {
            return (rear + maxSize - front) % maxSize;
        }

        //显示队列的头数据，注意不是取出数据
        public int headQueue() {
            //判断是否为空
            if (isEmpty()) {
                throw new RuntimeException("队列为空，没有数据");
            }
            return array[front];
        }
    }
}

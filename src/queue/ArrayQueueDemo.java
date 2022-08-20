package queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }

    /**
     *     使用数组模拟队列，编写一个ArrayQueue类
     */
    class ArrayQueue {
        private int maxSize; //表示在数组的最大容量
        private int front; //队列头
        private int rear; //队列尾
        private int[] array; //该数组用于存放数据，模拟队列

        //创建队列的构造器
        public ArrayQueue(int arrMaxsize) {
            maxSize = arrMaxsize;
            array = new int[maxSize];
            front = -1;
            rear = -1;
        }

        //判断队列是否为满
        public boolean isFull() {
            return rear == maxSize - 1;
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
            rear++;
            array[rear] = n;
        }

        //获取队列数据，出队列
        public int getQueue() {
            //判断对列是否为空
            if (isEmpty()) {
                throw new RuntimeException("队列还为空，无法取出数据。。。");
            }

            return array[++front];
        }

        //显示队列所有数据
        public void showQueue() {
            //遍历
            if (isEmpty()) {
                System.out.println("队列为空，没有数据。。。");
                return;
            }
            for (int num : array) {
                System.out.println(num);
            }
        }

        //显示队列的头数据，注意不是取出数据
        public int headQueue(){
            //判断是否为空
            if(isEmpty()){
                throw new RuntimeException("队列为空，没有数据");
            }
            return array[front + 1];
        }
    }
}

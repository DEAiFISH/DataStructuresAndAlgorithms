package Stack;

/**
 * @author qingyuan
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        arrayStack.show();
    }
}


/**
 * 定义一个ArrayStack 表示栈
 */
class ArrayStack {
    /**
     * 栈的大小
     **/
    private int maxSize;
    /**
     * 数组，数组模拟栈，数据就放在数组里
     **/
    private int[] stack;
    /**
     * top表示栈顶，初始化为-1
     */
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 栈是否满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈 - push
     */
    public void push(int value) {
        //先判断是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈 - pop ，将栈顶数据返回
     */
    public int pop() {
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据。。。");
        }

        return stack[top--];
    }

    /**
     * 显示栈
     */
    public void show(){
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}

package stack;

public class Calculator {
    //数字栈
    private ArrayStack digitStack;
    //符号栈
    private ArrayStack signStack;
    public Calculator() {
        digitStack = new ArrayStack(20);
        signStack = new ArrayStack(20);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate("10+1*2+3*4/5"));
    }

    /**
     * 计算
     *
     * @param str 计算式
     * @return 结果
     */
    public double calculate(String str) {
        //从左向右依次入栈
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {//数字直接入栈
                int num = c - '0';
                i++;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {//考虑多位数的情况
                    num = (str.charAt(i++) - '0') + num * 10;
                }
                digitStack.push(num);
                i--;
            } else {
                if (!signStack.isEmpty() && priority(c) <= priority((int) signStack.peek())) {
                    //如果栈为空或者读取到的符号的优先级小于符号栈栈顶符号的优先级
                    //先计算上一个符号并将结果压入数栈
                    double x = digitStack.pop();
                    double y = digitStack.pop();
                    int sign = (int) signStack.pop();
                    if (sign == '*') {
                        digitStack.push(y * x);
                    } else {
                        digitStack.push(y / x);
                    }
                    signStack.push(c);
                } else {
                    signStack.push(c);
                }
            }
        }

        //依次弹出 计算 最后数栈中剩下的就是结果
        while (!signStack.isEmpty()) {
            double x = digitStack.pop();
            double y = digitStack.pop();
            int sign = (int) signStack.pop();
            switch (sign) {
                case '+':
                    digitStack.push(y + x);
                    break;
                case '-':
                    digitStack.push(y - x);
                    break;
                case '*':
                    digitStack.push(y * x);
                    break;
                case '/':
                    digitStack.push(y / x);
            }
        }
        return digitStack.pop();
    }

    /**
     * 符号优先级
     *
     * @param sign
     * @return
     */
    private int priority(int sign) {
        if (sign == '*' || sign == '/') {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 定义一个ArrayStack 表示栈
     */
    private class ArrayStack {
        /**
         * 栈的大小
         **/
        private int maxSize;
        /**
         * 数组，数组模拟栈，数据就放在数组里
         **/
        private double[] stack;
        /**
         * top表示栈顶，初始化为-1
         */
        private int top = -1;

        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            stack = new double[this.maxSize];
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
        public void push(double value) {
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
        public double pop() {
            if (isEmpty()) {
                //抛出异常
                throw new RuntimeException("栈空，没有数据。。。");
            }

            return stack[top--];
        }

        /**
         * 显示顶层 - peek
         *
         * @return
         */
        public double peek() {
            if (isEmpty()) {
                throw new RuntimeException("栈空，没有数据。。。");
            }
            return stack[top];
        }
    }
}

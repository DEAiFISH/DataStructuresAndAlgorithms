package Stack;


/**
 * @author qingyuan
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack(10);
        linkedStack.push(new Student("sad", 1, ""));
        linkedStack.push(new Student("sad", 2, ""));
        linkedStack.push(new Student("sad", 3, ""));
        linkedStack.push(new Student("sad", 4, ""));
        linkedStack.push(new Student("sad", 5, ""));
        linkedStack.push(new Student("sad", 6, ""));

        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.pop());
    }
}

class LinkedStack {
    Student head = new Student("", 0, "");
    int maxSize = 0;
    int top = 0;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 栈是否满
     */
    public boolean isFull() {
        return top == maxSize;
    }

    /**
     * 栈是否为空
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 入栈 - push
     */
    public void push(Student student) {
        //判断是否满
        if (isFull()) {
            System.out.println("栈已满。。。");
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = student;
        top++;
    }

    /**
     * 出栈 - pop
     */
    public Student pop() {
        //判断是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空。。。");
        }
        Student temp = head;
        for (int i = 0; i < top; i++) {
            temp = temp.next;
        }
        top--;
        temp.next = null;
        return temp;
    }
}

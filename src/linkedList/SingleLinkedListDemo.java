package linkedList;


import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList SLL = new SingleLinkedList();
//        SLL.showList();
        SLL.add(new Student("张三", 19, "da"));
        SLL.add(new Student("李四", 18, "da"));
        SLL.add(new Student("w武", 14, "da"));
        SLL.add(new Student("老王", 17, "da"));
        SLL.add(new Student("a王", 14, "da"));
        SLL.add(new Student("z王", 14, "da"));

//        SLL.updateLinked(new Student("lisi", 20, "da"));
//        SLL.showList();
//        System.out.println();
//        SLL.updateLinked(new Student("李四", 20, "da"));
//        SLL.showList();
//        System.out.println();
//        SLL.updateLinked(new Student("z王", 20, "da"));
//        SLL.showList();
//        System.out.println();
//
//        SLL.delete("张三");
//        SLL.showList();
//        System.out.println();
//        SLL.delete("老王");
//        SLL.showList();

        SLL.showList();
        System.out.println();
        SLL.LastPrint();
    }

}

class SingleLinkedList {
    //先初始化一个头节点，头节点不要动存放具体数据
    private Student head = new Student("0", 0, "0");

    //将节点添加到单向链表中：
    //1·找到当前链表最后的节点
    //2·将最后这个节点的next 指向 新的节点

    public void add(Student student) {
        //因为head节点不能动，所以我们需要一个辅助遍历temp
        Student temp = head;

        //遍历链表，找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }

            //排序  按名字从大到小,年龄从小到大
            if (student.compareTo(temp.next) > 0) {
                Student t = temp.next;
                temp.next = student;
                student.next = t;
                return;
            }
            temp = temp.next;
        }

        //当退出循环时，temp就指向看了链表的最后一个节点
        temp.next = student;
    }

    /**
     * 显示链表（遍历）
     */
    public void showList() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空。。。");
            return;
        }

        //因为head不能动，因此我们需要一个辅助变量来遍历
        Student temp = head.next;

        while (true) {
            System.out.println(temp);
            //判断是否到链表最后
            if (temp.next == null) {
                break;
            }

            temp = temp.next;
        }
    }


    /**
     * 修改链表
     *
     * @param student
     */
    public void updateLinked(Student student) {
        if (head.next == null) {
            System.out.println("链表为空。。。");
            return;
        }

        //因为head不能动，因此我们需要一个辅助变量来遍历
        Student temp = head.next;


        while (true) {

            //判断是否到链表最后
            if (temp == null) {
                System.out.println("没有找到该学生。。。");
                return;
            } else if (temp.name.equals(student.name)) {
                temp.name = student.name;
                temp.age = student.age;
                temp.describe = student.describe;
                break;
            }

            temp = temp.next;

        }
    }

    /**
     * 删除链表中的元素
     *
     * @param name
     */
    public void delete(String name) {
        if (head == null) {
            System.out.println("链表为空。。。");
            return;
        }

        Student temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到该学生。。。");
                break;
            }

            if (temp.next.name.equals(name)) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }
    }

    /**
     * 求链表有几个节点
     *
     * @return 节点数
     */
    public int num() {
        int n = 0;
        Student temp = head;
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }
        return n;
    }


    /**
     * 逆序输出链表
     *
     */
    public void LastPrint(){
        //方法一 ： 栈方法
        if(head.next == null){
            System.out.println("链表为空。。。");
            return;
        }

        Student temp = head.next;
        Stack<Student> stack = new Stack<>();

        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        while(stack.size() > 0){
            System.out.println(stack.pop());
        }


        //方法二 ： 先反转，再遍历  （会破坏链表原有的结构）
    }
}
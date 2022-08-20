package LinkedList;

public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList csll = new CircleSingleLinkedList();
        csll.showBoy();
        csll.addBoy(5);
        csll.showBoy();
        System.out.println();
        csll.countBoy(1, 2, 5);
    }
}

/**
 * 创建一个环形单向链表
 */
class CircleSingleLinkedList {
    /**
     * 创建一个first节点，当前没有编号
     **/
    private Boy first = new Boy(-1);

    /**
     * 添加小孩节点，构建环形链表
     */
    public void addBoy(int nums) {
        //nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums 数据错误");
            return;
        }

        //辅助指针帮助构建环形链表
        Boy curBoy = null;
        //使用for来创建我们的环形链表

        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            //如果是第一个节点
            if (i == 1) {
                first = boy;
                //构成环
                first.setNext(first);
                //让cutBoy指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = curBoy.getNext();
            }

        }
    }

    //遍历当前环形链表
    public void showBoy() {
        if (first.getNext() == null) {
            System.out.println("环形链表为空");
            return;
        }

        //因为first不能动，因此我们需要使用一个辅助指针完成遍历
        Boy curBoy = first;
        do {
            System.out.println("小孩的编号" + curBoy.getNo());
            curBoy = curBoy.getNext();
        } while (curBoy != first);
    }

    //根据用户输入，计算出小孩出圈的顺序

    /**
     * @param startNo  表示第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少个小孩
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数出错，请重新输入");
            return;
        }

        //创建一个辅助指针helper，帮助小孩出圈
        Boy helper = first;
        //事先将helper指向最后小孩节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        //小孩报数前，需先让 first 和 helper 移动 startNo - 1  次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数是，让 first 和 helper 指针同时移动 countNum - 1 次
        while (true) {
            if (helper == first) {
                System.out.println(helper.getNo() + "号小孩留到最后");
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first.getNo() + "号小孩出圈");

            helper.setNext(first.getNext());
            first = first.getNext();

        }

    }
}

/**
 * 创建一个Boy类表示一个节点
 */
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

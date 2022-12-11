package stack;

import org.jetbrains.annotations.NotNull;

class Student implements Comparable<Student> {
    public String name;
    public int age;
    public String describe;
    //指向下一个节点
    public Student next;

    //指向上一个节点
    public Student pre;

    public Student() {
    }

    public Student(String name, int age, String describe) {
        this.name = name;
        this.age = age;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", describe='" + describe + '\'' +
                '}';
    }


    /**
     * 排序  按年龄从小到大，名字从大到小
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(@NotNull Student o) {
        if (o instanceof Student) {
            int result = -this.name.compareTo(o.name);

            if (result == 0) {
                result = this.age - o.age;
            }
            return result;
        }
        throw new RuntimeException("请传入Student参数。。。");
    }
}

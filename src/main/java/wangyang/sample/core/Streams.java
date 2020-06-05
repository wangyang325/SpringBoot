package wangyang.sample.core;
import org.testng.annotations.Test;
import wangyang.sample.common.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    // ��������
    @Test
    public void orderList() {
        // -- test data
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");

        // method1
        list.sort((x, y) -> x.compareTo(y));
        list.forEach(System.out::println);

        // method2
        list.stream().sorted().forEach(System.out::println);
    }

    // ɾ���ظ�����Ԫ��
    @Test
    public void uniqeList() {
        // -- test data
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("a");

        List<Student> list1 = new ArrayList<Student>();
        list1.add(new Student("1", "a"));
        list1.add(new Student("2", "b"));
        list1.add(new Student("4", "d"));
        list1.add(new Student("4", "d"));

        List<String> rs = list.stream().distinct().collect(Collectors.toList());
        rs.forEach(System.out::println);

        System.out.println("------------------");

        List<String> rs1 = list1.stream().map(Student::getName).distinct().collect(Collectors.toList());
        rs1.forEach(System.out::println);
    }

    @Test
    public void searchList() {
        // -- test data
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("a");

        List<Student> list1 = new ArrayList<Student>();
        list1.add(new Student("1", "a"));
        list1.add(new Student("2", "b"));
        list1.add(new Student("4", "d"));
        list1.add(new Student("4", "d"));

        // ----
        list.stream().filter((x) -> x.equals("a")).forEach(System.out::println);
        list1.stream().filter((x) -> x.getName().equals("a")).forEach((x) -> System.out.print(x.getName()));
    }

    @Test
    public void sumList() {
        List<Student> ls = new ArrayList<Student>();
        ls.add(new Student("1", "a", 60));
        ls.add(new Student("2", "b", 70));
        ls.add(new Student("3", "c", 80));
        ls.add(new Student("4", "d", 90));

        Integer rs = ls.stream().map(Student::getMark).reduce(Integer::sum).get();
        System.out.println(rs);
    }

    @Test
    public void partitionListByVal() {
        List<Integer> ls = new ArrayList<Integer>();
        // 10, 5, 1, 12, 6, 11, 7
        ls.add(10);
        ls.add(5);
        ls.add(1);
        ls.add(12);
        ls.add(6);
        ls.add(7);
        ls.add(11);
        ls.add(7);

        int k = 7;

        // ----
        List<Integer> left = ls.stream().filter((x) -> x < k).collect(Collectors.toList());
        List<Integer> equal = ls.stream().filter((x) -> x == k).collect(Collectors.toList());
        List<Integer> right = ls.stream().filter((x) -> x > k).collect(Collectors.toList());
        left.addAll(equal);
        left.addAll(right);
        left.forEach(System.out::println);
    }
}

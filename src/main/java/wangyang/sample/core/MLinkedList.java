package wangyang.sample.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class MLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Object> lst = new ArrayList<Object>();
        lst.add(null);
        lst.add("a");
        lst.add("a");
        lst.add(null);
        lst.add("b");
        lst.add("a");
        lst.add("a");
        lst.add(null);

        MLinkedList lstObj = new MLinkedList();

        lstObj.deleteDup(0, lst);
        System.out.println("Final--");
        for (Object value : lst) {
            System.out.println(value);
        }
    }

    // 2.1 Remove Dups: Write code to remove duplicates from an unsorted linked
    // list.
    public void deleteDup(int start, List<Object> list) {
        if (start < list.size()) {
            System.out.println("Index : " + start);
            for (Object value : list) {
                System.out.println(value);
            }

            Object nowDObj = list.get(start);
            if (nowDObj == null) {
                list.remove(start);
                start = start - 1;
            } else {
                String nowD = nowDObj.toString();
                int listSize = list.size();
                int nowInx = start + 1;
                while (true) {
                    if (nowInx < listSize) {
                        if (nowD.equals(list.get(nowInx))) {
                            list.remove(nowInx);
                            listSize = listSize - 1;
                        } else {
                            nowInx = nowInx + 1;
                        }
                    } else {
                        break;
                    }
                }
            }
            deleteDup(start + 1, list);
        } else {
            return;
        }
    }
    public void deleteLinked(int inx, List<Object> list) {
        List link = new LinkedList();

    }

    // 2.2 Return Kth to Last
    public void subList() {
        int k = 2;
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("a");

        for (int i = k - 1; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle
    // (i.e., any node but
    // the first and last node, not necessarily the exact middle) of a singly linked
    // list, given only access to
    // that node.
    public void delMidNode() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        int k = list.size() / 2;
        if (list.size() % 2 == 0) {
            k = list.size() / 2 - 1;
        }
        list.remove(list.get(k));

        list.forEach(System.out::println);
    }

    // 2.4 Partition: Write code to partition a linked list around a value x, such
    // that all nodes less than x come
    // before all nodes greater than or equal to x. Ifxis contained within the list,
    // the values of x only need
    // to be after the elements less than x (see below). The partition element x can
    // appear anywhere in the
    // "right partition"; it does not need to appear between the left and right
    // partitions.
    public void partitionList() {

    }

    // 2.5 Sum Lists: You have two numbers represented by a linked list, where each
    // node contains a single
    // digit. The digits are stored in reverse order, such that the Vs digit is at
    // the head of the list. Write a
    // function that adds the two numbers and returns the sum as a linked list.
    public void sum2Lists() {
        List<Integer> list1 = new LinkedList<Integer>();
        list1.add(7);
        list1.add(1);
        list1.add(6);
        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(5);
        list2.add(9);
        list2.add(2);

        Collections.reverse(list1);
        Collections.reverse(list2);

        String l1 = "";
        for (Integer val : list1) {
            l1 = l1 + val;
        }
        String l2 = "";
        for (Integer val : list2) {
            l2 = l2 + val;
        }
        int newI = Integer.parseInt(l1) + Integer.parseInt(l2);

        String newS = String.valueOf(newI);
        char[] chr = newS.toCharArray();

        List<Integer> lsI = new LinkedList<Integer>();
        for (char val : chr) {
            lsI.add(Integer.valueOf(Character.toString(val)));
        }

        Collections.reverse(lsI);
        lsI.forEach(System.out::println);
    }

    // 2.6 Palindrome: Implement a function to check if a linked list is a
    // palindrome
    public void isPalindrome() {
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("b");
        list1.add("a");
        list1.add("a");

        String ns = String.join("", list1);
        Collections.reverse(list1);
        String ns1 = String.join("", list1);
        System.out.println(ns.equals(ns1));
    }

    // 2.7 Intersection; Given two (singly) linked lists, determine if the two lists
    // intersect. Return the intersecting
    // node. Note that the intersection is defined based on reference, not value.
    // That is, if the kth
    // node of the first linked list is the exact same node (by reference) as the j
    // t h node of the second
    // linked list, then they are intersecting.
    public void findInteraction(int st1, int st2, List<String> l1, List<String> l2, List<List<String>> lrs) {
        if (st1 < l1.size()) {
            int est1 = -1;
            int est2 = -1;
            int len = 0;
            for (int i = st1; i < l1.size(); i++) {
                for (int j = st2; j < l2.size(); j++) {
                    if (l1.get(i).equals(l2.get(j))) {
                        est1 = i;
                        est2 = j;
                        len = len + 1;
                        break;
                    }
                }
            }

            if (len > 0) {
                int count = 1;
                for (int i = est1 + 1; i < l1.size(); i++) {
                    int j = est2 + count;

                    if (j < l2.size()) {
                        if (l1.get(i).equals(l2.get(j))) {
                            len = len + 1;
                        } else {

                        }
                    } else {

                    }
                    count = count + 1;
                }
            }
        }
    }

    @Test
    public List<String> cutList(int st, int len, List<String> ls) {

        // test data
        ls = new ArrayList<String>();
        ls.add("0");
        ls.add("1");
        ls.add("2");
        ls.add("3");

        st = 0;
        len = 4;

        // --------
        List<String> rs = new ArrayList<String>();
        if ((st + len - 1) < ls.size()) {
            for (int i = st; i < st + len; i++) {
                rs.add(ls.get(i));
            }
            rs.forEach(System.out::println);
            return rs;
        } else {
            return null;
        }
    }

}

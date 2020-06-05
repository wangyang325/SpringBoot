package wangyang.sample.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BTree.orderArray();
    }

    public static void orderArray() {
        int[] arr = { 1, 9, 6 };

        BTree bTree = new BTree();
        TreeNode root = bTree.new TreeNode(1);

        for (int i = 1; i < arr.length; i++) {
            TreeNode leaf = bTree.new TreeNode(arr[i]);
            insertD(root, leaf);
        }

        List<Integer> list = new ArrayList<Integer>();
        bTree.inOrderI(root, list);

        for (int a : list) {
            System.out.println(a);
        }

    }

    public static void insertD(TreeNode tn, TreeNode newN) {
        if (tn != null) {
            if (newN.idata > tn.idata) {
                if (tn.right != null) {
                    insertD(tn.right, newN);
                } else {
                    tn.right = newN;
                }
            } else {
                if (tn.left != null) {
                    insertD(tn.left, newN);
                } else {
                    tn.left = newN;
                }
            }
        }
    }

    public static void practise() {

        BTree bTree = new BTree();
        TreeNode root = bTree.new TreeNode("A");

        TreeNode l11 = bTree.new TreeNode("B");
        TreeNode l111 = bTree.new TreeNode("D");
        TreeNode l112 = bTree.new TreeNode("E");

        TreeNode l12 = bTree.new TreeNode("C");
        TreeNode l121 = bTree.new TreeNode("G");
        TreeNode l122 = bTree.new TreeNode("F");

        root.left = l11;
        root.right = l12;

        l11.left = l111;
        l11.right = l112;

        l12.left = l121;
        l12.right = l122;

        List<String> list = new ArrayList<String>();

//		bTree.inOrder(root, list);
//
//		for (int a : list) {
//			System.out.println(a);
//		}

//		list = new ArrayList<String>();
//
//		bTree.inOrder(root, list);
//
//		for (String a : list) {
//			System.out.println(a);
//		}
        System.out.println("----------------");
        list = bTree.inOrderT(root);

        for (String a : list) {
            System.out.println(a);
        }
    }

    public void inOrder(TreeNode node, List<String> list) {
        if (node != null) {
            inOrder(node.left, list);
            list.add(node.data);
            inOrder(node.right, list);
        }
    }

    public void inOrderI(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrderI(node.left, list);
            list.add(node.idata);
            inOrderI(node.right, list);
        }
    }

    public void preOrder(TreeNode node, List<String> list) {
        if (node != null) {
            list.add(node.data);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }

    public List<String> preOrderT(TreeNode root) {
        List<String> lst = new ArrayList<String>();

        if (root == null) {
            return lst;
        }

        Stack<TreeNode> sk = new Stack<TreeNode>();

        TreeNode context = root;
        sk.push(context);

        while (sk.isEmpty() == false) {
            TreeNode current = sk.pop();
            lst.add(current.data);

            if (current.right != null) {
                sk.push(current.right);
            }

            if (current.left != null) {
                sk.push(current.left);
            }
        }
        return lst;
    }

    public List<String> inOrderT(TreeNode root) {
        List<String> lst = new ArrayList<String>();

        if (root == null) {
            return lst;
        }

        Stack<TreeNode> sk = new Stack<TreeNode>();
        sk.push(root);

        TreeNode cur = root;

        while (sk.isEmpty() == false || cur != null) {

            while (cur != null) {
                sk.push(cur);
                cur = cur.left;
            }

            TreeNode node = sk.pop();
            lst.add(node.data);
            cur = node.right;
        }
        return lst;
    }

    public void postOrder(TreeNode node, List<String> list) {
        if (node != null) {
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.data);
        }
    }

    class TreeNode {

        public String data;
        public TreeNode left;
        public TreeNode right;

        public int idata;

        public TreeNode(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int data) {
            this.idata = data;
            this.left = null;
            this.right = null;
        }
    }
}

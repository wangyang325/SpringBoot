package wangyang.sample.core;

import java.util.*;

public class BasicC {
    // String and Char
    public void editString(String str) {

        // Get char by location
        str.charAt(1);

        // char to string
        Character.toString(str.charAt(1));

        // basic
        str.contains("xx");
        str.startsWith("xx");
        str.endsWith("xx");
        str.equals("xx");
        str.indexOf("xxx");
        str.replace("old", "new");
        String[] arrys = str.split("xx");
        str.valueOf("");
        String.join("", arrys);
        str.toLowerCase();
        str.equalsIgnoreCase("");

        // String to array
        char[] strArry = str.toCharArray();
        Arrays.sort(strArry);

        for (int i = 0; i < strArry.length - 1; i++) {
            if (strArry[i] == strArry[i + 1]) {

            }
        }

        // reverse
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb = sb.reverse();
        sb.toString();

        // rotates s towards left by d
        int d = 1;
        String ans = str.substring(d) + str.substring(0, d);
    }

    // Collection
    public void editCollection() {

        // *****  ArrayList
        List<String> lst = new ArrayList<String>();
        lst.add("a");
        lst.add("b");

        // *****  LinkedList
        List<String> lstl = new LinkedList<String>();
        lstl.add("a");
        lstl.add("b");

        // reverse
        Collections.reverse(lst);

        // List to string
        String.join("", lst);

        // basic
        lst.contains("");
        lst.indexOf("");
        lst.isEmpty();
        lst.remove("");
        lst.removeAll(new ArrayList<String>());
        // list to array
        lst.toArray();

        for (String value : lst) {

        }
        for (int i = 0; i < lst.size(); i++) {

        }
        lst.stream().forEach(System.out::println);

        // *****  HashMap
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");

        // keys
        map.keySet();
        // set
        map.entrySet();
        // values
        map.values();

        map.remove("");
        map.containsValue("");
        map.isEmpty();
        map.replace("", "");
        map.values();
        map.size();

        for (String key : map.keySet()) {
            map.get(key);
        }

        map.entrySet().stream().forEach((e) -> System.out.println("Key:" + e.getKey()+ " value:" + e.getValue()));
    }

    // Stack
    public void editStack() {
        Stack sk = new Stack();
        sk.peek();
        sk.pop();
        sk.push("");
        sk.isEmpty();
        sk.search("");
    }
}

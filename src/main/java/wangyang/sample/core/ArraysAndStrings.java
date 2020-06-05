package wangyang.sample.core;
import java.util.Arrays;

public class ArraysAndStrings {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArraysAndStrings obj = new ArraysAndStrings();
        // boolean rs = obj.isPalindrome("waterbottle");
        System.out.println(obj.rotateString1("waterbottle", "rbottlewate"));

//		boolean rs = obj.isUnique("A i A");
//		System.out.println(rs);

        // System.out.println(obj.repalceTo20P("Mr 3ohn Smith "));
        // System.out.println(obj.checkCharacter("pale", "bale"));
        // System.out.println(obj.compressionStr("aabcccccaaa"));
    }

    // �ַ����Ƿ�Ψһ �����
    public boolean isUnique(String str) {
        boolean rs = true;

        if (str != null && str.length() != 0) {
            str = str.replace(" ", "");
            char[] strArry = str.toCharArray();
            Arrays.sort(strArry);

            for (int i = 0; i < strArry.length - 1; i++) {
                if (strArry[i] == strArry[i + 1]) {
                    rs = false;
                    break;
                }
            }
        }

        return rs;
    }

    // Palindrome �������п����ַ���
    public boolean isPalindrome(String inStr) {
        boolean rs = false;
        if (inStr != null) {
            // StringBuilder ��תreverse
            StringBuilder sb = new StringBuilder();
            sb.append(inStr);
            sb = sb.reverse();
            String rsS = sb.toString();

            if (inStr.equals(rsS)) {
                rs = true;
            }
        }
        return rs;
    }

    // Permutation
    public boolean arePermutation(String str1, String str2) {
        boolean rs = true;
        // Get lenghts of both strings
        int n1 = str1.length();
        int n2 = str2.length();

        // If length of both strings is not same,
        // then they cannot be Permutation
        if (n1 != n2) {
            return false;
        }

        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();

        // Sort both strings
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (ch1[i] != ch2[i]) {

                return false;
            }

        return rs;
    }

    // replace space to %20
    public String repalceTo20P(String str) {
        if (str != null && str.length() != 0) {
            String nStr = str.trim();
            nStr = nStr.replace(" ", "%20");
            return nStr;
        }
        return str;
    }

    // One Away: There are three types of edits that can be performed on strings:
    // insert a character,
    // remove a character, or replace a character. Given two strings, write a
    // function to check if they are
    // one edit (or zero edits) away.
    public boolean checkCharacter(String str1, String str2) {
        int count = 0;
        if (str1 != null && str2 != null) {

            int l1 = str1.length();
            int l2 = str2.length();

            if (Math.abs(l1 - l2) > 1) {
                return false;
            } else {
                char[] arry1 = str1.toCharArray();
                char[] arry2 = str2.toCharArray();
                int i = 0;
                int j = 0;
                while (i < l1 && j < l2) {
                    if (arry1[i] != arry2[j]) {
                        count = count + 1;
                        if (l1 != l2) {
                            if (l1 > l2) {
                                j--;
                            } else {
                                i--;
                            }
                        }
                    }
                    i++;
                    j++;
                }
            }
        }
        if (count > 1) {
            System.out.println("wrong bit: " + count);
            return false;
        } else {
            return true;
        }
    }

    // String Compression: Implement a method to perform basic string compression
    // using the counts
    // of repeated characters. For example, the string aabcccccaaa would become
    // a2blc5a3, If the
    // "compressed" string would not become smaller than the original string, your
    // method should return
    // the original string. You can assume the string has only uppercase and
    // lowercase letters (a - z).
    public String compressionStr(String str) {
        String rs = "";
        String before = "";
        int count = 1;
        if (str != null && str.length() != 0) {
            char[] arry = str.toCharArray();
            before = Character.toString(arry[1]);
            for (int i = 1; i < arry.length; i++) {
                if (Character.toString(arry[i]).equals(before)) {
                    count = count + 1;
                    if (i == arry.length - 1) {
                        rs = rs + before + count;
                    }
                } else {
                    rs = rs + before + count;
                    before = Character.toString(arry[i]);
                    count = 1;
                }
            }
            str = rs;
        }
        return str;
    }

    // Rotate Matrix: 90 degrees
    public void rotateMatrix(int N, int mat[][]) {
        // Consider all squares one by one
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = mat[x][y];

                // Move values from right to top
                mat[x][y] = mat[y][N - 1 - x];

                // Move values from bottom to right
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

                // Move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

                // Assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
    }

    public boolean rotateString(String str1, String str2) {
        if (str1 != null && str2 != null && str1.length() == str2.length()) {
            for (int i = 1; i < str1.length(); i++) {
                if (str1.equals(leftrotate(str2, i))) {
                    return true;
                }
            }
        }
        return false;
    }

    // function that rotates s towards left by d
    public String leftrotate(String str, int d) {
        String ans = str.substring(d) + str.substring(0, d);
        return ans;
    }

    public boolean rotateString1(String str1, String str2) {
        if (str1 != null && str2 != null && str1.length() == str2.length()) {
            for (int i = 1; i < str1.length(); i++) {
                String sub = str1.substring(i);
                if (str2.startsWith(sub)) {
                    return true;
                }
            }
        }
        return false;
    }

}

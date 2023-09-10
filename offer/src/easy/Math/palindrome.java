package easy.Math;

import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome1(9));
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        int sum = 0 ;
        for (Iterator<Integer> i1 = integers.iterator(); i1.hasNext();){
            for(Iterator<Integer> i2 = integers.iterator(); i2.hasNext();){

                sum+=i1.next()+i2.next();
            }
        }
        System.out.println(
                sum
        );
        System.out.println(palindrome.getB()+"   "+palindrome.getC());

    }
    private static final boolean a = initA();
    private static boolean initA() {
        return true;
    }
    public static final boolean b =a;
    private static boolean getB() {
        return b;
    }
    public static final boolean c =b;
    private static boolean getC() {
        return c;
    }


    /**
     * 面试题9、回文数
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        Deque<String> first = new LinkedList<>();
        Deque<String> last = new LinkedList<>();
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (char c : chars){
            first.add(String.valueOf(c));
            last.add(String.valueOf(c));
        }

        StringBuilder q1 = new StringBuilder();
        StringBuilder q2 = new StringBuilder();
        while (!first.isEmpty()){
            String s1 = first.pollFirst();
            q1.append(s1);
            String s2 = last.pollLast();
            q2.append(s2);
        }
        System.out.println(q1);
        System.out.println(q2);
        return q1.toString().equals(q2.toString());

    }

    /**
     *
     * 题解：除与取模->直接翻转
     * @param x
     * @return
     */
    public static boolean isPalindrome1(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}

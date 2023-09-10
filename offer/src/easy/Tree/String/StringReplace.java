package easy.Tree.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串处理的题目往往涉及复杂的流程以及条件情况，如果直接上手写程序，一不小心就会写出极其臃肿的代码。
 * 因此，为了有条理地分析每个输入字符的处理方法，我们可以使用自动机这个概念：
 * 我们的程序在每个时刻有一个状态 s，每次从序列中输入一个字符 c，并根据字符 c 转移到下一个状态 s'。这样，我们只需要建立一个覆盖所有情况的从 s 与 c 映射到 s' 的表格即可解决题目中的问题。
 *
 */
public class StringReplace {

    public static void main(String[] args) {
        int ans=0;
        System.out.println((ans=ans * 10 + '2' - '0'));
        System.out.println((ans * 10 + '2' - '0'));
        System.out.println(-Integer.MIN_VALUE);//越界
        System.out.println(-(float) Integer.MIN_VALUE);
        System.out.println(-(double) Integer.MIN_VALUE);
    }

    //自动机解决字符串转换成整数的问题
    public int strToInt(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));//转为字符
        }
        return (int) (automaton.sign * automaton.ans);//符号*数值
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private final Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';//字符相乘得出拼接后的结果
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) :
                    Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {//用于判断字符c是不是数字形式的字符
            return 2;
        }
        return 3;
    }
}


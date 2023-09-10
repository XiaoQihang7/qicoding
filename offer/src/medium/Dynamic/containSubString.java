package medium.Dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class containSubString {
    public static void main(String[] args) {
        containSubString containSubString = new containSubString();
        System.out.println(containSubString.lengthOfLongestSubstring("dvdfvdfecaav")); //6
        System.out.println(containSubString.lengthOfLongestSubstring1("abceddrr")); //1

        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("d");
        strings.add("c");
        String error = strings.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(error);
    }


    /**
     * offer48、最长不含重复字符的子字符串
     * <p>
     * 此处，愈发觉得动态规划的题确实得好好规划，路径要考虑周全
     * 如何保存每一对字串进行拼接呢
     *
     * @param s
     * @return
     */
    //错误解法，考虑不周全，没有考虑到字符串前不重复的字符个数
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = 0, j = 0;
        ArrayList<String> strings = new ArrayList<>();
        for (char c : chars) {
            String str = String.valueOf(c);
            if (!strings.contains(str)) {
                strings.add(str);
            } else {
                String s1 = strings.stream().map(String::toString).collect(Collectors.joining());
                System.out.println(s1);
                len = Math.max(len, s1.length());
                strings.clear();
                if (j <= chars.length - 1)
                    strings.add(String.valueOf(chars[j - 1]));//将上一个字符加入，防止遗漏最大值
                if (!strings.contains(str))
                    strings.add(str);
            }
            j++;
        }
        String s1 = strings.stream().map(String::toString).collect(Collectors.joining());
        System.out.println(s1);
        len = Math.max(len, s1.length());
        return len;
    }

    //动态规划+哈希表
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int index = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            tmp = tmp < j - index ? tmp + 1 : j - index; //dp[j],若中间出现重复字符，保存最大的字符串长度，重置当前长度
            res = Math.max(res, tmp); //保存最大字符串长度
        }
        return res;
    }


    //双指针+动态规划
    public int length(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }

}

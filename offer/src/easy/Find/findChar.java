package easy.Find;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//offer50、找出第一个只出现一次的字符
public class findChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("zz"));
    }
    public static char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if (chars.length==1){
            return chars[0];
        }
        char p=' ';
        int count=0;
        for (char c : chars) {
            count = 0;
            //System.out.print(temp);
            for (char aChar : chars) { //要考虑到重复元素
                if (c == aChar) {
                    count++;
                }
            }
            if (count == 1) {
                p = c;
                break;
            }

        }
        return p;
    }

    //hash
    public char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));//第一次存为true，重复存为false
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }

    //有序hash表
    public char firstUniqChar2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}

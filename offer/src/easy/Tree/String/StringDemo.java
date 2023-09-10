package easy.Tree.String;

public class StringDemo {
    public static void main(String[] args) {
//        System.out.println(replaceSpace("We are happy."));
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    /**
     * 替换空字符串
     * @param s
     * @return
     */
    public static String replaceSpace(String s) {
//        char[] chars = s.toCharArray();
//        StringBuilder str = new stringbuilder();
//        for(char c:chars){
//            if(String.valueOf(c).equals(" ")){
//                str.append("%20");
//            }else {
//                str.append(c);
//            }
//        }
//        return str.toString();
        return s.replace(" ","%20");
    }

    /**
     *字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     */
    public static String reverseLeftWords(String s, int n) {//可以使用三次翻转来解决问题，不用额外申请空间
        String s1 = s.substring(0, n);
        System.out.println(s);//只是截取并没有取出截取的值
        return s.substring(n).concat(s1);
    }

}

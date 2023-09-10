package medium.Dynamic;

public class translationNums {
    public static void main(String[] args) {
        System.out.println(translationNum(12258));
        System.out.println(translateNum());

        System.out.println(-(long) Integer.MIN_VALUE);
    }

    /**
     * offer46、把数字翻译成字符串
     *
     * 我发现做动态规划的题，有一个不好处理的就是，路径很多，不好处理
     *
     * @param num 输入数字 0-2^31
     * @return
     */
    public static int translationNum(int num){
        int r=1,p=0,q=0;
        String s = String.valueOf(num);
        int length = s.length();
        for (int i=0;i<length;i++){
            p=q;
            q=r;
            r=0;
            r+=q;
            if (i==0){
                continue;
            }
            String str = s.substring(i - 1, i + 1);
            if (Integer.parseInt(str)<=25&&Integer.parseInt(str)>=10){
                r+=p;
            }
        }
        return r;
    }

    static int translateNum() {
        return f(12258);
    }

    static int f(int num) {
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return f(num / 10) + f(num / 100);
        } else {
            return f(num / 10);
        }
    }
}

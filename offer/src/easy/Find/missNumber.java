package easy.Find;

//offer53、寻找0-n-1中缺失的数字（这是一个递增数组）
public class missNumber {

    public static void main(String[] args) {
        missNumber missNumber = new missNumber();
        System.out.println(missNumber.missingNumber(new int[]{1}));
    }

    //暴力查找
    public int missingNumber(int[] nums) {
        if (nums.length==1&&nums[0]==0){
            return nums[0]+1;
        }else if (nums[0]!=0){
            return nums[0]-1;
        }

        for (int i=1;i<=nums.length-1;i++){ //写num[n+1]总有bug存在，输入[0],出错
            if (nums[i]!=nums[i-1]+1){
                return nums[i-1]+1;
            }
        }
        return nums[nums.length-1]+1;
    }

    //解法二：利用数组特性
    public int missingNumber1(int[] nums) {
        if (nums[0]==1) return 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=i) return i;
        }
        return nums.length;
    }

    //解法三：二分查找
    public int missingNumber2(int[] nums){
        int r=0,len=nums.length-1;
        while (r<=len){
            int m=(r+len)/2;
            if (nums[m]==m) r=m+1;
            else len=m-1;

        }
        return r;
    }
}

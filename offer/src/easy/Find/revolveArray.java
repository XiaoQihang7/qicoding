package easy.Find;

//Offer11、旋转数组中找最小值
public class revolveArray {
    public static void main(String[] args) {
        System.out.println(minArray1(new int[]{3, 4, 5, 1, 2}));
    }

    //numbers = [3,4,5,1,2],简化版选择排序
    public static int minArray(int[] numbers) {
        int min=numbers[0];
        for (int i=0;i<numbers.length-1;i++){
            if (numbers[i+1]<min){
                min=numbers[i+1];
            }
        }
        return min;
    }

    //利用旋转数组的规律(进行了0-n次旋转)，二分查找
    public static int minArray1(int[] numbers) {
        int One = 0;
        int length = numbers.length-1;
        while (One<length){
            int find=(One+length)/2;
            if (numbers[find]>numbers[length]) One=find+1; //中间数据大于最右数据，还在递增,向右查找
            else if(numbers[find]<numbers[length]) length=find; //中间小于最右，向左查找
            else length--;

        }
        return numbers[One];
    }
}

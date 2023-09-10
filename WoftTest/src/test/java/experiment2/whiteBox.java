package experiment2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class whiteBox {
    public static int getNmb(int x,int y) {
        int z;
        int ret;
        if (x<0){ //判定覆盖1：x=-1
            z=y-x;
        }
        else{ //判2：x=1 //条件1，x=12
            z=y+x;
        }
        if(z<10 && y>0) { //判1：z=2.y=1 （T,T）//条件1.z=11,y=-1 (F,F),ret=11*12
            ret = z*y;
        }
        else { //判2、z=0，y=-1(T,F) //条件组合.x=10,z=11,y=1(F,T)
            ret= z*x;
        }
        return ret;
    }

    @ParameterizedTest
    @CsvSource({"-1,1,2","1,-1,0","12,-1,132","10,1,110"})
    void testOfNum(int x,int y,int ret){ //语句覆盖+判定覆盖
        assertEquals(ret,whiteBox.getNmb(x,y)); //不可一个输入参数一个自定义参数
    }

    @Test
    public void testNum(){
        System.out.println(whiteBox.getNmb(-1, 1)); //2 ,两个if
        System.out.println(whiteBox.getNmb(1, -1)); //0 ，两个else，判定覆盖，语句覆盖
        System.out.println(whiteBox.getNmb(12, -1)); //132,条件覆盖，判定条件覆盖
        System.out.println(whiteBox.getNmb(10, 1)); //110,条件覆盖，判定条件覆盖,条件组合覆盖

    }
}

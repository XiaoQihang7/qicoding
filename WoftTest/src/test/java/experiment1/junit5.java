package experiment1;

import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class junit5 {
    public String getBMIType(double weight,double height){
//        double weight=120.5,height=172.1;
        double bmi = 0.0;
        String result = "";
        if( weight>0 && height>0){
            //1.计算bmi
            bmi = weight/(height*height);
            //2.根据bmi判断所属健康分类
            if(bmi<18.5){
                result = "偏瘦";
            }else if(bmi<24){
                result = "正常";
            }else if(bmi<28){
                result = "偏胖";
            }else{
                result = "肥胖";
            }
        }else{
            throw new MyException( "Weight or height error!");
        }
        return result;
    }

    junit5 junit5;

//固定片段
    @BeforeEach
    public void setUp(){
        this.junit5=new junit5();
    }

    @AfterEach
    public void tearDown(){
        this.junit5=null;
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testBMI() {
        //异常处理
        MyException myException = assertThrows(MyException.class, () -> junit5.getBMIType(-1, -1));
        System.out.println(myException);
        //由条件测试+测试用例
        System.out.println(Config.getConfigFile(55.1, 1.72));
        System.out.println(Config.getConfigFile(61.1, 1.82));
        System.out.println(Config.getConfigFile(76.2, 1.562));
        System.out.println(Config.getConfigFile(70.2, 1.903));
    }

    @ParameterizedTest
    @MethodSource
    void testCapitalize(double input1,double input2,String result) {
        assertEquals(result, Config.getConfigFile(input1,input2));
    }
    static List<Arguments> testCapitalize() {
        ArrayList<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.arguments("76.2","1.562","在Windows上运行体重76.2,身高1.562,得出bmi为肥胖"));
        arguments.add(Arguments.arguments("76.2","1.562","在Windows上运行体重70.2,身高1.903,得出bmi为正常"));
        return arguments;
    }
}



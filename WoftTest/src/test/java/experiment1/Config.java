package experiment1;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Config {

//    @Disabled
//    @Test
    public static String getConfigFile(double w,double h) {
        String os = System.getProperty("os.name").toLowerCase();
        junit5 junit5 = new junit5();
        String bmiType = junit5.getBMIType(w, h);
        if (os.contains("win")) {
            return "在Windows上运行" + "体重"+w+","+"身高"+h+",得出bmi为"+bmiType;
        }
        if (os.contains("mac") || os.contains("linux") || os.contains("unix")) {
            return "在mac或linux上运行" + "体重"+w+","+"身高"+h+",得出bmi为"+bmiType;
        }
        throw new UnsupportedOperationException();
    }
}
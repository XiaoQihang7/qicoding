package test.spi;

import java.util.ServiceLoader;


/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/9/25 20:09
 *
 * 验证JavaSpi机制
 */
public class JavaSpiLog {
    private static final ServiceLoader<Logger> LOGGERLOADER = ServiceLoader.load(Logger.class);

    public static  void log (String message){
        for (Logger logger : LOGGERLOADER){
            logger.log(message);
        }
    }
}

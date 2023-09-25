package test.spi;

import test.spi.Logger;

/**
 * @author qi_coding
 * @version 1.00
 * @time 2023/9/25 20:26
 *
 * Spi服务提供者
 */
public class LoggerImpl implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("输出日志为："+msg);
    }
}

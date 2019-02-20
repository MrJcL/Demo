package common;

import org.junit.Test;

/**
 * @program: Demo
 * @Date: 2019/2/20 20:10
 * @Author: LiJc
 * @Description:
 */
public class JFreeChartTest {

    /**
     * 创建折线图
     */
    @Test
    public void test1(){
        JFreeChartUtil chartUtil = new JFreeChartUtil();
        double[][] data = new double[][] { { 5, 5.2, 5.7, 5.7, 5.4, 5.3, 5.1, 4.3 },
                { 4.8, 4.4, 4.6, 4.7, 4.7, 4.6, 4.4, 4.3 } };
        String[] rowKeys = { "A", "B"};
        String[] colKeys = { "2019年1月", "2019年2月", "2019年3月", "2019年4月", "2019年5月", "2019年6月", "2019年7月", "2019年8月" };
        chartUtil.createTimeXYCharSimple(rowKeys, colKeys, data, "aa.jpg");
    }

    /**
     * 创建折线图（设置刻度）
     */
    @Test
    public void test2(){
        JFreeChartUtil chartUtil = new JFreeChartUtil();
        double[][] data = new double[][] { { 5, 5.2, 5.7, 5.7, 5.4, 5.3, 5.1, 4.3},
                { 4.8, 4.4, 4.6, 4.7, 4.7, 4.6, 4.4, 4.3} };
        String[] rowKeys = { "A", "B"};
        String[] colKeys = { "2019年1月", "2019年2月", "2019年3月", "2019年4月", "2019年5月", "2019年6月", "2019年7月", "2019年8月" };
        chartUtil.createTimeXYCharSimpleSetBoundAndTick(rowKeys, colKeys, data, "aa1.jpg", 4, 6, 0.5);
    }
}

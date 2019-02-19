package common;

import org.junit.Test;

import java.util.*;

/**
 * @program: Demo
 * @Date: 2019/2/19 11:25
 * @Author: LiJc
 * @Description:
 */
public class ExcelTest {

    /**
     * 生成excel 03
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i=0; i<3; i++){
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("姓名：","机器人"+i);
            map.put("年龄：","2"+i);
            map.put("身高：","19"+i);
            list.add(map);
        }
        ExcelUtil excel = new ExcelUtil();
        String fileName = "测试.xls";
        String filePath = "C:" + excel.getSavePath(null, fileName);
        boolean flag = excel.writeExcel(list, filePath);
        if(flag){
            System.out.println("生成成功!文件路径："+filePath);
        }else{
            System.out.println("生成失败！");
        }
    }

    /**
     * 生成excel 07
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i=0; i<3; i++){
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("姓名：","机器人"+i);
            map.put("年龄：","2"+i);
            map.put("身高：","19"+i);
            list.add(map);
        }
        ExcelUtil excel = new ExcelUtil();
        String fileName = "测试.xlsx";
        String filePath = "C:" + excel.getSavePath(null, fileName);
        boolean flag = excel.writeExcel(list, filePath);
        if(flag){
            System.out.println("生成成功!文件路径："+filePath);
        }else{
            System.out.println("生成失败！");
        }
    }

}

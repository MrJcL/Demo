package common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: Demo
 * @Date: 2019/2/19 10:50
 * @Author: LiJc
 * @Description:
 */
public class ExcelUtil {

    public boolean writeExcel(List<Map<String, Object>> list, String path) throws Exception {
        String postfix = path.substring(path.lastIndexOf(".") + 1, path.length());
        if (postfix.equals("xls")) {
            writeXls(list, path);
        } else if (postfix.equals("xlsx")) {
            writeXlsx(list, path);
        }else {
            System.out.println("文件后缀名不正确！");
            return false;
        }
        return true;
    }

    /**
     * read the Excel file
     *
     * @param path
     *            the path of the Excel file
     * @return
     * @throws IOException
     */
    public List<Map<String, Object>> readExcel(String path) throws IOException {
        String postfix = path.substring(path.lastIndexOf(".") + 1, path.length());
        if (postfix.equals("xls")) {
            return readXls(path);
        } else if (postfix.equals("xlsx")) {
            return readXlsx(path);
        }
        return null;
    }

    /**
     * Read the Excel 2010
     *
     * @param path
     *            the path of the excel file
     * @return
     * @throws IOException
     */
    public List<Map<String, Object>> readXlsx(String path) throws IOException {

        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    Map<String, Object> map = new HashMap<>();
                    for (int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++) {
                        if(xssfSheet.getRow(0).getCell(cellNum)==null||xssfRow.getCell(cellNum)==null)
                            continue;
                        map.put(xssfSheet.getRow(0).getCell(cellNum) + "", getValue(xssfRow.getCell(cellNum)));
                    }
                    list.add(map);
                }
            }
        }
        xssfWorkbook.close();
        is.close();
        return list;
    }

    /**
     * Read the Excel 2003-2007
     *
     * @param path
     *            the path of the Excel
     * @return
     * @throws IOException
     */
    public List<Map<String, Object>> readXls(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    Map<String, Object> map = new HashMap<>();
                    for (int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++) {
                        if(hssfSheet.getRow(0).getCell(cellNum)==null)
                            continue;
                        map.put(hssfSheet.getRow(0).getCell(cellNum) + "", getValue(hssfRow.getCell(cellNum)));
                    }
                    list.add(map);
                }
            }
        }
        hssfWorkbook.close();
        is.close();
        return list;
    }


    @SuppressWarnings({ "static-access", "deprecation" })
    private String getValue(XSSFCell xssfRow) {
        if (xssfRow == null) {
            return "";
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue()).trim();
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
            return String.valueOf(dataFormatter.formatCellValue(xssfRow)).trim();
            // return String.valueOf(xssfRow.getNumericCellValue()).trim();
        } else {
            return String.valueOf(xssfRow.getStringCellValue()).trim();
        }
    }

    @SuppressWarnings({ "static-access", "deprecation" })
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell == null) {
            return "";
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue()).trim();
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
            return String.valueOf(dataFormatter.formatCellValue(hssfCell)).trim();
            // return String.valueOf(hssfCell.getNumericCellValue()).trim();
        } else {
            return String.valueOf(hssfCell.getStringCellValue()).trim();
        }
    }

    public void writeXls(List<Map<String, Object>> list, String path) throws Exception {
        if (list == null) {
            return;
        }
        int countColumnNum = list.size();
        HSSFWorkbook book = new HSSFWorkbook();
        //	设置样式start
        HSSFCellStyle cellStyle = setStyleXls(book);
        //	设置样式end
        HSSFSheet sheet = book.createSheet("sheet");
        // option at first row.
        HSSFRow firstRow = sheet.createRow(0);

        // Set-->数组
        String[] options = new String[list.get(0).keySet().size()];
        list.get(0).keySet().toArray(options);

        for (int j = 0; j < options.length; j++) {
            HSSFCell cell = firstRow.createCell(j);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new HSSFRichTextString(options[j]));
        }

        for (int i = 0; i < countColumnNum; i++) {
            HSSFRow row = sheet.createRow(i + 1);
            Map<String, Object> map = list.get(i);
            for (int column = 0; column < options.length; column++) {
                HSSFCell cell = row.createCell(column);
                cell.setCellStyle(cellStyle);
                cell.setCellValue((map.get(options[column])==null?"":map.get(options[column])) + "");
            }
        }
        File file = new File(path);
        FileUtils.forceMkdir(file.getParentFile());
        OutputStream os = new FileOutputStream(file);
        book.write(os);
        os.close();
    }

    public void writeXlsx(List<Map<String, Object>> list, String path) throws Exception {
        if (list == null) {
            return;
        }
        // XSSFWorkbook
        int countColumnNum = list.size();
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFCellStyle cellStyle = setStyleXlsx(book);
        XSSFSheet sheet = book.createSheet("studentSheet");

        // option at first row.
        XSSFRow firstRow = sheet.createRow(0);
        // Set-->数组
        String[] options = new String[list.get(0).keySet().size()];
        list.get(0).keySet().toArray(options);
        for (int j = 0; j < options.length; j++) {
            XSSFCell cell = firstRow.createCell(j);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(new XSSFRichTextString(options[j]));
        }
        for (int i = 0; i < countColumnNum; i++) {
            XSSFRow row = sheet.createRow(i + 1);
            Map<String, Object> map = list.get(i);
            for (int column = 0; column < options.length; column++) {
                XSSFCell cell = row.createCell(column);
                cell.setCellStyle(cellStyle);
                cell.setCellValue((map.get(options[column])==null?"":map.get(options[column])) + "");
            }
        }
        File file = new File(path);
        FileUtils.forceMkdir(file.getParentFile());
        OutputStream os = new FileOutputStream(file);
        book.write(os);
        os.close();
    }

    /**
     * 设置样式
     * @param book
     * @return
     */
    public HSSFCellStyle setStyleXls(HSSFWorkbook book){
        HSSFCellStyle cellStyle = book.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        cellStyle.setBorderBottom(BorderStyle.THIN);//下边框    
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框    
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框    
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        return cellStyle;
    }

    /**
     * 设置样式
     * @param book
     * @return
     */
    public XSSFCellStyle setStyleXlsx(XSSFWorkbook book){
        XSSFCellStyle cellStyle = book.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        cellStyle.setBorderBottom(BorderStyle.THIN);//下边框    
        cellStyle.setBorderLeft(BorderStyle.THIN);//左边框    
        cellStyle.setBorderTop(BorderStyle.THIN);//上边框    
        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
        return cellStyle;
    }

    /**
     * 返回文件绝对路径
     *
     * @param subPath
     * @param fileName
     * @return
     */
    public String getSavePath(String subPath, String fileName) {

        // 处理子路径
        if (!StringUtils.isBlank(subPath)) {
            subPath += "/";
        } else {
            subPath = "";
        }

        // 处理日期路径
        Date date = new Date();
        SimpleDateFormat yyyyFt = new SimpleDateFormat("yyyy");
        SimpleDateFormat MMFt = new SimpleDateFormat("MM");
        SimpleDateFormat ddFt = new SimpleDateFormat("dd");
        SimpleDateFormat HHFt = new SimpleDateFormat("HH");
        String datePath = MessageFormat.format("{0}/{1}/{2}/{3}/", yyyyFt.format(date), MMFt.format(date), ddFt.format(date),
                HHFt.format(date));

        return "/" + subPath + datePath + getNewFileName(fileName);
    }

    /**
     * 构建新文件名称
     *
     * @param fileName
     * @return
     */
    public String getNewFileName(String fileName) {
        String[] names = fileName.split("[\\.]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
        String dateString = sdf.format(new Date());
        return names[0] + "-" + dateString + "." + names[1];
    }
}

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class ReadWord {
    public static void main(String[] arg){
        String path = "C:\\Users\\mi\\Documents\\Tencent Files\\876672460\\FileRecv\\常安佳苑东侧.docx";
        readFromword(path);
        //writeToExcel();
    }

    public static void readFromword(String filePath){
        try{
            FileInputStream in = new FileInputStream(filePath);//载入文档 //如果是office2007  docx格式
            if(filePath.toLowerCase().endsWith("docx")){
                //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
                XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息
                // List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();//得到段落信息
                Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格

                while(it.hasNext()){

                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows=table.getRows();
                    //读取每一行数据
                    for (int i = 1; i < rows.size(); i++) {
                        XWPFTableRow  row = rows.get(i);
                        //读取每一列数据
                        List<XWPFTableCell> cells = row.getTableCells();
                        for (int j = 0; j < cells.size(); j++) {
                            XWPFTableCell cell=cells.get(j);
                            //输出当前的单元格的数据
                            System.out.println(cell.getText());
                        }
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void writeToExcel() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();

        HSSFCell cell = row.createCell((short) 0);
        cell.setCellValue("点位名称");

        cell = row.createCell((short) 1);
        cell.setCellValue("所属区");

        cell = row.createCell((short) 2);
        cell.setCellValue("维护日期");

        cell = row.createCell((short) 3);
        cell.setCellValue("维护措施");

        //cell = row.createCell((short) 4);

        for (int i = 0; i < 3; i++) {
            row = sheet.createRow((int) i + 1);

            // 第四步，创建单元格，并设置值
            row.createCell((short) 0).setCellValue("学校");
            row.createCell((short) 1).setCellValue("武汉");
            row.createCell((short) 2).setCellValue("2019");
            row.createCell((short) 3).setCellValue("整改");
            // row.createCell((short) 2).setCellValue((double) stu.getAge());
            // cell = row.createCell((short) 3);
            // cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(stu
            // .getBirth()));
        }

        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\mi\\Desktop\\messs" + ".xls");
            // 选中项目右键，点击Refresh，即可显示导出文件
            wb.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

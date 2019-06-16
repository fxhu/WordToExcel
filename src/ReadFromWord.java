import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadFromWord implements Runnable{
    private BaseInfo info = null;
    private ArrayList<String> parentPath;
    public ReadFromWord(BaseInfo info, ArrayList<String>paths){
        this.info = info;
        this.parentPath = paths;
    }

    public void run(){
        boolean flag = false;
        for (int i = 0; i < parentPath.size(); i++){
            readFromword(parentPath.get(i));
        }
    }

    public void readFromword(String filePath){
        try{
            //BaseInfo info = new BaseInfo();
            ArrayList<String> lists = new ArrayList<String>();

            FileInputStream in = new FileInputStream(filePath);
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
                            //System.out.println(cell.getText());
                            lists.add(cell.getText());
                        }
                    }
                }
                info.set(lists.get(1), lists.get(2),lists.get(3), lists.get(4), lists.get(5), lists.get(6), lists.get(7), lists.get(8), lists.get(9), lists.get(10), lists.get(11), lists.get(12), lists.get(13), lists.get(14), lists.get(15), lists.get(16), lists.get(17));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

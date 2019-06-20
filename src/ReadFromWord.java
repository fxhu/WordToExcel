import javafx.concurrent.Task;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

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

    //读取docx格式
    public void readFromword(String filePath){
        FileInputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        File f = new File(filePath);
        String fileName = f.getName();
        try{
            if(filePath.toLowerCase().endsWith("docx")){
                Readdocx(in, fileName);
            }else if (filePath.toLowerCase().endsWith("doc")){
                Readdoc(in, fileName);
            }
            else {
                ReadException(fileName);
            }
            in.close();
        }catch (Exception ex){
            ex.printStackTrace();
            ReadException(fileName);
        }
    }

    public ArrayList<String> Readdoc(FileInputStream in, String fileName) throws IOException {
        ArrayList<String> lists = new ArrayList<String>();
        HWPFDocument hwpf = new HWPFDocument(in);//得到word文档的信息
        Range range = hwpf.getRange();
        TableIterator it = new TableIterator(range);
        int writeFlag = 0;
        while(it.hasNext()){
            Table table = (Table) it.next();
            int titleNum = 0;
            for (int i = 0; i < table.numRows(); i++) {
                TableRow row = table.getRow(i);
                //读取每一列数据
                for (int j = 0; j < row.numCells() / 2 * 2; j++){
                    TableCell td = row.getCell(j);
                    if (writeFlag % 2 != 0){
                        for(int k = 0; k < td.numParagraphs(); k++){
                            Paragraph para = td.getParagraph(k);
                            String s = para.text();
                            //去除后面的特殊符号
                            if(null != s && !"".equals(s)){
                                s = s.substring(0, s.length()-1);
                            }
                            lists.add(s);
                            System.out.print(s + "\t");
                        }
                    }
                    writeFlag++;
                }
            }
            info.set(fileName, lists.get(0), lists.get(1),lists.get(2), lists.get(3), lists.get(4), lists.get(5), lists.get(6), lists.get(7), lists.get(8),lists.get(9), lists.get(10), lists.get(11), lists.get(12), lists.get(13), lists.get(14), lists.get(15), lists.get(16), lists.get(17), lists.get(18), lists.get(19), lists.get(20));

        }
        return  lists;
    }

    public ArrayList<String> Readdocx(FileInputStream in, String fileName)throws IOException{
        ArrayList<String> lists = new ArrayList<String>();
        XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息
        Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格
        int writeFlag = 0;
        while(it.hasNext()){
            XWPFTable table = it.next();
            List<XWPFTableRow> rows=table.getRows();
            //读取每一行数据
            int titleNum = 0;
            for (int i = 0; i < rows.size(); i++) {
                XWPFTableRow  row = rows.get(i);
                //读取每一列数据
                List<XWPFTableCell> cells = row.getTableCells();
                for (int j = 0; j < cells.size()/2  * 2; j++) {
                    XWPFTableCell cell = cells.get(j);
                    if (writeFlag % 2 != 0){
                        lists.add(cell.getText());
                    }
//                            if (ReadText(cell, titleNum)){
//                                cell = cells.get(j + 1);
//                                lists.add(cell.getText());
//                            }
                    writeFlag++;
                }
            }
            info.set(fileName, lists.get(0), lists.get(1),lists.get(2), lists.get(3), lists.get(4), lists.get(5), lists.get(6), lists.get(7), lists.get(8),lists.get(9), lists.get(10), lists.get(11), lists.get(12), lists.get(13), lists.get(14), lists.get(15), lists.get(16), lists.get(17), lists.get(18), lists.get(19), lists.get(20));
        }
        return lists;
    }

    //文件读取异常
    public void ReadException(String fileName) {
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            Future<Boolean> excuteResult = executor.submit(new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    int result = JOptionPane.showConfirmDialog(null, "当前文件  " + fileName + "  不符合要求, 是否继续？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        return false;
                    } else {
                        System.exit(0);
                    }
                    return true;
                }
            });
            executor.shutdown();
            boolean proceed = excuteResult.get();
            while (true) {
                if (!proceed) {
                    break;
                }
                Thread.sleep(10);
            }
            info.set(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean ReadText( XWPFTableCell cell, int titlenum){
        String title = cell.getText();
        if ((title.indexOf(Titile.Id) != -1) && titlenum == 0 ){
            return true;
        }
        if ((title.indexOf(Titile.FireHydrant) != -1) && titlenum == 1 ){
            return true;
        }
        if ((title.indexOf(Titile.FireHydrantAdress) != -1) && titlenum == 2 ){
            return true;
        }
        if ((title.indexOf(Titile.Coordinates) != -1) && titlenum == 3 ){
            return true;
        }
        if ((title.indexOf(Titile.Road) != -1) && titlenum == 4 ){
            return true;
        }
        if ((title.indexOf(Titile.FireFightingInstitutions) != -1) && titlenum == 5 ){
            return true;
        }
        if ((title.indexOf(Titile.PlacementForm) != -1) && titlenum == 6 ){
            return true;
        }
        if ((title.indexOf(Titile.PhoneNumber) != -1) && titlenum == 7 ){
            return true;
        }
        if ((title.indexOf(Titile.Departments) != -1) && titlenum == 8 ){
            return true;
        }
        if ((title.indexOf(Titile.WaterFrom) != -1) && titlenum == 9 ){
            return true;
        }
        if ((title.indexOf(Titile.Diameter) != -1) && titlenum == 10 ){
            return true;
        }
        if ((title.indexOf(Titile.WaterSourceDy) != -1) && titlenum == 11 ){
            return true;
        }if ((title.indexOf(Titile.Pressure) != -1) && titlenum == 12 ){
            return true;
        }
        if ((title.indexOf(Titile.Attribution) != -1) && titlenum == 13 ){
            return true;
        }
        if ((title.indexOf(Titile.PipeNetwork) != -1) && titlenum == 14 ){
            return true;
        }
        if ((title.indexOf(Titile.AvailableState) != -1) && titlenum == 15 ){
            return true;
        }
        if ((title.indexOf(Titile.Watersupply) != -1) && titlenum == 16 ){
            return true;
        }
        if ((title.indexOf(Titile.InterfaceForm) != -1) && titlenum == 17 ){
            return true;
        }
        if ((title.indexOf(Titile.DateOfCompletion) != -1) && titlenum == 18 ){
            return true;
        }
        if ((title.indexOf(Titile.Inspectionrecord) != -1) && titlenum == 19 ){
            return true;
        }
        if ((title.indexOf(Titile.Remarks) != -1) && titlenum == 20 ){
            return true;
        }
        return false;
    }
}

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class WriteToExcel implements Runnable {
    private BaseInfo info = new BaseInfo();
    private int num;
    private String filePath;
    private ArrayList<BaseInfo>infos = new ArrayList<BaseInfo>();

    public WriteToExcel(BaseInfo info, int num, String filePath){
        this.info = info;
        this.num = num;
        this.filePath = filePath;
    }

    public void run(){
        for (int i = 0; i < num; i++){
            BaseInfo tmp = info.get();
            if (tmp.getFileName()!= null && tmp.getFileName() != ""){
                infos.add(tmp);
            }
        }
        Write();
    }

    public void Write(){
        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("sheet1");
            HSSFRow row = sheet.createRow(0);

            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            row.setRowStyle(style);
            HSSFCell cell = null;
            cell = row.createCell((short) 0);
            cell.setCellValue("文件名");
            cell = row.createCell((short) 1);
            cell.setCellValue("编号");
            cell = row.createCell((short) 2);
            cell.setCellValue("消火栓名称");
            cell = row.createCell((short) 3);
            cell.setCellValue("消火栓地址");
            cell = row.createCell((short) 4);
            cell.setCellValue("地理坐标");
            cell = row.createCell((short) 5);
            cell.setCellValue("所属路段");
            cell = row.createCell((short) 6);
            cell.setCellValue("管辖机构");
            cell = row.createCell((short) 7);
            cell.setCellValue("放置形式");
            cell = row.createCell((short) 8);
            cell.setCellValue("联系方式");
            cell = row.createCell((short) 9);
            cell.setCellValue("所属管网");
            cell = row.createCell((short) 10);
            cell.setCellValue("取水形式");
            cell = row.createCell((short) 11);
            cell.setCellValue("管网直径");
            cell = row.createCell((short) 12);
            cell.setCellValue("水源动态");
            cell = row.createCell((short) 13);
            cell.setCellValue("管网压力");
            cell = row.createCell((short) 14);
            cell.setCellValue("归属");
            cell = row.createCell((short) 15);
            cell.setCellValue("管网形式");
            cell = row.createCell((short) 16);
            cell.setCellValue("可用状态");
            cell = row.createCell((short) 17);
            cell.setCellValue("供水单位");
            cell = row.createCell((short) 18);
            cell.setCellValue("接口形式");
            cell = row.createCell((short) 19);
            cell.setCellValue("建造日期");
            cell = row.createCell((short) 20);
            cell.setCellValue("检查记录");
            cell = row.createCell((short) 21);
            cell.setCellValue("备注");

            for (int i = 0; i < infos.size(); i++){
                row = sheet.createRow(i+1);
                row.createCell((short) 0).setCellValue(infos.get(i).getFileName());
                row.createCell((short) 1).setCellValue(infos.get(i).getId());
                row.createCell((short) 2).setCellValue(infos.get(i).getFireHydrant());
                row.createCell((short) 3).setCellValue(infos.get(i).getFireHydrantAdress());
                row.createCell((short) 4).setCellValue(infos.get(i).getCoordinates());
                row.createCell((short) 5).setCellValue(infos.get(i).getRoad());
                row.createCell((short) 6).setCellValue(infos.get(i).getFireFightingInstitutions());
                row.createCell((short) 7).setCellValue(infos.get(i).getPlacementForm());
                row.createCell((short) 8).setCellValue(infos.get(i).getPhoneNumber());
                row.createCell((short) 9).setCellValue(infos.get(i).getDepartments());
                row.createCell((short) 10).setCellValue(infos.get(i).getWaterFrom());
                row.createCell((short) 11).setCellValue(infos.get(i).getDiameter());
                row.createCell((short) 12).setCellValue(infos.get(i).getWaterSourceDy());
                row.createCell((short) 13).setCellValue(infos.get(i).getPressure());
                row.createCell((short) 14).setCellValue(infos.get(i).getAttribution());
                row.createCell((short) 15).setCellValue(infos.get(i).getPipeNetwork());
                row.createCell((short) 16).setCellValue(infos.get(i).getAvailableState());
                row.createCell((short) 17).setCellValue(infos.get(i).getWatersupply());
                row.createCell((short) 18).setCellValue(infos.get(i).getInterfaceForm());
                row.createCell((short) 19).setCellValue(infos.get(i).getDateOfCompletion());
                row.createCell((short) 20).setCellValue(infos.get(i).getInspectionrecord());
                row.createCell((short) 21).setCellValue(infos.get(i).getRemarks());
            }
            String outputPath = new File(filePath).getParent()+"\\output.xls";
            FileOutputStream fout = new FileOutputStream(outputPath);
            wb.write(fout);
            fout.close();
            JOptionPane.showMessageDialog(null, "已成功将word转换成Excel文件，文件路径：" + outputPath, "OK", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

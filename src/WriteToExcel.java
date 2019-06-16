import java.io.FileOutputStream;
import java.util.ArrayList;

public class WriteToExcel implements Runnable {
    private BaseInfo info = null;
    private int num;
    public WriteToExcel(BaseInfo info, int num){
        this.info = info;
        this.num = num;
    }

    public void run(){
        for (int i = 0; i < num; i++){
           info.get();
        }
    }

    public void Write(){
        try {
            FileOutputStream fout = new FileOutputStream("C:\\Users\\mi\\Desktop\\messs" + ".xls");
            fout.write(new String("测试").getBytes());
            //wb.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

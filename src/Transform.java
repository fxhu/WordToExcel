import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

public class Transform {
    private static String WordPath;
    private static int filenum;
    //private static ArrayList<BaseInfo> BaseInfos;

    public static void main(String[] arg){
        ArrayList<String> paths = new ArrayList<String>();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame("文档转换工具");
        f.setLayout(null);
        JLabel lab = new JLabel("请选择文件夹:");
        JButton button = new JButton("请选择");
        JButton button1 = new JButton("开始");
        JTextField path = new JTextField();

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        lab.setBounds(45, 25, 150, 20);
        path.setBounds(150, 25, 250, 30);
        button.setBounds(400, 25, 80, 30);
        button1.setBounds(400, 400, 80, 30);
        chooser.setBounds(150, 70, 480, 430);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = chooser.showDialog(f, "请选择");
                if(flag==JFileChooser.APPROVE_OPTION){
                    //获得该文件
                    File f = chooser.getSelectedFile();
                    WordPath = f.getPath();
                    System.out.println(WordPath);
                    path.setText(WordPath);

                    File file = new File(WordPath);
                    int num = 0;
                    if (file.isDirectory()){
                        File[] files = file.listFiles();
                        if (files.length > 0){
                            for (int i = 0; i < files.length; i++){
                                paths.add(files[i].getAbsolutePath());
                                filenum++;
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "当前路径下文件数量为0", "警告", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "请选择正确的路径", "警告", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        f.add(lab);
        f.add(path);
        f.add(button);
        f.add(button1);

        f.setSize(700, 550);
        f.setBackground(Color.white);
        f.setLocation(550, 300);
        f.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BaseInfo  info = new BaseInfo();
                ReadFromWord pro = new ReadFromWord(info, paths);
                WriteToExcel com = new WriteToExcel(info, filenum, WordPath);

                new Thread(pro).start();
                new Thread(com).start();
            }
        });
    }
}

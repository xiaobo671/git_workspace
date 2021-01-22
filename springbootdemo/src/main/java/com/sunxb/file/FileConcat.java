package com.sunxb.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileConcat {

    public static void main(String[] args) {

//        FileSplit();
          FileConcat();
    }




    public static void FileSplit(){
        System.out.println("start splits file...");
        String fileFullName = "studyvideo.mp4";
        String fileName =  fileFullName.split("\\.")[0];
        String fileType = fileFullName.split("\\.")[1];
        FileInputStream fis = null;
        try {
            File file = new File("F:\\video\\拆分前\\"+fileFullName);
            fis = new FileInputStream(file);
            int available = fis.available();
            int fileTotal = available%(1024*1024*10)==0?available/(1024*1024*10):available/(1024*1024*10)+1;
            byte[] buffer = new byte[1024*1024*10];
            int temp = 0;
            int i=0;
            while ((temp = fis.read(buffer)) != -1) {
                i++;
                new FileOutputStream("F:\\video\\拆分后\\"+fileType+"_"+fileTotal+"_"+fileName+"_"+i+".jpg", true).write(buffer,0,temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("split file finish!");
    }



    public static void FileConcat(){
        System.out.println("start concat files...");
        FileOutputStream fos = null;
        try {
            File file = new File("F:\\video\\拆分后\\studyvideo.mp4");
            fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int temp = 0;
            for(int i=1;i<=16;i++){
                FileInputStream fis = new FileInputStream("F:\\video\\拆分后\\mp4_16_studyvideo_"+i+".jpg");
                while ((temp = fis.read(buffer)) != -1) {
                    fos.write(buffer,0,temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("concat files finish!");


    }




}


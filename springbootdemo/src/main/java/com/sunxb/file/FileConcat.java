package com.sunxb.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileConcat {

    public static void main(String[] args) throws Exception {
        splitAllFile("F:/video/拆分前", "F:/video/拆分后", 50);
        concatAllFile("F:/video/拆分后", "F:/video/合并后");
    }

    /**
     * 合并多个文件
     *
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void concatAllFile(String inputPath, String outputPath) throws IOException {

        inputPath = inputPath + "\\";
        outputPath = outputPath + "\\";
        File[] dirFiles = new File(inputPath).listFiles();
        for (File dirFile : dirFiles
                ) {
            String fileName = dirFile.getName();
            System.out.println("start concat file "+inputPath+fileName+"...");
            FileOutputStream fos;
            fos = new FileOutputStream(outputPath + fileName);
            byte[] buffer = new byte[1024];
            int temp = 0;
            for (int i = 1; i <= dirFile.listFiles().length; i++) {
                FileInputStream fis = new FileInputStream(inputPath + fileName + "\\" + i + "_" + fileName);
                while ((temp = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, temp);
                }
                fos.flush();
                fis.close();
            }
            fos.close();
            System.out.println("concat file "+inputPath+fileName+" finish!\n");
        }
    }

    /**
     * 拆分多个文件
     *
     * @param inputPath  要拆分文件路径
     * @param outputPath 拆分后文件存储路径
     */
    public static void splitAllFile(String inputPath, String outputPath, int partFileSize) {
        inputPath = inputPath + "\\";
        outputPath = outputPath + "\\";
        File dir = new File(inputPath);
        String[] list = dir.list();
        for (String fileFullName : list
                ) {
            String fileFullName_t = fileFullName.replace("_", "").trim();
            System.out.println("start splits file " + inputPath + fileFullName + "...");
            FileInputStream fis;
            try {
                fis = new FileInputStream(inputPath + fileFullName);
                byte[] buffer = new byte[1024 * 1024 * partFileSize];
                int temp;
                int i = 0;
                while ((temp = fis.read(buffer)) != -1) {
                    i++;
                    new File(outputPath + fileFullName_t).mkdirs();
                    FileOutputStream fos = new FileOutputStream(outputPath + fileFullName_t + "\\" + i + "_" + fileFullName_t);
                    fos.write(buffer, 0, temp);
                    fos.flush();
                    fos.close();
                }
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("split file " + inputPath + fileFullName + " finish!\n");
        }
    }
}


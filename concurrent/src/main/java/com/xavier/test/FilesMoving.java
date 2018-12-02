package com.xavier.test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class FilesMoving {
    public static final String ORIGNAL_PATH = "H:\\Private\\Others";
    public static final String DESTINATION_PATH="I:\\X-PRIVATE\\Others";
    public static List<String> folderArrayList = new ArrayList<String>();
    public static void main(String[] args) {
        //WRITE FOLDERS TO TXT.
        File folderDirectory = new File(ORIGNAL_PATH);
        File[]  foldersList = folderDirectory.listFiles();
        File file = new File("FolderLists.txt");
//        List<String> folderArrayList = new ArrayList<String>();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i< foldersList.length; i++) {
                if(foldersList[i].isFile()){
                    bw.write(foldersList[i].getName()+"\r\n");
                    folderArrayList.add(foldersList[i].getName());
                }else{
                    continue;
                }
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
//        for(int i=0; i<200;i++) {
//            cut(folderArrayList, i);
//        }

        ThreadCut[] cutThreads = new ThreadCut[394];
        FilesMoving fileMoving = new FilesMoving();
        Semaphore semaphore = new Semaphore(2);
        for(int i=0; i< cutThreads.length; i++) {
            cutThreads[i] = new ThreadCut(fileMoving, i, semaphore);
            cutThreads[i].start();
        }
    }

//    public static void cut(List<String> folderArrayList, int index, Semaphore semaphore) throws InterruptedException {
//        semaphore.acquire();
//        //Read ArrayList
//        try {
//            String folder = "";
//            if(folderArrayList.size() <1) {
//                System.exit(0);
//            }
//
//            folder = folderArrayList.get(index);
//            System.out.println(folder);
//
//            //Create destination Folder
//            File desFolder = new File(DESTINATION_PATH + folder);
//            desFolder.mkdir();
//
//            //Copy all files
//            File orignalFolder = new File(ORIGNAL_PATH + "\\" + folder);
//
//            File[] orignalFiles = orignalFolder.listFiles();
//            for(int j=0; j< orignalFiles.length; j++) {
//                File destFile = new File(desFolder+"\\" + orignalFiles[j].getName());
//                copy(orignalFiles[j], destFile);
//            }
//            delete(orignalFolder);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            semaphore.release();
//        }
//    }

    public static void cut(List<String> filesArray, int index, Semaphore semaphore) throws InterruptedException {
        semaphore.acquire();
        //Read ArrayList
        try {
            String folder = "";
            if(filesArray.size() <1) {
                System.exit(0);
            }

            File orignalFile = new File(ORIGNAL_PATH + "\\" + filesArray.get(index));
            File destFile = new File(DESTINATION_PATH+"\\" + filesArray.get(index));
            System.out.println(orignalFile.getName()+"\t\t\t"+destFile.getName());
            copy(orignalFile, destFile);
            System.out.print(index + "\t\t");
            deleteFileOnly(orignalFile);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void copy(File f1, File f2) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f2));
        int len = 0;
        byte[] b = new byte[1024];
        while ((len = bis.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        bis.close();
        bos.close();
    }

    public static void deleteFileOnly(File f) {
        if (f.isFile()) {
            System.out.println("Delete File -----" + f.getName());
            f.delete();
        }
    }

    public static void delete(File f) {
        if (f.isFile()) {
            f.delete();
        } else {
            File[] arr = f.listFiles();
            for (int i = 0; i < arr.length; i++) {
                delete(arr[i]);
            }
            System.out.println("Delete Folder -----" + f.getName());
            f.delete();
        }
    }
}

package com.qadata.service;


import com.qadata.vo.FileNameObject;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

public class FileOperateService {

    private static String rename(String name) {

        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()));
        Long random = (long) (Math.random() * now);
        String fileName = now + "" + random;

        if (name.indexOf(".") != -1) {
            fileName += name.substring(name.lastIndexOf("."));
        }
        return fileName;
    }

    private static String zipName(String name) {
        String prefix = "";
        if (name.indexOf(".") != -1) {
            prefix = name.substring(0, name.lastIndexOf("."));
        } else {
            prefix = name;
        }
        return prefix + ".zip";
    }

    public static void uploadOneFile(MultipartFile file, String uploadDir) throws Exception {
        File file1 = new File(uploadDir);

        if (!file1.exists()) {
            file1.mkdirs();
        }

        String fileName = null;
        fileName = file.getOriginalFilename();
        String storeName = rename(fileName);
        String noZipName = uploadDir + storeName;
        String zipName = zipName(noZipName);

        // 上传成为压缩文件
        ZipOutputStream outputStream = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(zipName)));
        outputStream.putNextEntry(new ZipEntry(fileName));
        outputStream.setEncoding("GBK");

        FileCopyUtils.copy(file.getInputStream(), outputStream);
    }

    public static List<String> getFileListInZip(String fileUrl) {
        List<String> list = new ArrayList<>();
        ZipFile slf_zipFile = null;
        if(fileUrl==null)
            return null;
        try {
            slf_zipFile = new ZipFile(fileUrl);
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            System.out.println(fileUrl);
            e.printStackTrace();
            list.add("fileHaveMissed");
        }
        if (slf_zipFile == null)
            return list;
        Enumeration e = slf_zipFile.getEntries();
        while (e.hasMoreElements()) {
            ZipEntry slf_zipEntry = (ZipEntry) e.nextElement();
            if (!slf_zipEntry.isDirectory()) {
                String filename = slf_zipEntry.getName().substring(slf_zipEntry.getName().lastIndexOf("/") + 1, slf_zipEntry.getName().length());
                list.add(filename);
            }
        }
        return list;

    }

    public static List<FileNameObject> getFileListInZip(String path, String zipName) {
        List<FileNameObject> list = new ArrayList<>();
        ZipFile slf_zipFile = null;
        try {
            slf_zipFile = new ZipFile(path + zipName);
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            System.out.println(zipName);
            e.printStackTrace();
        }
        Enumeration e = slf_zipFile.getEntries();
        while (e.hasMoreElements()) {
            ZipEntry slf_zipEntry = (ZipEntry) e.nextElement();
            if (!slf_zipEntry.isDirectory()) {
                String filename = slf_zipEntry.getName().substring(slf_zipEntry.getName().lastIndexOf("/") + 1, slf_zipEntry.getName().length());
                FileNameObject fileNameObject = new FileNameObject();
                fileNameObject.setZipName(zipName);
                fileNameObject.setContentType(slf_zipEntry.getName().substring(slf_zipEntry.getName().indexOf(".") + 1));
                fileNameObject.setFileName(filename);
                list.add(fileNameObject);
            }
        }
        return list;
    }

    public static List<FileNameObject> getFileList(String path) {
        File f = new File(path);
        if (!f.exists()) {
            System.out.println(path + " not exists");
            return null;
        }
        List<FileNameObject> list = new ArrayList<FileNameObject>();
        File fa[] = f.listFiles();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (fs.isDirectory()) {
                System.out.println(fs.getName() + " [目录]");
            } else {
                list.addAll(getFileListInZip(path, fs.getName()));
            }
        }
        return list;
    }

    public static void download(HttpServletRequest request,
                                HttpServletResponse response, String downLoadPath, String fileName) throws Exception {
        downLoadPath = downLoadPath + fileName;
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            File file = new File(downLoadPath);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String(fileName.getBytes("ISO8859-1"), "UTF-8"));
            response.setContentLength((int) file.length());
            response.setContentType("application/zip");// 定义输出类型
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream buff = new BufferedInputStream(fis);
            byte[] b = new byte[1024];// 相当于我们的缓存
            long k = 0;// 该值用于计算当前实际下载了多少字节
            OutputStream myout = response.getOutputStream();// 从response对象中得到输出流,准备下载
            // 开始循环下载
            while (k < file.length()) {
                int j = buff.read(b, 0, 1024);
                k += j;
                myout.write(b, 0, j);
            }
            myout.flush();
            buff.close();
            file.delete();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String getDownloadURL(HttpServletRequest request, String fileURL) {
        String downloadURL=request.getRequestURL().substring(0,request.getRequestURL().indexOf("qa-data"));
        downloadURL+=fileURL.substring(fileURL.indexOf("webapps")+8);
        return downloadURL;
    }

    public static String getUploadDir(HttpServletRequest request){
        String s=request.getSession().getServletContext().getRealPath("\\");
        s=s.substring(0,s.indexOf("webapps")+8);
        s+="qa-data-download\\";
        return s;
    }
}

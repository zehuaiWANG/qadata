package com.qadata.service;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 2017/8/16.
 */
public class FileService {
    public static String uploadMultiFile(String uploadDir, MultipartFile... files) throws Exception {
        File file1 = new File(uploadDir);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        String zipName = uploadDir + getZipName();

        // 上传成为压缩文件
        byte[] buffer = new byte[1024];
        ZipOutputStream outputStream = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(zipName)));
        for (MultipartFile file : files) {
            if (file != null) {
                String fileName = null;
                fileName = file.getOriginalFilename();
                outputStream.putNextEntry(new ZipEntry(fileName));
                outputStream.setEncoding("UTF-8");
                InputStream fis = file.getInputStream();
                int len;

                //读入需要下载的文件的内容，打包到zip文件

                while ((len = fis.read(buffer)) > 0) {

                    outputStream.write(buffer, 0, len);

                }

                outputStream.closeEntry();

                fis.close();
            }
        }
        outputStream.close();
        return zipName;
    }

    private static String getZipName() {
        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()));
        Long random = (long) (Math.random() * now);
        String fileName = now + "" + random;
        return fileName + ".zip";
    }

    public static void download(HttpServletRequest request,
                                HttpServletResponse response, String downLoadPath, String contentType,
                                String realName) throws Exception {
        request.setCharacterEncoding("UTF-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        long fileLength = new File(downLoadPath).length();

        System.out.println("download");
        java.util.zip.ZipFile zf = new java.util.zip.ZipFile(downLoadPath);
        InputStream in = new BufferedInputStream(new FileInputStream(downLoadPath));
        java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(in);
        java.util.zip.ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.getName().equals(realName)) {
                break;
            }
        }
        if (!ze.getName().equals(realName)) {
            return;
        }
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType(contentType);
        response.setHeader("Content-disposition", "attachment; filename="
                + new String(realName.getBytes("utf-8"), "ISO8859-1"));
        response.setHeader("Content-Length", String.valueOf(fileLength));
        bis = new BufferedInputStream(zf.getInputStream(ze));
        bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buff = new byte[2048];
        int bytesRead;
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }
        bis.close();
        bos.close();
    }

    public static void downloadAll(HttpServletRequest request,
                                   HttpServletResponse response, String downLoadPath) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String fileName;
        long fileLength = new File(downLoadPath).length();
        if (downLoadPath.lastIndexOf("\\") != -1) {
            fileName = downLoadPath.substring(downLoadPath.lastIndexOf("\\") + 1);
            System.out.println(fileName);
        } else {
            System.out.println("no file");
            return;
        }
        response.setContentType("zip");
        response.setHeader("Content-disposition", "attachment; filename="
                + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
        response.setHeader("Content-Length", String.valueOf(fileLength));
        FileInputStream in = new FileInputStream(downLoadPath);
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }

}

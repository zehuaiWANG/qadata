package com.qadata.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

/**
 * Created by Administrator on 2017/8/11 0011.
 */public class ZipSearch {

    /**
     * @param args
     * @coding by sunlifan at 2007.7.25
     */
    private List list = new ArrayList();

    public List zipLibSearch(String rootName, int searchlibNum) {

        ZipFile slf_file = null;
        try {
            slf_file = new ZipFile(rootName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        Enumeration e = slf_file.getEntries();
        while (e.hasMoreElements()) {
            ZipEntry slf_zipEntry = (ZipEntry) e.nextElement();
            if (slf_zipEntry.isDirectory()) {
                StringTokenizer st = new StringTokenizer(slf_zipEntry.getName(),
                        "/");

                int k = st.countTokens();

                if (k >= 1) {
                    List slf_temp = new ArrayList();
                    while (st.hasMoreTokens()) {

                        slf_temp.add(st.nextToken());
                    }

                    if (slf_temp.size() > searchlibNum) {
                        if (list.contains(slf_temp.get(searchlibNum)) == false) {
                            list.add(slf_temp.get(searchlibNum));
                        }
                    }

                }
            } else {
                if (slf_zipEntry.getSize() < 10240) {
                    System.out.println("压缩包内的文件大小不符合规范");
                    try {
                        slf_file.close();
                    } catch (IOException e1) {
                        // TODO 自动生成 catch 块
                        e1.printStackTrace();
                    }
                    return null;
                }
            }

        }
        try {
            slf_file.close();
        } catch (IOException e1) {
            // TODO 自动生成 catch 块
            e1.printStackTrace();
        }
        return list;
    }
}
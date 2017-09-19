package com.qadata.controller.protal;

import com.qadata.service.FileOperateService;
import com.qadata.service.FileService;
import com.qadata.vo.FileNameObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/11 0011.
 */
@RequestMapping(value = "/file")
public class FileOperate {

    private String uploadDir = "d:\\pizhicheng\\uploadDir\\userid\\";

    /**
     * 上传文件
     *
     * @param request
     * @return
     * @throws Exception
     * @author geloin
     * @date 2012-3-29 下午4:01:41
     */
    @ApiOperation(value = "文件上传测试", notes = "文件上传测试")
    @RequestMapping(value = "/upload1", produces = {"application/json"}, method = RequestMethod.POST)
    @ResponseBody
    public String upload1(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
        FileOperateService.uploadOneFile(file, uploadDir);
        return "success";
    }

    @ApiOperation(value = "文件上传测试", notes = "文件上传测试")
    @RequestMapping(value = "/upload2", produces = {"application/json"}, method = RequestMethod.POST)
    @ResponseBody
    public String upload2(HttpServletRequest request, @RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2, @RequestParam("file3") MultipartFile file3) throws Exception {
        FileService.uploadMultiFile(uploadDir, file1, file2, file3);
        return "success";
    }

    @RequestMapping(value = "/to_upload", produces = {"application/json"}, method = RequestMethod.POST)
    public String toUpload() throws Exception {
        return "upload";
    }

    @ApiOperation(value = "获取文件列表", notes = "获取文件列表", response = String.class)
    @RequestMapping(value = "/getList", produces = {"application/json"}, method = RequestMethod.POST)
    @ResponseBody
    public List<FileNameObject> getList(HttpServletRequest request) throws Exception {
        return FileOperateService.getFileList(uploadDir);
    }

    @ApiOperation(value = "文件下载测试", notes = "文件下载测试", response = String.class)
    @RequestMapping(value = "/download", produces = {"application/json"}, method = RequestMethod.POST)
    public void getList(HttpServletRequest request, HttpServletResponse response, @RequestParam String fileName) throws Exception {
        FileOperateService.download(request, response, uploadDir, fileName);
    }

    @RequestMapping("testResponseEntity")
    public ResponseEntity testResponseEntity(HttpServletRequest request,HttpServletResponse response, @RequestParam String fileName) throws IOException {
        if (fileName != null) {
            String realPath =uploadDir;
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

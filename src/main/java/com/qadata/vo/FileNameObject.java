package com.qadata.vo;

//import io.swagger.annotations.ApiModelProperty;
/**
 * Created by Administrator on 2017/8/11 0011.
 */
public class FileNameObject {

   // @ApiModelProperty(value = "zipName")
    String zipName;
    //@ApiModelProperty(value = "fileName")
    String fileName;
    //@ApiModelProperty(value = "contentType")
    String contentType;

    public String getZipName() {
        return zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

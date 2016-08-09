package com.pop.app.rest;

import com.pop.app.response.file.PathResponse;
import com.pop.exception.ExceptionInfoGetter;
import com.pop.file.FileUtil;
import com.wordnik.swagger.annotations.*;
import ocean.fastdfs.FastdfsClient;
import ocean.fastdfs.FastdfsClientFactory;
import ocean.fastdfs.data.Attachment;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by xugang on 16/8/7.
 */
@RestController
@RequestMapping(value = "/file")
@Api(value = "file", description = "文件上传下载api")
public class FileControl {
    final static Logger logger = LoggerFactory.getLogger(FileControl.class);
    @Autowired
    private FastdfsClientFactory fastdfsClientFactory;

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "上传文件", notes = "上传文件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public PathResponse upload(@RequestParam(value = "file", required = true) MultipartFile file) {
//        PathResponse response = new PathResponse();
//        response.setPath(FileUtil.upload(file));
//        return response;
        PathResponse response = new PathResponse();
        FastdfsClient fastdfsClient = fastdfsClientFactory.getFastdfsClient();
        Attachment attachment = getAttachment(file);
        String fileUrl = fastdfsClient.uploadImg(attachment);
        response.setPath(fileUrl);
        return response;
    }

    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
    @ApiOperation(value = "获取文件路径", notes = "获取文件路径")
    @RequestMapping(value = "/getFileUrl", method = RequestMethod.GET)
    public String getFileUrl(@ApiParam(name="filePath",value = "文件地址")@RequestParam("filePath")String filePath) {
        FastdfsClient client = fastdfsClientFactory.getFastdfsClient();
        return client.getUrl(filePath);
    }

//    @ApiResponses(value = {@ApiResponse(code = 200, message = "请求成功")})
//    @ApiOperation(value = "下载文件", notes = "下载文件")
//    @RequestMapping(value = "/download", method = RequestMethod.POST)
//    public ResponseEntity<byte[]> download(@RequestBody String filepath) throws IOException {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        String[] name = filepath.split("/");
//        headers.setContentDispositionFormData("attachment", name[name.length - 1]);
//        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filepath)),
//                headers, HttpStatus.CREATED);
//
//    }

    private Attachment getAttachment(MultipartFile mFile) {
        Attachment attachment = new Attachment();
        try {
            attachment.setContent(mFile.getBytes());
            attachment.setName(mFile.getName());
            attachment.setContentType(mFile.getContentType());
            attachment.setOriginalFilename(mFile.getOriginalFilename());
        } catch (IOException ex) {
            logger.error("文件上传错误:\n" + ex.getMessage());
        }
        return attachment;
    }

}

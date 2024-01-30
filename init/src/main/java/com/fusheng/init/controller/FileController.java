package com.fusheng.init.controller;


import com.fusheng.init.utils.FileUploadUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/file")
@RestController
@Tag(name = "文件操作")
public class FileController {
    @PostMapping("/upload")
    @Operation(summary = "上传文件")
    public String upload(MultipartFile file) {
        return FileUploadUtil.uploadFile(file);
    }
}

package com.nFactorial.backend.uploadfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class UploadfileController {

	@Autowired
	UploadfileService uploadfileservice;
	
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String flaskServerUrl = "http://localhost:5000/upload";

        // Flask ������ ������ �����ϴ� ���� ȣ��
        uploadfileservice.sendFileToFlaskServer(file, flaskServerUrl);

        return "File uploaded and sent to Flask server successfully";
    }

    
}

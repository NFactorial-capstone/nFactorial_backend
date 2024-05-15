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

        // Flask 서버로 파일을 전송하는 로직 호출
        uploadfileservice.sendFileToFlaskServer(file, flaskServerUrl);

        return "File uploaded and sent to Flask server successfully";
    }

    
}

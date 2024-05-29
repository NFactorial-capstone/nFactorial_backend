package com.nFactorial.backend.uploadfile;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VideoUploadController {

	
	

    @RequestMapping(value = "/uploadVideo", method = RequestMethod.POST)
    public void handleVideoUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String flaskServerUrl = "http://localhost:5000/upload"; // Flask ���� URL

        // ������ ������ ByteArray�� ��ȯ
        byte[] fileBytes = file.getBytes();
     
        // MultiValueMap�� ����Ͽ� ���� �Ķ���� ����
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };
        body.add("file", resource);

        // HttpHeaders ����
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        
        // HttpEntity ����
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        
        // Flask ������ POST ��û ������
        ResponseEntity<String> message = restTemplate.exchange(
                flaskServerUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        
        System.out.println(message);

    }
}

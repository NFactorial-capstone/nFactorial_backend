package com.nFactorial.backend.uploadfile;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ImageUploadController {

    private static final String FLASK_SERVER_URL = "http://localhost:5000/detect_objects";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadImage(MultipartHttpServletRequest mhsr) throws IOException {
    	System.out.println("uploadImage up!");
       
    	MultipartFile image = mhsr.getFile("image");
        
    	System.out.println(image);
            // ������ Base64�� ���ڵ�
            byte[] bytes = image.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(bytes);

            // Flask ������ �̹��� ����
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            Map<String, String> payload = new HashMap<>();
            payload.put("filename", image.getOriginalFilename());
            payload.put("image", base64Image);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(payload, headers);
            
            
            RestTemplate restTemplate = new RestTemplate();
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            messageConverters.add(new MappingJacksonHttpMessageConverter());
            restTemplate.setMessageConverters(messageConverters);

            ResponseEntity<Integer> response = restTemplate.postForEntity(FLASK_SERVER_URL, requestEntity, Integer.class);

            System.out.println("done!");
        
        
        
    }
    
    @RequestMapping(value = "/uploadtest", method = RequestMethod.GET)
    public void testup() {
    	System.out.println("test!");
    }
}
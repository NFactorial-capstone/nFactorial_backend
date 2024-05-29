package com.nFactorial.backend.uploadfile;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ImageUploadController {

    private static final String FLASK_SERVER_URL = "http://localhost:5000/detect_objects";

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("img") MultipartFile mhsr) throws IOException {
    	System.out.println("uploadImage up!");
       
    	byte[] bytes = mhsr.getBytes();
        
    	System.out.println("image");
            // 파일을 Base64로 인코딩
//            byte[] bytes = image.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(bytes);

            // Flask 서버로 이미지 전송
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            Map<String, String> payload = new HashMap<>();
            payload.put("filename", mhsr.getOriginalFilename());
            payload.put("image", base64Image);
            
            System.out.println(mhsr.getOriginalFilename());

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(payload, headers);
            
            
            RestTemplate restTemplate = new RestTemplate();
//            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter());
//            stringConverter.setDefaultCharset(StandardCharsets.UTF_8);
//            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//            messageConverters.add(new MappingJacksonHttpMessageConverter());
//            restTemplate.setMessageConverters(messageConverters);

//            restTemplate.postForEntity(FLASK_SERVER_URL, requestEntity, String.class);
            try {
            	ResponseEntity<String> response = restTemplate.postForEntity(FLASK_SERVER_URL, requestEntity, String.class);
                System.out.println("Request sent successfully.");
                System.out.println(response.getBody());
                return response.getBody();
            } catch (RestClientException e) {
                System.out.println("Error sending request: " + e.getMessage());
                return "1";
            }
        
    }
    
    @RequestMapping(value = "/uploadtest", method = RequestMethod.GET)
    public void testup() {
    	System.out.println("test!");
    }
}

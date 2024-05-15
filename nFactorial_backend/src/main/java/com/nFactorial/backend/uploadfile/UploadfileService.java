package com.nFactorial.backend.uploadfile;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadfileService {

	
	public void sendFileToFlaskServer(MultipartFile file, String flaskServerUrl) throws IOException {
        // HttpClient를 사용하여 파일을 Flask 서버로 전송
		CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            HttpPost uploadFile = new HttpPost(flaskServerUrl);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();

            builder.addBinaryBody(
                    "file",
                    file.getInputStream(),
                    org.apache.http.entity.ContentType.APPLICATION_OCTET_STREAM,
                    file.getOriginalFilename()
            );

            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);

            CloseableHttpResponse response = httpClient.execute(uploadFile);
            try {
                HttpEntity responseEntity = response.getEntity();
                if (responseEntity != null) {
                    System.out.println(EntityUtils.toString(responseEntity));
                }
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }
}

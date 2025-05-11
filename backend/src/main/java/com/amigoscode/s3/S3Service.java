package com.amigoscode.s3;

import com.fasterxml.jackson.core.ObjectCodec;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class S3Service {
    private final S3Client s3Client;
    private final ObjectCodec objectCodec;

    public S3Service(S3Client s3Client, ObjectCodec objectCodec) {
        this.s3Client = s3Client;
        this.objectCodec = objectCodec;
    }

    public void putObject(String bucketName, String key, byte[] file) {
        PutObjectRequest objectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();
        s3Client.putObject(objectRequest, RequestBody.fromBytes(file));
    }
}

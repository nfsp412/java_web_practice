package com.example.module17_spring_boot_minio.minio;

import io.minio.*;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MinioApp {
    public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MinioClient client = MinioClient.builder()
                .endpoint("http://172.20.10.7:9000")
                .credentials("minioadmin", "minioadmin")
                .build();
        boolean flag = client.bucketExists(BucketExistsArgs.builder().bucket("hello1").build());
        if (!flag) {
            //create bucket
            client.makeBucket(MakeBucketArgs.builder().bucket("hello1").build());
            //权限
            String policy = "{ \"Statement\" : [ { \"Action\" : \"s3:GetObject\", \"Effect\" : \"Allow\", \"Principal\" : \"*\", \"Resource\" : \"arn:aws:s3:::hello-minio/*\"} ], \"Version\" : \"2012-10-17\" }";
            client.setBucketPolicy(SetBucketPolicyArgs.builder().bucket("hello1").config(policy).build());

        } else {
            System.out.println("already exists");
        }

        //upload
        client.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("hello1")
                        .object("公寓-外观.jpg")
                        .filename("/Users/asuka/Documents/资料/shangtinggongyu/2.资料/7.images/公寓-外观.jpg")
                        .build()
        );
        System.out.println("success");
    }
}
//http://172.20.10.7:9000/hello1/公寓-外观.jpg
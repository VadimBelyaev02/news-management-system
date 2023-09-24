package com.vadim.grpcservice.controller;

import com.google.protobuf.ByteString;
import com.vadim.imageservice.ImageServiceGrpc;
import com.vadim.imageservice.ImageServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/dick")
public class TestController {

    @PostMapping("/upload")
    public String test(@RequestParam("file") MultipartFile image) throws IOException {
        System.err.println(image.getName());
        System.err.println(image.getSize());
        System.err.println(image.getOriginalFilename());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:9090")
                .keepAliveWithoutCalls(true)
                .idleTimeout(10000, TimeUnit.MILLISECONDS)
                .usePlaintext().build();
        System.err.println(channel.getState(false));
        System.err.println(channel.getState(true));
        ImageServiceGrpc.ImageServiceBlockingStub stub = ImageServiceGrpc.newBlockingStub(channel);

        ImageServiceOuterClass.UploadImageRequest request = ImageServiceOuterClass.UploadImageRequest
                .newBuilder()
                .setImage(ByteString.copyFrom(image.getBytes()))
                .setFilename("user1avatar")
                .build();
        ImageServiceOuterClass.UploadImageResponse response = stub.uploadImage(request);
        System.err.println(response.getImageUrl());
        System.err.println(response.getImageUrl());
        System.err.println(response.getImageUrl());
        System.err.println(response.getImageUrl());
        System.err.println(response.getImageUrl());
        return request.getFilename();
    }

}

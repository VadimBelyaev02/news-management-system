package com.vadim.userservice.service.impl;

import com.vadim.userservice.model.dto.request.PhotoRequestDto;
import com.vadim.userservice.model.mapper.PhotoMapper;
import com.vadim.userservice.model.unsplash.ResponseData;
import com.vadim.userservice.repository.PhotoRepository;
import com.vadim.userservice.service.PhotoService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.codec.multipart.FilePart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final WebClient client;
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    @Value("${unsplash.access-key}")
    private String accessKey;
    @Override
    public String uploadImage(PhotoRequestDto photo) {
        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();
        bodyBuilder.part("file", photo.getImage().getResource());
                //.filename("zalupa")
               // .contentType(MediaType.MULTIPART_FORM_DATA);
        Mono<ResponseData> response = null;
            response = client.post()
                    .uri("https://api.imgbb.com/1/upload?key=fbc98e8512f3ce8bdec29ce8432106c6")
                   .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData(bodyBuilder.build()))

                    .retrieve()
                    .bodyToMono(ResponseData.class);

        response.subscribe(tmp -> {
            System.out.println(tmp.getData().getUrl());
                }
        );

        return null;
    }


}

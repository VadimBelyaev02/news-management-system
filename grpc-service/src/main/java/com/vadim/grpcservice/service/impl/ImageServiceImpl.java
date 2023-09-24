package com.vadim.grpcservice.service.impl;

import com.vadim.grpcservice.model.UnsplashPhoto;
import com.vadim.grpcservice.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final WebClient client;

    @Value("${unsplash.access-key}")
    private String accessKey;
    @Override
    public String uploadImage(MultipartFile image) {
        Mono<UnsplashPhoto> response = client.post()
                .uri("https://api.unsplash.com/photos")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(image))
                .header("Authorization", "Client-ID " + accessKey)
                .retrieve()
                .bodyToMono(UnsplashPhoto.class);
        UnsplashPhoto photo = response.block();
        System.out.println(photo.getUrls().getFull());
        System.out.println(photo);
        return photo.getUrls().getFull();
//        response.subscribe(photo -> {
//            photo.getUrls().getFull();
//        });
    }


}

package com.vadim.userservice.service.impl;

import com.vadim.userservice.model.mapper.PhotoMapper;
import com.vadim.userservice.model.unsplash.UnsplashPhoto;
import com.vadim.userservice.repository.PhotoRepository;
import com.vadim.userservice.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final WebClient client;
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

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

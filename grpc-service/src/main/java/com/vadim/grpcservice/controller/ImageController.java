package com.vadim.grpcservice.controller;

import com.vadim.grpcservice.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    public String uploadImage(@RequestParam("file") MultipartFile image) {
        System.out.println(image.getOriginalFilename());
        return imageService.uploadImage(image);
    }
}

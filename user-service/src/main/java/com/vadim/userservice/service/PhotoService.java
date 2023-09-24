package com.vadim.userservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

    String uploadImage(MultipartFile image);


}

package com.vadim.userservice.service;

import com.vadim.userservice.model.dto.request.PhotoRequestDto;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

    String uploadImage(PhotoRequestDto image);


}

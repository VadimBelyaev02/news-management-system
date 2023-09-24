package com.vadim.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "photoFeignClient", url = "${app.openfeign.photo-feign-client.url}")
public interface PhotoFeignClient {

    @GetMapping(produces = "multipart/form-data")
    String uploadImage(MultipartFile image);

}

/*
@FeignClient(value = "userFeignClient", url = "${app.openfeign.user-feign-client.url}")
public interface UserFeignClient {

}

 */

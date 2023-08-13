package com.vadim.newsservice.client;

import com.vadim.newsservice.client.dto.UserResponseDto;
import com.vadim.newsservice.model.dto.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userFeignClient", url = "${app.openfeign.user-feign-client.url}")
public interface UserFeignClient {

    @GetMapping(value = "/token/{token}", produces = "application/json")
    ResponseEntity<ApiResponse<UserResponseDto>> getUserByToken(@PathVariable String token);
}

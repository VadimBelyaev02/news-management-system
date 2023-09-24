package com.vadim.userservice.controller;

import com.google.protobuf.ByteString;
import com.vadim.imageservice.ImageServiceGrpc;
import com.vadim.imageservice.ImageServiceOuterClass;
import com.vadim.userservice.model.criteria.UserCriteria;
import com.vadim.userservice.model.dto.request.UserRequestDto;
import com.vadim.userservice.model.dto.response.ApiResponse;
import com.vadim.userservice.model.dto.response.PageResponse;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.service.UserService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.vadim.userservice.util.constants.UserConstants.USER_API_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping(USER_API_PATH)
public class UserController {

    private final UserService service;

    @PostMapping("/upload")
    public String test(@RequestParam MultipartFile image) throws IOException {
//        int port = 9090;
//        System.out.println(image.getOriginalFilename());
//
//        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
//                .usePlaintext()
//    //                .enableRetry()
//    //                .maxRetryAttempts(10)
//    //                .keepAliveTime(1, TimeUnit.MINUTES)
//    //                .keepAliveTimeout(1, TimeUnit.MINUTES)
//    //                .keepAliveWithoutCalls(true)
//                .build();
//        System.err.println("Created channel: " + channel.getState(true).name());
//        ImageServiceGrpc.ImageServiceBlockingStub stub = ImageServiceGrpc.newBlockingStub(channel);
//        System.err.println("Created blocking stub" + stub.toString());
//
//        ImageServiceOuterClass.UploadImageRequest request = ImageServiceOuterClass.UploadImageRequest
//                .newBuilder()
//                .setImage(ByteString.copyFrom(image.getBytes()))
//                .setFilename("user1avatar")
//                .build();
//        ImageServiceOuterClass.UploadImageResponse response = stub.uploadImage(request);
//        System.err.println(response.getImageUrl());
//        return request.getFilename();
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> getUser(@PathVariable UUID userId) {
        UserResponseDto userResponseDto = service.getById(userId);

        return ApiResponse.ok(
                "User with id = " + userId,
                USER_API_PATH,
                userResponseDto
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<UserResponseDto>>> getAllUsers(Pageable pageable,
                                                                                  @RequestBody(required = false) UserCriteria userCriteria) {
        PageResponse<UserResponseDto> pageResponse = service.getAll(pageable, userCriteria);

        return ApiResponse.ok(
                "All users",
                USER_API_PATH,
                pageResponse
        );
    }


    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDto>> postUsers(@RequestBody @Valid UserRequestDto requestDto) {
        UserResponseDto userResponseDto = service.save(requestDto);

        return ApiResponse.created(
                "User with id = " + userResponseDto.id() + " was created",
                USER_API_PATH,
                userResponseDto
        );
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponseDto>> putUsers(@RequestBody @Valid UserRequestDto requestDto,
                                                                 @PathVariable UUID userId) {
        UserResponseDto userResponseDto = service.update(userId, requestDto);

        return ApiResponse.ok(
                "Comment with id = " + userId + " was updated",
                USER_API_PATH,
                userResponseDto
        );
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable UUID userId) {
        service.deleteById(userId);

        return ApiResponse.noContent(
                "User with id = " + userId + " was deleted",
                USER_API_PATH
        );
    }
}

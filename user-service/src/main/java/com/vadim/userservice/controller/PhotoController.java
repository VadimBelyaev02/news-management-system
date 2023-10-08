package com.vadim.userservice.controller;

import com.vadim.userservice.model.dto.request.PhotoRequestDto;
import com.vadim.userservice.model.dto.response.ApiResponse;
import com.vadim.userservice.model.dto.response.PhotoResponseDto;
import com.vadim.userservice.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.vadim.userservice.util.constants.UserConstants.USER_API_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER_API_PATH + "/photos")
public class PhotoController {

    private final PhotoService photoService;

    //  @PostMapping
    @PostMapping("/upload")
//public ResponseEntity<ApiResponse<PhotoResponseDto>> postPhoto(@RequestBody PhotoRequestDto photoRequestDto) {
    //public ResponseEntity<ApiResponse<PhotoResponseDto>> postPhoto(@RequestParam("image") MultipartFile image, @RequestParam("isAvatar") boolean isAvatar) {
    public ResponseEntity<ApiResponse<PhotoResponseDto>> postPhoto(@RequestParam("image") MultipartFile image,
                                                                   @RequestParam(value = "isAvatar", required = false, defaultValue = "false") boolean isAvatar) {
        PhotoRequestDto requestDto = PhotoRequestDto.builder()
                .isAvatar(isAvatar)
                .image(image)
                .build();
        System.out.println(image.getOriginalFilename());

        photoService.uploadImage(requestDto);

        return ApiResponse.ok("ok", null, null);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PhotoResponseDto>> get() {

        return ApiResponse.ok("ok", "chlen", null);
    }
}

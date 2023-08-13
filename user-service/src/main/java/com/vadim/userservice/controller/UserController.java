package com.vadim.userservice.controller;

import com.vadim.userservice.model.criteria.UserCriteria;
import com.vadim.userservice.model.dto.request.UserRequestDto;
import com.vadim.userservice.model.dto.response.ApiResponse;
import com.vadim.userservice.model.dto.response.PageResponse;
import com.vadim.userservice.model.dto.response.UserResponseDto;
import com.vadim.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.vadim.userservice.util.constants.UserConstants.USER_API_PATH;

@RequiredArgsConstructor
@RestController
@RequestMapping(USER_API_PATH)
public class UserController {

    private final UserService service;

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

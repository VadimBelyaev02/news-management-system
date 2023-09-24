package com.vadim.grpcservice.service.impl;

import com.vadim.imageservice.ImageServiceGrpc;
import com.vadim.imageservice.ImageServiceOuterClass;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@GrpcService
@RequiredArgsConstructor
public class ImageGrpcServiceImpl extends ImageServiceGrpc.ImageServiceImplBase {

    private final WebClient client;


    private final String ACCESS_KEY = "3_xyabeh8tBcBRG9OiLteRKh5rBx1r3CiM0QQ83uAvE";
    private final String URL = "https://api.unsplash.com/photos\n";

    @Override
    public void uploadImage(ImageServiceOuterClass.UploadImageRequest request,
                            StreamObserver<ImageServiceOuterClass.UploadImageResponse> responseObserver) {
        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();
                formData.add("photo", request.getImage().toByteArray());

//
//        Mono<String> responseMono = client.post()
//                .uri(uriBuilder -> uriBuilder.path(URL)
//                        .queryParam("client_id", ACCESS_KEY)
//                        .build()
//                )
//                .contentType(MediaType.IMAGE_PNG)
//                .body(BodyInserters.fromMultipartData(formData))
//                .retrieve()
//                .bodyToMono(String.class);
//
//        final ImageServiceOuterClass.UploadImageResponse.Builder builder = ImageServiceOuterClass.UploadImageResponse.newBuilder();
//
//        responseMono.subscribe(builder::setImageUrl);
//        builder.setMessage("Photo was saved!");
//        builder.setSuccess(true);
//        responseObserver.onNext(builder.build());
//        responseObserver.onCompleted();

    }
}

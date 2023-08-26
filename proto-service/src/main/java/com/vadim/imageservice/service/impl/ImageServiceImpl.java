//package com.vadim.imageservice.service.impl;
//import io.grpc.stub.StreamObserver;
////import image.ImageServiceGrpc;
////import image.ImageUploadRequest;
//import com.*;
//public class ImageServiceImpl {
//    //extends ImageServiceGrpc.ImageServiceImplBase {
////    @Override
////    public StreamObserver<ImageUploadRequest> uploadImage(StreamObserver<ImageUploadResponse> responseObserver) {
////        return new StreamObserver<ImageUploadRequest>() {
////            private ByteArrayOutputStream imageData = new ByteArrayOutputStream();
////            private String filename;
////
////            @Override
////            public void onNext(ImageUploadRequest request) {
////                if (request.hasFilename()) {
////                    filename = request.getFilename();
////                }
////                if (request.hasImage()) {
////                    try {
////                        imageData.write(request.getImage().toByteArray());
////                    } catch (IOException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }
////
////            @Override
////            public void onError(Throwable t) {
////                // Обработка ошибок
////            }
////
////            @Override
////            public void onCompleted() {
////                String imageUrl = saveImage(imageData.toByteArray(), filename); // Сохранение изображения
////                ImageUploadResponse response = ImageUploadResponse.newBuilder().setImageUrl(imageUrl).build();
////                responseObserver.onNext(response);
////                responseObserver.onCompleted();
////            }
////        };
////    }
//}

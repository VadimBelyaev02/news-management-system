package com.vadim.userservice.service.impl;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Main {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 9991; // Порт вашего gRPC сервера

        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        final ConnectivityState state = channel.getState(true);
        // Создание вашего gRPC клиента
        // Выполнение запросов и проверка ответов
        // ...
        System.out.println(state.toString());
        channel.shutdown();
    }
}

package com.github.piroyoung.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PingPongServer {
    private static int PORT = 50051;
    private static Server server;

    public static void main(String[] args ) throws Exception{
        server = ServerBuilder
                .forPort(PORT)
                .addService(new PingPongServerGrpcImpl())
                .build();

        server.start();
        server.awaitTermination();
    }

}

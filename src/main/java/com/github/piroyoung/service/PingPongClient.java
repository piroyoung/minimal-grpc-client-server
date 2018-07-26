package com.github.piroyoung.service;

import com.github.piroyoung.protobuf.PingPongServiceGrpc;
import com.github.piroyoung.protobuf.Request;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class PingPongClient {
    private final ManagedChannel channel;
    private final PingPongServiceGrpc.PingPongServiceBlockingStub blockingStub;

    PingPongClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    private PingPongClient(ManagedChannel managedChannel) {
        this.channel = managedChannel;
        this.blockingStub = PingPongServiceGrpc.newBlockingStub(channel);
    }

    public static void main(String[] args) {
        PingPongClient client = new PingPongClient("localhost", 50051);

        Request request = Request.newBuilder().setMessage("ping").build();
        System.out.println(client.blockingStub.request(request));

    }
}

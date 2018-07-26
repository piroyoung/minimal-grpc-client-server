package com.github.piroyoung.service;

import com.github.piroyoung.protobuf.PingPongServiceGrpc;
import com.github.piroyoung.protobuf.Request;
import com.github.piroyoung.protobuf.Response;
import io.grpc.stub.StreamObserver;

public class PingPongServerGrpcImpl extends PingPongServiceGrpc.PingPongServiceImplBase {

    @Override
    public void request(Request request, StreamObserver<Response> obs) {
        Response response = Response.newBuilder().setMessage("pong").build();
        obs.onNext(response);
        obs.onCompleted();

    }

}

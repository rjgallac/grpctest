package com.example.demo.hello;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.sheffieldwebprogrammer.helloworld.Greeting;
import uk.co.sheffieldwebprogrammer.helloworld.HelloWorldServiceGrpc;
import uk.co.sheffieldwebprogrammer.helloworld.Person;

public class HelloService extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

    @Override
    public void sayHello(Person request, StreamObserver<Greeting> responseObserver) {
        String msg = new StringBuilder().append("Hello, ")
                .append(request.getFirstName()).append(" ")
                .append(request.getLastName()).toString();
        Greeting greeting = Greeting.newBuilder().setMessage(msg).build();
        LOGGER.info("sending msg");
        responseObserver.onNext(greeting);
        LOGGER.info("msg sent");
        responseObserver.onCompleted();
        LOGGER.info("sending complete");
    }

}

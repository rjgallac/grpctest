package com.example.demo.hello;



import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.sheffieldwebprogrammer.helloworld.Greeting;
import uk.co.sheffieldwebprogrammer.helloworld.HelloWorldServiceGrpc;
import uk.co.sheffieldwebprogrammer.helloworld.Person;

@GRpcService
public class HelloService extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloService.class);

    @Override
    public void sayHello(Person request,
                         StreamObserver<Greeting> responseObserver) {



        LOGGER.info("server received {}", request);

        String message = "Hello " + request.getFirstName() + " "
                + request.getLastName() + "!";
        Greeting greeting =
                Greeting.newBuilder().setMessage(message).build();
        LOGGER.info("server responded {}", greeting);

        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
    }

}

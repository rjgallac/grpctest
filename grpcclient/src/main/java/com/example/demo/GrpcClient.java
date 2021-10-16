package com.example.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.sheffieldwebprogrammer.helloworld.Greeting;
import uk.co.sheffieldwebprogrammer.helloworld.HelloWorldServiceGrpc;
import uk.co.sheffieldwebprogrammer.helloworld.Person;

public class GrpcClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(GrpcClient.class);

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

		HelloWorldServiceGrpc.HelloWorldServiceBlockingStub stub = HelloWorldServiceGrpc.newBlockingStub(channel);
		Person person = Person.newBuilder().setFirstName("r").setLastName("g").build();
		Greeting greeting = stub.sayHello(person);
		LOGGER.info("client received {}", greeting);
		channel.shutdown();
	}

}

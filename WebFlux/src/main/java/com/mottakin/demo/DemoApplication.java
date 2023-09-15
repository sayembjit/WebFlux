package com.mottakin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
									/*Merging in a normal way*/

				/*Flux<String> f1 = Flux.just("Hello,", "Welcome To");
				Flux<String> f2 = Flux.just("A", "new World!");

				Flux<String> mergedFlux = Flux.merge(f1, f2)

						.log()
						.map(String::toUpperCase)
						.reduce("", (s1, s2) -> s1 + " " + s2)
						.flux();

				mergedFlux.subscribe(result -> System.out.println(result));*/




									/*usage of mergeWith*/



		/*Flux<String> flux1 = Flux.just("Hello,", "Welcome To");
		Flux<String> flux2 = Flux.just("A", "new World!");

		Flux<String> errorFlux = Flux.error(new RuntimeException("An error occurred"));

		Flux<String> mergedFlux = flux1.mergeWith(flux2)
				.mergeWith(errorFlux)
				.map(s -> "Processed: " + s)
				.log();

		mergedFlux.subscribe(
				result -> System.out.println("Result: " + result),
				error -> System.err.println("Error: " + error.getMessage())
		);*/



								/*usage of concatWith*/


		/*Flux<String> flux1 = Flux.just("Hello,", "Welcome To");
		Flux<String> flux2 = Flux.just("A", "new World!");

		Flux<String> errorFlux = Flux.error(new RuntimeException("An error occurred"));

		Flux<String> concatenatedFlux = flux1.concatWith(flux2)
				.map(s -> "Processed: " + s)
				.log();

		concatenatedFlux.subscribe(
				result -> System.out.println("Result: " + result),
				error -> System.err.println("Error: " + error.getMessage())
		);*/

								/*zipWith Example two*/


/*
		Flux<String> source1 = Flux.just("Hello", "Welcome", "To");
		Flux<String> source2 = Flux.just("the", "new", "world");

		Flux<String> zippedFlux = source1.zipWith(source2, (one, two) -> one + " " + two);

		zippedFlux.subscribe(result -> System.out.println("Combined: " + result));*/


		/*Flux<String> flux1 = Flux.just("Hello,", "Welcome To");
		Flux<String> flux2 = Flux.just("A", "new World!");

		Flux<String> errorFlux = Flux.error(new RuntimeException("An error occurred"));

		Flux<String> zippedFlux = flux1.zipWith(flux2, (s1, s2) -> s1 + s2)
				.zipWith(errorFlux, (s, error) -> "Processed: " + s)
				.log();

		zippedFlux.subscribe(
				result -> System.out.println(result),
				error -> System.err.println("Error: " + error.getMessage())
		);*/


		/*List<String> words = Arrays.asList("My", "Name", "Is", "Sayem", "Mottakin", "Chowdhury");

		List<Character> character = words.stream()
				.flatMap(word -> word.chars().mapToObj(c -> (char) c))
				.collect(Collectors.toList());

		System.out.println(character);*/




		Optional<String> result = applyForLoan()
				.flatMap(DemoApplication::checkCreditScore)
				.flatMap(DemoApplication::verifyEmployment)
				.orElseGet(() -> String.valueOf(Optional.of("Loan application denied"))).describeConstable();

		System.out.println("Loan Application Result: " + result.orElse("Loan application denied"));

	}


	private static Optional<String> applyForLoan() {
		return Optional.of("Loan application approved");
	}

	private static Optional<String> checkCreditScore(String applicant) {
		return Optional.of(applicant + " - Credit score is sufficient");
	}

	private static Optional<String> verifyEmployment(String applicant) {
		return Optional.of(applicant + " - Employment verified");
	}



}

package org.example.pairmatchingsum;

import lombok.RequiredArgsConstructor;
import org.example.pairmatchingsum.dto.RequestDTO;
import org.example.pairmatchingsum.dto.ResponseDTO;
import org.example.pairmatchingsum.service.FindPairService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class PairMatchingSumApplication implements CommandLineRunner {

	private final FindPairService findPairService;

	public static void main(String[] args) {
		SpringApplication.run(PairMatchingSumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the target number: ");
		int target = scanner.nextInt();

		System.out.print("Enter the numbers separated by spaces: ");
		scanner.nextLine();
		String[] input = scanner.nextLine().split(" ");

		List<Integer> numbersList = Arrays.stream(input).mapToInt(Integer::parseInt).boxed().toList();

		RequestDTO request = RequestDTO.builder()
				.targetNumber(target)
				.numbers(numbersList)
				.build();

		ResponseDTO response = findPairService.findPair(request);

		if (response.getPairs().isEmpty()) {
			System.out.println("No pairs found.");
		} else {
			System.out.println("Pairs that sum to " + target + ":");
			for (int[] pair : response.getPairs()) {
				System.out.println(Arrays.toString(pair));
			}
		}

		scanner.close();
	}
}

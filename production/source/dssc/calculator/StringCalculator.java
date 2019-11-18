package dssc.calculator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StringCalculator {

    public static int add(String numbers){

        String error = "Negatives not allowed, found";

        if(numbers.isEmpty())
            return 0;
        else {
            numbers =numbers.replaceAll("[^-?0-9]+", " ");

            List<Integer> digits = Stream.of(numbers.trim().split(" ")).
                    mapToInt(Integer::valueOf).
                    boxed().collect(Collectors.toList());

            Optional<Integer> negatives = digits.stream().filter(x -> x < 0).findFirst();

            if(negatives.isPresent()) throw new RuntimeException();

            return digits.stream().mapToInt(Integer::intValue).filter(x-> x < 1001).sum();
        }

    }
}

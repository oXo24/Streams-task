package task_01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println("Initial list of names:");
        formAnswer(provideNames());

        char startingLetter = startingLetter();

        System.out.println("\nSelected names starting with letter '" + startingLetter + "':");
        formAnswer(selectNames(provideNames(), startingLetter));
    }

    private static List<String> provideNames() {
        return Arrays.asList("Michael", "Linda", "John", "Elizabeth", "Paul");
    }

    private static List<String> selectNames(List<String> names, char startingLetter) {
        return names.stream()
                .filter(name -> name.charAt(0) == startingLetter)
                .collect(Collectors.toList());
    }

    private static void formAnswer(List<String> names) {
        names.forEach(name -> System.out.println(names.indexOf(name) + 1 + ") " + name));
    }

    private static String askForLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first letter of a wanted name: ");
        return scanner.nextLine().trim();
    }

    private static char startingLetter() {
        return askForLetter().charAt(0);
    }
}
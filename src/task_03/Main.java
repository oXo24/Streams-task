package task_03;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    static int minTemp = 10;
    static int maxTemp = 13;

    public static void main(String[] args) {

        System.out.println("Daily temperature readings:");
        formAnswer(temperaturesList());

        System.out.println("\nSelected temperatures between " + minTemp + " and " + maxTemp + " degrees:");
        formAnswer(selectTemperatures(temperaturesList()));
    }

    public static Map<Integer, String> temperaturesList() {
        Map<Integer, String> temperatures = new HashMap<>();
        temperatures.put(12, "Monday");
        temperatures.put(9, "Tuesday");
        temperatures.put(13, "Wednesday");
        temperatures.put(10, "Thursday");
        temperatures.put(11, "Friday");
        temperatures.put(14, "Saturday");
        temperatures.put(8, "Sunday");

        return temperatures;
    }

    private static Map<Integer, String> selectTemperatures(Map<Integer, String> temperatures) {
        return temperatures.entrySet().stream()
                .filter(entry -> entry.getKey() >= minTemp && entry.getKey() <= maxTemp)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void formAnswer(Map<Integer, String> temperatures) {
        temperatures.forEach((temperature, day) -> System.out.println(temperature + " degrees on " + day));
    }
}

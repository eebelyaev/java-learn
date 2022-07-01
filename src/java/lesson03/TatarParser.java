package lesson03;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TatarParser {
    public static int[] getYearsFromText() {
        File file = new File("src/resources/lesson03", "tatar-dates.txt");
        if (!file.exists()) {
            System.out.println("File not exists");
            return new int[0];
        }
        StringBuilder builder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)) {
            Pattern pattern = Pattern.compile("\\([1-2]\\d{3}\\)");
            Matcher matcher;
            while (scanner.hasNextLine()) {
                matcher = pattern.matcher(scanner.nextLine());
                while (matcher.find()) {
                    builder.append(":").append(matcher.group(), 1, 5);
                }
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return Arrays.stream(builder.substring(1).split(":"))
                .distinct()
                .limit(20)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

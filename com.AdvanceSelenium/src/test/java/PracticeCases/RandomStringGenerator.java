package PracticeCases;

import java.util.Random;

public class RandomStringGenerator {

    // Method to generate random alphanumeric string of given length
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    // Method to generate random string in the format "xxx-xxxxx-xxx-xxxxx"
    public static String generateFormattedRandomString() {
        // Example format: "uet-232424-asdf-3asf324"
        String part1 = "uet";
        String part2 = generateRandomString(6);  // Random numeric string
        String part3 = generateRandomString(4);  // Random alphabetic string
        String part4 = generateRandomString(6);  // Random alphanumeric string

        return String.format("%s-%s-%s-%s", part1, part2, part3, part4);
    }

    public static void main(String[] args) {
        // Generate a formatted random string
        String randomString = generateFormattedRandomString();
        System.out.println("Generated Random String: " + randomString);
    }
}
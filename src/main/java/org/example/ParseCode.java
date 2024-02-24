package org.example;

import org.json.JSONObject;
public class ParseCode {
    public static void main(String[] args) {
        // Parse the input code line
        String input = "3**2"; // This is the code line you need to check
        JSONObject output = getJsonObject(input); // Get the JSON object with the ratings
        System.out.println(output); // Print the JSON object
    }

    private static JSONObject getJsonObject(String input) {
        // Split the input code line by the "**" symbol
        boolean isCorrect = isCorrect(input);

        // Edge cases check
        boolean hasEdgeCase = input.contains("^"); // Check if the input code line has the "^" symbol

        // Format instructions check
        boolean hasFormat = input.matches("\\d+\\*\\*\\d+"); // Check if the input code line matches the regex pattern

        // Compiler output
        // Create a JSON object to store the compiler output
        JSONObject output = new JSONObject();
        output.put("correctness", isCorrect ? "Yes" : "No"); // Add the correctness value
        output.put("edgeCases", hasEdgeCase ? "Yes" : "No"); // Add the edge case value
        output.put("formatInstructions", hasFormat ? "Yes" : "No"); // Add the format value
        return output;
    }

    private static boolean isCorrect(String input) {
        String[] parts = input.split("\\*\\*");
        // Check if the input code line has two parts
        if (parts.length != 2) {
            // If not, throw an exception
            throw new IllegalArgumentException("Invalid input code line: " + input);
        }
        // Get the base and exponent as integers
        int base = Integer.parseInt(parts[0]);
        int exponent = Integer.parseInt(parts[1]);

        // Correctness check
        boolean isCorrect = false; // Initialize a boolean variable to store the correctness
        double result = Math.pow(base, exponent); // Calculate the result using the Math.pow method
        if (result == 9.0) { // Compare the result with the expected value
            isCorrect = true; // If they match, set the correctness to true
        }
        return isCorrect;
    }
}

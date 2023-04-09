package interfaces;

public interface InputValidator {

    /**
     * Applies all validations to input.
     * @param input to validate.
     * @return true if valid, else false.
     */
    boolean isValid(String input);

    /**
     * Validates that the input less than the maxLength.
     * If invalid, outputs a message to the console.
     * @param input to validate.
     * @return true if length is valid, else false.
     */
    boolean validateLength(String input, int maxLength);

    /**
     * Validates that the input has not been used before.
     * If invalid, outputs a message to the console.
     * @param input to validate.
     * @return true if valid, else false.
     */
    boolean validateUnique(String input);
}

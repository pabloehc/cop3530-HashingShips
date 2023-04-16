package game;

import interfaces.InputValidator;

import java.util.HashSet;
import java.util.Set;

public class InputValidatorImpl implements InputValidator {

    public final Set<String> inputSet = new HashSet<>();


    @Override
    public boolean isValid(String input) throws InterruptedException {
        if (!validateLength(input, 2)) {
           return false;
        }

        if (!validateUnique(input)){
            return false;
        }

        return true;
    }

    /**
     * Validates that the input less than the maxLength.
     * If invalid, outputs a message to the console.
     * @param input to validate.
     * @param maxLength of the input
     * @return true if length is valid, else false.
     */
    @Override
    public boolean validateLength(String input, int maxLength) throws InterruptedException {
        if (input.length() > maxLength){
            System.out.println("You have entered an invalid length. Max length is 2.");
            Thread.sleep(1000);
            return false;
        }

        return true;
    }

    /**
     * Validates that the input has not been used before.
     * If invalid, outputs a message to the console.
     * @param input to validate.
     * @return true if valid, else false.
     */
    @Override
    public boolean validateUnique(String input) throws InterruptedException {
        if (inputSet.contains(input)){
            System.out.println("You have entered that input previously. Please enter a different input.");
            Thread.sleep(1000);
            return false;
        }

        inputSet.add(input);
        return true;

    }

}

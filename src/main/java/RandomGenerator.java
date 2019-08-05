import org.apache.commons.lang3.RandomStringUtils;

class RandomGenerator {

   // private static int length;
    private static boolean useLetters;
    private static boolean useNumbers;

/*    RandomGenerator(int length) {
        RandomGenerator.length = length;
    }*/


    static String randomLetters(int lettersLength) {

        useLetters = true;
        useNumbers = false;
        return
                RandomStringUtils.random(lettersLength, useLetters, useNumbers);

    }

    static String randomNumbers(int numbersLength) {

        useLetters = false;
        useNumbers = true;
        return
                RandomStringUtils.random(numbersLength, useLetters, useNumbers);
    }




}

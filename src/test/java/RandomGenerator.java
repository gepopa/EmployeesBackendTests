import org.apache.commons.lang3.RandomStringUtils;

class RandomGenerator {

    private static int length;
    private static boolean useLetters;
    private static boolean useNumbers;

    RandomGenerator(int length) {
        RandomGenerator.length = length;
    }


    static String randomLetters() {

        useLetters = true;
        useNumbers = false;
        return
                RandomStringUtils.random(length, useLetters, useNumbers);

    }

    static String randomNumbers() {

        useLetters = false;
        useNumbers = true;
        return
                RandomStringUtils.random(length, useLetters, useNumbers);
    }


}

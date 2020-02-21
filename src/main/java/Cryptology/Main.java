package Cryptology;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
public class Main {


    public static void main(String[] args) {
        CryptoUse menu = new CryptoUse();

        int numberOfTestStrings = 33;
        List<String> test = new ArrayList<>();
        for (int i = 0; i <numberOfTestStrings; i++) {
            String s = RandomStringUtils.randomAlphabetic(1).charAt(0) + RandomStringUtils.randomAlphabetic(5, 10).substring(1);
            test.add(s);
            }
        for (String s : test) {
            menu.start(s, 5);
        }
    }
}

package test.Cryptology;

public class CryptoUse {

    public void start(String input, int jump) {
        Encrypt start = new Encrypt();
        Decrypt end = new Decrypt();

        print(input, "Przed szyfrowaniem");
        String startResult = start.finish(input, jump);

        String middle = "Zaszyfrowany ";
        print(startResult, middle);

        String endResult = end.finish(startResult, jump);

        String afterCrypt = "Rozszyfrowany ";
        print(endResult, afterCrypt);

        System.out.println();

    }

    private void print(String text, String type) {
        System.out.println(type + " " + text);
    }
}

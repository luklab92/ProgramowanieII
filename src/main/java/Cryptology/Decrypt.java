package Cryptology;

public class Decrypt {
    private final int big = 'A';
    private final int small = 'a';
    private final int backToStart = 'z' - 'a' + 1;
    ;


    private String[] split(String input, int jump) {
        boolean isBig;
        String[] output = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                int value = input.charAt(i);
                isBig = isItBigLetter(value);
                value = value - jump;
                if (!isBig)
                    value = smallLetterValueCheck(value);
                else
                    value = bigLetterValueCheck(value);
                String s = Character.toString((char) value);
                output[i] = s;
            } else output[i] = String.valueOf(input.charAt(i));
        }
        return output;
    }


    public String finish(String input, int jump) {
        String[] string = split(input, jump);
        StringBuilder sb = new StringBuilder();
        for (String s : string) {
            sb.append(s);
        }
        return sb.toString();
    }

    private int bigLetterValueCheck(int value) {

        if (value < big) value = value + backToStart;
        return value;
    }

    private int smallLetterValueCheck(int value) {
        if (value < small) value = value + backToStart;
        return value;
    }

    private boolean isItBigLetter(int value) {
        return (value < small);
    }

}

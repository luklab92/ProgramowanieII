package Cryptology;


public class Encrypt {
private String input;



    public Encrypt(String plainText, int jump) {
        this.input = plainText;
        finish(jump);
    }

    private String[] split(int jump) {
        boolean isBig = false;
        String[] output = new String[input.length()];
        for (int i = 0; i <input.length(); i++) {
            if (input.charAt(i) != ' ') {
                int value = input.charAt(i);

                if (isItBigLetter(value)) isBig=true;
                value = value + jump;

                if (!isBig)
                    value = smallLetterValueCheck(value);
                if (isBig)
                    value = bigLetterValueCheck(value);
                String s = Character.toString((char) value);
                output[i] = s;
            }
            else output[i] = String.valueOf(input.charAt(i));
        }
        return output;
}

private String finish(int jump) {
        String[] string = split(jump);
        StringBuilder sb = new StringBuilder();
        for (String s: string) {
            sb.append(s);
        }
    System.out.println(sb.toString());
        return sb.toString();
}

private int bigLetterValueCheck(int value) {

        if (value>90) value=value-90+64;
    return value;
}

    private int smallLetterValueCheck(int value) {
        if (value>122) value=value-122+96;
        return value;
    }

    private boolean isItBigLetter (int value) {
        return (value<95) ;
    }

}

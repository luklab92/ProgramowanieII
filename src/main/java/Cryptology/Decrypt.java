package Cryptology;

public class Decrypt {

        private String input;
        public Decrypt(String secret, int jump) {
            this.input = secret;
            finish(jump);
        }

        private String[] split(int jump) {
            boolean isBig = false;
            String[] output = new String[input.length()];
            for (int i = 0; i <input.length(); i++) {
                if (input.charAt(i) != ' ') {
                    int value = input.charAt(i);

                    if (isItBigLetter(value)) isBig=true;
                    value = value - jump;

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

        private void finish(int jump) {
            String[] string = split(jump);
            StringBuilder sb = new StringBuilder();
            for (String s: string) {
                sb.append(s);
            }
            System.out.println(sb.toString());
        }

        private int bigLetterValueCheck(int value) {

            if (value<65) value=value+26;
            return value;
        }

        private int smallLetterValueCheck(int value) {
            if (value<97) value=value+26;
            return value;
        }

        private boolean isItBigLetter (int value) {
            return (value<95) ;
        }

    }


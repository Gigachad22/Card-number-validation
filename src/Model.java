public class Model {
    public boolean Luhn_algorithm(String cardNumber){
        char[] temp = cardNumber.toCharArray();
        int[] digits = new int[temp.length];
        for (int i = 0; i < digits.length; i++){
            digits[i] = Character.getNumericValue(temp[i]);
        }

        // Ha nem 16 számjegy hosszú biztosan nem valid
        if (digits.length != 16)
            return false;
        int checksum = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            if (i % 2 == 0){
                digits[i] *= 2;
                if (digits[i] > 9)
                    digits[i] = digits[i] - 9;
            }
            checksum += digits[i];
        }
        return (checksum % 10 == 0);
    }
}

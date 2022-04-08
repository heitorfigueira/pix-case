package br.com.itau.pix.domain.model.util;

public class CnpjValidator {

    public static boolean validate(String cnpj) {
        final int[] digitWeight = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        if ((cnpj==null)||(cnpj.length()!=14)) return false;

        Integer digit1 = generateDigit(cnpj.substring(0,12), digitWeight);
        Integer digit2 = generateDigit(cnpj.substring(0,12) + digit1, digitWeight);
        return cnpj.equals(cnpj.substring(0,12) + digit1.toString() + digit2.toString());
    }

    private static int generateDigit(String str, int[] weight) {
        int sum = 0;
        for (int index=str.length()-1, digit; index >= 0; index-- ) {
            digit = Integer.parseInt(str.substring(index,index+1));
            sum += digit*weight[weight.length-str.length()+index];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }

}

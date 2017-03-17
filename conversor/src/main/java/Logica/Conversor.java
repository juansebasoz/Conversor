package Logica;

import java.math.BigInteger;

/**
 * Created by fmont on 02 mar 2017.
 */

public class Conversor {

    public String opciones(String numero, int opcion) {

        String conversion = "";
        if (!numero.isEmpty()) {
            switch (opcion) {
                case 1:
                    conversion = binario_hexadecimal(numero);
                    break;
                case 2:
                    conversion = binario_decimal(numero);
                    break;
                case 3:
                    conversion = binario_octal(numero);
                    break;

                case 4:
                    conversion = octal_hexadecimal(numero);
                    break;
                case 5:
                    conversion = octal_decimal(numero);
                    break;
                case 6:
                    conversion = octal_binaro(numero);
                    break;

                case 7:
                    conversion = decimal_hexadecimal(numero);
                    break;
                case 8:
                    conversion = decimal_octal(numero);
                    break;
                case 9:
                    conversion = decimal_binario(numero);
                    break;

                case 10:
                    conversion = hexadecimal_decimal(numero);
                    break;
                case 11:
                    conversion = hexadecimal_octal(numero);
                    break;
                case 12:
                    conversion = hexadecimal_binario(numero);
                    break;
            }
            try {
                if (Long.parseLong(numero) == 0)
                    return "0";
            } catch (NumberFormatException e) {
            }
        }
        return conversion;
    }

    private BigInteger elevar(BigInteger base, BigInteger exponente) {
        BigInteger resultado = base;
        if (exponente.compareTo(BigInteger.ZERO) == 0) {
            resultado = BigInteger.ONE;
        } else {
            for (BigInteger i = BigInteger.ONE; i.compareTo(exponente) < 0; i = i.add(BigInteger.ONE)) {
                resultado = resultado.multiply(base);
            }
        }
        return resultado;
    }

    private char letras(int n) {
        char c = ' ';
        switch (n) {
            case 10:
                c = 'A';
                break;
            case 11:
                c = 'B';
                break;
            case 12:
                c = 'C';
                break;
            case 13:
                c = 'D';
                break;
            case 14:
                c = 'E';
                break;
            case 15:
                c = 'F';
                break;
        }
        return c;
    }

    private int numeros(char c) {
        int n = 0;
        switch (c) {
            case 'A':
                n = 10;
                break;
            case 'B':
                n = 11;
                break;
            case 'C':
                n = 12;
                break;
            case 'D':
                n = 13;
                break;
            case 'E':
                n = 14;
                break;
            case 'F':
                n = 15;
                break;
        }
        return n;
    }

    /// BINARIO//////////////////////////////////////////////////////////////////////////////////////
    private String binario_hexadecimal(String binario) {
        return decimal_hexadecimal(binario_decimal(binario));
    }

    private String binario_decimal(String binario) {
        return resolver(binario, new BigInteger("2"));
    }

    private String binario_octal(String binario) {
        return decimal_octal(binario_decimal(binario));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// OCTAL////////////////////////////////////////////////////////////////////////////////////////
    private String octal_hexadecimal(String octal) {
        return decimal_hexadecimal(octal_decimal(octal));
    }

    private String octal_decimal(String octal) {
        return resolver(octal, new BigInteger("8"));
    }

    private String octal_binaro(String octal) {
        return decimal_binario(octal_decimal(octal));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// DECIMAL//////////////////////////////////////////////////////////////////////////////////////
    private String decimal_hexadecimal(String numero) {
        String hexadecimal = "";
        for (BigInteger i = new BigInteger(numero); i.compareTo(BigInteger.ZERO) > 0; i = i
                .divide(new BigInteger("16"))) {
            BigInteger resultado = i.mod(new BigInteger("16"));
            if (resultado.compareTo(new BigInteger("10")) >= 0) {
                hexadecimal += letras(resultado.intValue());
            } else {
                hexadecimal += resultado;
            }
        }
        return invertir(hexadecimal);
    }

    private String decimal_octal(String numero) {
        String octal = "";
        for (BigInteger i = new BigInteger(numero); i.compareTo(BigInteger.ZERO) > 0; i = i
                .divide(new BigInteger("8"))) {
            octal += i.mod(new BigInteger("8"));
        }

        return invertir(octal);
    }

    private String decimal_binario(String numero) {
        String binario = "";
        for (BigInteger i = new BigInteger(numero); i.compareTo(BigInteger.ZERO) > 0; i = i
                .divide(new BigInteger("2"))) {
            binario += i.mod(new BigInteger("2"));
        }

        return invertir(binario);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// HEXADECIMAL//////////////////////////////////////////////////////////////////////////////////
    private String hexadecimal_decimal(String hexadecimal) {
        BigInteger decimal = BigInteger.ZERO;
        String letra = "ABCDEF";
        BigInteger tam = new BigInteger("" + hexadecimal.length());
        BigInteger nums[] = new BigInteger[tam.intValue()];

        for (BigInteger i = BigInteger.ZERO; i.compareTo(tam) < 0; i = i.add(BigInteger.ONE)) {
            for (BigInteger j = BigInteger.ZERO; j.compareTo(new BigInteger("" + letra.length())) < 0; j = j
                    .add(BigInteger.ONE)) {
                char c = hexadecimal.charAt(i.intValue());
                if (c == letra.charAt(j.intValue())) {
                    nums[i.intValue()] = BigInteger.valueOf(numeros(c));
                }
            }
        }
        for (BigInteger i = BigInteger.ZERO; i.compareTo(tam) < 0; i = i.add(BigInteger.ONE)) {
            if (hexadecimal.charAt(i.intValue()) < 65) {
                nums[i.intValue()] = new BigInteger("" + hexadecimal.charAt(i.intValue()));
            }
        }
        for (BigInteger i = tam.subtract(BigInteger.ONE), j = BigInteger.ZERO; i.compareTo(BigInteger.ZERO) >= 0; i = i
                .subtract(BigInteger.ONE), j = j.add(BigInteger.ONE)) {
            decimal = decimal.add(new BigInteger("" + nums[i.intValue()].multiply(elevar(new BigInteger("16"), j))));
        }
        return decimal.toString();
    }

    private String hexadecimal_octal(String hexadecimal) {
        return decimal_octal(hexadecimal_decimal(hexadecimal));
    }

    private String hexadecimal_binario(String hexadecimal) {
        return decimal_binario(hexadecimal_decimal(hexadecimal));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String resolver(String numero, BigInteger base) {
        BigInteger resultado = BigInteger.ZERO;
        for (BigInteger i = new BigInteger("" + (numero.length() - 1)), j = BigInteger.ZERO; i
                .compareTo(BigInteger.ZERO) >= 0; i = i.subtract(BigInteger.ONE), j = j.add(BigInteger.ONE)) {
            resultado = resultado.add(new BigInteger("" + numero.charAt(i.intValue())).multiply(elevar(base, j)));
        }
        return resultado.toString();
    }

    private String invertir(String numero) {
        String resultado = "";
        for (int i = numero.length() - 1; i >= 0; i--)
            resultado += numero.charAt(i);
        return resultado;
    }

}

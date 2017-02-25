package Logica;

/**
 * Created by fmont on 23 feb 2017.
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
                    conversion = decimal_hexadecimal(Long.parseLong(numero));
                    break;
                case 8:
                    conversion = decimal_octal(Long.parseLong(numero));
                    break;
                case 9:
                    conversion = decimal_binario(Long.parseLong(numero));
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
                if (Integer.parseInt(numero) == 0)
                    return "0";
            } catch (NumberFormatException e) {
            }
        }
        return conversion;
    }

    // Metodo para elevar un numero
    private long elevar(long b, long e) {
        long res = b;
        if (e == 0) {
            res = 1;
        } else {
            for (int i = 1; i < e; i++) {
                res *= b;
            }
        }
        return res;
    }

    /*
     * Metodo que resive un numero y devuelve la letra correspondiente
     */
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

    /*
     * Metodo que resive una letra y devuelve el numero correspondiente
     */
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
        long numero = Long.parseLong(binario_decimal(binario));
        return decimal_hexadecimal(numero);
    }

    private String binario_decimal(String binario) {
        int t = binario.length();
        long decimal = 0;

        for (int i = t - 1, j = 0; i >= 0; i--, j++) {
            decimal += Long.parseLong("" + binario.charAt(i)) * elevar(2, j);
        }
        return "" + decimal;
    }

    private String binario_octal(String binario) {
        long numero = Long.parseLong(binario_decimal(binario));
        return decimal_octal(numero);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// OCTAL////////////////////////////////////////////////////////////////////////////////////////
    private String octal_hexadecimal(String octal) {
        long numero = Long.parseLong(octal_decimal(octal));
        return decimal_hexadecimal(numero);
    }

    private String octal_decimal(String octal) {
        int t = octal.length();
        long decimal = 0;

        for (int i = t - 1, j = 0; i >= 0; i--, j++) {
            decimal += Long.parseLong("" + octal.charAt(i)) * elevar(8, j);
        }
        return "" + decimal;
    }

    private String octal_binaro(String octal) {
        long numero = Long.parseLong(octal_decimal(octal));
        return decimal_binario(numero);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// DECIMAL//////////////////////////////////////////////////////////////////////////////////////
    private String decimal_hexadecimal(long numero) {
        String hex = "", hexadecimal = "";

        for (long i = numero; i > 0; i /= 16) {
            long res = i % 16;
            if (res >= 10) {
                hex += letras((int) res);
            } else {
                hex += res;
            }
        }
        for (int i = hex.length() - 1; i >= 0; i--)
            hexadecimal += hex.charAt(i);

        return hexadecimal;
    }

    private String decimal_octal(long numero) {
        String oct = "", octal = "";

        for (long i = numero; i > 0; i /= 8) {
            long res = i % 8;
            oct += res;
        }

        for (int i = oct.length() - 1; i >= 0; i--)
            octal += oct.charAt(i);

        return octal;
    }

    private String decimal_binario(long numero) {
        String bin = "", binario = "";

        for (long i = numero; i > 0; i /= 2) {
            long res = i % 2;
            bin += res;
        }

        for (int i = bin.length() - 1; i >= 0; i--)
            binario += bin.charAt(i);

        return binario;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// HEXADECIMAL//////////////////////////////////////////////////////////////////////////////////
    private String hexadecimal_decimal(String hexadecimal) {
        long decimal = 0;
        hexadecimal = hexadecimal.toUpperCase();
        String letra = "ABCDEF";
        int t = hexadecimal.length();
        int nums[] = new int[t];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < letra.length(); j++) {
                char c = hexadecimal.charAt(i);
                if (c == letra.charAt(j)) {
                    nums[i] = numeros(c);
                }
            }
        }
        for (int i = 0; i < t; i++) {
            if (hexadecimal.charAt(i) < 65) {
                nums[i] = Integer.parseInt("" + hexadecimal.charAt(i));
            }
        }
        for (int i = t - 1, j = 0; i >= 0; i--, j++) {
            long d = nums[i] * elevar(16, j);
            decimal += d;
        }
        return "" + decimal;
    }

    private String hexadecimal_octal(String hexadecimal) {
        long numero = Long.parseLong(hexadecimal_decimal(hexadecimal));
        return decimal_octal(numero);
    }

    private String hexadecimal_binario(String hexadecimal) {
        long numero = Long.parseLong(hexadecimal_decimal(hexadecimal));
        return decimal_binario(numero);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
}

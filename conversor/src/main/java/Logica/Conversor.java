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
            } catch (NumberFormatException e){}
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
    public String binario_hexadecimal(String binario) {
        return decimal_hexadecimal(Long.parseLong(binario_decimal(binario)));
    }

    public String binario_decimal(String binario) {
        return  resolver(binario,2);
    }

    public String binario_octal(String binario) {
        return decimal_octal(Long.parseLong(binario_decimal(binario)));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// OCTAL////////////////////////////////////////////////////////////////////////////////////////
    public String octal_hexadecimal(String octal) {
        return decimal_hexadecimal(Long.parseLong(octal_decimal(octal)));
    }

    public String octal_decimal(String octal) {
        return resolver(octal,8);
    }

    public String octal_binaro(String octal) {
        return decimal_binario(Long.parseLong(octal_decimal(octal)));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// DECIMAL//////////////////////////////////////////////////////////////////////////////////////
    public String decimal_hexadecimal(long numero) {
        String hexadecimal = "";

        for (long i = numero; i > 0; i /= 16) {
            long res = i % 16;
            if (res >= 10)
                hexadecimal += letras((int) res);
            else
                hexadecimal += res;
        }
        return invertir(hexadecimal);
    }

    public String decimal_octal(long numero) {
        String octal = "";

        for (long i = numero; i > 0; i /= 8)
            octal += i % 8;

        return invertir(octal);
    }

    public String decimal_binario(long numero) {
        String binario = "";

        for (long i = numero; i > 0; i /= 2)
            binario += i % 2;

        return invertir(binario);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    /// HEXADECIMAL//////////////////////////////////////////////////////////////////////////////////
    public String hexadecimal_decimal(String hexadecimal) {
        long decimal = 0;
        String letra = "ABCDEF";
        int t = hexadecimal.length();
        int nums[] = new int[t];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < letra.length(); j++) {
                char c = hexadecimal.charAt(i);
                if (c == letra.charAt(j))
                    nums[i] = numeros(c);
            }
        }
        for (int i = 0; i < t; i++) {
            if (hexadecimal.charAt(i) < 65)
                nums[i] = Integer.parseInt("" + hexadecimal.charAt(i));
        }
        for (int i = t - 1, j = 0; i >= 0; i--, j++)
            decimal += nums[i] * elevar(16, j);

        return "" + decimal;
    }

    public String hexadecimal_octal(String hexadecimal) {
        return decimal_octal(Long.parseLong(hexadecimal_decimal(hexadecimal)));
    }

    public String hexadecimal_binario(String hexadecimal) {
        return decimal_binario(Long.parseLong(hexadecimal_decimal(hexadecimal)));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String invertir(String numero){
        String resultado = "";
        for (int i = numero.length() - 1; i >= 0; i--)
            resultado += numero.charAt(i);
        return resultado;
    }

    private String resolver(String numero, int base){
        long resultado = 0;
        for (int i = numero.length() - 1, j = 0; i >= 0; i--, j++)
            resultado += Long.parseLong("" + numero.charAt(i)) * elevar(base, j);
        return "" + resultado;
    }

}
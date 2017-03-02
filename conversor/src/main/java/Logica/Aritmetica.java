package Logica;

import java.math.BigInteger;

/**
 * Created by fmont on 02 mar 2017.
 */

public class Aritmetica {

    public BigInteger suma(BigInteger a, BigInteger b){

        return a.add(b);
    }

    public BigInteger resta(BigInteger a, BigInteger b){

        return a.subtract(b);
    }

    public BigInteger multiplicacion(BigInteger a, BigInteger b){

        return a.multiply(b);
    }

    public BigInteger division(BigInteger a, BigInteger b){

        return a.divide(b);
    }

}

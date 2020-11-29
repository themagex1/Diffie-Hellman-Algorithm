package com.company;

import java.math.BigInteger;
import java.util.Random;

public class NMGenerator
{
    private BigInteger N;
    private BigInteger G;
    private static final int bits = 512;
    private static final int p = 100;
    private final Random rand = new Random();

    public NMGenerator() {
        N = generatePrime();
        G = new BigInteger(bits, rand);
    }

    private BigInteger generatePrime()
    {
        BigInteger primeNumber = BigInteger.probablePrime(bits,rand);

        while (!primeNumber.isProbablePrime(p) ||
                !((primeNumber
                        .subtract(BigInteger.ONE))
                        .divide(BigInteger.TWO))
                        .isProbablePrime(p))
        {
            primeNumber = BigInteger.probablePrime(bits, rand);
        }

        return primeNumber;
    }

    public BigInteger getN()
    {
        return N;
    }
    public BigInteger getG()
    {
        return G;
    }
}

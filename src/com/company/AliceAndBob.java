package com.company;

import java.math.BigInteger;
import java.util.Random;

public class AliceAndBob
{
    private static final int bits = 512;
    private final Random rand = new Random();

    private BigInteger modN;
    private BigInteger baseG;
    private BigInteger exponentX;

    public AliceAndBob(BigInteger G, BigInteger N)
    {
        baseG = G;
        modN = N;
        exponentX = new BigInteger(bits, rand);
    }

    public BigInteger modPow()
    {
        BigInteger result = baseG.modPow(exponentX,modN);
        return result;
    }

    public BigInteger keyGenerator(BigInteger number)
    {
        BigInteger key = number.modPow(exponentX,modN);
        return key;
    }
}

package com.company;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("ALICE AND BOB DH");
        System.out.println();

        NMGenerator generator = new NMGenerator();

        System.out.println("G = "+ generator.getG().toString());
        System.out.println("N = "+ generator.getN().toString());
        System.out.println();

        AliceAndBob alice = new AliceAndBob(generator.getG(),generator.getN());
        AliceAndBob bob = new AliceAndBob(generator.getG(),generator.getN());

        BigInteger alicesNumber = alice.modPow();
        BigInteger bobsNumber = bob.modPow();

        System.out.println("Alice send: "+ alicesNumber.toString());
        System.out.println("Bob send: "+bobsNumber.toString());
        System.out.println();

        BigInteger alicesKey = alice.keyGenerator(bobsNumber);
        BigInteger bobsKey = bob.keyGenerator(alicesNumber);

        System.out.println("Alice's private key is "+ alicesKey.toString());
        System.out.println("Bob's private key is " + bobsKey.toString());
        System.out.println();
        System.out.println((alicesKey.compareTo(bobsKey) == 0) ? "Keys are equal. GOOD JOB!" : "Keys are not equal. BAD JOB!");

    }
}

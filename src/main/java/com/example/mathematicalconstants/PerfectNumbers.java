package com.example.mathematicalconstants;

import java.math.BigInteger;

public class PerfectNumbers {

    //CHAT GPT GENERATED CODE
    public static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) < 1) {
            return false;
        }
        BigInteger sqrtNum = num.sqrt();
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(sqrtNum) <= 0; i = i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }

    public static BigInteger generateMersennePrime(int exponent) {
        BigInteger candidate = BigInteger.valueOf(2).pow(exponent).subtract(BigInteger.ONE);
        while (!isPrime(candidate)) {
            exponent++;
            candidate = BigInteger.valueOf(2).pow(exponent).subtract(BigInteger.ONE);
        }
        return candidate;
    }

    public static BigInteger[] generatePerfectNumbers(int n) {
        int exponent = 2;
        BigInteger[] perfectNumbers = new BigInteger[n];
        int count = 0;

        while (count < n) {
            BigInteger mersennePrime = generateMersennePrime(exponent);
            BigInteger perfectNum = BigInteger.valueOf(2).pow(exponent - 1).multiply(mersennePrime);
            perfectNumbers[count] = perfectNum;
            count++;
            exponent++;
        }

        return perfectNumbers;
    }

    public static void main(String[] args) {
        // Generate the first 10 perfect numbers
        BigInteger[] first10PerfectNumbers = generatePerfectNumbers(30);
        System.out.println("First 10 Perfect Numbers:");
        for (int i = 0; i < first10PerfectNumbers.length; i++) {
            System.out.println("P" + (i + 1) + ": " + first10PerfectNumbers[i]);
        }
    }
}
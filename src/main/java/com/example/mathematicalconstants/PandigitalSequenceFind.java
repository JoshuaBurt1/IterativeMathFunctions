package com.example.mathematicalconstants;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//this is much quicker by finding sequences in already generated strings
public class PandigitalSequenceFind {
    public static void main(String[] args) {

        //BASE 10 PI, Current formula: Gauss-Legendre
        //CURRENT
        //Sequence found starting at digit 61: 4592307816
        //Sequence found starting at digit 5472: 7908143562
        //Sequence found starting at digit 8669: 0457618932
        //Time taken: 145108248500 nanoseconds
        //Sequence found starting at digit 16547: 0395648127

        MathContext mathContext = new MathContext(6050);

        long startTimeGauss = System.nanoTime();
        BigDecimal piGauss = BigDecimal.ZERO;

        for (int k = 0; k < 6050; k++) {
            BigDecimal term1 = BigDecimal.valueOf(4).divide(BigDecimal.valueOf(8 * k + 1), mathContext);
            BigDecimal term2 = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(8 * k + 4), mathContext);
            BigDecimal term3 = BigDecimal.ONE.divide(BigDecimal.valueOf(8 * k + 5), mathContext);
            BigDecimal term4 = BigDecimal.ONE.divide(BigDecimal.valueOf(8 * k + 6), mathContext);

            BigDecimal term = term1.subtract(term2).subtract(term3).subtract(term4);
            term = term.multiply(BigDecimal.ONE.divide(BigDecimal.valueOf(16).pow(k), mathContext));

            piGauss = piGauss.add(term);
        }

        long endTimeGauss = System.nanoTime();
        System.out.println("Gauss-Legendre Algorithm");
        System.out.println("Pi: " + piGauss.setScale(6050, RoundingMode.HALF_UP));

        String piGaussString = piGauss.setScale(6050, RoundingMode.HALF_UP).toString();
        Set<Character> foundDigits = new HashSet<>();
        List<String> sequences = new ArrayList<>();

        int sequenceL=9;
        for (int i = 0; i < piGaussString.length(); i++) {
            char currentChar = piGaussString.charAt(i);
            if (Character.isDigit(currentChar) && foundDigits.add(currentChar)) {
                if (foundDigits.size() == sequenceL) {
                    String sequence = piGaussString.substring(i - sequenceL, i + 0);
                    sequences.add("Sequence found starting at digit " + (i - sequenceL + 0) + ": " + sequence);
                    foundDigits.clear();
                }
            } else {
                foundDigits.clear();
            }
        }
        for (String sequence : sequences) {
            System.out.println(sequence);
        }
        long elapsedGauss = endTimeGauss - startTimeGauss;
        System.out.println("Time taken: " + elapsedGauss + " nanoseconds");
    }
}
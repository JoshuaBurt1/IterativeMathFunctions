package com.example.mathematicalconstants;

import java.math.BigInteger;
import java.util.*;
//Records:

//VERSION 1:
//value.isProbablePrime(10);
//Generated possible solutions set time: 156ms
//7000ms (1+15 primes); 1000 iterations

//VERSION 2:
//value.isProbablePrime(10);
// 3703ms/3 seconds (3+14 primes); 1000 iterations
// 18230ms/18 seconds (3+17 primes); 1500 iterations
// 902996ms/15 minutes (3+20 primes); 4000 iterations (result: June 2, 1963, ILLIAC 2)

//VERSION 3:
//value.isProbablePrime(10);
// 1224ms/1 second (2+15 primes); 200 iterations
// 286916ms/5 minutes (2+21 primes); 1000 iterations
// 3876269ms/64 minutes (2+22 primes); 1750 iterations (result: March 4, 1971, IBM 360/91)
// 6906925ms/115 minutes (2+24 primes); 2000 iterations (result: February 9, 1979, CDC Cyber 174)
//division algorithm based on previous M#, seems to be ~90% Mp filtration:
// (0.33*(429/1000)) = 0.14157; (0.33*(2898/8800)=0.108675; (0.33*(4944/16000))=0.10197; (0.33*(7126/24000))=0.0979825;

//CHAT GPT GENERATED:
//value.isProbablePrime(10);
//44196ms (19+1 primes)

public class MersennePrimes {

    public static void main(String[] args) {

        //VERSION 1: ********************************************************************************************************************************
//        int numValues = 1000;  // You can change this value to generate more numbers
//        long startTime1 = System.currentTimeMillis();
//        // Generate OriginalSet
//        Set<BigInteger> originalSet = generateValuesForFormula1Set(numValues);
//        originalSet.addAll(generateValuesForFormula2Set(1, numValues));
//        originalSet.addAll(generateValuesForFormula2Set(2, numValues));
//
//        //System.out.println("\nOriginal Set (sorted): ");
//        //printSortedSet(originalSet);
//
//        // Generate FilteredSet
//        Set<BigInteger> filteredSet = filterSetByFormula1(originalSet);
//        System.out.println("\nFiltered Set (sorted): ");
//        printSortedSet(filteredSet);
//
//        // Generate RemovedSet
//        Set<BigInteger> removedSet = new HashSet<>(originalSet);
//        removedSet.removeAll(filteredSet);
//
//        //System.out.println("\nRemoved Set (sorted): ");
//        //printSortedSet(removedSet);
//        long endTime1 = System.currentTimeMillis();
//        long elapsedTime1 = endTime1 - startTime1;
//        System.out.println("Time taken: " + elapsedTime1 + " milliseconds \n");
//    }
//
//
//    private static Set<BigInteger> generateValuesForFormula1Set(int numValues) {
//        Set<BigInteger> results = new HashSet<>();
//        for (int n = 1; n <= numValues + 1; n++) {
//            BigInteger result = BigInteger.valueOf(2).multiply(BigInteger.valueOf(2).pow(2 * n)).subtract(BigInteger.ONE);
//            results.add(result);
//        }
//        return results;
//    }
//
//    private static Set<BigInteger> generateValuesForFormula2Set(int m, int numValues) {
//        Set<BigInteger> results = new HashSet<>();
//        for (int n = 1; n <= numValues + 1; n++) {
//            BigInteger result = BigInteger.valueOf(m).multiply(BigInteger.valueOf(2).multiply(BigInteger.valueOf(2).pow(3 * n))).subtract(BigInteger.ONE);
//            results.add(result);
//        }
//        return results;
//    }
//
//    private static Set<BigInteger> filterSetByFormula1(Set<BigInteger> set) {
//        Set<BigInteger> filteredSet = new HashSet<>();
//        for (BigInteger value : set) {
//            boolean matchesFormula1 = checkFormula1Matches(value);
//            if (matchesFormula1) {
//                filteredSet.add(value);
//            }
//        }
//        return filteredSet;
//    }
//
//    private static boolean checkFormula1Matches(BigInteger value) {
//        // Check if a solution exists for formula1 only
//        return value.isProbablePrime(10);
//        //use above only at end --> takes time++, filter by if both solutions are present in list value
//    }
//
//    private static void printSortedSet(Set<BigInteger> set) {
//        List<BigInteger> sortedList = new ArrayList<>(set);
//        Collections.sort(sortedList);
//
//        for (BigInteger result : sortedList) {
//            System.out.println("* "+result);
//        }
//    }


        //VERSION 2: ***************************************************************************************************************************************************
        //2^m×(4(2^n)^2)−1; 2^0×(4(2^0)^2)−1=3; 2^1×(4(2^0)^2)−1=7; 2^1×(4(2^1)^2)−1=31; 2^3×(4(2^1)^2)−1 = 127; 2^3×(4(2^3)^2)−1 = 2047;
        //2^5×(4(2^3)^2)−1 = 8191; 2^5×(4(2^5)^2)−1 = 131071; 2^7×(4(2^5)^2)−1 = 524287;

//        long startTime = System.currentTimeMillis();
//        ArrayList<BigInteger> resultList = new ArrayList<>();
//        for (int m = 3; m <= 8000; m += 2) {
//            for (int n = m - 2; n <= m; n += 2) {
//                BigInteger result = BigInteger.valueOf(2).pow(m)
//                        .multiply(BigInteger.valueOf(4).multiply(BigInteger.valueOf(2).pow(2 * n))).subtract(BigInteger.ONE);
//                System.out.println("m: " + m + ", n: " + n + ", result: " + result);
//                resultList.add(result);
//            }
//        }
//
//        ArrayList<BigInteger> primeList = filterPrimes(resultList);
//
//        System.out.println("\nPrime List:");
//        for (BigInteger prime : primeList) {
//            System.out.println("*" + prime);
//        }
//
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//        System.out.println("\nComputation Time: " + totalTime + " milliseconds");
//    }
//
//    private static ArrayList<BigInteger> filterPrimes(ArrayList<BigInteger> resultList) {
//        ArrayList<BigInteger> primeList = new ArrayList<>();
//
//        for (BigInteger number : resultList) {
//            if (checkFormula1Matches(number)) {
//                primeList.add(number);
//            }
//        }
//
//        return primeList;
//    }
//
//    private static boolean checkFormula1Matches(BigInteger value) {
//        // Check if a solution exists for formula1 only
//        return value.isProbablePrime(10);
//        // use above only at the end --> takes time++, filter by if both solutions are present in the list
//    }

        //VERSION 3: ****************************************************************************************************************************************
        // Record start time
//        long startTime = System.currentTimeMillis();
//        int numberOfTerms = 100; // Change this to the desired number of terms
//        List<BigInteger> originalList = generateNumbers1(numberOfTerms);
//
//        // Print the original list
//        System.out.println("Original List:");
//        printList(originalList);
//
//        // Create a duplicate list
//        List<BigInteger> duplicateList = new ArrayList<>(originalList);
//
//        // Remove numbers from duplicate list that are divisible by numbers in the original list
//        removeDivisibleNumbers(duplicateList, originalList);
//
//        // Print the filtered list
//        System.out.println("\nFiltered List:");
//        printList(duplicateList);
//
//        // Create a new list containing only prime numbers from the filtered list using checkFormula1Matches
//        List<BigInteger> primeNumberList = filterPrimes(duplicateList);
//
//        // Print the prime number list
//        System.out.println("\nPrime Number List:");
//        printList(primeNumberList);
//        long endTime = System.currentTimeMillis();
//
//        // Calculate and print the time taken in milliseconds
//        System.out.println("\nTime taken: " + (endTime - startTime) + " milliseconds");
//    }
//
//    private static List<BigInteger> generateNumbers1(int numberOfTerms) {
//        List<BigInteger> numberList1 = new ArrayList<>();
//
//        for (int n = 0; n < numberOfTerms; n++) {
//            BigInteger term1a = BigInteger.valueOf(2).pow(5 + 12 * n).subtract(BigInteger.ONE);
//            BigInteger term2a = BigInteger.valueOf(2).pow(7 + 12 * n).subtract(BigInteger.ONE);
//            BigInteger term3a = BigInteger.valueOf(2).pow(11 + 12 * n).subtract(BigInteger.ONE);
//            BigInteger term4a = BigInteger.valueOf(2).pow(13 + 12 * n).subtract(BigInteger.ONE);
//
//            numberList1.add(term1a);
//            numberList1.add(term2a);
//            numberList1.add(term3a);
//            numberList1.add(term4a);
//        }
//
//        return numberList1;
//    }
//
//    private static List<BigInteger> generateNumbers2(int numberOfTerms) {
//        List<BigInteger> numberList2 = new ArrayList<>();
//
//        for (int n = 0; n < numberOfTerms; n++) {
//            BigInteger term1b = BigInteger.valueOf(2).pow(3 + 10 * n).subtract(BigInteger.ONE);
//            BigInteger term2b = BigInteger.valueOf(2).pow(7 + 10 * n).subtract(BigInteger.ONE);
//            BigInteger term3b = BigInteger.valueOf(2).pow(9 + 10 * n).subtract(BigInteger.ONE);
//            BigInteger term4b = BigInteger.valueOf(2).pow(11 + 10 * n).subtract(BigInteger.ONE);
//
//            numberList2.add(term1b);
//            numberList2.add(term2b);
//            numberList2.add(term3b);
//            numberList2.add(term4b);
//        }
//
//        return numberList2;
//    }
//
//    private static void printList(List<BigInteger> list) {
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("Term " + (i + 1) + ": " + list.get(i));
//        }
//    }
//
//    private static void removeDivisibleNumbers(List<BigInteger> duplicateList, List<BigInteger> originalList) {
//        Iterator<BigInteger> iterator = duplicateList.iterator();
//
//        while (iterator.hasNext()) {
//            BigInteger currentNumber = iterator.next();
//
//            for (BigInteger originalNumber : originalList) {
//                if (!currentNumber.equals(originalNumber) && currentNumber.mod(originalNumber).equals(BigInteger.ZERO) && !currentNumber.equals(BigInteger.ONE)) {
//                    // Remove the currentNumber from the duplicate list
//                    iterator.remove();
//                    break; // Break the inner loop after removing the number
//                }
//            }
//        }
//    }
//
//    private static List<BigInteger> filterPrimes(List<BigInteger> numberList1) {
//        List<BigInteger> primeNumberList = new ArrayList<>();
//
//        for (BigInteger number : numberList1) {
//            if (checkFormula1Matches(number)) {
//                primeNumberList.add(number);
//            }
//        }
//
//        return primeNumberList;
//    }
//
//    private static boolean checkFormula1Matches(BigInteger value) {
//        // Check if a solution exists for formula1 only
//        return value.isProbablePrime(10);
//        // use above only at the end --> takes time++, filter by if both solutions are present in the list
//    }

    //VERSION 4 ************************************************************************************************************************************************
    //checking duplicate list against lists of known prime #s is slower than just checking for primes but does eliminate some options
        //******Apply filter by ending in 31 or 67 last 2 digits here to
    long startTime = System.currentTimeMillis();
    int numberOfTerms = 200; // Change this to the desired number of terms

    List<BigInteger> originalList1 = generateNumbers1(numberOfTerms);

    // Print the original list
    System.out.println("Original List1:");
    printList(originalList1);

    // Create a duplicate list
    //List<BigInteger> duplicateList1 = new ArrayList<>(originalList1);

    // Remove numbers from duplicate list that are divisible by numbers in the original list
    //removeDivisibleNumbers(originalList1, duplicateList1);
        //removeCommonElements(originalList1, duplicateList1);
    // Print the filtered list
    System.out.println("\nFiltered List:");
       printList(originalList1);

    // Create a new list containing only prime numbers from the filtered list using checkFormula1Matches
    List<BigInteger> primeNumberList = filterPrimes(originalList1);

    // Print the prime number list
    System.out.println("\nPrime Number List:");
    printList(primeNumberList);
    long endTime = System.currentTimeMillis();

    // Calculate and print the time taken in milliseconds
        System.out.println("\nTime taken: " + (endTime - startTime) + " milliseconds");
}

    private static List<BigInteger> generateNumbers1(int numberOfTerms) {
        List<BigInteger> numberList1 = new ArrayList<>();

        for (int n = 0; n < numberOfTerms; n++) {
            // If the exponent is not prime, do not generate
            int exponent1a = 5 + 12 * n;
            int exponent2a = 7 + 12 * n;
            int exponent3a = 11 + 12 * n;
            int exponent4a = 13 + 12 * n;

            if (isPrime(exponent1a)) {
                numberList1.add(BigInteger.valueOf(2).pow(exponent1a).subtract(BigInteger.ONE));
            }
            if (isPrime(exponent2a)) {
                numberList1.add(BigInteger.valueOf(2).pow(exponent2a).subtract(BigInteger.ONE));
            }
            if (isPrime(exponent3a)) {
                numberList1.add(BigInteger.valueOf(2).pow(exponent3a).subtract(BigInteger.ONE));
            }
            if (isPrime(exponent4a)) {
                numberList1.add(BigInteger.valueOf(2).pow(exponent4a).subtract(BigInteger.ONE));
            }
        }
        return numberList1;
    }


    private static void printList(List<BigInteger> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Term " + (i + 1) + ": " + list.get(i));
        }
    }

    private static void removeCommonElements(List<BigInteger> list1, List<BigInteger> list2) {
        list1.removeIf(list2::contains);
    }

    private static void removeDivisibleNumbers(List<BigInteger> duplicateList, List<BigInteger> originalList) {
        Iterator<BigInteger> iterator = duplicateList.iterator();

        while (iterator.hasNext()) {
            BigInteger currentNumber = iterator.next();

            for (BigInteger originalNumber : originalList) {
                if (!currentNumber.equals(originalNumber) && currentNumber.mod(originalNumber).equals(BigInteger.ZERO) && !currentNumber.equals(BigInteger.ONE)) {
                    // Remove the currentNumber from the duplicate list
                    iterator.remove();
                    break; // Break the inner loop after removing the number
                }
            }
        }
    }
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<BigInteger> filterPrimes(List<BigInteger> numberList1) {
        List<BigInteger> primeNumberList = new ArrayList<>();

        for (BigInteger number : numberList1) {
            if (checkFormula1Matches(number)) {
                primeNumberList.add(number);
            }
        }

        return primeNumberList;
    }

    private static boolean checkFormula1Matches(BigInteger value) {
        // Check if a solution exists for formula1 only
        return value.isProbablePrime(10);
        // use above only at the end --> takes time++, filter by if both solutions are present in the list
    }

        //CHAT GPT GENERATED
//        long startTime = System.currentTimeMillis();
//        int numberOfPrimesToGenerate = 19; // Change this value to generate more Mersenne primes
//
//        int count = 0;
//        int candidate = 2;
//
//        while (count < numberOfPrimesToGenerate) {
//            if (isMersennePrime(candidate)) {
//                System.out.println("M" + candidate + " is a Mersenne prime.");
//                count++;
//            }
//            candidate++;
//        }
//        long endTime = System.currentTimeMillis();
//        // Calculate and print the time taken in milliseconds
//        System.out.println("\nTime taken: " + (endTime - startTime) + " milliseconds");
//    }
//
//    private static boolean isMersennePrime(int p) {
//        BigInteger mersenneNumber = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
//
//        if (!mersenneNumber.isProbablePrime(10)) {
//            return false;
//        }

//        BigInteger lucasLehmerResult = BigInteger.valueOf(4);
//        BigInteger mersenneModulo = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
//
//        for (int i = 0; i < p - 2; i++) {
//            lucasLehmerResult = lucasLehmerResult.multiply(lucasLehmerResult).subtract(BigInteger.valueOf(2)).mod(mersenneModulo);
//        }
//        return lucasLehmerResult.equals(BigInteger.ZERO);
//    }
}
package com.dsalgado.examples.cleancode.chapter4;

public class EratosthenesSievePrimeGenerator {

    private static final int FIRST_PRIME = 2;

    private static boolean[] uncrossedOut;

    public static int[] generatePrimes(int maxPrimeValue){
        if (maxPrimeValue < FIRST_PRIME){
            return new int[0];
        }

        crossIntegerUpTo(maxPrimeValue + 1);
        crossOutMultiples();
        int countOfPrimes = getNumberOfPrimesInArray();

        return generateOutputForSieveMethod(countOfPrimes);
    }

    private static void crossIntegerUpTo(int arraySize){
        uncrossedOut = new boolean[arraySize];
        for(int i = 0; i < arraySize; i ++){
            uncrossedOut[i] = true;
        }
    }

    private static void crossOutMultiples(){
        uncrossedOut[0] = false;
        uncrossedOut[1] = false;
        int iterationLimit = determineIterationLimit();

        for(int i = FIRST_PRIME; i <= iterationLimit; i++){
            if(uncrossedOut[i]){
                for(int multiple = 2 * i; multiple < uncrossedOut.length; multiple += i){
                    uncrossedOut[multiple] = false;
                }
            }
        }
    }

    private static int determineIterationLimit(){
        double iterationLimit = Math.sqrt(uncrossedOut.length);
        return (int) iterationLimit ;
    }

    private static int getNumberOfPrimesInArray(){
        int countOfPrimes = 0;
        for(int i = 0; i < uncrossedOut.length; i++){
            if(uncrossedOut[i]){
                countOfPrimes++;
            }
        }
        return countOfPrimes;
    }

    private static int[] generateOutputForSieveMethod(int countOfPrimes){
        int primesGenerated[] = new int[countOfPrimes];
        for(int i = 0, j = 0; i < uncrossedOut.length; i ++)
        {
            if(uncrossedOut[i]){
                primesGenerated[j++] = i;
            }
        }

        return primesGenerated;
    }

}

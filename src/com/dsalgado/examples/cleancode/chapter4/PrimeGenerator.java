package com.dsalgado.examples.cleancode.chapter4;

public class PrimeGenerator {

    private static int FIRST_PRIME = 2;


    public static int[] generatePrimesWithEratosthenesSieve(int maxPrimeValue){
        if (maxPrimeValue < 2){
            return new int[0];
        }

        int arraySize = maxPrimeValue + 1;
        boolean[] flagsForPrimeNumberArray = createBooleanArrayWithTrues(arraySize);

        sieveMethod(flagsForPrimeNumberArray, arraySize);

        int countOfPrimes = getNumberOfPrimesInArray(flagsForPrimeNumberArray, arraySize);
        int primesGenerated[] = generateOutputForSieveMethod(flagsForPrimeNumberArray, countOfPrimes, arraySize);

        return primesGenerated;
    }

    private static boolean[] createBooleanArrayWithTrues(int arraySize){
        boolean[] arraysOfTrues = new boolean[arraySize];
        for(int i = 0; i < arraySize; i ++){
            arraysOfTrues[i] = true;
        }

        return arraysOfTrues;
    }

    private static void sieveMethod(boolean[] flagsForPrimeNumberArray, int arraySize){
        flagsForPrimeNumberArray[0] = false;
        flagsForPrimeNumberArray[1] = false;
        for(int i = FIRST_PRIME; i < Math.sqrt(arraySize); i++){
            if(flagsForPrimeNumberArray[i]){
                for(int j = 2 * i; j < arraySize; j += i){
                    flagsForPrimeNumberArray[j] = false;
                }
            }
        }
    }

    private static int getNumberOfPrimesInArray(boolean[] flagsForPrimeNumberArray, int arraySize){
        int countOfPrimes = 0;
        for(int i = 0; i < arraySize; i++){
            if(flagsForPrimeNumberArray[i]){
                countOfPrimes++;
            }
        }
        return countOfPrimes;
    }

    private static int[] generateOutputForSieveMethod(boolean[] flagsForPrimeNumberArray, int arraySize, int iterations){
        int primesGenerated[] = new int[arraySize];
        for(int i = 0, j = 0; i < iterations; i ++)
        {
            if(flagsForPrimeNumberArray[i]){
                primesGenerated[j++] = i;
            }
        }

        return primesGenerated;
    }
}

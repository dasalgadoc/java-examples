package com.dsalgado.examples;

import com.dsalgado.examples.apistream.*;
import com.dsalgado.examples.datastructures.HashSetExample;
import com.dsalgado.examples.functional.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {

    public static void main(String[] args){
        //launchHashSetExamples();
        //lauchLambdaConsumerExample();
        //lauchLambdaSupploerExample();
        //lauchLambdaFunctionExample();
        //lauchLambdaPredicateExample();
        //lauchLambdaCustomExample();

        //lauchStreamDeclaration();
        //lauchSimpleMapDeaclaration();
        //lauchFilterExample();
        //lauchOptionalExample();
        //lauchVariousExamples();
        //lauchReduceExample();

        lauchParallelExample();
    }

    public static void launchHashSetExamples(){
        System.out.println("HashSet Example:\n");

        Set<String> hs = new HashSet<>();
        HashSetExample hse = new HashSetExample(hs);

        hse.addElement("Hola");
        hse.addElement("Mundo");

        // Duplicated elements will be ignored
        hse.addElement("Hola");

        System.out.println(hse.getHashSet());
    }

    public static void lauchLambdaConsumerExample(){
        LambdaConsumerExample lce = new LambdaConsumerExample();

        lce.lambdaSimpleConsumer();
        lce.lambdaBiConsumer("Diego",30);
        lce.lambdaContracted("Hola, mundo");
        lce.lambdaAppliedToList(Arrays.asList("Uno", "Dos", "Tres"));
        lce.lambdaAppliedToObjects();
    }

    public static void lauchLambdaSupploerExample(){
        LambdaSupplierExample lse = new LambdaSupplierExample();

        lse.basicSupplier();
        lse.supplierCreatesUser();
    }

    public static void lauchLambdaFunctionExample(){
        LambdaFuncionExample lfe = new LambdaFuncionExample();

        lfe.lambdaFunctionBasic();
        lfe.lambdaBiFunctions();
    }

    public static void lauchLambdaPredicateExample(){
        LambdaPredicateExample lpe = new LambdaPredicateExample();

        lpe.lambdaPredicateBasic();
        lpe.lambdaBiPredicate();
    }

    public static void lauchLambdaCustomExample(){
        LambdaCustomExample lce = new LambdaCustomExample();

        lce.lambdaCustomBasic(10,5);
    }

    public static void lauchStreamDeclaration(){
        SimpleStreamExample sse = new SimpleStreamExample();

        sse.streamDeclaration();
        System.out.println("...");

        sse.streamForArray();
        System.out.println("...");

        sse.streamForStreamBuilder();
        System.out.println("...");

        sse.streamForCollection();
        System.out.println("...");

        sse.streamToList();
        System.out.println("...");

        sse.findElementsStream();
        System.out.println("...");

        sse.countStreamElements();
        System.out.println("...");

        sse.infiniteStreamWithGenerate(20);
        System.out.println("...");
    }

    public static void lauchSimpleMapDeaclaration(){
        MapExample me = new MapExample();

        me.simpleMapExample();

        me.mapUsingObjects();

        me.mapUsingObjectsAnSavedIntoList();
    }

    public static void lauchFilterExample(){
        FilterExample fe = new FilterExample();

        fe.basicFilter();

        fe.usingFilterWithAttributes();

        fe.existsAnyInStream();
    }

    public static void lauchOptionalExample(){
        OptionalExample oe = new OptionalExample();
        oe.nullWrapper();
        oe.optionalOrElseGet();
        oe.optionalCheckPresentEmpty();
    }

    public static void lauchVariousExamples(){
        VariousOperatorsExample voe = new VariousOperatorsExample();

        voe.checkEmpties();

        voe.checkDistinct();

        voe.intStreamAndStats();

        voe.flatMapExample();

        voe.exampleInvoice();
    }

    public static void lauchReduceExample(){
        ReduceExample re = new ReduceExample();

        re.simpleReduceExample();
    }

    public static void lauchParallelExample(){
        ParallelExample pe = new ParallelExample();

        pe.parallelStreamBasic();
    }
}

package com.dsalgado.examples;

import com.dsalgado.examples.apistream.*;
import com.dsalgado.examples.datastructures.HashSetExample;
import com.dsalgado.examples.functional.*;
import com.dsalgado.examples.threads.MyCustomThreadRunnable;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

  public static void main(String[] args) {
    // launchHashSetExamples();
    // lauchLambdaConsumerExample();
    // lauchLambdaSupploerExample();
    // lauchLambdaFunctionExample();
    // lauchLambdaPredicateExample();
    // lauchLambdaCustomExample();

    // lauchStreamDeclaration();
    // lauchSimpleMapDeaclaration();
    // lauchFilterExample();
    // lauchOptionalExample();
    // lauchVariousExamples();
    // lauchReduceExample();

    // lauchParallelExample();

    // System.out.println(EnumExample.GET);
    // System.out.println(EnumExample.GET.toString());

    // int generatePrimes[] = GeneratePrimes.generatePrimes(10);
    // int primeGenerator[] = PrimeGenerator.generatePrimesWithEratosthenesSieve(10);
    // int eratosthenes[] = EratosthenesSievePrimeGenerator.generatePrimes(10);

    // Arrays.stream(generatePrimes).forEach(System.out::println);
    // System.out.println("---");
    // Arrays.stream(primeGenerator).forEach(System.out::println);
    // System.out.println("---");
    // Arrays.stream(eratosthenes).forEach(System.out::println);

    // testOnMaps();

    // testCalendars();
    // testZoneId();

    // testEnum();
    // testList();
    // testListElements();
    // testDoubles();
    // testNico();
    // testDates();
    // testStream();
    // testStream2();
    // testRecursidad();
    // testPrintASCII();
    /// testBigDouble();
    // testNullables();

    // threadsExample();
    // listTest();
  }

  public static void listTest() {
    String listTest = "1111111111";
    for (int i = 0; i < 10000; i++) {
      long start = System.nanoTime();
      ListElements.listElements.contains(listTest);
      long end = System.nanoTime();
      System.out.println("Time: " + (end - start) / 1000);
    }
  }

  public static void threadsExample() {
    new MyCustomThreadRunnable("My thread");
    try {
      for (int i = 5; i > 0; i--) {
        System.out.println("Main thread: " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Sleep throws exception: " + e.getStackTrace());
    }
    System.out.println("End of main thread");
  }

  public static void testNullables() {
    FieldsExample field3 = new FieldsExample("Daniela", "20", false, null);

    String valueOf = String.valueOf(field3.getUserId());
    System.out.println(valueOf);
  }

  public static void testBigDouble() {
    // Double d = 20_000_000_000d;
    // BigDecimal bigDecimal = new BigDecimal(d.toString());
    BigInteger d = new BigInteger("9999999999911111111111119223372036854775808");
    System.out.println(d);
  }

  public static void testPrintASCII() {
    System.out.println(Character.toChars(8364));
    // for (int i = 0; i < 1000; i ++){
    //    System.out.print("- " + String.valueOf(Character.toChars(i)));
    // }
  }

  public static void testRecursidad() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Hola FOR " + i);
    }
    sayHello(0, 10);

    // Stack overflow
  }

  public static void sayHello(Integer number, Integer iterations) {
    System.out.println("Hola Function " + number);
    if (number < iterations - 1) {
      sayHello(number + 1, iterations);
    }
  }

  public static void testStream2() {
    List<Integer> list = List.of(1, 2, 3, 4, 5);

    System.out.println(list);

    list = list.stream().map(l -> l % 2 == 1 ? 0 : l).collect(Collectors.toList());

    System.out.println(list);
  }

  public static void testStream() {
    List<String> list = List.of("A", "B", "C");
    List<String> copyCat = new ArrayList<>();
    list.stream().map(lista -> lista.toLowerCase(Locale.ROOT)).forEach(lista -> copyCat.add(lista));

    System.out.println(copyCat);
  }

  public static void testDates() {
    String pattern = "yyyy-MM-dd'T'HH:mm:ssXXX";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    Date xx = new Date();
    String date = simpleDateFormat.format(xx);

    String date1 = date.substring(0, date.indexOf("T") + 1) + "08:00:00-03:00";
    System.out.println(date);
    System.out.println(date.indexOf("T") + 1);
    System.out.println(date1);

    Calendar cal = Calendar.getInstance();
    cal.setTime(xx);
    cal.add(Calendar.DATE, 1);
    Date xy = cal.getTime();
    String dd = simpleDateFormat.format(xy);
    System.out.println(dd);
  }

  public static void testNico() {
    // List<String> listString = Collections.EMPTY_LIST;
    // List<Long> listLong = Collections.EMPTY_LIST;

    // System.out.println(listString.isEmpty());
    // System.out.println(listLong.isEmpty());

    Long userId = 1168820642L;
    String user = userId.toString();

    System.out.println(userId);
    System.out.println(user);

    String boat = "Missi";

    System.out.println(boat);

    boat = boat.concat("sippi");

    System.out.println(boat);
  }

  public static void testDoubles() {
    Double number = 100d;
    System.out.println(number);

    String numberString = String.format("The number is %s", number);
    System.out.println(numberString);
  }

  public static void testListElements() {
    FieldsExample field1 = new FieldsExample("Diego", "20", true);
    FieldsExample field2 = new FieldsExample("Alex", "10", false);
    FieldsExample field3 = new FieldsExample("Daniela", "20", false);
    FieldsExample field4 = new FieldsExample("Aleja", "10", false);
    FieldsExample field5 = new FieldsExample("Luis", "20", false);

    List<FieldsExample> listL = new ArrayList<>();
    listL.add(field1);
    listL.add(field2);
    listL.add(field3);
    listL.add(field4);
    listL.add(field5);

    List<Boolean> mayores =
        listL.stream().map(FieldsExample::isMayorEdad).collect(Collectors.toList());

    System.out.println(mayores);

    System.out.println(mayores.contains(Boolean.TRUE));
  }

  public static void testList() {
    List<String> vocalesMayus = List.of("A", "E", "I", "O", "U");
    List<String> vocalesMinus = List.of("a", "e", "i", "o", "u");

    System.out.println(vocalesMayus);
    System.out.println(vocalesMinus);

    List<String> newList =
        Stream.concat(vocalesMayus.stream(), vocalesMinus.stream()).collect(Collectors.toList());

    System.out.println(newList);
  }

  public static void testEnum() {
    List<String> enumTest = List.of("GET", "POST", "PATCH");

    for (String part : enumTest) {

      for (EnumExample example : EnumExample.values()) {
        if (example.name().equals(part)) {
          System.out.println("OK " + part);
        }
      }
    }
    for (String part : enumTest) {
      System.out.println(
          Arrays.stream(EnumExample.values()).anyMatch((t) -> t.name().equals(part)));
    }
  }

  public static void testOnMaps() {
    Map<List<String>, String> myHash = new ConcurrentHashMap<>();

    myHash.put(List.of("DIARIO", "FINANCIERO", "NATURAL", "TRASNFERENCIA"), "D-F-N-T");
    myHash.put(List.of("NOCTURNO", "FINANCIERO", "NATURAL", "TRASNFERENCIA"), "N-F-N-T");
    myHash.put(List.of("DIARIO", "PERSONALIZADO", "NATURAL", "TRASNFERENCIA"), "D-P-N-T");
    myHash.put(List.of("DIARIO", "PERSONALIZADO", "NATURAL", "TRASNFERENCIA"), "AAAAZ");

    System.out.println(myHash);

    List<String> list1 = List.of("DIARIO", "FINANCIERO", "NATURAL", "TRASNFERENCIA");

    List<String> list2 = new ArrayList<>();
    list2.add("DIARIO");
    list2.add("FINANCIERO");
    list2.add("NATURAL");
    list2.add("TRASNFERENCIA");

    System.out.println(myHash.get(list1));
    System.out.println(myHash.get(list2));
    System.out.println(list1.equals(list2));
  }

  public static void testZoneId() {
    ZoneId colombia = ZoneId.of("America/Bogota");
    ZoneId brasil = ZoneId.of("America/Sao_Paulo");
    LocalTime horaCol = LocalTime.now(colombia);
    LocalTime horaBra = LocalTime.now(brasil);
    System.out.println(colombia + " " + horaCol);
    System.out.println(brasil + " " + horaBra);
  }

  public static void testCalendars() {
    Date currentTime = Calendar.getInstance().getTime();
    // LocalTime target = LocalTime.parse( "00:30:00" ) ;
    LocalTime target = LocalTime.now();
    boolean targetInZone =
        (target.isAfter(LocalTime.parse("20:00:00"))
            && target.isBefore(LocalTime.parse("23:59:59.999")));
    boolean targetInZone2 =
        (target.isAfter(LocalTime.parse("00:00:00"))
            && target.isBefore(LocalTime.parse("05:59:59.999")));
    System.out.println(currentTime);
    System.out.println(targetInZone || targetInZone2);
  }

  public static void launchHashSetExamples() {
    System.out.println("HashSet Example:\n");

    Set<String> hs = new HashSet<>();
    HashSetExample hse = new HashSetExample(hs);

    hse.addElement("Hola");
    hse.addElement("Mundo");

    // Duplicated elements will be ignored
    hse.addElement("Hola");

    System.out.println(hse.getHashSet());
  }

  public static void lauchLambdaConsumerExample() {
    LambdaConsumerExample lce = new LambdaConsumerExample();

    lce.lambdaSimpleConsumer();
    System.out.println("--->");
    lce.lambdaBiConsumer("Diego", 30);
    System.out.println("--->");
    lce.lambdaContracted("Hola, mundo");
    System.out.println("--->");
    lce.lambdaAppliedToList(Arrays.asList("Uno", "Dos", "Tres"));
    System.out.println("--->");
    lce.lambdaAppliedToObjects();
    System.out.println("--->");
  }

  public static void lauchLambdaSupploerExample() {
    LambdaSupplierExample lse = new LambdaSupplierExample();

    lse.basicSupplier();
    lse.supplierCreatesUser();
  }

  public static void lauchLambdaFunctionExample() {
    LambdaFuncionExample lfe = new LambdaFuncionExample();

    lfe.lambdaFunctionBasic();
    lfe.lambdaBiFunctions();

    lfe.functionExample();
  }

  public static void lauchLambdaPredicateExample() {
    LambdaPredicateExample lpe = new LambdaPredicateExample();

    lpe.lambdaPredicateBasic();
    lpe.lambdaBiPredicate();
  }

  public static void lauchLambdaCustomExample() {
    LambdaCustomExample lce = new LambdaCustomExample();

    lce.lambdaCustomBasic(10, 5);
  }

  public static void lauchStreamDeclaration() {
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

  public static void lauchSimpleMapDeaclaration() {
    MapExample me = new MapExample();

    me.simpleMapExample();

    me.mapUsingObjects();

    me.mapUsingObjectsAnSavedIntoList();
  }

  public static void lauchFilterExample() {
    FilterExample fe = new FilterExample();

    fe.basicFilter();

    fe.usingFilterWithAttributes();

    fe.existsAnyInStream();
  }

  public static void lauchOptionalExample() {
    OptionalExample oe = new OptionalExample();
    oe.nullWrapper();
    oe.optionalOrElseGet();
    oe.optionalCheckPresentEmpty();
  }

  public static void lauchVariousExamples() {
    VariousOperatorsExample voe = new VariousOperatorsExample();

    voe.checkEmpties();

    voe.checkDistinct();

    voe.intStreamAndStats();

    voe.flatMapExample();

    voe.exampleInvoice();
  }

  public static void lauchReduceExample() {
    ReduceExample re = new ReduceExample();

    re.simpleReduceExample();
  }

  public static void lauchParallelExample() {
    ParallelExample pe = new ParallelExample();

    pe.parallelStreamBasic();
  }
}

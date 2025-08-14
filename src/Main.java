import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Print the non-repeating characters in a string
        String input = "Programming";
        Map<Character, Long> NonRepeatingChar = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

        NonRepeatingChar.entrySet().stream()
                        .filter(entry -> entry.getValue() == 1 )
                                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println(" ");

        //Calculate the frequency of each word in the given string.
        String input1 = "London Brigde is falling down falling down";
        Map<String, Long> FreqOfWord = Arrays.stream(input1.split(" "))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        System.out.println("The Frequency of each word in string is :" + FreqOfWord);

        //find largest and second largest number in array.

        List<Integer> arrays = Arrays.asList(1,2,34,21,22,22,1,2,4,5,6,2,21);
        List<Integer> answer = arrays.stream().distinct().sorted(Comparator.reverseOrder()).limit(2).toList();
        System.out.println("Largest in the array " + answer.get(0));
        System.out.println("Second Largest in the array " + answer.get(1));

        //Return a Map with ID as key and salary as value from list of employees.

        List<Employee> employees = Arrays.asList(
                new Employee(101, "zlice", 50000),
                new Employee(102, "Bob", 50000),
                new Employee(103, "jharlie", 62000),
                new Employee(104, "David", 62000),
                new Employee(105, "Eve", 48000)
        );
        Map<Integer,Double> salaryClassification = employees.stream().collect(Collectors.toMap(Employee::getId,Employee::getSalary));
        System.out.println("Salary Classification : " + salaryClassification);

        //Find the Duplicate value an given array
        Map<Integer, Long> listofDuplicates = arrays.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        List<Integer> duplicate = new ArrayList<>();
                listofDuplicates.forEach((key,value) -> {
                    if(value > 1) {
                        duplicate.add(key);
                    }
                    });
        System.out.println("Duplicate values in array are : " + duplicate);

        //Write a program to comma separated value in given Array.
        String[] names = {"Shri","Shru","Swa","Sur","Mouni"};
        String commaSeparatedValue = Arrays.stream(names).collect(Collectors.joining(","));
        System.out.print(Arrays.toString(names));
        System.out.println(" : " + commaSeparatedValue);

        // Find First Non-Repeated Character in a String
        //String input = "Programming";
        Map<Character, Long> Char = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));

         Optional<Map.Entry<Character,Long>> nonRepeatingChar =   Char.entrySet().stream()
                 .filter(entry->entry.getValue() <2)
                 .findFirst();
         System.out.println("First Non-Repeated Character in a String : " + nonRepeatingChar);


         //Find the Duplicate Elements in a List
        List<Character> DuplicateElements = Char.entrySet().stream()
                .filter(entry ->entry.getValue() >1)
                .map(Map.Entry::getKey)
                        .toList();
        System.out.println("Duplicate Elements in a Lsi" + DuplicateElements);

        //Sort a List of Strings by Length
        List<String> fruits = Arrays.asList("Apple", "Cat", "Banana");
        List<String> sortedListofFruits = fruits.stream().sorted(Comparator.comparing(entry ->entry.length())).toList();
        System.out.println(sortedListofFruits);

        //Convert a List of Strings to Uppercase
        List<String> fruitstoUpperCase = sortedListofFruits.stream().map(String::toUpperCase).toList();
        System.out.println("Fruits to Upper Case : " + fruitstoUpperCase);

        //Find Max and Min Value from a List of Integers
        //List<Integer> arrays = Arrays.asList(1,2,34,21,22,22,1,2,4,5,6,2,21);
        Optional<Integer> minValue = arrays.stream().min(Integer::compareTo);
        Optional<Integer> maxValue = arrays.stream().max(Integer::compareTo);
        System.out.println("Max and Min value from " + arrays + " are : " + maxValue + " ," + minValue);

        //Sort List of Employees by Name or Salary
        List<Employee> sortByEmpSalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
        System.out.println(sortByEmpSalary);

        //group the students by their marks descending order
        Map<Double,List<String>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getSalary,Collectors.mapping(Employee::getName,Collectors.toList())));
        System.out.println(grouped);

        grouped.entrySet().stream()
                .sorted(Map.Entry.<Double,List<String>>comparingByKey(Comparator.reverseOrder()))
                .forEach(
                        entry -> {
                            List<String> name = entry.getValue();
                            Collections.sort(name);
                            System.out.println(name);

                        });



    }



    }


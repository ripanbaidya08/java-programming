package com.java.ripan.sapp;

import java.lang.*;
import java.util.*;

class SortElements{
    public List<Integer> sortIntegerElementsInAscendingOrder(List<Integer> integerElement){
        Collections.sort(integerElement);
        return integerElement;
    }
    public List<Double> sortDoubleElementsInAscendingOrder(List<Double> doubleElement){
        Collections.sort(doubleElement);
        return doubleElement;
    }
    public List<String> sortStringElementsInAscendingOrder(List<String> stringElement){
        Collections.sort(stringElement);
        return stringElement;
    }
    public List<Character> sortCharacterElementsInAscendingOrder(List<Character> characterElement){
        Collections.sort(characterElement);
        return characterElement;
    }

}
public class CustomizedSorting {
    public static List<Integer> selectIntegers(List<Object> mixedElement){
        List<Integer> selectedIntegers = new ArrayList<>();
        for(Object element : mixedElement ){
            if(element instanceof Integer){
                selectedIntegers.add((Integer)element);
            }
        }
        return selectedIntegers;
    }
    public static List<Double> selectDoubles(List<Object> mixedElement){
        List<Double> selectedDoubles = new ArrayList<>();
        for(Object element : mixedElement ){
            if(element instanceof Double){
                selectedDoubles.add((Double)element);
            }
        }
        return selectedDoubles;
    }
    public static List<String> selectStrings(List<Object> mixedElement){
        List<String> selectedStrings = new ArrayList<>();
        for(Object element : mixedElement ){
            if(element instanceof String){
                selectedStrings.add((String) element);
            }
        }
        return selectedStrings;
    }
    public static List<Character> selectCharacters(List<Object> mixedElement){
        List<Character> selectedCharacters = new ArrayList<>();
        for(Object element : mixedElement ){
            if(element instanceof Character){
                selectedCharacters.add((Character) element);
            }
        }
        return selectedCharacters;
    }
    public static void main(String[] args){
        List<Object> mixedObject = new ArrayList<Object>(List.of(3,10.3,4.3,1,20,'d',"ripan","andrew","luke","trishtan",5,'T','h',"nate"));
        Scanner scanner = new Scanner(System.in);
        SortElements sortElements = new SortElements(); // object creation ...
        System.out.println("Elements are : ");
        System.out.println(mixedObject);
        System.out.println("Enter which data you want to sort : [int, double, string, char]");
        String answer = scanner.next();

        switch (answer){
            case "int":
                List<Integer> integerList = selectIntegers(mixedObject);
                System.out.println("Unsorted integer elements are : "+integerList);
                List<Integer> sortIntElements = sortElements.sortIntegerElementsInAscendingOrder(integerList);
                System.out.println("Sorted integer elements are : "+sortIntElements);
                break;
            case "double":
                List<Double> doubleList = selectDoubles(mixedObject);
                System.out.println("Unsorted integer elements are : "+doubleList);
                List<Double> sortDoubleElements = sortElements.sortDoubleElementsInAscendingOrder(doubleList);
                System.out.println("Sorted double elements are : "+sortDoubleElements);
                break;
            case "string":
                List<String> stringList = selectStrings(mixedObject);
                System.out.println("Unsorted integer elements are : "+stringList);
                List<String> sortStringElements = sortElements.sortStringElementsInAscendingOrder(stringList);
                System.out.println("Sorted string Elements are : "+sortStringElements);
                break;
            case "char":
                List<Character> characterList = selectCharacters(mixedObject);
                System.out.println("Unsorted integer elements are : "+characterList);
                List<Character> sortCharacterElements = sortElements.sortCharacterElementsInAscendingOrder(characterList);
                System.out.println("Sorted character elements are : "+sortCharacterElements);
                break;
            default:
                System.out.println("Please enter the valid data .. ");
        }
    }
}

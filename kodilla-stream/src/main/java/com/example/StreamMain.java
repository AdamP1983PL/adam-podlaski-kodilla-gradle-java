package com.example;

import com.kodilla.stream.Book.Book;
import com.kodilla.stream.Book.BookDirectory;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumUsers.Forum;
import com.kodilla.stream.forumUsers.ForumUser;
import com.kodilla.stream.forumUsers.Sex;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.reference.FunctionalCalculator;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("xxxxxxxxxxxxxxx_Zadanie: funkcyjny spacer po liście użytkowników forum_xxxxxxxxxxxxxxxxxxx");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

        Forum forum = new Forum();
        Map<Integer, ForumUser> resultForumUsersMap = forum.getForumUsersList()
                .stream()
                .filter(sex -> sex.getSex().equals(Sex.M))
                .filter(age -> LocalDate.now().minusYears(age.getDob().getYear()).getYear() >= 20)
                .filter(posts -> posts.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getIdentityNumber, forumUser -> forumUser));

        resultForumUsersMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);


        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx_THE_END_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");

//        People.getList().stream().forEach(s -> System.out.print(s + ", "));
//        System.out.println("\n");
//
//        List<String> peopleList = People.getList();
//        peopleList.forEach(s -> System.out.print(s + ", "));
//        System.out.println("\n");
//
//        List<String> upperCaseList = People.getList()
//                .stream()
//                .map(String::toUpperCase)
//                .toList();
//
//        upperCaseList.forEach(s -> System.out.print(s + ", "));
//        System.out.println("\n");
//
//        List<String> lowerCaseList = People.getList()
//                .stream()
//                .map(s -> s.toLowerCase())
//                .toList();
//
//        lowerCaseList.forEach(s -> System.out.print(s + ", "));
//        System.out.println("\n");
//
//        People.getList()
//                .stream()
//                .filter(s -> s.length() > 11)
//                .forEach(c -> System.out.print(c + ", "));
//        System.out.println("\n");
//
//        System.out.println("Cascade operations");
//        People.getList()
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.length() > 11)
//                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
//                .filter(s -> s.substring(0, 1).equals("M"))
//                .forEach(System.out::println);

//        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

//        System.out.println("\n\n");
//        System.out.println("x".repeat(24));
//        System.out.println("BOOK DIRECTORY EXAMPLE: ");
//        System.out.println("x".repeat(24));
//        System.out.println();
//
//        BookDirectory theBookDirectory = new BookDirectory();
//        theBookDirectory.getList()
//                .stream()
//                .filter(book -> book.getYearOfPublication() > 2005)
//                .forEach(System.out::println);
//
//        System.out.println();
//
//        List<Book> theResultListOfBooks = theBookDirectory.getList()
//                .stream()
//                .filter(b -> b.getYearOfPublication() > 2005)
//                .collect(Collectors.toList());
//
//        System.out.println("Collectors.toList(): ");
//        System.out.println("# elements: " + theResultListOfBooks.size());
//        theResultListOfBooks.stream().forEach(System.out::println);
//
//        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx_Collectors.toMap()_xxxxxxxxxxxxxxxxxxxxxxxxx");
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
//
//        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList()
//                .stream()
//                .filter(b -> b.getYearOfPublication() > 2005)
//                .collect(Collectors.toMap(Book::getSignature, b -> b));
//
//        System.out.println("Collectors.toMap(): ");
//        System.out.println("# elements: " + theResultMapOfBooks.size());
//        theResultMapOfBooks.entrySet()
//                .stream()
//                .map(entry -> entry.getKey() + " : " + entry.getValue())
//                .forEach(System.out::println);
//
//        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx_Collectors.joining()_xxxxxxxxxxxxxxxxxxxxxxxxx");
//        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
//
//        String theResultStringOfBooks = theBookDirectory.getList()
//                .stream()
//                .filter(b -> b.getYearOfPublication() > 2005)
//                .map(Book::toString)
//                .collect(Collectors.joining(",\n", "<<", ">>"));
//
//        System.out.println(theResultStringOfBooks);


//        Processor processor = new Processor();
//        Executor codeToExecute = () -> System.out.println("Lambda, example text");
//        processor.execute(codeToExecute);
//
//        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
//
//        System.out.println("Lambda: ");
//        expressionExecutor.executeExpression(10, 5, Double::sum);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
//        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);
//
//        System.out.println("Method reference:");
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
//        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
//
//        PoemBeautifier poemBeautifier = new PoemBeautifier();
//        String textToBeautify = "Ala ma kota";
//        poemBeautifier.beautify(textToBeautify, String::toUpperCase);
//        poemBeautifier.beautify(textToBeautify, String::toLowerCase);
//        poemBeautifier.beautify(textToBeautify, s -> "xxx_" + s + "_xxx");
//        poemBeautifier.beautify(textToBeautify, s -> s.replaceAll("Ala", "Romek"));
//
//        System.out.println("Using Stream to generate even numbers");
//        NumbersGenerator.generateEven(20);


    }
}

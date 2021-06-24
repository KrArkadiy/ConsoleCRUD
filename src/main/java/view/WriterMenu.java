package view;

import model.Writer;

import java.util.Scanner;

import static repository.Implementation.JsonWriterRepositoryImpl.*;

public class WriterMenu {
    public static void Menu(){
        System.out.println("===Menu===");
        System.out.println("1.Add new writer.");
        System.out.println("2.Update writer.");
        System.out.println("3.Remove writer.");
        System.out.println("4.Choose new option.");
    }
}


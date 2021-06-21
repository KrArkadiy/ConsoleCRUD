package view;

import model.Label;
import model.Writer;

import java.util.Scanner;

import static repository.JsonWriterRepositoryImpl.*;

public class WriterMenu {
    public static void Menu(){
        System.out.println("===Menu===");
        System.out.println("1.Add new writer.");
        System.out.println("2.Update writer.");
        System.out.println("3.Remove writer.");
        System.out.println("4.Choose new option.");

        Scanner sc = new Scanner(System.in);
        int enteredOption = sc.nextInt();
        switch (enteredOption){
            case 1:
                addWriter(new Writer());
            case 2:
                updateWriter(new Writer());
            case 3:
                removeWriter(new Writer().getId());
        }
    }
}


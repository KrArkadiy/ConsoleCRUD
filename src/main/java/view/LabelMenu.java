package view;

import model.Label;
import repository.JsonLabelRepositoryImpl;
import repository.LabelRepository;

import static repository.JsonLabelRepositoryImpl.*;

import java.util.Scanner;

public class LabelMenu {
    public static void Menu(){
        System.out.println("===Menu===");
        System.out.println("1.Add new label.");
        System.out.println("2.Update label.");
        System.out.println("3.Remove label.");
        System.out.println("4.Choose new option.");

        Scanner sc = new Scanner(System.in);
        int enteredOption = sc.nextInt();
        switch (enteredOption){
            case 1:
                addLabel(new Label());
            case 2:
                updateLabel(new Label());
            case 3:
                removeLabel(new Label().getId());
        }
    }
}

package view;

import model.Post;

import java.util.Scanner;

import static repository.Implementation.JsonPostRepositoryImpl.*;

public class PostMenu {
    public static void Menu(){
        System.out.println("===Menu===");
        System.out.println("1.Add new post.");
        System.out.println("2.Update post.");
        System.out.println("3.Remove post.");
        System.out.println("4.Choose new option.");

        Scanner sc = new Scanner(System.in);
        int enteredOption = sc.nextInt();
        /*switch (enteredOption){
            case 1:
                addPost(new Post());
            case 2:
                updatePost(new Post());
            case 3:
                removePost(new Post().getId());
        }*/
    }
}


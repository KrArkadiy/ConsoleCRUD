package view;

import controller.LabelController;
import controller.PostController;
import controller.WriterController;

import java.util.Scanner;

public class ConsoleFunctionality {
    private Scanner sc = new Scanner(System.in);

    private String options = "Выберите сущность\n" +
            "1. Label\n" +
            "2. Writer\n" +
            "3. Post\n" +
            "4. Exit\n";

    //creating controllers
    LabelController labelController = new LabelController();
    WriterController writerController = new WriterController();
    PostController postController = new PostController();

    //creating views
    BasicView labelView = new LabelView(sc, labelController);
    BasicView writerView = new WriterView(sc, writerController);
    BasicView postView = new PostView(sc, postController);

    public void run() {
        boolean isExit = false;
        while (true) {
            System.out.println(options);
            String option = sc.next();
            switch (option) {
                case "1":
                    labelView.show();
                    break;
                case "2":
                    writerView.show();
                    break;
                case "3":
                    postView.show();
                    break;
                case "4":
                    isExit = true;
                    break;
            }
            if (isExit) {
                break;
            }
        }
    }
}

package view;

import controller.WriterController;

import java.util.Scanner;

public abstract class BasicView {

    protected Scanner sc;

    abstract void getById();

    abstract void getAll();

    abstract void deleteById();

    abstract void save();

    abstract void update();

    public void show(){
        boolean isExit = false;
        String option = sc.next();
        while (true){
            switch (option){
                case "1":
                    getById();
                    break;
                case "2" :
                    getAll();
                    break;
                case "3":
                    save();
                    break;
                case "4":
                    update();
                    break;
                case "5":
                    deleteById();
                    break;
                case "6":
                    isExit = true;
                    break;
            }
            if (isExit){
                return;
            }
        }
    }
}

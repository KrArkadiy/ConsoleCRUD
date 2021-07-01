package view;

import controller.LabelController;
import model.Label;
import repository.Implementation.JsonLabelRepositoryImpl;

import static repository.Implementation.JsonLabelRepositoryImpl.*;

import java.util.Scanner;

public class LabelView extends BasicView {

    LabelController labelController;

    private final String menuMessage = "Выберете действие над label:\n" +
            "1. Получение label по номеру\n" +
            "2. Вывести список всех label\n" +
            "3. Добавить label\n" +
            "4. Редактировать label\n" +
            "5. Удалить label\n" +
            "6. Выход";

    public LabelView(LabelController labelController, Scanner sc){
        this.labelController = labelController;
        this.sc = sc;
    }

    public LabelView(Scanner sc, LabelController labelController) {
        this.sc = sc;
        this.labelController = labelController;
    }


    public void getById() {
        System.out.println(menuMessage);
        Integer id = sc.nextInt();
        try {
            Label label = labelController.getById(id);
            System.out.println(label.getName());
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void getAll() {
        System.out.println(menuMessage);
        try {
            System.out.println(labelController.getAll());
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void deleteById() {
        System.out.println(menuMessage);
        System.out.println("Введите id удаляемого post");
        Integer id = sc.nextInt();
        try {
            labelController.deleteById(id);
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void save() {
        System.out.println(menuMessage);
        System.out.println("Введите имя label");
        String name = sc.nextLine();
        System.out.println("Введите id для label");
        Integer id = sc.nextInt();
        try{
            Label newOne = new Label(name, id);
            labelController.save(newOne);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    public void update() {
        System.out.println(menuMessage);
        System.out.println("Введите имя label");
        String name = sc.nextLine();
        System.out.println("Введите id для label");
        Integer id = sc.nextInt();
        try{
            Label updatedLabel = new Label(name, id);
            labelController.update(updatedLabel);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }
}


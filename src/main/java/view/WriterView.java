package view;

import controller.PostController;
import controller.WriterController;
import model.Writer;

import java.util.Scanner;


public class WriterView extends BasicView{

    WriterController writerController;
    PostController postController;

    private final String menuMessage = "Выберете действие над label:\n" +
            "1. Получение label по номеру\n" +
            "2. Вывести список всех label\n" +
            "3. Добавить label\n" +
            "4. Редактировать label\n" +
            "5. Удалить label\n" +
            "6. Выход";


    void getById() {
        System.out.println(menuMessage);
        Integer id = sc.nextInt();
        try {
            writerController.getById(id);
            System.out.println("Операция успешно выполнена");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void getAll() {
        System.out.println(menuMessage);
        try {
            System.out.println(writerController.getAll());
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void deleteById() {
        System.out.println(menuMessage);
        System.out.println("Введите id удаляемого post");
        Integer id = sc.nextInt();
        try {
            writerController.deleteById(id);
            System.out.println("Операция успешно выполнена");
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void save() {
        System.out.println(menuMessage);
        System.out.println("Введите имя writer");
        String name = sc.nextLine();
        System.out.println("Введите id для writer");
        Integer id = sc.nextInt();
        try{
            Writer newOne = new Writer(id, name, postController.getAll());
            writerController.save(newOne);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }

    void update() {
        System.out.println(menuMessage);
        System.out.println("Введите имя writer");
        String name = sc.nextLine();
        System.out.println("Введите id для writer");
        Integer id = sc.nextInt();
        try{
            Writer updatedWriter = new Writer(id, name, postController.getAll());
            writerController.update(updatedWriter);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Возникла ошибка");
        }
    }
}



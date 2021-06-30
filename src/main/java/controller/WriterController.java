package controller;

import model.Writer;
import repository.Implementation.JsonWriterRepositoryImpl;

import java.util.List;

public class WriterController {


    WriterController writerController;

    public WriterController() {

    }

    public List<Writer> getAll(){
        return writerController.getAll();
    }

    public Writer getById(Integer aInteger){
        return writerController.getById(aInteger);
    }

    public void save(Writer writer){
        writerController.save(writer);
    }

    public void update(Writer writer){
        writerController.update(writer);
    }

    public void deleteById(Integer aInteger){
        writerController.deleteById(aInteger);
    }
}

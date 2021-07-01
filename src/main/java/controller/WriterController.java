package controller;

import model.Writer;
import repository.Implementation.JsonPostRepositoryImpl;
import repository.Implementation.JsonWriterRepositoryImpl;
import repository.WriterRepository;

import java.util.List;

public class WriterController {


    WriterRepository jsonWriterRepository = new JsonWriterRepositoryImpl();

    public WriterController() {

    }

    public List<Writer> getAll(){
        return jsonWriterRepository.getAll();
    }

    public Writer getById(Integer aInteger){
        return jsonWriterRepository.getById(aInteger);
    }

    public void save(Writer writer){
        jsonWriterRepository.save(writer);
    }

    public void update(Writer writer){
        jsonWriterRepository.update(writer);
    }

    public void deleteById(Integer aInteger){
        jsonWriterRepository.deleteById(aInteger);
    }
}

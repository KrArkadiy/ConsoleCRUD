package controller;

import model.Post;
import repository.Implementation.JsonPostRepositoryImpl;

import java.util.List;

public class PostController {

    JsonPostRepositoryImpl jsonPostRepository;

    public PostController(JsonPostRepositoryImpl jsonPostRepository) {
        this.jsonPostRepository = jsonPostRepository;
    }

    public List<Post> getAll(){
        return jsonPostRepository.getAll();
    }

    public Post getById(Integer aInteger){
        return jsonPostRepository.getById(aInteger);
    }

    public void save(Post post){
        jsonPostRepository.save(post);
    }

    public void update(Post post){
        jsonPostRepository.update(post);
    }

    public void deleteById(Integer aInteger){
        jsonPostRepository.deleteById(aInteger);
    }
}

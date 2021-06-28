package repository.Implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Post;
import model.Writer;
import repository.PostRepository;
import utility.Utility;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonPostRepositoryImpl implements PostRepository {

    private final static String FILE_NAME = "posts.json";

    @Override
    public Post getById(Integer aInteger) {
        List<Post> posts = arrayDeserialization(Utility.read(FILE_NAME));
        Post post = posts.stream().filter((s)->s.getId().equals(aInteger)).findFirst().get();
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = arrayDeserialization(Utility.read(FILE_NAME));
        return posts;
    }

    @Override
    public void save(Post post) {
        Utility.write(FILE_NAME, serialization(post));
    }

    @Override
    public void update(Post post) {
        deleteById(post.getId());
        save(post);
    }

    @Override
    public void deleteById(Integer aInteger) {
        List<Post> posts = arrayDeserialization(Utility.read(FILE_NAME));
        Post deletedPost = posts.stream().filter((s)->s.getId().equals(aInteger)).findFirst().get();
        posts.remove(deletedPost);

        Utility.writeList(FILE_NAME, serialization(posts));
    }
    
    public String serialization(Post post){
        String json = new Gson().toJson(post);
        return json;
    }

    public List<String> serialization(List<Post> data){
        List<String> serialized = new ArrayList<>();
        for(Post post : data){
            String json = new Gson().toJson(post);
            serialized.add(json);
        }
        return serialized;
    }

    public List<Post> arrayDeserialization(List<String> data){
        List<Post> posts = new ArrayList<>();
        Type targetClassType = new TypeToken<ArrayList<Post>>(){}.getType();

        for(String post : data){
            posts = new Gson().fromJson(post, targetClassType);
        }
        return posts;
    }
}

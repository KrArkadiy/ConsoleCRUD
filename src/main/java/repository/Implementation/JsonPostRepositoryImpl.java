package repository.Implementation;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Post;
import model.Writer;
import repository.PostRepository;
import utility.Utility;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class JsonPostRepositoryImpl implements PostRepository {

    private final static String FILE_NAME = "posts.json";
    private final Gson gson = new Gson();

    @Override
    public Post getById(Integer aInteger) {
        return arrayDeserialization(Utility.read(FILE_NAME))
                .stream()
                .filter((s)->s.getId().equals(aInteger))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return arrayDeserialization(Utility.read(FILE_NAME));
    }

    @Override
    public Post save(Post post) {
        post.setId(generateNewId());
        Utility.write(FILE_NAME, serialization(post));
        return post;
    }

    @Override
    public Post update(Post post) {
        List<Post> posts = arrayDeserialization(Utility.read(FILE_NAME));
        posts.forEach(p->{
            if(p.getId().equals(post.getId())){
                p.setContent(post.getContent());
            }
        });
        Utility.writeList(FILE_NAME, serialization(posts));
        return post;
    }

    @Override
    public void deleteById(Integer aInteger) {
        List<Post> posts = arrayDeserialization(Utility.read(FILE_NAME));
        posts.removeIf(p->p.getId().equals(aInteger));
        Utility.writeList(FILE_NAME, serialization(posts));
    }
    
    public String serialization(Post post){
        String json = gson.toJson(post);
        return json;
    }

    public List<String> serialization(List<Post> data){
        List<String> serialized = new ArrayList<>();
        for(Post post : data){
            String json = gson.toJson(post);
            serialized.add(json);
        }
        return serialized;
    }

    public List<Post> arrayDeserialization(List<String> data){
        List<Post> posts = new ArrayList<>();
        Type targetClassType = new TypeToken<ArrayList<Post>>(){}.getType();

        for(String post : data){
            posts = gson.fromJson(post, targetClassType);
        }
        return posts;
    }

    public Integer generateNewId(){
        Post maxIdPost = arrayDeserialization(Utility.read(FILE_NAME)).stream().max(Comparator.comparing(Post::getId))
                .orElse(null);
        return Objects.nonNull(maxIdPost) ? maxIdPost.getId() + 1 : 1;
    }
}

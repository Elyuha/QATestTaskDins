import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class Controller {
    private HttpService httpService;

    public Controller(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        httpService = retrofit.create(HttpService.class);
    }

    public POJO getPostById(long id){
        Call<POJO> postById = httpService.getPostById(id);
        try {
            POJO body = postById.execute().body();
            return body;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<POJO> getPostsByUserId(long id){
        Call<List<POJO>> postsByUserId = httpService.getPostsByUserId(id);
        try {
            List<POJO> body = postsByUserId.execute().body();
            return body;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<POJO> getAllPosts(){
        Call<List<POJO>> allPosts = httpService.getAllPosts();
        try {
            List<POJO> body = allPosts.execute().body();
            return body;
        } catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}

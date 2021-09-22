import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface HttpService {
    @GET("posts/")
    Call<POJO> getPostById(@Path("id") Long id);

    @GET("posts/?")
    Call<List<POJO>> getPostsByUserId(@Query("userId") Long userId);

    @GET("posts/")
    Call<List<POJO>> getAllPosts();
}

package rest;

import java.util.List;

import model.Hero;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dakshgargas
 */

public interface ApiInterface {
    @GET("marvel")
    Call<List<Hero>> getHeros();
}

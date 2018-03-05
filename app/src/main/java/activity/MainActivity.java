package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dakshgargas.simplifiedcodingdagger.R;

import java.util.List;

import model.Hero;
import rest.ApiInterface;
import rest.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listViewHeroes);
    }

    public void hitIt(View view) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Hero>> call = apiInterface.getHeros();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                int statusCode = response.code();
                if(response.body() != null )
                {
                    List<Hero> heroList = response.body();

                    //Creating an String array for the ListView
                    String[] heroes = new String[heroList.size()];

                    //looping through all the heroes and inserting the names inside the string array
                    for (int i = 0; i < heroList.size(); i++) {
                        heroes[i] = heroList.get(i).getName();
                    }


                    //displaying the string array into listview
                    listView.setAdapter(new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, heroes));
                }else{

                }

            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

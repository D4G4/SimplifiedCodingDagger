package dashboard;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import di.ApiComponent;
import di.DaggerApiComponent;
import di.modules.ApiModule;
import di.modules.AppModule;
import utils.Urls;

/**
 * Created by dakshgargas
 */

public class AppController extends Application {

    private ApiComponent mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApiComponent = DaggerApiComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(Urls.BASE_URL))
                .build();
    }

    public ApiComponent getNetComponent() {
        return mApiComponent;
    }
}

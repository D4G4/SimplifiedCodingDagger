package di;

import javax.inject.Singleton;

import activity.MainActivity;
import dagger.Component;
import di.modules.ApiModule;
import di.modules.AppModule;

/**
 * Created by dakshgargas
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface ApiComponent {
    void inject(MainActivity activity);
}

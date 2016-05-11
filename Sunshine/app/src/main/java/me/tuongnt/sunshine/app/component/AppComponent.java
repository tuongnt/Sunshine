package me.tuongnt.sunshine.app.component;

import javax.inject.Singleton;

import dagger.Component;
import me.tuongnt.sunshine.app.module.ApplicationModule;
import me.tuongnt.sunshine.app.module.NetworkModule;
import me.tuongnt.sunshine.app.module.RepositoryModule;
import me.tuongnt.sunshine.ui.common.Router;
import me.tuongnt.sunshine.ui.home.view.HomeFragment;

/**
 * Created by TuongNguyen on 5/10/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class, RepositoryModule.class, NetworkModule.class})
public interface AppComponent {
    Router getRouter();

    void inject(HomeFragment homeFragment);
}

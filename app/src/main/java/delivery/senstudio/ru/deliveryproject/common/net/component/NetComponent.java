package delivery.senstudio.ru.deliveryproject.common.net.component;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Singleton;

import dagger.Component;
import delivery.senstudio.ru.deliveryproject.common.Activity.CurrencyActivity;
import delivery.senstudio.ru.deliveryproject.common.Activity.DateActivity;
import delivery.senstudio.ru.deliveryproject.common.net.module.AppModule;
import delivery.senstudio.ru.deliveryproject.common.net.module.NetModule;

@Singleton
@Component(modules = {NetModule.class})
public interface NetComponent {
    void inject(CurrencyActivity activity);
    void inject(DateActivity activity);
}
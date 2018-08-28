package delivery.senstudio.ru.deliveryproject;

import android.app.Application;

import delivery.senstudio.ru.deliveryproject.common.net.component.DaggerNetComponent;
import delivery.senstudio.ru.deliveryproject.common.net.component.NetComponent;
import delivery.senstudio.ru.deliveryproject.common.net.module.NetModule;

public class App extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();



        mNetComponent = DaggerNetComponent.builder()
                .netModule(new NetModule("http://www.cbr.ru/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}

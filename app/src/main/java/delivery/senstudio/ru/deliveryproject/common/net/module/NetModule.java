package delivery.senstudio.ru.deliveryproject.common.net.module;

import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module
public class NetModule {

    String mBaseUrl;

    public NetModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())))
                .baseUrl(mBaseUrl)
                .build();
    }
}

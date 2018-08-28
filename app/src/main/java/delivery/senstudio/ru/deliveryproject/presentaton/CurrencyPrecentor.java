package delivery.senstudio.ru.deliveryproject.presentaton;



import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import delivery.senstudio.ru.deliveryproject.App;
import delivery.senstudio.ru.deliveryproject.common.net.ResponseCallback;
import delivery.senstudio.ru.deliveryproject.common.net.api.API;
import delivery.senstudio.ru.deliveryproject.model.Currency;
import delivery.senstudio.ru.deliveryproject.model.Valute;
import delivery.senstudio.ru.deliveryproject.view.CurrencyView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@InjectViewState
public class CurrencyPrecentor extends MvpPresenter<CurrencyView> {


    Retrofit mRetrofit;
    Locale mLocale;

    public CurrencyPrecentor() {


    }

    public void setLocale(Locale locale) {
        this.mLocale = locale;
    }

    public void getCurrency(String date) {

        getViewState().showLading();
    Call<Currency> requestGetCurrency  =  mRetrofit.create(API.class).getCurrencys(date);

    requestGetCurrency.enqueue(new Callback<Currency>() {
        @Override
        public void onResponse(Call<Currency> call, Response<Currency> response) {

            getViewState().hideLoading();
            if(response.body() != null) {

                Currency cur = response.body();

                List<String> arrayList = new ArrayList<>();

                if( cur == null || cur.getValuteList() == null ) {
                    getViewState().refreshDates(arrayList);
                    return;
                }

                for( Valute valute: cur.getValuteList()) {
                    if (valute.getCharCode().equals("USD") || valute.getCharCode().equals("EUR")) {

                        String value = valute.getValue();
                        if( !Locale.getDefault().getLanguage().equals("en")) {
                           value = valute.getValue().replace(",",".");
                        }

                        arrayList.add(valute.getName() +
                                " : " + value + " " + valute.getCharCode());
                    }


                }

                getViewState().refreshDates(arrayList);

            }
        }

        @Override
        public void onFailure(Call<Currency> call, Throwable t) {

            getViewState().refreshDates(new ArrayList<String>());
            getViewState().hideLoading();
            getViewState().showMessage("");
        }
    });


    }

    public void setRetrofit(Retrofit retrofit) {
        this.mRetrofit = retrofit;
    }
}

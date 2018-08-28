package delivery.senstudio.ru.deliveryproject.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import delivery.senstudio.ru.deliveryproject.common.Activity.MainView;

public interface CurrencyView extends MvpView,MainView {

    void refreshDates(List<String> currencys);
}


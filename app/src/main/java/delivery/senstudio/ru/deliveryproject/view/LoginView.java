package delivery.senstudio.ru.deliveryproject.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import delivery.senstudio.ru.deliveryproject.common.Activity.MainView;

public interface LoginView extends MvpView, MainView {
    void showMessage(int message);

    void refreshDates(List<String> dates);

    void openActivityDate(String date);
}

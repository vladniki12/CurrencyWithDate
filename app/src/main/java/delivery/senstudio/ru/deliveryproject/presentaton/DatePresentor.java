package delivery.senstudio.ru.deliveryproject.presentaton;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import delivery.senstudio.ru.deliveryproject.view.LoginView;

@InjectViewState
public class DatePresentor extends MvpPresenter<LoginView> {
    List<String> mDateList = new ArrayList<>();

    long mCurrentTimeMillis = 0L;
    Calendar mCalendar = null;
    SimpleDateFormat mFormatter = null;

    public static int MAX_SIZE_ELEMENT = 30;

    public DatePresentor() {

    }

    public void initRecyclerView() {

        mCalendar = Calendar.getInstance();
        mCurrentTimeMillis = mCalendar.getTimeInMillis();

        mFormatter = new SimpleDateFormat("dd/MM/yyyy");

        updateDateList();

        getViewState().refreshDates(mDateList);
    }

    public void openActivityWithDate(int index) {
        String date = mDateList.get(index);
        getViewState().openActivityDate(date);
    }

    public void updateList() {
        getViewState().showLading();

        updateDateList();

        getViewState().refreshDates(mDateList);

        getViewState().hideLoading();
    }

    private void updateDateList() {
        for( int i = 0; i < MAX_SIZE_ELEMENT; i++) {

            String dateString = mFormatter.format(mCalendar.getTime());

            mDateList.add(dateString);

            mCurrentTimeMillis += 24 * 60 * 60 * 1000;

            mCalendar.setTimeInMillis(mCurrentTimeMillis);

        }
    }
}

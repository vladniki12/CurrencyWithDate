package delivery.senstudio.ru.deliveryproject.common.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import delivery.senstudio.ru.deliveryproject.App;
import delivery.senstudio.ru.deliveryproject.R;
import delivery.senstudio.ru.deliveryproject.common.Adapter.DateAdapter;
import delivery.senstudio.ru.deliveryproject.presentaton.DatePresentor;
import delivery.senstudio.ru.deliveryproject.view.LoginView;
import retrofit2.Retrofit;

public class DateActivity extends MainAppActivity implements LoginView {




    @InjectPresenter
    DatePresentor mDatePresentor;

    @Inject
    Retrofit mRetrofit;

    @BindView(R.id.date_recycler_view)
    RecyclerView mDateRecyclerView;

    @BindView(R.id.date_toolbar)
    Toolbar mTollBarView;


    LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_activity);

        ButterKnife.bind(this);

        ((App) getApplication()).getNetComponent().inject(this);



        mDateRecyclerView.setLayoutManager(mLayoutManager);

        mDatePresentor.initRecyclerView();

        setSupportActionBar(mTollBarView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setTitle(R.string.date_title);



        mDateRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0) //check for scroll down
                {

                    int visibleItemCount = mLayoutManager.getChildCount();
                    int totalItemCount = mLayoutManager.getItemCount();
                    int pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();


                        if ( (visibleItemCount + pastVisiblesItems) >= totalItemCount)
                        {
                                mDatePresentor.updateList();
                            //Do pagination.. i.e. fetch new data
                        }

                }
            }

        });
    }




    @Override
    public void showMessage(int message) {
        //test.setText(String.valueOf(message));
    }

    @Override
    public void refreshDates(List<String> dates) {

        DateAdapter dateAdapter = new DateAdapter(dates, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = mDateRecyclerView.getChildLayoutPosition(view);
                mDatePresentor.openActivityWithDate(itemPosition);
            }
        });

        mDateRecyclerView.setAdapter(dateAdapter);
        mLayoutManager.scrollToPosition(dates.size() - DatePresentor.MAX_SIZE_ELEMENT);
    }

    @Override
    public void openActivityDate(String date) {


        Intent intendDateActivity = new Intent(this, CurrencyActivity.class);
        intendDateActivity.putExtra("date", date);

        startActivity(intendDateActivity);
    }
}

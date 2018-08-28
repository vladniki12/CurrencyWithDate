package delivery.senstudio.ru.deliveryproject.common.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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
import delivery.senstudio.ru.deliveryproject.presentaton.CurrencyPrecentor;
import delivery.senstudio.ru.deliveryproject.view.CurrencyView;
import retrofit2.Retrofit;

public class CurrencyActivity extends MainAppActivity implements CurrencyView {

    @InjectPresenter
    CurrencyPrecentor mCurrencyPresentor;

    @Inject
    Retrofit mRetrofit;

    @BindView(R.id.currency_recucler_view)
    RecyclerView mCurrencyRecylerView;

    @BindView(R.id.currency_toolbar)
    Toolbar mToolBarView;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.currency_activity);

        ButterKnife.bind(this);

        String date = getIntent().getStringExtra("date");

        ((App) getApplication()).getNetComponent().inject(this);

        setSupportActionBar(mToolBarView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setTitle(getString(R.string.currency_title)+ " " + date);

        mToolBarView.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mCurrencyPresentor.setRetrofit(mRetrofit);

        mCurrencyPresentor.getCurrency(date);

        mCurrencyRecylerView.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    public void refreshDates(List<String> currencys) {

        if( currencys.size() == 0 ) {
            currencys.add(getString(R.string.no_date));
        }
        DateAdapter dateAdapter = new DateAdapter(currencys, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        mCurrencyRecylerView.setAdapter(dateAdapter);
    }


}

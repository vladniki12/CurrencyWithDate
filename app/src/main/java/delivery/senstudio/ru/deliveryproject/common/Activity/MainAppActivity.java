package delivery.senstudio.ru.deliveryproject.common.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;

import delivery.senstudio.ru.deliveryproject.R;

public class MainAppActivity extends MvpAppCompatActivity implements MainView {

    ProgressDialog mProgressDialog = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(R.string.loading));
    }

    @Override
    public void showLading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showMessage(String message) {
        Toast toast = Toast.makeText(getApplicationContext(),
                getString(R.string.error), Toast.LENGTH_LONG);
        toast.show();
    }
}

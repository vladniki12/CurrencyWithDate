package delivery.senstudio.ru.deliveryproject.common.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import delivery.senstudio.ru.deliveryproject.R;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {


    List<String> mData = null;
    private View.OnClickListener mOnClickListener = null;


    public DateAdapter(List<String> data, View.OnClickListener onClickListener) {
        this.mData = data;
        this.mOnClickListener = onClickListener;
    }

    @NonNull
    @Override
    public DateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewItemDate = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_date_list, viewGroup, false);

        viewItemDate.setOnClickListener(mOnClickListener);
        DateViewHolder vh = new DateViewHolder(viewItemDate);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DateViewHolder dateViewHolder, int i) {
        dateViewHolder.setTitleItem(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class DateViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.date_text_view)
        public TextView mTextView;
        public DateViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);

        }

        public void setTitleItem(String titleText) {
            mTextView.setText(titleText);
        }
    }
}

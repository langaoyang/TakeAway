package org.alan.takeaway.veiw.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.alan.takeaway.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/14.
 */

public class SimpleHomeHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_outter_adapter_text)
    public TextView tvOutterAdapterText;

    public SimpleHomeHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

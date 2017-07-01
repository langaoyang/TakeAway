package org.alan.takeaway.veiw.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.alan.takeaway.R;
import org.alan.takeaway.veiw.holder.SimpleHomeHolder;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */

public class SimpleHomeAdapter extends RecyclerView.Adapter<SimpleHomeHolder> {
    private List<String> mData;

    public SimpleHomeAdapter(List<String> mData) {
        this.mData = mData;
    }

    @Override
    public SimpleHomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_outteradapter, parent, false);
        return new SimpleHomeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SimpleHomeHolder holder, int position) {
        holder.tvOutterAdapterText.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

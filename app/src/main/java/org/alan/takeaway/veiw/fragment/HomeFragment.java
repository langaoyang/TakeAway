package org.alan.takeaway.veiw.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.alan.takeaway.R;
import org.alan.takeaway.presenter.HomePresenter;
import org.alan.takeaway.utils.LogUtils;
import org.alan.takeaway.veiw.adapter.SimpleHomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/4/1.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.rv_home)
    RecyclerView recyclerView;
    Unbinder unbinder;
    @BindView(R.id.home_tv_address)
    TextView homeTvAddress;
    @BindView(R.id.ll_title_search)
    LinearLayout llTitleSearch;
    @BindView(R.id.toolbar)
    LinearLayout toolbar;
    private int mDistance;
    private int mMaxDistance = 500; //透明度改变的滑动量。
    private
    RecyclerView.OnScrollListener listener = new RecyclerView.OnScrollListener() {
        // 处理   滑动事件
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            mDistance += dy;
            if (mDistance <= mMaxDistance) {

                float percent = (mMaxDistance - mDistance) * 1f / mMaxDistance;
                LogUtils.e(percent);
                int alpha = (int) (percent * 255);
                int argb = Color.argb(alpha, 57, 174, 255);
                //将这个argb传递给homeActivity当中的标题。
                toolbar.setBackgroundColor(argb);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        HomePresenter homePresenter = new HomePresenter(this);
        homePresenter.loadData();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void showLoading() {
        Toast.makeText(getActivity(), "加载中", Toast.LENGTH_SHORT).show();
    }

    public void showRv(List<String> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new SimpleHomeAdapter(list));

        recyclerView.addOnScrollListener(listener);
    }
}

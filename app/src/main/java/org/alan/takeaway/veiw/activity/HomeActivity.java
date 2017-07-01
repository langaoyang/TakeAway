package org.alan.takeaway.veiw.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.alan.takeaway.R;
import org.alan.takeaway.veiw.fragment.HomeFragment;
import org.alan.takeaway.veiw.fragment.MoreFragment;
import org.alan.takeaway.veiw.fragment.OrderFragment;
import org.alan.takeaway.veiw.fragment.UserFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.home_fragments)
    FrameLayout homeFragments;
    @BindView(R.id.home_tabs)
    LinearLayout homeTabs;
    private int mCurrentTag;
    Fragment[] fragments = {new HomeFragment(), new OrderFragment(), new UserFragment(), new MoreFragment()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        //初始化每个选项卡enable
        mCurrentTag = 0;
        initTabs();
        selectIndexTab(0);
        initStatusBar(getResources().getColor(R.color.colorPrimary));

    }


    private void initTabs() {
        final int childCount = homeTabs.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final LinearLayout childAt = (LinearLayout) homeTabs.getChildAt(i);
            final int finalI = i;
            childAt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCurrentTag = finalI;
                    selectIndexTab(childCount);
                }
            });

        }
    }

    private void selectIndexTab(int childCount) {
        for (int i = 0; i < childCount; i++) {
            LinearLayout childAt = (LinearLayout) homeTabs.getChildAt(i);
            ImageView imageView = (ImageView) childAt.getChildAt(0);
            TextView textView = (TextView) childAt.getChildAt(1);
            if (mCurrentTag == i) {
                imageView.setEnabled(false);
                textView.setEnabled(false);
            } else {
                imageView.setEnabled(true);
                textView.setEnabled(true);
            }
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.home_fragments, fragments[mCurrentTag]).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}

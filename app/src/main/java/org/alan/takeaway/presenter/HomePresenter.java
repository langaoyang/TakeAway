package org.alan.takeaway.presenter;

import org.alan.takeaway.veiw.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/5.
 */

public class HomePresenter {

    private HomeFragment view;

    public HomePresenter(HomeFragment view) {
        this.view = view;
    }

    public void loadData() {
        view.showLoading();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("商家    " + i);
        }
        //显示rv
        view.showRv(list);
    }
}

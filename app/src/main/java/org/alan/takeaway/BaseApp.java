package org.alan.takeaway;

import android.app.Application;

import org.alan.takeaway.utils.LogUtils;
import org.alan.takeaway.utils.Utils;

/**
 * Created by Administrator on 2017/7/1.
 */

public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        LogUtils.init(true,false,'e',"alan");
    }
}

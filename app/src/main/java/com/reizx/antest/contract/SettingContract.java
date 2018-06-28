package com.reizx.antest.contract;

import com.reizx.antest.presenter.common.IBasePresenter;
import com.reizx.antest.view.common.BaseView;

public class SettingContract {
    public interface View extends BaseView {
        void showIpStatus(String msg);
    }

    public interface  Presenter extends IBasePresenter<View> {
    }
}

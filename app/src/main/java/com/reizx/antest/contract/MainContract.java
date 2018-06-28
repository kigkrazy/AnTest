package com.reizx.antest.contract;

import com.reizx.antest.presenter.common.IBasePresenter;
import com.reizx.antest.view.common.BaseView;

public class MainContract {
    public interface View extends BaseView {

    }

    public interface Presenter extends IBasePresenter<View> {

    }
}

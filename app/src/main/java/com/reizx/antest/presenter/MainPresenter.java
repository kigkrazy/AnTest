package com.reizx.antest.presenter;

import com.reizx.antest.contract.MainContract;
import com.reizx.antest.presenter.common.BasePresenterImpl;

import javax.inject.Inject;

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {
    @Inject
    public MainPresenter() {
    }
}

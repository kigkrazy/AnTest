package com.reizx.asf.view.fragment;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.reizx.asf.R;
import com.reizx.asf.contract.SettingContract;
import com.reizx.asf.presenter.SettingPresenter;
import com.reizx.asf.view.common.BaseFragment;

import butterknife.BindView;

public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingContract.View {
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;

    @Override
    public int getFragmentLayoutID() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initAllMembersView() {
        super.initAllMembersView();
        initTopBar();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().Inject(this);
    }

    public void initTopBar() {
        mTopBar.setTitle("设置");
    }
}
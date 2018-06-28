package com.reizx.antest.view.fragment;

import android.widget.TextView;

import com.qmuiteam.qmui.widget.QMUITopBar;
import com.reizx.antest.R;
import com.reizx.antest.contract.SettingContract;
import com.reizx.antest.presenter.SettingPresenter;
import com.reizx.antest.view.common.BaseFragment;

import butterknife.BindView;

public class SettingFragment extends BaseFragment<SettingPresenter> implements SettingContract.View {
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;

    @BindView(R.id.tv_setting_page_show_ip_des)
    TextView tvIpStatus;

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

    @Override
    public void showIpStatus(String msg) {
        tvIpStatus.setText(msg);
    }
}

package com.reizx.antest.view.fragment;

import android.provider.Settings;
import android.util.Base64;
import android.widget.EditText;

import com.blankj.utilcode.util.FileUtils;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.reizx.antest.R;
import com.reizx.antest.component.wdj.WdjUtil;
import com.reizx.antest.contract.HomeConstract;
import com.reizx.antest.presenter.HomePresenter;
import com.reizx.antest.util.AsfMgrLog;
import com.reizx.antest.view.common.BaseFragment;
import com.ta.utdid2.device.UTDevice;

import org.joor.Reflect;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeConstract.View{
    @BindView(R.id.topbar)
    QMUITopBar mTopBar;

    @BindView(R.id.et_app_show_log)
    EditText etLog;

    @OnClick(R.id.btn_app_genutdid_lib)
    public void startGenUtdidLib(){
        cleanUtdid();
        String utdid = UTDevice.getUtdid(app);
        etLog.append(utdid + "\n");
    }

    @OnClick(R.id.btn_app_genutdid_util)
    public void startGenUtdidUtil(){
        String imei = "123456789012345";
        try {
            String utdid = Base64.encodeToString(WdjUtil._generateUtdid(imei), 2);
            etLog.append(utdid + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }


    @OnClick(R.id.btn_app_clean_sharedpreferences)
    public void stopZkService(){
        cleanSharedPreferences();
    }

    @OnClick(R.id.btn_app_request_ip)
    public void requestIp(){
        presenter.showCurrentIp();
    }

    @Override
    public int getFragmentLayoutID() {
        return R.layout.fragment_home;
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

    public void initTopBar(){
        mTopBar.setTitle("主页");
    }

    @Override
    public void showErrorMsg(String msg) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    @Override
    public void setCurrentIp(String ip) {
        etLog.setText(ip);
    }

    public void cleanUtdid(){
        //反射清空数据
        Reflect.on("com.ta.utdid2.device.b" , app.getClassLoader()).set("a", null);
        Settings.System.putString(app.getContentResolver(), "dxCRMxhQkdGePGnp", "");
        Settings.System.putString(app.getContentResolver(), "mqBRboGZkQPcAkyk", "");
        FileUtils.deleteDir(new File("/sdcard/.UTSystemConfig"));
        FileUtils.deleteDir(new File("/sdcard/.DataStorage"));
        cleanSharedPreferences();
    }

    public void cleanSharedPreferences(){
        boolean rel = FileUtils.deleteAllInDir("/data/data/" + app.getPackageName() + "/shared_prefs");
        AsfMgrLog.d("clean SharedPreferences result : " + rel);
    }
}

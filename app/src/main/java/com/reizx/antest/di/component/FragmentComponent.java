package com.reizx.antest.di.component;

import android.app.Activity;

import com.reizx.antest.di.module.FragmentModule;
import com.reizx.antest.di.scope.FragmentScope;
import com.reizx.antest.view.fragment.HomeFragment;
import com.reizx.antest.view.fragment.MainFragment;
import com.reizx.antest.view.fragment.SettingFragment;

import dagger.Component;

/**
 * Created by kigkrazy on 18-5-12.
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void Inject(HomeFragment homeFragment);

    void Inject(SettingFragment settingFragment);

    void Inject(MainFragment settingFragment);
}

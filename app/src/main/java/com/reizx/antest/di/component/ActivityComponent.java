package com.reizx.antest.di.component;

import android.app.Activity;

import com.reizx.antest.di.module.ActivityModule;
import com.reizx.antest.di.scope.ActivityScope;
import com.reizx.antest.view.MainActivity;

import dagger.Component;

/**
 * Created by kigkrazy on 18-5-12.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
    
    void inject(MainActivity mainActivity);
}

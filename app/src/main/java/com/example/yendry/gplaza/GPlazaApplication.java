package com.example.yendry.gplaza;

import android.app.Application;

import com.example.yendry.gplaza.di.components.AppComponent;
import com.example.yendry.gplaza.di.components.DaggerAppComponent;
import com.example.yendry.gplaza.di.models.AppModule;
import com.example.yendry.gplaza.di.models.NetWorkModule;

public class GPlazaApplication extends Application {

    private final String URL_BASE = "https://reqres.in/";
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netWorkModule(new NetWorkModule(URL_BASE))
                .build();
    }

    public AppComponent getComponent() {
        return component;
    }
}

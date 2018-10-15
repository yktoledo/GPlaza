package com.example.yendry.gplaza.di.components;

import com.example.yendry.gplaza.di.models.AppModule;
import com.example.yendry.gplaza.di.models.NetWorkModule;
import com.example.yendry.gplaza.presentation.view.AddUserFragment;
import com.example.yendry.gplaza.presentation.view.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetWorkModule.class})
public interface AppComponent {
    void inject(HomeFragment homeFragment);

    void inject(AddUserFragment addUserFragment);
}

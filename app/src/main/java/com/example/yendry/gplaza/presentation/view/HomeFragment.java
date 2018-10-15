package com.example.yendry.gplaza.presentation.view;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yendry.gplaza.GPlazaApplication;
import com.example.yendry.gplaza.R;
import com.example.yendry.gplaza.base.BaseFragment;
import com.example.yendry.gplaza.domain.model.User;
import com.example.yendry.gplaza.domain.usecases.GetListUseCase;
import com.example.yendry.gplaza.presentation.viewmodel.HomeViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();

    HomeViewModel viewModel;
    @Inject GetListUseCase useCase;
    RecyclerView rv;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        init(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new HomeViewModel(useCase);
            }
        }).get(HomeViewModel.class);
        viewModel.setFragment(this);
        viewModel.init();
    }

    private void init(View view) {
        rv = view.findViewById(R.id.rv);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((GPlazaApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    public void showList(List<User> users) {
        Log.d(TAG, "showList: ");
    }
}

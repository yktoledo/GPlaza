package com.example.yendry.gplaza.presentation.view;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yendry.gplaza.GPlazaApplication;
import com.example.yendry.gplaza.MainActivity;
import com.example.yendry.gplaza.R;
import com.example.yendry.gplaza.base.BaseFragment;
import com.example.yendry.gplaza.domain.model.UserEntity;
import com.example.yendry.gplaza.domain.usecases.CreateUseCase;
import com.example.yendry.gplaza.presentation.viewmodel.AddUserViewModel;
import com.example.yendry.gplaza.presentation.viewmodel.HomeViewModel;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends BaseFragment {

    @Inject
    CreateUseCase useCase;
    private AddUserViewModel viewModel;
    private EditText userNameInput, jobInput;
    private Button cancel, submit;


    public AddUserFragment() {
        // Required empty public constructor
    }

    public static AddUserFragment newInstance() {

        Bundle args = new Bundle();

        AddUserFragment fragment = new AddUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);


        init(view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((GPlazaApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new AddUserViewModel(useCase);
            }
        }).get(AddUserViewModel.class);
        viewModel.setFragment(this);
        viewModel.init();
    }

    private void init(View view) {
        cancel = view.findViewById(R.id.cancel);
        submit = view.findViewById(R.id.submit_btn);
        userNameInput = view.findViewById(R.id.user_name);
        jobInput = view.findViewById(R.id.user_job);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).hideKeyboard();
                getActivity().onBackPressed();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(userNameInput.getText()) && !TextUtils.isEmpty(jobInput.getText())) {
                    viewModel.createUser(new UserEntity(userNameInput.getText().toString(), jobInput.getText().toString()));
                    ((MainActivity) getActivity()).hideKeyboard();
                    showProgress(true);
                }else {
                    Toast.makeText(getContext(), "Please provide data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showProgress(boolean show) {
        ((MainActivity) getActivity()).showProgress(show);
    }

    public void cleanData(){
        userNameInput.setText("");
        jobInput.setText("");
    }

}

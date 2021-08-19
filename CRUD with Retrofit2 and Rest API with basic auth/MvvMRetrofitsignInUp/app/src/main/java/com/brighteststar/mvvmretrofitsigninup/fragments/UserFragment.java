package com.brighteststar.mvvmretrofitsigninup.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brighteststar.mvvmretrofitsigninup.R;
import com.brighteststar.mvvmretrofitsigninup.adapter.UsersAdapter;
import com.brighteststar.mvvmretrofitsigninup.databinding.FragmentUserBinding;
import com.brighteststar.mvvmretrofitsigninup.models.User;
import com.brighteststar.mvvmretrofitsigninup.models.UsersResponse;
import com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels.SettingFragmentViewModel;
import com.brighteststar.mvvmretrofitsigninup.viewModels.fragmentViewModels.UserFragmentViewModel;

import java.util.List;


public class UserFragment extends Fragment {
    FragmentUserBinding fragmentUserBinding;
    UserFragmentViewModel userFragmentViewModel;
    View view;
    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    private List<User> userList;
    public UserFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        fragmentUserBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_user, container, false);
        view=fragmentUserBinding.getRoot();
        userFragmentViewModel = ViewModelProviders.of(this).get(UserFragmentViewModel.class);
        fragmentUserBinding.setUserviewmodel(userFragmentViewModel);
        fragmentUserBinding.setLifecycleOwner(this);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        userFragmentViewModel.getAllUserslivedata().observe(this, new Observer<UsersResponse>() {
            @Override
            public void onChanged(UsersResponse usersResponse) {
                userList=usersResponse.getUsers();
                adapter = new UsersAdapter(getActivity(), userList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });



        return view;
    }
}
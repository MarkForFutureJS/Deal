package com.money.lava.deal.view;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.money.lava.deal.R;

public class WelcomeFragment extends Fragment {


    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        getActivity().setTitle("Welcome");
        findWidgets(view);

        return view;
    }

    private void findWidgets(View v) {

        TextView tvLend = (TextView) v.findViewById(R.id.tvLendTitle);
        TextView tvBorrow = (TextView) v.findViewById(R.id.tvBorrowTitle);

        tvLend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LendFragment lendFragment = new LendFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, lendFragment)
                .addToBackStack(null)
                .commit();
            }
        });

        tvBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BorrowFragment borrowFragment = new BorrowFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, borrowFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        TextView tvRegisterAsLender = (TextView) v.findViewById(R.id.tvRegisterLender);
        TextView tvRegisterAsBorrower = (TextView) v.findViewById(R.id.tvRegisterBorrower);

        tvRegisterAsLender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterAsLenderFragment registerAsLenderFragment = new RegisterAsLenderFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, registerAsLenderFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        tvRegisterAsBorrower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterAsBorrowerFragment registerAsBorrowerFragment = new RegisterAsBorrowerFragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, registerAsBorrowerFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}

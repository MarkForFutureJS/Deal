package com.money.lava.deal.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.money.lava.deal.R;
import com.money.lava.deal.adapter.UserAdapter;
import com.money.lava.deal.db.UserTable;
import com.money.lava.deal.model.Login.User;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Context context;

    public UserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_borrow, container, false);

        context = getActivity();
        getActivity().setTitle("Borrow");

        findWidgets(view);

        getUsers();

        return view;
    }

    private void findWidgets(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void getUsers() {
        new AsyncTask<Void, Void, Void>() {

            List<User> users = new ArrayList<>();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... params) {

                UserTable userTable = new UserTable(context);
                users = userTable.getAll();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapter = new UserAdapter(context, users, getChildFragmentManager());
                recyclerView.setAdapter(adapter);
            }
        }.execute();
    }
}

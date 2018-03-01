package com.money.lava.deal.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.money.lava.deal.R;
import com.money.lava.deal.db.LendTable;
import com.money.lava.deal.db.UserTable;
import com.money.lava.deal.model.LendItem;
import com.money.lava.deal.model.Login.User;

import de.greenrobot.event.EventBus;

public class RegisterAsLenderFragment extends Fragment {

    EditText etName;
    Context context;

    public RegisterAsLenderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_as_lender, container, false);
        getActivity().setTitle("Register As Lender");
        findWidgets(view);
        context = getActivity();

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        return view;
    }

    private void findWidgets(View view) {
        etName = (EditText) view.findViewById(R.id.etName);
        LinearLayout llRegister = (LinearLayout) view.findViewById(R.id.ll_register);
        llRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertUserTable(view, etName.getText().toString());
            }
        });
    }

    private void insertUserTable(final View view, final String username) {
        new AsyncTask<Void, Void, User>() {

            ProgressDialog dialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                dialog = new ProgressDialog(context);
                dialog.setMessage("Loading...");
                dialog.show();
            }

            @Override
            protected User doInBackground(Void... params) {

                UserTable userTable = new UserTable(context);
                User user = new User(username, UserTable.TYPE_LENDER);
                userTable.insert(user);

                return user;
            }

            @Override
            protected void onPostExecute(User user) {
                super.onPostExecute(user);


                dialog.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Success!");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                        Bundle bundle = new Bundle();
                        bundle.putString("username", username);
                        LendFragment lendFragment = new LendFragment();
                        lendFragment.setArguments(bundle);

                        transaction.replace(R.id.main_container, lendFragment).commit();

                        InputMethodManager im = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        im.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                });
                builder.show();

            }
        }.execute();
    }

}

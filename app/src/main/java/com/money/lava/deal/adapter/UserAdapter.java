package com.money.lava.deal.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.money.lava.deal.R;
import com.money.lava.deal.db.UserTable;
import com.money.lava.deal.model.Login.User;

import java.util.List;
import com.money.lava.deal.db.UserTable;

/**
 * Created by Mark on 2018/3/1.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;
    private Context context;
    private FragmentManager fragmentManager;

    public UserAdapter(Context context, List<User> users, FragmentManager fm) {
        this.users = users;
        this.context = context;
        this.fragmentManager = fm;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUsername;
        public TextView tvType;
        public ViewHolder(View v) {
            super(v);

            tvUsername = (TextView) v.findViewById(R.id.tvUsername);
            tvType = (TextView) v.findViewById(R.id.tvType);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = users.get(position);

        holder.tvUsername.setText(user.getUsername());
        holder.tvType.setText(user.getType() == UserTable.TYPE_LENDER ? "Lender" : "Borrower");
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

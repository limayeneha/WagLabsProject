package com.limayeneha.waglabsproject.ui;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.limayeneha.waglabsproject.R;
import com.limayeneha.waglabsproject.databinding.ListItemUserBinding;
import com.limayeneha.waglabsproject.model.User;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.annotations.NonNull;

/**
 * Created by limayeneha on 3/11/19.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {


    private List<User> users;
    private Context context;

    public UserAdapter(final Context context, final List<User> users) {
        this.context = context;
        this.users = users;
    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {

        ListItemUserBinding binding;


        public UserViewHolder(ListItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void update(User user) {
            binding.setUser(user);
            binding.executePendingBindings();
        }
    }

    public void setUserItems(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                             int viewType) {
        ListItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(
                parent.getContext()), R.layout.list_item_user, parent, false);
        return new UserViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        User user = users.get(position);
        holder.update(user);
        Picasso.get()
                .load(user.getProfileImage())
                .error(R.drawable.ic_launcher_background)
                .into(holder.binding.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.binding.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        Picasso.get()
                                .load(user.getProfileImage())
                                .error(R.drawable.ic_launcher_background)
                                .into(holder.binding.imageView, new Callback() {
                                    @Override
                                    public void onSuccess() {
                                        holder.binding.progressBar.setVisibility(View.GONE);
                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        Log.v("Picasso", "Could not fetch image");
                                    }
                                });

                    }
                });
        holder.binding.bronze.setText(context.getResources().getString(R.string.bronze, user.getBadges().get("bronze")));
        holder.binding.silver.setText(context.getResources().getString(R.string.silver, user.getBadges().get("silver")));
        holder.binding.gold.setText(context.getResources().getString(R.string.gold, user.getBadges().get("gold")));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}

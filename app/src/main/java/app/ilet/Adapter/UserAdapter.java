package app.ilet.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import app.ilet.Activity.MessageActivity;
import app.ilet.Model.User;
import app.ilet.R;

public class UserAdapter extends RecyclerView.Adapter {
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private Context mContext;
    private List<User> mUsers;


    public UserAdapter(Context mContext, List<User> mUsers ) {
        this.mUsers = mUsers;
        this.mContext = mContext;

    }



    @Override
    public int getItemViewType(int position) {
        return mUsers.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;
        if (viewType == VIEW_ITEM) {
            View v =  LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);

            vh = new UViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UViewHolder) {
            final User user = mUsers.get(position);
            ((UViewHolder) holder).username.setText(user.getUsername());
            ((UViewHolder) holder).profile_image.setImageResource(R.drawable.user);



            ((UViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MessageActivity.class);
                    intent.putExtra("userid", user.getId());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
                }
            });

            ((UViewHolder) holder).profile_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class UViewHolder extends RecyclerView.ViewHolder {

        public TextView username;
        public ImageView profile_image;

        public UViewHolder(View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            profile_image = itemView.findViewById(R.id.profile_image);
        }

    }




}

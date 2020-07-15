package RecycleViewUsage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingviewpagerrecycleviewfragmentcardview.R;

import java.util.List;

import DataUtils.FetchAllData;

public class MyVideoAdapter extends RecyclerView.Adapter <MyVideoAdapter.MyVideoViewHolder>{
    LayoutInflater inflater;
    List<String>videoList;
    public MyVideoAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        videoList = FetchAllData.getVideoList();
    }

    @NonNull
    @Override
    public MyVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyVideoViewHolder(inflater.inflate(R.layout.card_view,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyVideoViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.video);
        holder.textView.setText(videoList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class MyVideoViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyVideoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

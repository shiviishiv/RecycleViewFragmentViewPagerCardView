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

public class MySongAdapter extends RecyclerView.Adapter <MySongAdapter.MySongViewHolder>{
    LayoutInflater inflater;
    List<String>songList;
    public MySongAdapter(LayoutInflater inflater) {
    this.inflater = inflater;
    songList = FetchAllData.getSongList();
    }

    @NonNull
    @Override
    public MySongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MySongViewHolder(inflater.inflate(R.layout.card_view,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MySongViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.song);
        holder.textView.setText(songList.get(position));

    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class MySongViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MySongViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}

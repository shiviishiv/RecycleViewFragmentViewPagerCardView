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

public class MyAppAdapter extends RecyclerView.Adapter <MyAppAdapter.MyAppViewHolder>{
    LayoutInflater inflater;
    List<String>appList ;
    public MyAppAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        this.appList = FetchAllData.getImageList();

    }

    @NonNull
    @Override
    public MyAppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyAppViewHolder(inflater.inflate(R.layout.card_view,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAppViewHolder holder, int position) {
            holder.imageView.setImageResource(R.drawable.apk);
            holder.textView.setText(appList.get(position));

    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public class MyAppViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyAppViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

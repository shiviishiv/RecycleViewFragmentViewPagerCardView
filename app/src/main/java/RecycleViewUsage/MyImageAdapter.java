package RecycleViewUsage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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

public class MyImageAdapter extends RecyclerView.Adapter <MyImageAdapter.MyImageViewHolder>{
    LayoutInflater inflater;
    List<String>imageList;
    public MyImageAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        imageList = FetchAllData.getImageList();
    }

    @NonNull
    @Override
    public MyImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyImageViewHolder(inflater.inflate(R.layout.card_view,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyImageViewHolder holder, int position) {
        Bitmap bitmap = BitmapFactory.decodeFile(imageList.get(position));
        holder.imageView.setImageBitmap(bitmap);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.imageView.isSelected()){
                    holder.imageView.setSelected(false);
                }else{
                    holder.imageView.setSelected(true);
                    holder.imageView.setBackgroundColor(Color.BLUE);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class MyImageViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);

        }
    }
}

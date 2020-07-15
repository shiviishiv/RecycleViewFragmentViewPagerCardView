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

public class MyPdfAdapter extends RecyclerView.Adapter <MyPdfAdapter.MyPdfViewHolder>{
    LayoutInflater inflater;
    List<String>pdfList;
    public MyPdfAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        this.pdfList = FetchAllData.getPdfList();

    }
    @NonNull
    @Override
    public MyPdfViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyPdfViewHolder(inflater.inflate(R.layout.card_view,null,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyPdfViewHolder holder, int position) {
        holder.imageView.setImageResource(R.drawable.pdf_icon);
        holder.textView.setText(pdfList.get(position));
    }

    @Override
    public int getItemCount() {
        return pdfList.size();
    }

    public class MyPdfViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyPdfViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}

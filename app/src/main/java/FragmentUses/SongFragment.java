package FragmentUses;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testingviewpagerrecycleviewfragmentcardview.R;

import RecycleViewUsage.MyAppAdapter;
import RecycleViewUsage.MySongAdapter;

public class SongFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recylceView);
        recyclerView.setAdapter(new MySongAdapter(inflater));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        return view;
    }
}
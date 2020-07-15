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
import RecycleViewUsage.MyVideoAdapter;

public class VideoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recylceView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(new MyVideoAdapter(inflater));

        return view;

    }}
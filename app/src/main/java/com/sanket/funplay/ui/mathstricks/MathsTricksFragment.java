package com.sanket.funplay.ui.mathstricks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sanket.funplay.R;
import com.sanket.funplay.ui.mathstricks.adapter.CustomAdapter;

import java.util.ArrayList;

public class MathsTricksFragment extends Fragment {

    private MathsTricksViewModel mathsTricksViewModel;
    ArrayList<String> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mathsTricksViewModel =
                ViewModelProviders.of(this).get(MathsTricksViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maths_tricks, container, false);

        list = new ArrayList<String>();
        RecyclerView recyclerView = root.findViewById(R.id.recycle1);

        list.add(getString(R.string.trick1));
        list.add(getString(R.string.trick2));
        list.add(getString(R.string.trick3));
        list.add(getString(R.string.trick4));
        list.add(getString(R.string.trick5));
        list.add(getString(R.string.trick6));
        list.add(getString(R.string.trick7));
        list.add(getString(R.string.trick8));
        list.add(getString(R.string.trick9));
        list.add(getString(R.string.trick10));

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(),list);
        recyclerView.setAdapter(customAdapter);

        return root;
    }
}

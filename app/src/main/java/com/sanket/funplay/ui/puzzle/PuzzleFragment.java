package com.sanket.funplay.ui.puzzle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sanket.funplay.R;
import com.sanket.funplay.ui.puzzle.adapter.CustomAdapter;

import java.util.ArrayList;

public class PuzzleFragment extends Fragment {

    private PuzzleViewModel puzzleViewModel;
    ArrayList<String> list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        puzzleViewModel =
                ViewModelProviders.of(this).get(PuzzleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_puzzle, container, false);

        list = new ArrayList<String>();
        RecyclerView recyclerView = root.findViewById(R.id.recyclea1);

        list.add(getString(R.string.puz1));
        list.add(getString(R.string.puz2));
        list.add(getString(R.string.puz3));
        list.add(getString(R.string.puz4));
        list.add(getString(R.string.puz5));
        list.add(getString(R.string.puz6));
        list.add(getString(R.string.puz7));
        list.add(getString(R.string.puz8));
        list.add(getString(R.string.puz9));
        list.add(getString(R.string.puz10));

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(),list);
        recyclerView.setAdapter(customAdapter);

        return root;
    }
}

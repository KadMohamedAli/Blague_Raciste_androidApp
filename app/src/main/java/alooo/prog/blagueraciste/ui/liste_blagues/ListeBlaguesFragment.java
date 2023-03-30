package alooo.prog.blagueraciste.ui.liste_blagues;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import alooo.prog.blagueraciste.databinding.FragmentListeBlaguesBinding;

public class ListeBlaguesFragment extends Fragment {

    private FragmentListeBlaguesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListeBlaguesViewModel listeBlaguesViewModel =
                new ViewModelProvider(this).get(ListeBlaguesViewModel.class);

        binding = FragmentListeBlaguesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        listeBlaguesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
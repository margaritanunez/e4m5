package com.example.e3m5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.e3m5.databinding.FragmentSecondBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    private int radioButtonCorrecto;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("Nombre");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(getLayoutInflater(), container, false);
        binding.holaTxt.setText("Hola, " +mParam1);

        // Inflate the layout for this fragment

        binding.enviarButton.setOnClickListener(v -> {
            if (binding.radioGroup.getCheckedRadioButtonId() == binding.radioButtonB.getId()) {
                Bundle correctBundle = new Bundle();
                correctBundle.putString("Respuesta", "Perfectirijillo");
                correctBundle.putString("Nombre", mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_secondFragment_to_thirdFragment, correctBundle);
            }else {
                Bundle wrongBundle = new Bundle();
                wrongBundle.putString("Respuesta", "Keeesoooo!!!");
                wrongBundle.putString("Nombre", mParam1);
                Navigation.findNavController(getView()).navigate(R.id.action_secondFragment_to_thirdFragment, wrongBundle);
            }
        });
        return binding.getRoot();
    }
}
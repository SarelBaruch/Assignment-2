package com.example.myfragmentapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfragmentapp.Product;
import com.example.myfragmentapp.R;
import com.example.myfragmentapp.User;
import com.example.myfragmentapp.activitys.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentFour#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentFour extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentFour() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_Four.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentFour newInstance(String param1, String param2) {
        fragmentFour fragment = new fragmentFour();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__four, container, false);

        Button addToList = view.findViewById(R.id.AddToList);
        EditText productName = view.findViewById(R.id.ProductName);
        TextView amount = view.findViewById(R.id.Amount);

        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = getArguments().getString("user");
                Bundle bundle = new Bundle();
                bundle.putString("user", email);
                for(User user : MainActivity.UsersList)
                {
                    if(user.getEmail().equals(email))
                    {
                        user.addProduct(new Product(productName.getText().toString(), Integer.valueOf(amount.getText().toString())));
                    }
                }
                Navigation.findNavController(view).navigate(R.id.action_fragmentFour_to_fragmentTwo, bundle);
            }
        });

        return view;
    }
}
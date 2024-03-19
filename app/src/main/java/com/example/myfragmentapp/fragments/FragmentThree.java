package com.example.myfragmentapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfragmentapp.R;
import com.example.myfragmentapp.User;
import com.example.myfragmentapp.activitys.MainActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentThree#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentThree extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentThree() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentThree.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentThree newInstance(String param1, String param2) {
        FragmentThree fragment = new FragmentThree();
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
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        Button buttonSignUp = view.findViewById(R.id.SignUpButton);
        Button backButton = view.findViewById(R.id.BackButton);
        EditText emailText = view.findViewById(R.id.SignUpEmailAddress);
        EditText passwordText = view.findViewById(R.id.SignUpPassword);
        EditText phoneText = view.findViewById(R.id.SignUpPhone);
        final Context fragmentContext = getContext();

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean found = false;
                for(User user : MainActivity.UsersList)
                {
                    if(user.getEmail().equals(emailText.toString()) || user.getPhone().equals(phoneText.toString()))
                    {
                        Toast.makeText(fragmentContext,"The email/phone are taken",Toast.LENGTH_SHORT).show();
                        found = true;
                    }
                }

                if(found == false)
                {
                    User insertUser = new User(emailText.getText().toString(), passwordText.getText().toString(), phoneText.getText().toString());
                    MainActivity.UsersList.add(insertUser);
                    Bundle bundle = new Bundle();
                    bundle.putString("user", emailText.getText().toString());
                    Navigation.findNavController(view).navigate(R.id.action_fragmentThree_to_fragmentTwo, bundle);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_fragmentThree_to_fragmentOne);
            }
        });

        return view;
    }
}
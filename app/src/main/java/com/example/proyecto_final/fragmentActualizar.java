package com.example.proyecto_final;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;


public class fragmentActualizar extends Fragment {


    Button btn_actualizar,btn_cancelarr;
    EditText txt_contraseñaa,txt_contraseñaa1;


    public fragmentActualizar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actualizar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        btn_actualizar = view.findViewById(R.id.btn_actualizar);
        btn_cancelarr = view.findViewById(R.id.btn_cancelar1);
        txt_contraseñaa = view.findViewById(R.id.txt_contraseñaa);
        txt_contraseñaa1 = view.findViewById(R.id.txt_contraseñaa1);


        btn_actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contraseñaa = txt_contraseñaa.getText().toString();
                String contraseñaa1 = txt_contraseñaa1.getText().toString();

                User user = MainActivity.myDataBase.myDao().editar(contraseñaa);
                if (user !=null){
                    user.setContraseña(contraseñaa1);
                    MainActivity.myDataBase.myDao().actualiza(user);
                    Toast.makeText(getActivity(),"Actualizado",Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.fragmentInicio);
                }
            }
        });


        btn_cancelarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragmentHome);
            }
        });
    }
}
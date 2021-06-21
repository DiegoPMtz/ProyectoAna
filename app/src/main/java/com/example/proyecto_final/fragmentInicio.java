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

public class fragmentInicio extends Fragment {

    private Button btnIngresar,btnRegistrar;
    private EditText txtId,txtContraseña;


    public fragmentInicio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        btnIngresar = view.findViewById(R.id.btn_ingresar);
        btnRegistrar = view.findViewById(R.id.btn_registrar);
        txtId = view.findViewById(R.id.txt_id);
        txtContraseña = view.findViewById(R.id.txt_contraseña);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragmentRegistro);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(txtId.getText().toString());
                String contraseña = txtContraseña.getText().toString();

                User user = MainActivity.myDataBase.myDao().ingresar(id,contraseña);

                if (user == null){
                    Toast.makeText(getActivity(),"Usuario incorrecto",Toast.LENGTH_SHORT).show();
                }else {
                    navController.navigate(R.id.fragmentHome);
                }
            }
        });

    }
}
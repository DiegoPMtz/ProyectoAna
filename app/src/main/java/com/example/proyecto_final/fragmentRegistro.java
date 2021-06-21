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

public class fragmentRegistro extends Fragment {


    private Button btnGuardar, btnCancelar;
    private EditText txtid,txtcontraseña;


    public fragmentRegistro() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        btnGuardar = view.findViewById(R.id.btn_guardar);
        btnCancelar = view.findViewById(R.id.btn_cancelar);
        txtid = view.findViewById(R.id.txt_id1);
        txtcontraseña = view.findViewById(R.id.txt_contraseña1);




        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(txtid.getText().toString());
                String contraseña = txtcontraseña.getText().toString();
                User user = new User();
                User user1 = MainActivity.myDataBase.myDao().registro(id);
                if (user1 != null){
                    Toast.makeText(getActivity(),"Usuario existente",Toast.LENGTH_SHORT).show();
                }else{
                    user.setId(id);
                    user.setContraseña(contraseña);
                    MainActivity.myDataBase.myDao().agregar(user);
                    Toast.makeText(getActivity(),"Agregado",Toast.LENGTH_SHORT).show();
                    txtid.setText("");
                    txtcontraseña.setText("");
                    navController.navigate(R.id.fragmentHome);
                }


            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.fragmentInicio);
            }
        });
    }
}
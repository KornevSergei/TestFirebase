package com.example.testfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    //переменные для считывания
    private EditText editTextName;
    private EditText editTextSecondName;
    private EditText editTextEmail;

    //переменные для доступа к файрбейс
    //обьект который вмещает ссылку на буазу данных
    private DatabaseReference myDatabase;


    private String USER_KEY = "User";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //вызываем метод для связывания
        init();


    }


    //связываем переменные в отдельном методе
    private void init() {
        editTextName = findViewById(R.id.editTextName);
        editTextSecondName = findViewById(R.id.editTextSecondName);
        editTextEmail = findViewById(R.id.editTextEmail);


        myDatabase = FirebaseDatabase.getInstance().getReference(USER_KEY);

    }

    public void onClickSave(View view) {
        //получаем айди от базы
        String id = myDatabase.getKey();
        //получаем данные из эдиттекстов
        String name = editTextName.getText().toString();
        String secondName = editTextSecondName.getText().toString();
        String email = editTextEmail.getText().toString();

        //вписываем данные в клас Юзер согласно конструктору
        User newUser = new User(id, name, secondName, email);


        //проверяем на пустоту, если пусто - код не выполняется
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(secondName) && !TextUtils.isEmpty(email)) {
            //отправляем информацию в базу
            myDatabase.push().setValue(newUser);
            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show();


            //делаем уведосление при пустом вводе
        } else {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }


    }


    public void onClickRead(View view) {
    }
}
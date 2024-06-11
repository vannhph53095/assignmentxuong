package fpoly.ph53095.assignment.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import fpoly.ph53095.assignment.R;
import fpoly.ph53095.assignment.database.docghifile;
import fpoly.ph53095.assignment.models.user;

public class manhinhdangnhap extends AppCompatActivity {
    private Button dangnhap;
    private Button dangky;
    private TextInputEditText username, password;
    private docghifile docghifile;
    private ArrayList<user> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manhinhdangnhap);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        dangnhap = findViewById(R.id.dangnhap);
        dangky = findViewById(R.id.dangky);

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manhinhdangnhap.this, manhinhdangky.class);
                startActivity(intent);
            }
        });

        dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = username.getText().toString();
                String passInput = password.getText().toString();

                if (userInput.isEmpty() || passInput.isEmpty()) {
                    Toast.makeText(manhinhdangnhap.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                docghifile = new docghifile(manhinhdangnhap.this);
                list = docghifile.ReadFromFile("user.txt");

                if (list == null) {
                    Toast.makeText(manhinhdangnhap.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean loginSuccess = false;

                for (user u : list) {
                    if (u.getName().equals(userInput) && u.getPass().equals(passInput)) {
                        loginSuccess = true;
                        break;
                    }
                }

                if (loginSuccess) {
                    Toast.makeText(manhinhdangnhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(manhinhdangnhap.this, manhinhquanlynhansu.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(manhinhdangnhap.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
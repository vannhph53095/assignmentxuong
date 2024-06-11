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

public class manhinhdangky extends AppCompatActivity {
    private Button dangky, trove;
    private TextInputEditText username, password, repassword;
    private docghifile docghifile;
    private ArrayList<user> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manhinhdangky);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.txtrepassword);
        dangky = findViewById(R.id.dbtnangky);
        trove = findViewById(R.id.btntrove);

        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = username.getText().toString();
                String passInput = password.getText().toString();
                String rePassInput = repassword.getText().toString();

                if (userInput.isEmpty() || passInput.isEmpty() || rePassInput.isEmpty()) {
                    Toast.makeText(manhinhdangky.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!passInput.equals(rePassInput)) {
                    Toast.makeText(manhinhdangky.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }

                user newUser = new user(userInput, passInput);
                docghifile = new docghifile(manhinhdangky.this);
                list = docghifile.ReadFromFile("user.txt");

                if (list == null) {
                    list = new ArrayList<>();
                }

                list.add(newUser);
                docghifile.WriteToFile(list, "user.txt");
                Toast.makeText(manhinhdangky.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(manhinhdangky.this, manhinhdangnhap.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
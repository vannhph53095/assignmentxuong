package fpoly.ph53095.assignment.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import fpoly.ph53095.assignment.R;

public class manhinhadd extends AppCompatActivity {
    private Spinner spphongban;
    private Button btnSubmit;
    private String phongbanthuoc;
    private String[] phongban = {"Đào Tạo", "Nhân Sự", "Hành Chính"};
    private TextInputEditText masvnew;
    private TextInputEditText hotennew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhadd);

        spphongban = findViewById(R.id.spphongban);
        btnSubmit = findViewById(R.id.btnaddnv);
        masvnew = findViewById(R.id.masvnew);
        hotennew = findViewById(R.id.hotennew);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, phongban);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spphongban.setAdapter(adapter);

        spphongban.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                phongbanthuoc = spphongban.getSelectedItem().toString();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = masvnew.getText().toString().trim();
                String hoten = hotennew.getText().toString().trim();

                if (maNV.isEmpty() || hoten.isEmpty() || phongbanthuoc.isEmpty()) {
                    Toast.makeText(manhinhadd.this,"moi nhap day du thong tin",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent();
                intent.putExtra("maNV", maNV);
                intent.putExtra("hoten", hoten);
                intent.putExtra("phongban", phongbanthuoc);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
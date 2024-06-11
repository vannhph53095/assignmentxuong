package fpoly.ph53095.assignment.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import fpoly.ph53095.assignment.R;
import fpoly.ph53095.assignment.adapters.nhanvienadapter;
import fpoly.ph53095.assignment.database.docghifilenv;
import fpoly.ph53095.assignment.models.nhanvien;

public class manhinhquanlynhanvien extends AppCompatActivity {
    private static final int ADD_NHANVIEN_REQUEST_CODE = 1;
    private static final String FILE_NAME = "nhanvien.txt";

    private ListView listnhanvien;
    private ImageView imgback;
    private Button btnadd;
    private nhanvienadapter nhanvienadapter;
    private ArrayList<nhanvien> nhanvienArrayList;
    private docghifilenv fileHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhquanlynhanvien);

        AnhXa();
        fileHelper = new docghifilenv(this);
        nhanvienArrayList = fileHelper.ReadFromFile(FILE_NAME);
        if (nhanvienArrayList == null) {
            nhanvienArrayList = new ArrayList<>();
        }

        nhanvienadapter = new nhanvienadapter(this, nhanvienArrayList);
        listnhanvien.setAdapter(nhanvienadapter);
imgback=findViewById(R.id.imgback);
imgback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(manhinhquanlynhanvien.this, manhinhquanlynhansu.class);
        startActivity(intent);
        finish();
    }
});
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manhinhquanlynhanvien.this, manhinhadd.class);
                startActivityForResult(intent, ADD_NHANVIEN_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_NHANVIEN_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null && data.hasExtra("phongban") && data.hasExtra("hoten") && data.hasExtra("maNV")) {
                String maNV = data.getStringExtra("maNV");
                String hoten = data.getStringExtra("hoten");
                String phongban = data.getStringExtra("phongban");

                nhanvien newNhanvien = new nhanvien(maNV, hoten, phongban);
                nhanvienArrayList.add(newNhanvien);
                nhanvienadapter.notifyDataSetChanged();
                fileHelper.WriteToFile(nhanvienArrayList, FILE_NAME);
            }
        }
    }

    private void AnhXa() {
        btnadd = findViewById(R.id.btnadd);
        listnhanvien = findViewById(R.id.listnhanvien);
    }
}
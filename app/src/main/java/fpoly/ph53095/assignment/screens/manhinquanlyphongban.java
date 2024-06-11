package fpoly.ph53095.assignment.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import fpoly.ph53095.assignment.R;
import fpoly.ph53095.assignment.adapters.phongbanadapter;
import fpoly.ph53095.assignment.models.phongban;

public class manhinquanlyphongban extends AppCompatActivity {
private ListView listphongban;
private ImageView btntrolai;
private phongbanadapter phongbanadapter;
private ArrayList <phongban> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_manhinquanlyphongban);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btntrolai=findViewById(R.id.btntrolai);
btntrolai.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(manhinquanlyphongban.this, manhinhquanlynhansu.class);
        startActivity(intent);
        finish();
    }
});
        AnhXa();
        phongban nhansu  = new phongban(R.drawable.pb,"Nhân sự");
        list.add(nhansu);
        phongban hanhchinh  = new phongban(R.drawable.pb,"Hành chính");
        list.add(hanhchinh);
        phongban daotao= new phongban(R.drawable.pb,"Đào tạo");
        list.add(daotao);
        phongbanadapter = new phongbanadapter(manhinquanlyphongban.this,list);
        listphongban.setAdapter(phongbanadapter);
    }

    private void AnhXa() {
        listphongban = findViewById(R.id.listphongban);
    }
}
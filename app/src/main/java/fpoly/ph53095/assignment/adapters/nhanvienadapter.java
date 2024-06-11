package fpoly.ph53095.assignment.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fpoly.ph53095.assignment.R;
import fpoly.ph53095.assignment.models.nhanvien;
import fpoly.ph53095.assignment.database.docghifilenv;

public class nhanvienadapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<nhanvien> nhanvienArrayList;
    private docghifilenv fileHelper;
    private static final String FILE_NAME = "nhanvien.txt";

    public nhanvienadapter(Context mContext, ArrayList<nhanvien> nhanvienArrayList) {
        this.mContext = mContext;
        this.nhanvienArrayList = nhanvienArrayList;
        fileHelper = new docghifilenv(mContext);
    }

    @Override
    public int getCount() {
        if (nhanvienArrayList != null)
            return nhanvienArrayList.size();
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.nhanvienitemlist, viewGroup, false);

        ImageView imgDelete = view.findViewById(R.id.imgdelete);
        TextView tvManv = view.findViewById(R.id.tvmanv);
        TextView tvName = view.findViewById(R.id.tvname);
        TextView tvPhongban = view.findViewById(R.id.tvphongban);

        nhanvien nhanvien = nhanvienArrayList.get(i);
        tvManv.setText(nhanvien.getMaNV());
        tvName.setText(nhanvien.getHoten());
        tvPhongban.setText(nhanvien.getPhongban());

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowDialogDelete(i);
            }
        });
        return view;
    }

    private void ShowDialogDelete(int index) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Xóa Nhân Viên");
        builder.setMessage("Bạn có chắc chắn muốn xóa nhân viên này?");
        builder.setPositiveButton("Có", (dialog, which) -> {
            nhanvienArrayList.remove(index);
            fileHelper.WriteToFile(nhanvienArrayList, FILE_NAME);
            notifyDataSetChanged();
            Toast.makeText(mContext, "Nhân viên đã được xóa", Toast.LENGTH_SHORT).show();
        });
        builder.setNegativeButton("Không", null);
        builder.show();
    }
}
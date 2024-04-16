package ntu.ntt.viewpage2recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> listData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem = cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(vItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lay doi tuong hien thi
        LandScape landScapeHienThi = listData.get(position);
        //Trich thong tin
        String caption = landScapeHienThi.getLandCapion();
        String tenFileAnh = landScapeHienThi.getLandImageFileName();
        //Dat vao cac truong thong tin cua holder
        holder.tvCaption.setText(caption);
            //dat anh
                String packageNamme = holder.itemView.getContext().getPackageName();
                int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh,"mipmap",packageNamme);
        holder.ivLandScape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        ImageView ivLandScape;
        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.txtViewCaption);
            ivLandScape = itemView.findViewById(R.id.imgViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int viTriDcClick = getAdapterPosition();
            LandScape phanTuDcClick = listData.get(viTriDcClick);
            String ten = phanTuDcClick.getLandCapion();
            String tenFile = phanTuDcClick.getLandImageFileName();

            String chuoiThongBao = "Bạn vừa click vào: " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_SHORT).show();
        }
    }
}

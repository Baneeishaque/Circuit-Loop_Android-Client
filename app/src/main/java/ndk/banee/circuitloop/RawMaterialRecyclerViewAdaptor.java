package ndk.banee.circuitloop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RawMaterialRecyclerViewAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<RowMaterialModel> rowMaterials;
    private OnItemClickListener onItemClickListener;

    public RawMaterialRecyclerViewAdaptor(ArrayList<RowMaterialModel> rowMaterials) {

        this.rowMaterials = rowMaterials;
    }

    public void updateList(ArrayList<RowMaterialModel> rowMaterials) {

        this.rowMaterials = rowMaterials;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_row_material, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ViewHolder) {

            final RowMaterialModel rowMaterial = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.textViewRawMaterialName.setText(rowMaterial.getName());
            genericViewHolder.textViewCurrentStock.setText("Current Stock : " + rowMaterial.getCurrentStock() + " " + rowMaterial.getMeasurementUnit());
            genericViewHolder.textViewMinimumStock.setText("Minimum Stock : " + rowMaterial.getMinimumStock() + " " + rowMaterial.getMeasurementUnit());
            if (Double.parseDouble(rowMaterial.getCurrentStock()) < Double.parseDouble(rowMaterial.minimumStock)) {

                genericViewHolder.constraintLayout.setBackgroundResource(R.drawable._5dp_corner_oval_red_rectangle);
            }
        }
    }

    @Override
    public int getItemCount() {
        return rowMaterials.size();
    }

    public void SetOnItemClickListener(OnItemClickListener onItemClickListener) {

        this.onItemClickListener = onItemClickListener;
    }

    private RowMaterialModel getItem(int position) {
        return rowMaterials.get(position);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, RowMaterialModel agent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewRawMaterialName;
        private TextView textViewCurrentStock;
        private TextView textViewMinimumStock;
        private ConstraintLayout constraintLayout;

        ViewHolder(final View itemView) {

            super(itemView);

            this.textViewRawMaterialName = itemView.findViewById(R.id.textViewRawMaterialName);
            this.textViewCurrentStock = itemView.findViewById(R.id.textViewCurrentStock);
            this.textViewMinimumStock = itemView.findViewById(R.id.textViewMinimumStock);
            this.constraintLayout = itemView.findViewById(R.id.constraintLayout);

            itemView.setOnClickListener(view -> onItemClickListener.onItemClick(itemView, getAdapterPosition(), rowMaterials.get(getAdapterPosition())));
        }
    }
}

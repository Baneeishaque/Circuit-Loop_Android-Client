package ndk.banee.circuitloop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.LongPressAwareTableDataAdapter;

import static android.graphics.Color.BLACK;

public class RawMaterialStockTableAdapter extends LongPressAwareTableDataAdapter<RawMaterialModel> {

    private static final int TEXT_SIZE = 14;

    public RawMaterialStockTableAdapter(final Context context, final List<RawMaterialModel> data, final TableView<RawMaterialModel> tableView) {

        super(context, data, tableView);
    }

    @Override
    public View getDefaultCellView(int rowIndex, int columnIndex, ViewGroup parentView) {

        final RawMaterialModel rawMaterial = getRowData(rowIndex);

        View renderedView = null;

        //TODO : Color for rows to indicate status
        switch (columnIndex) {

            case 0:

                renderedView = renderString(String.valueOf(rawMaterial.getSerialNumber()));
                break;

            case 1:

                renderedView = renderString(rawMaterial.getName());
                break;

            case 2:

                renderedView = renderString(String.valueOf(rawMaterial.getCurrentStock()));
                break;

            case 3:

                renderedView = renderString(String.valueOf(rawMaterial.getMinimumStock()));
                break;
        }

        return renderedView;
    }

    @Override
    public View getLongPressCellView(int rowIndex, int columnIndex, ViewGroup parentView) {

        return getDefaultCellView(rowIndex, columnIndex, parentView);
    }

    private View renderString(final String value) {

        final TextView textView = new TextView(getContext());
        textView.setText(value);
        textView.setTextColor(BLACK);
        textView.setPadding(20, 10, 20, 10);
        textView.setTextSize(TEXT_SIZE);
        return textView;
    }
}

package com.photon.templatemvp.view.section.gallery;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.photon.templatemvp.R;
import com.photon.templatemvp.data.model.gallery.Car;
import com.photon.templatemvp.util.DebugLog;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptar that manages a collection of {@link Car}.
 */
public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.CarViewHolder> {

    public interface OnImageItemClickListener {
        void onCarImageItemClicked(Car car);
    }

    private List<Car> carsCollection;
    private final LayoutInflater layoutInflater;

    private OnImageItemClickListener onImageItemClickListener;

    @Inject
    GalleryAdapter(Context context) {
        DebugLog.write("(LayoutInflater) context.getSystemService(Context" +
                ".LAYOUT_INFLATER_SERVICE)");
        this.layoutInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.carsCollection = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        DebugLog.write();
        return (this.carsCollection != null) ? this.carsCollection.size() : 0;
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DebugLog.write();
        final View view = this.layoutInflater.inflate(R.layout.row_gallery, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, final int position) {
        DebugLog.write();
        final Car car = this.carsCollection.get(position);
        String models = "";
        for (String carModel : car.getModels()) {
            models += (carModel + " , ");
        }
        holder.textViewModels.setText(models);
        holder.imageModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GalleryAdapter.this.onImageItemClickListener != null) {
                    DebugLog.write("Clicked " + String.valueOf(position));
                    GalleryAdapter.this.onImageItemClickListener.onCarImageItemClicked(car);
                }
            }
        });
    }

    public void setCarsCollection(Collection<Car> carsCollection) {
        DebugLog.write();
        DebugLog.write("this.validateCarsCollection(carsCollection)");
        this.validateCarsCollection(carsCollection);
        this.carsCollection = (List<Car>) carsCollection;
        this.notifyDataSetChanged();
    }


    @Override
    public long getItemId(int position) {
        DebugLog.write();
        return position;
    }

    public void setOnImageItemClickListener(OnImageItemClickListener onImageItemClickListener) {
        DebugLog.write();
        this.onImageItemClickListener = onImageItemClickListener;
    }

    public void validateCarsCollection(Collection<Car> carsCollection) {
        DebugLog.write();
        if (carsCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }


    static class CarViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.row_gallery_avatar)
        AppCompatImageView imageModel;
        @BindView(R.id.row_gallery_models)
        AppCompatTextView textViewModels;
        CarViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}

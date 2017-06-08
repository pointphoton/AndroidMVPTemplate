package com.photon.templatemvp.view.section.gallery;

import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.photon.templatemvp.R;
import com.photon.templatemvp.data.model.gallery.Car;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.di.components.GalleryComponent;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.view.base.fragment.BaseFragment;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Fragment that shows a list of Cars.
 */
public class GalleryFragment extends BaseFragment implements GalleryView {

    private static final String TEST_PARAM_GALLERY_ID = "test_param_gallery_id";



    /**
     * Interface for listening car list events.
     */
    public interface CarListListener {
        void onCarClicked(final Car car);
    }

    @Inject
    GalleryPresenter galleryPresenter;
    @Inject
    GalleryAdapter galleryAdapter;

    @BindView(R.id.gallery_rv_cars)
    RecyclerView mGalleryRecyclerViewCars;
    @BindView(R.id.rl_progress)
    RelativeLayout rl_progress;
    @BindView(R.id.rl_retry)
    RelativeLayout rl_retry;
    @BindView(R.id.bt_retry)
    Button bt_retry;
    @BindView(R.id.btnTest)
    Button bt_reloadTest;

    private CarListListener carListListener;
    private Unbinder unbinder;

    public GalleryFragment() {
        DebugLog.write("setRetainInstance(true)");
        setRetainInstance(true);
    }

    public static GalleryFragment newInstanceWithId(int id) {
        DebugLog.write();
        final GalleryFragment userDetailsFragment = new GalleryFragment();
        final Bundle arguments = new Bundle();
        arguments.putInt(TEST_PARAM_GALLERY_ID, id);
        userDetailsFragment.setArguments(arguments);
        return userDetailsFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        DebugLog.write();
        AppCompatActivity activity;
        if (context instanceof AppCompatActivity) {
            activity = (AppCompatActivity) context;
            if (activity instanceof CarListListener) {
                DebugLog.write("this.galleryListListener = (GalleryListListener)activity");
                this.carListListener = (CarListListener) activity;
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DebugLog.write("this.getComponent(GalleryComponent.class).inject(this)");
        this.getComponent(GalleryComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        DebugLog.write();
        final View fragmentView = inflater.inflate(R.layout.fragment_gallery, container, false);
       unbinder = ButterKnife.bind(this, fragmentView);

        setupRecyclerView();
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DebugLog.write();
        DebugLog.write("this.galleryPresenter.setView(this);");
        this.galleryPresenter.setView(this);
        if (savedInstanceState == null) {
            DebugLog.write("this.loadCarList()");
            this.loadCarList();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    DebugLog.write();
    }

    @Override
    public void onResume() {
        super.onResume();
        DebugLog.write();
    this.galleryPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        DebugLog.write();
    this.galleryPresenter.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    DebugLog.write();
    mGalleryRecyclerViewCars.setAdapter(null);
    unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    DebugLog.write();
    this.galleryPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        DebugLog.write();
    this.carListListener = null;
    }

    @Override
    public void showLoading() {
        DebugLog.write();
        this.rl_progress.setVisibility(View.VISIBLE);
        this.getActivity().setProgressBarIndeterminateVisibility(true);
    }

    @Override
    public void hideLoading() {
DebugLog.write();
this.rl_progress.setVisibility(View.INVISIBLE);
        this.rl_progress.setVisibility(View.GONE);
        this.getActivity().setProgressBarIndeterminateVisibility(false);
    }

    @Override
    public void showRetry() {
        DebugLog.write();
        this.rl_retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        DebugLog.write();
        this.rl_retry.setVisibility(View.INVISIBLE);
        this.rl_retry.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        DebugLog.write("LoadDataView showError(String message)");
        this.showToastMessage(message);
    }

    @Override
    public Context context() {
        DebugLog.write();
        return this.getActivity().getApplicationContext();
    }

    @Override
    public void renderUserList(Collection<Car> galleryCarCollection) {
    DebugLog.write();
    DebugLog.write("this.galleryAdapter.setCarsCollection(galleryCarCollection)");
    this.galleryAdapter.setCarsCollection(galleryCarCollection);
    }

    @Override
    public void showCarModel(Car car) {
        DebugLog.write();
        if (this.carListListener != null){
            DebugLog.write("this.carListListener.onCarClicked(car)");
            this.carListListener.onCarClicked(car);
        }

    }

    private void setupRecyclerView() {
        DebugLog.write("this.galleryAdapter.setOnImageItemClickListener(onImageItemClickListener);");
        this.galleryAdapter.setOnImageItemClickListener(onImageItemClickListener);
        DebugLog.write("this.mGalleryRecyclerViewCars.setLayoutManager(new GalleryLayoutManager(context()));");
        this.mGalleryRecyclerViewCars.setLayoutManager(new GalleryLayoutManager(context()));
        DebugLog.write("this.mGalleryRecyclerViewCars.setAdapter(galleryAdapter);");
        this.mGalleryRecyclerViewCars.setAdapter(galleryAdapter);
    }

    /**
     * Loads all cars.
     */
    private void loadCarList() {
        DebugLog.write("this.userListPresenter.initialize()");
        this.galleryPresenter.initialize();
    }

    private GalleryAdapter.OnImageItemClickListener onImageItemClickListener = car -> {
        DebugLog.write("onImageItemClickListener = car ->");
        if (GalleryFragment.this.galleryPresenter != null && car != null) {
            DebugLog.write("GalleryFragment.this.galleryPresenter.onCarClicked(car)");
            GalleryFragment.this.galleryPresenter.onCarClicked(car);
        }
    };


    //test
    @OnClick(R.id.btnTest)
    void reload(){
        loadCarList();
    }
}

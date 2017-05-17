package com.photon.templatemvp.view.section.gallery;

import android.support.annotation.NonNull;

import com.photon.templatemvp.data.model.gallery.Car;
import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.view.base.presenter.Presenter;

/**
 * {@link Presenter} that controls communication between views and models of the presentation layer.
 */
@PerActivity
public class GalleryPresenter implements Presenter{

    private GalleryView viewGalleryView;


    public void setView(@NonNull GalleryView view) {
        DebugLog.write("this.viewGalleryView = view");
        this.viewGalleryView = view;
    }

    @Override
    public void resume() {
        DebugLog.write();
    }

    @Override
    public void pause() {
        DebugLog.write();
    }

    @Override
    public void destroy() {
        DebugLog.write();
    }


    /**
     * Initializes the presenter by start retrieving the user list.
     */
    public void initialize() {
        DebugLog.write("this.loadUserList()");
        this.loadUserList();
    }

   /**
    * Loads all users.
    */
    private void loadUserList() {
        DebugLog.write("this.hideViewRetry()");
        this.hideViewRetry();
        DebugLog.write("this.showViewLoading()");
        this.showViewLoading();
        DebugLog.write("this.getUserList()");
        this.getCarList();
    }


    /**
     * Retrieve a car object which is clicked in the {@link GalleryAdapter} by way of listener of the {@link GalleryFragment}.
     * @param car The {@link Car} that will be shown.
     */
    public void onCarClicked(Car car) {
       DebugLog.write("this.viewGalleryView.showCarModel(car)");
        this.viewGalleryView.showCarModel(car);
    }

    private void showViewLoading() {
        DebugLog.write("LoadDataView showViewLoading()");
        this.viewGalleryView.showLoading();
    }

    private void hideViewLoading() {
        DebugLog.write("LoadDataView hideViewLoading()");
        this.viewGalleryView.hideLoading();
    }

    private void showViewRetry() {
        DebugLog.write("LoadDataView showRetry()");
        this.viewGalleryView.showRetry();
    }

    private void hideViewRetry() {
        DebugLog.write("LoadDataView hideViewRetry()");
        this.viewGalleryView.hideRetry();
    }

    private void getCarList() {
        DebugLog.write();
        DebugLog.write("GetUserList getUserListUseCase.execute(new UserListObserver(), null)");
       // this.getUserListUseCase.execute(new UserListObserver(), null);
    }
}

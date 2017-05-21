package com.photon.templatemvp.view.section.gallery;

import android.support.annotation.NonNull;

import com.photon.templatemvp.data.mapper.GalleryModelCarCollectionMapper;
import com.photon.templatemvp.data.model.gallery.Car;
import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.di.PerActivity;
import com.photon.templatemvp.exception.DefaultErrorBundle;
import com.photon.templatemvp.iteractor.DefaultObserver;
import com.photon.templatemvp.iteractor.gallery.GalleryUseCase;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.view.base.presenter.Presenter;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;


/**
 * {@link Presenter} that controls communication between views and models of the presentation layer.
 */
@PerActivity
public class GalleryPresenter implements Presenter {

    private GalleryView viewGalleryView;
    private final GalleryUseCase galleryUseCase;
    private final GalleryModelCarCollectionMapper carCollectionMapper;

    @Inject
    public GalleryPresenter(GalleryUseCase galleryUseCase, GalleryModelCarCollectionMapper carCollectionMapper) {
        this.galleryUseCase = galleryUseCase;
        this.carCollectionMapper = carCollectionMapper;
    }


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
        this.galleryUseCase.dispose();
        this.viewGalleryView = null;
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
     *
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

    private void showCarsCollectionInView(GalleryModel galleryModel) {
        DebugLog.write();
        DebugLog.write("this.carCollectionMapper.transform(galleryModel);");
        final Collection<Car> cars = this.carCollectionMapper.transform(galleryModel);
        DebugLog.write("this.viewGalleryView.renderUserList(cars)");
        this.viewGalleryView.renderUserList(cars);

    }

    private void getCarList() {
        DebugLog.write();
        DebugLog.write("GetUserList getUserListUseCase.execute(new UserListObserver(), null)");
        this.galleryUseCase.execute(new GalleryObserver(), null);
    }

    private final class GalleryObserver extends DefaultObserver<GalleryModel> {
        {
            DebugLog.write("GalleryObserver extends DefaultObserver<GalleryModel>");
        }

        @Override
        public void onComplete() {
            DebugLog.write("GalleryObserver onComplete() ");
            DebugLog.write("GalleryObserver.this.hideViewLoading() ");
            GalleryPresenter.this.hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            DebugLog.write("GalleryObserver onError(Throwable e)");
            DebugLog.write("GalleryPresenter.this.hideViewLoading() ");
            GalleryPresenter.this.hideViewLoading();
            DebugLog.write("GalleryPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e)");
            // GalleryPresenter.this.showErrorMessage(new DefaultErrorBundle((Exception) e));
            DebugLog.write("UserListPresenter.this.showViewRetry()");
            GalleryPresenter.this.showViewRetry();
        }

        @Override
        public void onNext(final GalleryModel model) {
            DebugLog.write("GalleryObserver onNext(List<User> users) ");
            DebugLog.write("UserListPresenter.this.showUsersCollectionInView(users)");
            DebugLog.write(model.getType());
            GalleryPresenter.this.showCarsCollectionInView(model);
        }
    }
}

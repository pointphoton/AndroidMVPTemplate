package com.photon.templatemvp.iteractor.gallery;

import com.photon.templatemvp.data.model.gallery.GalleryModel;
import com.photon.templatemvp.data.repository.gallery.GalleryRepository;
import com.photon.templatemvp.executor.PostExecutionThread;
import com.photon.templatemvp.executor.ThreadExecutor;
import com.photon.templatemvp.iteractor.base.UseCase;
import com.photon.templatemvp.util.DebugLog;
import com.photon.templatemvp.util.Utils;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by jumbada on 18/05/2017.
 */

public class GalleryUseCase  extends UseCase<GalleryModel, Void>{

    private final GalleryRepository galleryRepository;

    @Inject
    GalleryUseCase(GalleryRepository galleryRepository, ThreadExecutor threadExecutor,
                   PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.galleryRepository = galleryRepository;
    }

    @Override
    protected Observable<GalleryModel> buildUseCaseObservable(Void aVoid) {
        DebugLog.write("this.galleryRepository.galleryModel()");
        return this.galleryRepository.galleryModel();
    }



}

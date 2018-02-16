package com.hiroshi.cimoc.presenter;

import com.hiroshi.cimoc.manager.ComicManager;
import com.hiroshi.cimoc.manager.SourceManager;
import com.hiroshi.cimoc.model.Source;
import com.hiroshi.cimoc.ui.view.SourceDetailView;

/**
 * Created by Hiroshi on 2017/1/18.
 */

public class SourceDetailPresenter extends BasePresenter<SourceDetailView> {

    private SourceManager mSourceManager;
    private ComicManager mComicManager;

    @Override
    protected void onViewAttach() {
        mSourceManager = SourceManager.getInstance();
        mComicManager = ComicManager.getInstance();
    }

    public void load(String id) {
        Source source = mSourceManager.get(id);
        long count = mComicManager.countBySource(id);
        mBaseView.onSourceLoadSuccess(id, source.getName(), count);
    }

}

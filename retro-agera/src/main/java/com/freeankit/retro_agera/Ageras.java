package com.freeankit.retro_agera;

import android.support.annotation.NonNull;

import com.google.android.agera.RepositoryCompilerStates.RFlow;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.google.android.agera.Repositories.repositoryWithInitialValue;

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 21/12/2017 (MM/DD/YYYY )
 */

public class Ageras {
    private static class LazyLoad {
        static final Executor networkExecutor = Executors.newSingleThreadExecutor();
    }


    @NonNull
    public static Executor getNetworkSingleThreadExecutor() {
        return LazyLoad.networkExecutor;
    }


    @NonNull
    public static <T> RFlow<T, T, ?> goToNetworkExecutorWithInitialValue(
            @NonNull final T initialValue) {
        return repositoryWithInitialValue(initialValue)
                .observe()
                .onUpdatesPerLoop()
                .goTo(getNetworkSingleThreadExecutor());
    }
}

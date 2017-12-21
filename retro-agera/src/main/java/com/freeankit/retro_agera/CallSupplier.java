package com.freeankit.retro_agera;

import android.support.annotation.NonNull;

import com.google.android.agera.Result;
import com.google.android.agera.Supplier;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

import static com.google.android.agera.Preconditions.checkNotNull;

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 21/12/2017 (MM/DD/YYYY )
 */

public class CallSupplier<T> implements Supplier<Result<T>> {

    private final Call<T> originalCall;


    CallSupplier(@NonNull final Call<T> call) {
        this.originalCall = checkNotNull(call);
    }


    @NonNull
    @Override
    public Result<T> get() {
        Result<T> result;
        try {
            Response<T> response = originalCall.clone().execute();
            if (response.isSuccessful()) {
                result = Result.absentIfNull(response.body());
            } else {
                result = Result.failure(new HttpException(response));
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = Result.failure(e);
        }
        return result;
    }
}
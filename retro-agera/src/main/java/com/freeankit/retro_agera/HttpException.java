package com.freeankit.retro_agera;

import retrofit2.Response;

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 21/12/2017 (MM/DD/YYYY )
 */

public final class HttpException extends retrofit2.HttpException {

    public HttpException(Response<?> response) {
        super(response);
    }
}
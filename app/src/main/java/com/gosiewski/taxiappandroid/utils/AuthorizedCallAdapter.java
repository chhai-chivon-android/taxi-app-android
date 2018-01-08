package com.gosiewski.taxiappandroid.utils;

import java.lang.reflect.Type;
import java.util.Set;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.CallAdapter;


class AuthorizedCallAdapter<T> implements CallAdapter {
    private final CallAdapter wrappedAdapter;
    private final Set<Integer> authorizedRequestsRepository;

    AuthorizedCallAdapter(CallAdapter adapter, Set<Integer> authorizedRequestsRepository) {
        this.wrappedAdapter = adapter;
        this.authorizedRequestsRepository = authorizedRequestsRepository;
    }

    @Override
    public Type responseType() {
        return wrappedAdapter.responseType();
    }

    @Override
    public Object adapt(Call call) {
        Request request = call.request();

        authorizedRequestsRepository.add(identify(request));

        return wrappedAdapter.adapt(call);
    }

    static int identify(Request request) {
        return (request.url() + request.method()).hashCode();

    }
}
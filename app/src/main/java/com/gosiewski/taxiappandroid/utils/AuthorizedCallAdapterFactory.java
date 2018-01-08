package com.gosiewski.taxiappandroid.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class AuthorizedCallAdapterFactory extends CallAdapter.Factory {
    private final Set<Integer> authorizedRequestsRepository;

    public AuthorizedCallAdapterFactory(Set<Integer> authorizedRequestsRepository) {
        this.authorizedRequestsRepository = authorizedRequestsRepository;
    }

    @Override
    public CallAdapter get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Authorized authorizedAnnotation = null;
        for (Annotation annotation : annotations)
            if (Authorized.class == annotation.annotationType()) {
                authorizedAnnotation = (Authorized) annotation;
                break;
            }

        for (CallAdapter.Factory callAdapterFactory : retrofit.callAdapterFactories()) {
            if (callAdapterFactory.getClass() == getClass())
                continue;

            CallAdapter callAdapter = callAdapterFactory.get(returnType, annotations, retrofit);
            if (callAdapter != null)
                if (authorizedAnnotation != null)
                    return new AuthorizedCallAdapter<>(callAdapter, authorizedRequestsRepository);
                else
                    return callAdapter;
        }

        return null;
    }
}

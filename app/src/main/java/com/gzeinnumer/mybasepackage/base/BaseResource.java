package com.gzeinnumer.mybasepackage.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BaseResource<T> {

    public enum BaseResourceStatus{
        STATUS_1_SUCCESS,
        STATUS_2_ERROR,
        STATUS_3_EMPTY,
        STATUS_4_INFO,
        STATUS_5_LOGOUT,
        STATUS_6_LOADING
    }

    @NonNull
    final public BaseResourceStatus status;

    @Nullable
    final public T data;

    @Nullable
    final public String message;

    public BaseResource(@NonNull BaseResourceStatus status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> BaseResource<T> success(@NonNull String msg, @Nullable T data) {
        return new BaseResource<>(BaseResourceStatus.STATUS_1_SUCCESS, data, msg);
    }

    public static <T> BaseResource<T> error(@NonNull String msg) {
        return new BaseResource<>(BaseResourceStatus.STATUS_2_ERROR, null, msg);
    }

    public static <T> BaseResource<T> empty(@NonNull String msg) {
        return new BaseResource<>(BaseResourceStatus.STATUS_3_EMPTY, null, msg);
    }

    public static <T> BaseResource<T> info(@NonNull String msg) {
        return new BaseResource<>(BaseResourceStatus.STATUS_4_INFO, null, msg);
    }

    public static <T> BaseResource<T> logout() {
        return new BaseResource<>(BaseResourceStatus.STATUS_5_LOGOUT, null, null);
    }

    public static <T> BaseResource<T> loading() {
        return new BaseResource<>(BaseResourceStatus.STATUS_6_LOADING, null, null);
    }
}

package com.magang.jvm_es3_kula.di;

import android.content.Context;

import com.magang.jvm_es3_kula.data.DataRepository;
import com.magang.jvm_es3_kula.data.rest.api.ApiCall;

public class Injection {
    public static DataRepository provideRepository(Context context){
        ApiCall apiCall = ApiCall.getInstance(context);
        return DataRepository.getInstance(apiCall);
    }
}

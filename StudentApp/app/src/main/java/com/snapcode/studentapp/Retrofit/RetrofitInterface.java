package com.snapcode.studentapp.Retrofit;

import com.snapcode.studentapp.Response.StudentResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {


    @GET("api/student")
    Call<List<StudentResponse>> STUDENT_RESPONSE_CALL();





}

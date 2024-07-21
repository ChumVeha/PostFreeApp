package com.chumvehakh.postfreeapp.presenters;

import com.chumvehakh.postfreeapp.api.APIClient;
import com.chumvehakh.postfreeapp.api.APIInterface;
import com.chumvehakh.postfreeapp.models.request.RegiserRequest;
import com.chumvehakh.postfreeapp.models.response.BaseResponse;
import com.chumvehakh.postfreeapp.views.RegisterView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {
    private RegisterView view;
    private APIInterface apiInterface;
    public RegisterPresenter(RegisterView view){
        this.view = view;
        apiInterface = APIClient.getClient().create(APIInterface.class);

    }
    public void register(RegiserRequest req){
        view.onLoading();
        apiInterface.registerUser(req).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                view.onHidingLoading();
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }else {
                    view.onError("Invalid input ");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable throwable) {
                view.onHidingLoading();
                view.onError("Internal server error");
            }
        });
    }
}

package delivery.senstudio.ru.deliveryproject.common.net.api;

import delivery.senstudio.ru.deliveryproject.model.Currency;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("scripts/XML_daily.asp")
    /*Call<GitHubModel> getSearchedRepos(@Query("date_req") String date);*/
   Call<Currency> getCurrencys(@Query("date_req") String date);
}

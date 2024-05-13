package mainPackage.oksoft.lab5;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;

public class CartApi {

    public CartInfo getCartInfo(){
        var a = RestAssured
                .given()
                .cookie("Language=ru; wid=6315b6abd1404ab69499a0cd90cf6f3c; WarehousesShopCode=1; _ym_uid=1714140812741738598; _ym_d=1714140812; PartnersTicket=6281f38d-478c-4749-b60b-a6ab7ccadef8; _ga=GA1.2.742829728.1712429724; _ga_NRZ0CMV0B4=GS1.1.1715282654.9.0.1715282654.60.0.0; ASP.NET_SessionId=0wxpnipoadkoy1dtllgkh3c0; UTckt=2e1e148c-6bda-44c0-8688-50fdb6ac2b54; .ASPXAUTH=5483550B12A2F155D16DC2EE49F47BF0091919464EE2DAA4CC3F4BD40F0BA22F57BF3B76B335A55A7270C7F125AD8049F53E79728D7998D989C4CD590691D36EBBBF531B9FC78ABCFB034891FCB97560BA227A89E8218EC0E604DAE7E26A1161EC50EEBF4FC9666358A83C28CBBA4592; _gid=GA1.2.1852238273.1715632736; IsWarehouseSelected=Y; CartGuid=a38a8c66-5e3f-4b77-aa80-daa5283cc2b9; _gat=1")
                .post("https://demo.oksoft.ru/JsonAndSettingsController/CartOrderedInfoGet")
                .then()
                .assertThat()
                .statusCode(200);

        String res = a.extract().response().print();

        JsonParser parser = new JsonParser();

        JsonObject jsonObject = parser.parse(res).getAsJsonObject();


        int totalQty = jsonObject.get("totalQty").getAsInt();
        double totalSum = Double.parseDouble(
                jsonObject.get("totalSum").getAsString()
                        .replaceAll(",", ".")
                        .replaceAll("&\\w+;", "")
                        .replaceAll(String.valueOf((char) 160), ""));

        double totalDiscount = Double.parseDouble(
                jsonObject.get("totalDiscount").getAsString()
                        .replaceAll(",", ".")
                        .replaceAll("&\\w+;", "")
                        .replaceAll(String.valueOf((char) 160), ""));

        double totalVp = Double.parseDouble(
                jsonObject.get("totalVp").getAsString()
                        .replaceAll(",", ".")
                        .replaceAll("&\\w+;", "")
                        .replaceAll(String.valueOf((char) 160), ""));


        return new CartInfo(totalQty, totalSum, totalDiscount, totalVp);
    }
}

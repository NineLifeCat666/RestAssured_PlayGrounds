package spec;

import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class Request {
    private static final RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri(Config.baseURL())
            .setBasePath(Config.basePath())
            .setContentType(ContentType.JSON)
            .build();
    public static RequestSpecification spec() {
        return SPEC;
    }
}

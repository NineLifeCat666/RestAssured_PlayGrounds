package spec;

import config.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static template.ReportTemplate.filters;

public class Request {
    private static final RequestSpecification SPEC = new RequestSpecBuilder()
            .setBaseUri(Config.baseURL())
            .setBasePath(Config.basePath())
            .addFilter(filters().customTemplates())
            .setContentType(ContentType.JSON)
            .build();
    public static RequestSpecification spec() {
        return SPEC;
    }
}

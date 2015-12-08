package io.pivotal.data.eventservice;


import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.*;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.pivotal.data.eventservice.App;

import java.net.URL;

/**
 * Created by cax on 16/09/2015.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=0"})
public class RequestHelper {

    private URL base;
    private RestOperations restOperations;
    private HttpHeaders headers;

    @Value("${local.server.port}")
    private int port;

    @Before
    public void setUp() throws Exception{
        base = new URL("http://localhost:" + port + "/");
        restOperations = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    /**
     *
     * @param endpoint
     * @param method
     * @param clazz
     * @return
     */
    protected ResponseEntity makeRequest(String endpoint, HttpMethod method, Class clazz){
        String uri = base.toString() + "/" + endpoint;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);

        return restOperations.exchange(uriComponentsBuilder.build().toUriString(),method, new HttpEntity<byte[]>(headers),clazz);
    }

    /**
     *
     * @param endpoint
     * @param method
     * @param clazz
     * @param params
     * @return
     */
    protected ResponseEntity makeRequest(String endpoint, HttpMethod method, Class clazz,Object params){
        String uri = base.toString() + "/" + endpoint;
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(uri);
        HttpEntity httpEntity = new HttpEntity<>(params,headers);
        return restOperations.exchange(uriComponentsBuilder.build().toUriString(),method, httpEntity,clazz);
    }
}

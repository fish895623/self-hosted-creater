package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import com.google.gson.reflect.TypeToken;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.KubeConfig;
import io.kubernetes.client.util.Watch;

public class kubernetes {
    public static void main(String[] args) throws IOException, ApiException {
        ApiClient client = Config.defaultClient();
        // TODO Use Writer to
        KubeConfig.loadKubeConfig(new FileReader("C:\\Users\\dan99\\.kube\\config"));
        Configuration.setDefaultApiClient(client);
        CoreV1Api api = new CoreV1Api();

        Watch<V1Namespace> watch = Watch.createWatch(
                client,
                api.listNamespaceCall(null, null, null, null, null, 5, null, null, null, Boolean.TRUE, null),
                new TypeToken<Watch.Response<V1Namespace>>() {
                }.getType());

        for (Watch.Response<V1Namespace> item : watch) {
            if (Objects.equals(Objects.requireNonNull(item.object.getMetadata()).getName(), "transformer")) {
                System.out.println("exist");
                break;
            }
        }
    }
}

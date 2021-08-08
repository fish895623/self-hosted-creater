package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.KubeConfig;

public class kubernetes {
    public static void main(String[] args) throws IOException, ApiException {
        ApiClient client = Config.defaultClient();
        // TODO Use Writer to
        KubeConfig.loadKubeConfig(new FileReader("/home/dan99/.kube/config"));
        Configuration.setDefaultApiClient(client);
        CoreV1Api api = new CoreV1Api();

        V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null, null);
        for (V1Pod item : list.getItems()) {
            System.out.println(Objects.requireNonNull(item.getMetadata()).getName());
        }
    }
}

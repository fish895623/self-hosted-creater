package org.example;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Namespace;
import io.kubernetes.client.openapi.models.V1ObjectMeta;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.KubeConfig;

import java.io.FileReader;
import java.io.IOException;

public class KubernetesDefault {
  public static void main(String[] args) throws IOException, ApiException {
    ApiClient client = Config.defaultClient();
    KubeConfig.loadKubeConfig(new FileReader("C:\\Users\\dan99\\.kube\\config"));
    Configuration.setDefaultApiClient(client);

    CoreV1Api api = new CoreV1Api();

    String namespaceName = "action";
    V1Namespace body = new V1Namespace().metadata(new V1ObjectMeta().name(namespaceName));
    api.createNamespace(body, null, null, null);
  }
}

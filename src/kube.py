from kubernetes import client, config, watch

config.load_kube_config(config_file="config.yml")

v1 = client.CoreV1Api()
count = 10
w = watch.Watch()
try:
    for event in w.stream(v1.list_namespace, _request_timeout=5):
        print("Event: %s %s" % (event["type"], event["object"].metadata.name))
        count -= 1
        if not count:
            w.stop()
except:
    pass

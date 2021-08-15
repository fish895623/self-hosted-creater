import json
from src import utils
from src.kube import Kubernet

if __name__ == "__main__":
    # Kubernet().kubectl_download()
    a = Kubernet.Controller().Namespace()
    a.name("asdf")
    a.delete()
    print(a.exist())

    # a, b = utils.run("kubectl get nodes")
    # print(a.decode("utf-8"))

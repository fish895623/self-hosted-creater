import json
from src import utils
from src.kube import kubernet

if __name__ == "__main__":
    kubernet().kubectl_download()
    # a, b = utils.run("kubectl get nodes")
    # print(a.decode("utf-8"))

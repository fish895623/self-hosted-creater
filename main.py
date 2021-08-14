import json
from src import gh
from src.kube import kubernet

if __name__ == "__main__":
    kubernet().kubectl_download()

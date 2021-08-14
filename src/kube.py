import requests


def kubectl_version() -> str:
    return requests.get("https://dl.k8s.io/release/stable.txt").text


class kubernet:
    def __init__(self, version=kubectl_version(), filename="kubectl"):
        self.version = version
        self.filename = filename
        pass

    def kubectl_download(self):
        url = "https://dl.k8s.io/release/" + self.version + "/bin/linux/amd64/kubectl"
        with open(file=self.filename, mode="wb") as file:
            response = requests.get(url)
            file.write(response.content)

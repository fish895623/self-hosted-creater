import re
from pathlib import Path

import requests

from . import utils


def kubectl_version() -> str:
    return requests.get("https://dl.k8s.io/release/stable.txt").text


class kubernet:
    def __init__(self, version=kubectl_version(), filename="kubectl"):
        self.version = version
        self.filename = filename
        pass

    def kubectl_exist(self):
        filename = Path(self.filename)
        if filename.is_file():
            return True
        else:
            return False

    def kubectl_check_version(self):
        assert self.kubectl_exist()
        print("Already exist!!")
        print("Check Version...")
        output, _ = utils.run("kubectl version")
        output = output.decode("utf-8")
        r = re.search('''GitVersion:"%s"''' % self.version, output)
        if r:
            return True
        else:
            return False

    # TODO - Check Download finished and rquired to download
    def kubectl_download(self):
        if self.kubectl_check_version():
            print("Version Matched!!")
            pass
        else:
            print("New Version Released")
            url = (
                "https://dl.k8s.io/release/" + self.version + "/bin/linux/amd64/kubectl"
            )
            with open(file=self.filename, mode="wb") as file:
                response = requests.get(url)
                file.write(response.content)

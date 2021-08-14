import json
from src import gh, kube

if __name__ == "__main__":
    # with open(file="token.json", mode="r") as f:
    #     data = f.read()
    #     token = json.loads(data)["token"]

    # gh.GH(token=token)()
    stdout, _ = kube.run("top")
    print(stdout.decode("utf-8"))

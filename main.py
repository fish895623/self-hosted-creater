import json
from src import gh

if __name__ == "__main__":
    with open(file="token.json", mode="r") as f:
        data = f.read()
        token = json.loads(data)["token"]

    gh.GH(token=token)()

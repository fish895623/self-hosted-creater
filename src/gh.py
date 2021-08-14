import requests
import json
from github import Github

token = "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"

g = Github(token)
for repo in g.get_user().get_repos():
    print(repo.full_name)

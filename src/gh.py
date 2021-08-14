from github import Github


class GH:
    def __init__(self, token) -> None:
        self.token = token
        pass

    def __call__(self):
        g = Github(self.token)
        for repo in g.get_user().get_repos():
            print(repo.full_name)

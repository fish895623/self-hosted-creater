from subprocess import Popen, PIPE


def run(args: str):
    comm = Popen(args.split(), stdout=PIPE, stderr=PIPE)
    stdout, stderr = comm.communicate()
    return stdout, stderr


if __name__ == "__main__":
    stdout, _ = run("ls -ahlF")
    print(stdout.decode('utf-8'))

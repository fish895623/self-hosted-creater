import sys
from subprocess import PIPE, Popen


def run(args: str):
    with Popen(args.split(), stdout=PIPE, stderr=PIPE) as process:
        return process.communicate()


def run_liveoutput(args: str):
    with Popen(args.split(), stdout=PIPE, stderr=PIPE, shell=True) as process:
        with open("test.log", "w") as f:
            for c in iter(lambda: process.stdout.read(1), ""):
                sys.stdout.write(c.decode("utf-8"))
                f.write(c.decode("utf-8"))

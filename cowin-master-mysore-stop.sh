#!/bin/bash
pid=$(cat pid.txt);
kill -9 $pid;
echo PID killed : $pid
rm pid.txt

#!/bin/sh

LINE=`cat  dns.txt`
FILE=/etc/hosts
grep -qF "$LINE" "$FILE"  || echo "$LINE" | sudo tee -a "$FILE"
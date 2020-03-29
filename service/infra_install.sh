#!/bin/sh

cd /home/pi/jenkins/build
echo $PWD

echo "# Stop service"
service infra stop

echo "# Setup service"
cp service/infra.service /etc/systemd/system/infra.service
systemctl daemon-reload

echo "# Start service"
service infra start

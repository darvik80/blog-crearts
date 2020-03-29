#!/bin/sh

echo "# Run core service"

cd /home/pi/jenkins/build
echo "# Stop service"
service core stop

echo "# Setup service"
cp -f service/core.service /etc/systemd/system/core.service
systemctl daemon-reload
systemctl enable core

echo "# Start service"
service core start

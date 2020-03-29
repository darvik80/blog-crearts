#!/bin/sh

echo "# Run infra service"

cd /home/pi/jenkins/build
echo "# Stop service"
service infra stop

echo "# Setup service"
cp -f service/infra.service /etc/systemd/system/infra.service
systemctl daemon-reload
systemctl enable infra

echo "# Start service"
service infra start

#!/bin/sh

echo "# Run infra service"

cd ~/blog_deploy
echo "# Stop service"
service infra stop

echo "# Setup service"
cp -f service/infra.service /etc/systemd/system/infra.service
systemctl daemon-reload
systemctl enable infra

echo "# Start service"
service infra start

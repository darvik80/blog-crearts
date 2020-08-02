#!/bin/sh

echo "# Run admin service"

cd ~/blog_deploy
echo "# Stop service"
service core stop

echo "# Setup service"
cp -f service/core.service /etc/systemd/system/admin.service
systemctl daemon-reload
systemctl enable admin

echo "# Start service"
service admin start

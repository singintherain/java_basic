#!/bin/bash
source /etc/profile
exec java -Xmx1024M -Xms512M  -cp classes lvsong.club.SocketChannelExample $1 $2
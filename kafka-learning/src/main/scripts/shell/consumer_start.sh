#!/bin/bash
source /etc/profile
cd $(dirname $0)
exec java -Xmx1024M -Xms512M  -cp classes:$(echo $(ls ../lib/*) | sed 's/ /:/g') lvsong.club.domain.controller.MyConsumerController
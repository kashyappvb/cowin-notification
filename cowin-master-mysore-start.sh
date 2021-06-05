#!/bin/bash
nohup java -jar -Dtelegram-bot-api-token=$TELEGRAM_BOT_API_KEY cowin-notification-0.0.1-SNAPSHOT.jar > cowin_log.log &
echo PID : $!
echo $! > pid.txt

#1685287041:AAFhUloQrhY37GSNrpzPG98s9BwO9oYccHc

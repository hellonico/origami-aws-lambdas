
# lein uberjar 
# ./slim.sh
export FUN=$1

aws lambda delete-function --function-name $FUN

aws lambda create-function  --function-name $FUN  \
 --handler lando.$FUN::handler   \
 --runtime java8   \
 --memory 512   \
 --timeout 20   \
 --zip-file fileb://./target/lando-0.1.0-SNAPSHOT-standalone.jar \
 --role arn:aws:iam::817572757560:role/lando \
 --environment Variables="{JAVA_TOOL_OPTIONS=-Dnetworks.local=/tmp}" 
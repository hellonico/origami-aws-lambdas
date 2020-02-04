# Lando

Write a clojure lambda function that can read a set of pictures, and tell, what they are containing using Yolo.

In the best case, the network files should be on S3 ... but it seems we can use the lambda's temporary local storage to re-use the files.



https://aws.amazon.com/blogs/compute/clojure/

https://docs.aws.amazon.com/general/latest/gr/rande.html

https://qiita.com/ekzemplaro/items/b5b42ce90fbe2fb05cd2

# install

```
brew install awscli

aws lambda help
```

# first clojure lambda on AWS

```
lein new lando
lein uberjar
```

```
export AWS_PROFILE="default"
```

```
aws lambda create-function   --function-name lando   --handler lando.core::handler   --runtime java8   --memory 512   --timeout 10   --zip-file fileb://./target/lando-0.1.0-SNAPSHOT-standalone.jar --role arn:aws:iam::817572757560:role/lando 

aws lambda delete-function --function-name lando

aws lambda list-functions

aws lambda invoke --function-name lando --payload '["Nico"]' lando.log
```

# simple origami

``` 
lein uberjar
```

```
 zip -d target/lando-0.1.0-SNAPSHOT-standalone.jar  natives/windows_64/opencv_java420.dll  natives/osx_64/libopencv_java420.dylib natives/linux_arm64/libopencv_java420.so natives/linux_arm/libopencv_java420.so 
```

```
 aws lambda create-function   --function-name origami   --handler lando.origami::handler   --runtime java8   --memory 512   --timeout 10   --zip-file fileb://./target/lando-0.1.0-SNAPSHOT-standalone.jar --role arn:aws:iam::817572757560:role/lando 
```

```
aws lambda invoke --function-name origami --payload '[]' origami.log
```

# dnn

```
aws lambda create-function   --function-name yolo   --handler lando.dnn::handler   --runtime java8   --memory 512   --timeout 10   --zip-file fileb://./target/lando-0.1.0-SNAPSHOT-standalone.jar --role arn:aws:iam::817572757560:role/lando --environment Variables="{JAVA_TOOL_OPTIONS=-Dnetworks.local=/tmp}" 

aws lambda delete-function --function-name yolo
```

```
 aws lambda invoke --function-name yolo --payload '"https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=900&q=60"' yolo.log
```

# improved dnn

```
aws lambda create-function   --function-name dnn2   --handler lando.dnn2::handler   --runtime java8   --memory 512   --timeout 10   --zip-file fileb://./target/lando-0.1.0-SNAPSHOT-standalone.jar --role arn:aws:iam::817572757560:role/lando --environment Variables="{JAVA_TOOL_OPTIONS=-Dnetworks.local=/tmp}" 
```

```
aws lambda invoke --function-name dnn2 --payload '["https://images.unsplash.com/photo-1518791841217-8f162f1e1131]"' dnn2.log
```
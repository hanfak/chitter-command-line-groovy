Install Java SDK

```
1. Download and install from here

2. Type in Terminal /usr/libexec/java_home -V
to get something like
1.7.0_55, x86_64:	"Java SE 7"	/Library/Java/JavaVirtualMachines/jdk1.7.0_55.jdk/Contents/Home

3. Type in terminal export JAVA_HOME=`/usr/libexec/java_home -v 1.7.0_55, x86_64
```

Install groovy
```brew install groovy```

Install gradle
```brew install gradle```

Note for non mac users, follow instructions at said websites

Program is in folder
```/src/main/groovy/```

Tests are is folder
```/src/test/groovy/```

Run all tests
```gradle build```

To view test report
open in browser, the file from root
```/build/reports/tests/index.html```

Run code example
```cd src/main/groovy```
```groovy main.groovy```

Run code individually
```cd src/main/groovy```
```groovysh```
import classes
```import Chitter```

To use
To start

To signin

To addpost

To view my time line

To view others posts

To view all posts

To sign out

To follow users

To view time line (show others posts)

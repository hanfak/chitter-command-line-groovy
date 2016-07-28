## Setup
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

## Running the program and tests

Program is in folder
```
/src/main/groovy/
```

Tests is in the folder
```
/src/test/groovy/
```

### Run tests
Run all tests

```gradle build```

To view test report

open in browser, the file from root
```
/build/reports/tests/index.html
```

### Run code example

go to
```cd src/main/groovy```

For first user story
```groovy UserStory1.groovy```

For second user story
```groovy UserStory2.groovy```

For third user story
```groovy UserStory3.groovy```

For fourth user story
```groovy UserStory4.groovy```



### Run code individually in command line
Go to

```
cd src/main/groovy
```

open groovy shell

```
groovysh
```

import classes
```import Chitter```

#### To use

To start
```java
chitter = new Chitter()
```

To signin
```java
chitter.login('Spike')
```

To addpost
```java
chitter.addPost('This is s a message')
```

To follow a user
```java
chitter.follow('Leo')
```

To view my time line
```java
chitter.viewTimeline()
```

To view others time line
```java
chitter.viewTimeline('Leo')
```

To view others posts
```java
chitter.viewUserPosts('Spike')
```

To view all posts
```java
chitter.viewPosts()
```

To sign out
```java
chitter.logOut()
```

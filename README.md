# Tech test

This is an implementation of a console-based social networking application (similar to Twitter) with the features below.

This is built using Groovy as the scripting language, Gradle as the build system, and Spock as the testing framework.

Although, I have a created software that satisfies the user stories, I still have some stuff undone to improve the design and test, cover edge cases etc. These can be seen here [list of things to do](to-do.md).

Here are the [instructions](instructions.md) for running the program.

## Requirements

### User Story 1

```
User creating: a new user called *Spike* can be created
```

### User Story 2

```
Posting: *Spike* can publish messages to a personal timeline
```

### User Story 3

```
Reading: *Spike* can view *Nikesh’s* timeline
```

### User Story 4

```
Following: *Leo* can subscribe to *Spike* and *Nikesh's* timelines, and view an aggregated list of all subscriptions
```

## Solution

I have not used the language Groovy or it's testing framework, Spock, or Gradle before, so this was a challenge. I spent some time beforehand implementing this solution doing a Fizzbuzz kata and an airport kata, to help me understand the syntax, how to run the program, how to test, setup a project structure and iron out any issuses.

I aimed to produce this software so that it adheres to the principles of good software design, such as SOLID, encapsulation, DRY, as much as possible.

I also aimed to implement the Model-View-Controller pattern in my software. Where the controller is the Chitter class, and models are the Users and Posts classes. I have not created a View, but this would have been a printer class which would render the output to the command line and called from the controller. Using an MVC, meant I needed to simplify my controller, Chitter class, and move the logic to the models(Users and Posts classes), to allow for skinny controllers.

The software was produced in a test driven manner. I used the Chicago style of testing, I wanted to use the London style (use of mocks) but I had difficulties with mocking an injected object in the constructor and testing that the injected object's method has been called. I would have liked to have done automated feature testing, but I ended creating manual feature tests (for example see the files marked src/main/groovy/UserStory1.groovy) which can be run in the terminal.

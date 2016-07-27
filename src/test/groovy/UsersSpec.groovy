import spock.lang.*

class UsersSpec extends Specification {
  def Users

  def setup() {
    users = new Users()
  }

  def 'no user has logged in at start'() {
    expect:
    users.getLoggedInUser() == null
  }

  def 'no users stored at the start'() {
    expect:
    users.getListofUsers() == []
  }

  def 'User can login and be signed up automatically'() {
    when:
    users.loginUser('Spike')

    then:
    users.getLoggedInUser().getName() == 'Spike'
    users.getListofUsers()[0].getName() == 'Spike'
  }

  def 'User can log out and deletes as active user'() {
    when:
    users.loginUser('Spike')
    users.logOutUser()

    then:
    users.getLoggedInUser() == null
    users.getListofUsers()[0].getName() == 'Spike'
  }

  def 'User can login again, and not automatically sign up'() {
    when:
    users.loginUser('Spike')
    users.logOutUser()
    users.loginUser('Spike')

    then:
    users.getLoggedInUser().getName() == 'Spike'
    users.getListofUsers().size() == 1
  }

  def 'User can login with different user'() {
    when:
    users.loginUser('Spike')
    users.logOutUser()
    users.loginUser('Leo')

    then:
    users.getLoggedInUser().getName() == 'Leo'
    users.getListofUsers().size() == 2
    users.getListofUsers()[1].getName() == 'Leo'
  }

  def 'Can search for a user who has been logged in before'() {
    when:
    users.loginUser('Spike')
    users.logOutUser()
    users.loginUser('Nikesh')
    users.logOutUser()
    users.loginUser('Mary')
    users.logOutUser()
    users.loginUser('Leo')
    def result = users.lookForUser('Nikesh')

    then:
    result.getName() == 'Nikesh'
  }

  def 'it is it\'s own follower at start'() {
    given:
    users.loginUser('Spike')

    expect:
    users.getLoggedInUser().getFollowers().size() == 1
    users.getLoggedInUser().getName() == 'Spike'
  }

  def 'can follow someone'() {
    given:
    users.loginUser('Leo')
    users.logOutUser()
    users.loginUser('Spike')

    when:
    users.followAUser('Leo')

    then:
    users.getLoggedInUser().getFollowers()[1].getName() =='Leo'
    users.getLoggedInUser().getFollowers().size() == 2
  }

  def 'cannot follow someone who is not a user'() {
    given:
    users.loginUser('Spike')

    when:
    users.followAUser('Leo')

    then:
    users.getLoggedInUser().getFollowers().size() == 1
    def exception = thrown(UserDoesNotExistException)
    exception.message == 'User not follower: User must exist first'
  }
}

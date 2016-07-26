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
}

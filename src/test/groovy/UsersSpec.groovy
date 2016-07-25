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
    users.login('Spike')

    then:
    users.getLoggedInUser().getName() == 'Spike'
    users.getListofUsers()[0].getName() == 'Spike'
  }

  def 'User can log out and deletes as active user'() {
    when:
    users.login('Spike')
    users.logOut()

    then:
    users.getLoggedInUser() == null
    users.getListofUsers()[0].getName() == 'Spike'
  }

  def 'User can login again, and not automatically sign up'() {
    when:
    users.login('Spike')
    users.logOut()
    users.login('Spike')

    then:
    users.getLoggedInUser().getName() == 'Spike'
    users.getListofUsers().size() == 1
  }
}

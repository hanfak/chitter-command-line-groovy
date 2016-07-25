import spock.lang.*

class ChitterSpec extends Specification {
  def chitter

  def setup() {
    chitter = new Chitter()
  }

  def 'no user has logged in at start'() {
    expect:
    def result = chitter.getActiveUser()

    result == null
  }

  def 'no users stored at the start'() {
    expect:
    def result = chitter.getUsersSignedUp()

    result == []
  }

  def 'User can login be signed up automatically'() {
    when:
    chitter.login('Spike')

    then:
    chitter.getActiveUser() == 'Spike'
    chitter.getUsersSignedUp().contains('Spike') == true
  }

  def 'User can log out and deletes as active user'() {
    when:
    chitter.login('Spike')
    chitter.logOut()

    then:
    chitter.getActiveUser() == null
    chitter.getUsersSignedUp().contains('Spike') == true
  }

  def 'User can login again, and not automatically sign up'() {
    when:
    chitter.login('Spike')
    chitter.logOut()
    chitter.login('Spike')

    then:
    chitter.getActiveUser() == 'Spike'
    chitter.getUsersSignedUp().size() == 1
  }
}

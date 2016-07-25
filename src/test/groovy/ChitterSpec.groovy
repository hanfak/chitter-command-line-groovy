import spock.lang.*

class ChitterSpec extends Specification {
  def chitter

  def setup() {
    chitter = new Chitter()
  }

  def 'no user has logged in at start'() {
    expect:
    chitter.getActiveUser() == null
  }

  def 'no users stored at the start'() {
    expect:
    chitter.getUsersSignedUp() == []
  }

  def 'User can login and be signed up automatically'() {
    when:
    chitter.login('Spike')

    then:
    chitter.getActiveUser().getName() == 'Spike'
    chitter.getUsersSignedUp()[0].getName() == 'Spike'
  }

  def 'User can log out and deletes as active user'() {
    when:
    chitter.login('Spike')
    chitter.logOut()

    then:
    chitter.getActiveUser() == null
    chitter.getUsersSignedUp()[0].getName() == 'Spike'
  }

  def 'User can login again, and not automatically sign up'() {
    when:
    chitter.login('Spike')
    chitter.logOut()
    chitter.login('Spike')

    then:
    chitter.getActiveUser().getName() == 'Spike'
    chitter.getUsersSignedUp().size() == 1
  }
}

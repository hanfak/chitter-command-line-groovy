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
}

import spock.lang.*

class ChitterSpec extends Specification {
  def 'no user has logged in at start'() {
    given:
    def chitter = new Chitter()

    when:
    def result = chitter.getActiveUser()

    then:
    result == null
  }
}

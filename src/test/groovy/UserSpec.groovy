import spock.lang.*

class UserSpec extends Specification {
  def 'User object has a name'() {
    given:
    def user = new User('Spike')

    expect:
    user.getName() == 'Spike'
  }
}

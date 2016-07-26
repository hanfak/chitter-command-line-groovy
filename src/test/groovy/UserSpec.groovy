import spock.lang.*

class UserSpec extends Specification {
  def spike

  def setup() {
    spike = new User('Spike')
  }

  def 'User object has a name'() {
    expect:
    spike.getName() == 'Spike'
  }

  def 'User can add followers'() {
    given:
    def leo = new User('Leo')
    def nikesh = new User('Nikesh')

    when:
    spike.addFollower(leo)
    spike.addFollower(nikesh)

    then:
    spike.getFollowers().size() == 3
    spike.getFollowers()[1].getName() == 'Leo'
    spike.getFollowers()[2].getName() == 'Nikesh'
  }
}

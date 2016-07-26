import spock.lang.*

class ChitterSpec extends Specification {
  def chitter
  // Users users

  def setup() {
    // users = GroovyMock()
    chitter = new Chitter()
  }

  def 'no user has logged in at start'() {
    expect:
    chitter.getActiveUser() == null
  }

  def 'no users stored at the start'() {
    expect:
    chitter.getUsersSignedUp().getListofUsers() == []
  }

  def 'Chitter can login a user'() {
    when:
    chitter.login('Spike')

    then:
    chitter.getActiveUser().getName() == 'Spike'
  }

  def 'Chitter can logout a user'() {
    when:
    chitter.login('Spike')
    chitter.logOut()

    then:
    chitter.getActiveUser() == null
  }

  def 'at start number of posts is 0'() {
    expect:
    chitter.viewPosts().size() == 0
  }

  def 'Cannot add a post if not logged in'() {
    when:
    chitter.addPost('Hello this is my first post')

    then:
    chitter.viewPosts().size() == 0
    def exception = thrown(OnlyLoggedInUsersCanPostException)
    exception.message == 'Post not made: User must be logged in first'
  }

  def 'Can add a post if logged in'() {
    when:
    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')

    then:
    chitter.viewPosts().size() == 1
    chitter.viewPosts()[0].getMessage() == 'Hello this is my first post'
  }

  // spying on  a method call is not working
  // def 'Chitter can use login '() {
  //   when:
  //   chitter.login('Spike')
  //
  //   then:
  //   1 * users.loginUser("Spike")
  // }
  // //
  // def 'Chitter can logout a user'() {
  //   when:
  //   chitter.logOut()
  //
  //   then:
  //   1 * users.logOutUser()
  // }
}

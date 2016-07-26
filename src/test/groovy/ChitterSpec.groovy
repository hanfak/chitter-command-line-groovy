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
    chitter.viewPosts()[0]['post'].getMessage() == 'Hello this is my first post'
  }

  def 'Can view my posts/timeline'() {
    when:
    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')
    chitter.addPost('Hello this is my second post')
    chitter.logOut()
    chitter.login('Leo')
    chitter.addPost('A random post not by Spike')
    chitter.logOut()
    chitter.login('Spike')

    then:
    chitter.viewUserPosts().size() == 2
    chitter.viewUserPosts()[0]['post'].getMessage() == 'Hello this is my first post'
    chitter.viewUserPosts()[1]['post'].getMessage() == 'Hello this is my second post'
  }

  def 'Can view others posts/timeline'() {
    when:
    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')
    chitter.addPost('Hello this is my second post')
    chitter.logOut()
    chitter.login('Leo')
    chitter.addPost('A random post not by Spike')
    chitter.logOut()

    then:
    chitter.viewPosts().size() == 3
    chitter.viewUserPosts('Spike').size() == 2

    chitter.viewUserPosts('Spike')[0]['post'].getMessage() == 'Hello this is my first post'
    chitter.viewUserPosts('Spike')[1]['post'].getMessage() == 'Hello this is my second post'

    chitter.viewUserPosts('Spike').find {it['post'].getMessage() == 'A random post not by Spike'} == null
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

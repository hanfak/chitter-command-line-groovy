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

  //Need to use a spy
  def 'Chitter can login a user'() {
    when:
    chitter.login('Spike')

    then:
    chitter.getActiveUser().getName() == 'Spike'
  }

  //Need to use a spy
  def 'Chitter can logout a user'() {
    when:
    chitter.login('Spike')
    chitter.logOut()

    then:
    chitter.getActiveUser() == null
  }
  //Need to use a spy
  def 'can follow someone'() {
    given:
    chitter.login('Leo')
    chitter.logOut()
    chitter.login('Spike')

    when:
    chitter.follow('Leo')

    then:
    chitter.getActiveUser().getFollowers()[1].getName() =='Leo'
  }
  ////done
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


  def 'Can view my posts'() {
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

  def 'Can view others posts'() {
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
  ////

  //////
  def 'view timeline of other user'() {
    when:
    chitter.login('Leo')
    chitter.addPost('Other post ')
    chitter.logOut()

    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')
    chitter.logOut()

    chitter.login('Nikesh')
    chitter.addPost('what post by nikesh')
    chitter.follow('Leo')
    chitter.logOut()

    def result = chitter.viewTimeline('Nikesh')

    then:
    result[0]['post'].getMessage() == 'Other post '
    result[1]['post'].getMessage() == 'what post by nikesh'
    result.size() == 2
    result.find {it['post'].getMessage() == 'Hello this is my first post'} == null
  }

  def 'view timeline of active user'() {
    when:
    chitter.login('Leo')
    chitter.addPost('Other post ')
    chitter.logOut()

    chitter.login('Spike')
    chitter.addPost('Hello this is my first post')
    chitter.addPost('Hello this is my second post')
    chitter.logOut()

    chitter.login('Nikesh')
    chitter.addPost('what post by nikesh')
    chitter.logOut()

    chitter.login('Spike')
    chitter.follow('Leo')
    def result = chitter.viewTimeline()

    then:
    result[0]['post'].getMessage() == 'Other post '
    result[1]['post'].getMessage() == 'Hello this is my first post'
    result[2]['post'].getMessage() == 'Hello this is my second post'
    result.size() == 3
    result.find {it['post'].getMessage() == 'what post by nikesh'} == null
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

  // def 'Chitter can follow '() {
  //   given:
  //   chitter.login('Leo')
  //   chitter.logOut()
  //   chitter.login('Spike')
  //
  //   when:
  //   chitter.follow('Leo')
  //   then:
  //   1 * users.follow("Spike")
  // }
}
